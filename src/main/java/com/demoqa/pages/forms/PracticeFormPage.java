package com.demoqa.pages.forms;

import org.openqa.selenium.By;

import static Utilities.JavascriptUtility.clickJS;
import static Utilities.JavascriptUtility.scrollToElementJS;

public class PracticeFormPage extends FormsPage{

    private By
                firstName = By.xpath("//form[@id='userForm']//input[@placeholder='First Name']"),
                lastName = By.xpath("//form[@id='userForm']//input[@placeholder='Last Name']"),
                email = By.xpath("//form[@id='userForm']//input[@placeholder='name@example.com']"),
                mobile = By.xpath("//input[@placeholder='Mobile Number']"),
                dateOfBirth = By.id("dateOfBirthInput")

    ;

    private By
                maleRadioButton = By.id("gender-radio-1"),
                femaleRadioButton = By.id("gender-radio-2"),
                otherRadioButton = By.id("gender-radio-3"),
                sportsHobbyCheckBox = By.id("hobbies-checkbox-1"),
                readingHobbyCheckBox = By.id("hobbies-checkbox-2"),
                musicHobbyCheckBox = By.id("hobbies-checkbox-3"),
                submitButton = By.id("submit")
    ;

    public void fillInForm(String firstName, String lastName, String email, String gender, String number,
                           String[] dateOfBirth){
        set(this.firstName,firstName);
        set(this.lastName, lastName);
        set(this.email, email);
        setGender(gender);
        set(this.mobile, number);
        setDateOfBirth(dateOfBirth[0], dateOfBirth[1], dateOfBirth[2]);
    }

    public void setGender(String gender){
        switch (gender){
            case "male": clickJS(maleRadioButton); break;
            case "female": clickJS(femaleRadioButton); break;
            default: clickJS(otherRadioButton);
        }
    }

    public void setDateOfBirth(String yearValue, String monthValue, String dayValue){
        By selectYear = By.xpath(
                "//select[@class='react-datepicker__year-select']//option[@value='"+yearValue+"']");
        By selectMonth = By.xpath(
                "//select[@class='react-datepicker__month-select']//option[@value='"+monthValue+"']");
        By selectDay = By.xpath(
                "div[@class=\"react-datepicker__day react-datepicker__day--00"+dayValue+"\"]");
        click(dateOfBirth);
        clickJS(selectYear);
        clickJS(selectMonth);
        clickJS(selectDay);
    }

    public void clickSubmitButton(){
        //scrollToElementJS(submitButton);
        click(submitButton);
    }

    public void clickFemaleRadioButton(){
        scrollToElementJS(femaleRadioButton);
        clickJS(femaleRadioButton);
    }

    public boolean isFemaleSelected(){
        return find(femaleRadioButton).isSelected();
    }

    public void clickSportsCheckBox(){
        if(!find(sportsHobbyCheckBox).isSelected()) {
            scrollToElementJS(sportsHobbyCheckBox);
            clickJS(sportsHobbyCheckBox);
        }
    }

    public void clickReadingCheckBox(){
        if(!find(readingHobbyCheckBox).isSelected()) {
            scrollToElementJS(readingHobbyCheckBox);
            clickJS(readingHobbyCheckBox);
        }
    }

    public void clickMusicCheckBox(){
        if(!find(musicHobbyCheckBox).isSelected()){
            scrollToElementJS(musicHobbyCheckBox);
            clickJS(musicHobbyCheckBox);
        }
    }
    /* UnClicking CheckBoxes */
    public void unClickSportsCheckBox(){
        if(find(sportsHobbyCheckBox).isSelected()) {
            scrollToElementJS(sportsHobbyCheckBox);
            clickJS(sportsHobbyCheckBox);
        }
    }

    public boolean isSportsSelected(){
        return find(sportsHobbyCheckBox).isSelected();
    }

    public void unClickReadingCheckBox(){
        if(find(readingHobbyCheckBox).isSelected()) {
            scrollToElementJS(readingHobbyCheckBox);
            clickJS(readingHobbyCheckBox);
        }
    }

    public boolean isReadingSelected(){
        return find(readingHobbyCheckBox).isSelected();
    }

    public void unClickMusicCheckBox(){
        if(find(musicHobbyCheckBox).isSelected()){
            scrollToElementJS(musicHobbyCheckBox);
            clickJS(musicHobbyCheckBox);
        }
    }

    public boolean isMusicSelected(){
        return find(musicHobbyCheckBox).isSelected();
    }
}