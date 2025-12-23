package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import static Utilities.JavascriptUtility.scrollToElementJS;

public class LinksPage extends ElementsPage {
    private By
                badRequestLink = By.id("bad-request"),
                responseLink = By.id("linkResponse");

    public void clickBadRequestLink(){
        scrollToElementJS(badRequestLink);
        click(badRequestLink);
    }

    public String getResponse() throws InterruptedException {
        Thread.sleep(2000);
        return find(responseLink).getText();
    }
}