package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static Utilities.ActionsUtility.sendKeys;
import static Utilities.GetUtility.getText;
import static Utilities.JavascriptUtility.scrollToElementJS;
import static Utilities.WaitUtility.explicitWaitUntilVisible;

public class TextBoxPage extends ElementsPage {

    private By
                usernameInput = By.xpath("//div[@id='userName-wrapper']//input[@id='userName']"),
                emailInput = By.xpath("//div[@id='userEmail-wrapper']//input[@id='userEmail']"),
                currentAddressInput = By.xpath("//textarea[@id='currentAddress']"),
                permanentAddressInput = By.xpath("//textarea[@id='permanentAddress']"),
                submitButton = By.id("submit"),
    // results
                nameResult = By.xpath("//p[@id='name']"),
                emailResult = By.xpath("//p[@id='email']"),
                currentAddressResult = By.xpath("//p[@id='currentAddress']"),
                permanentAddressResult = By.xpath("//p[@id='permanentAddress']");

    public String getNameResult(){
        explicitWaitUntilVisible(5, nameResult);
        return getText(nameResult);
    }
    public String getEmailResult(){
        explicitWaitUntilVisible(5, emailResult);
        return getText(emailResult);
    }

    public String getCurrentAddressResult(){
        explicitWaitUntilVisible(5, currentAddressResult);
        return getText(currentAddressResult);
    }
    public String getPermanentAddressResult(){
        explicitWaitUntilVisible(5, permanentAddressResult);
        return getText(permanentAddressResult);
    }

    public void setFullName(String fullName){
        sendKeys(find(usernameInput), Keys.chord(fullName));
    }

    public void setEmail(String email){
        setFullName(Keys.chord(Keys.TAB, email));
    }

    public void setCurrentAddress(String currentAddress){
        find(currentAddressInput).sendKeys(currentAddress + Keys.ENTER);
    }

    public void setPermanentAddress(String permanentAddress){
        setCurrentAddress(Keys.chord(Keys.TAB, permanentAddress));
    }

    public void clickSubmit(){
        setPermanentAddress(Keys.chord(Keys.TAB));
        scrollToElementJS(submitButton);
        click(submitButton);
    }
}