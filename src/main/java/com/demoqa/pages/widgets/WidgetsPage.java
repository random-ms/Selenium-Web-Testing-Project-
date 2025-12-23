package com.demoqa.pages.widgets;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavascriptUtility.scrollToElementJS;

public class WidgetsPage extends HomePage {
    private By
                selectMenu = By.xpath("//li[@id='item-8']//span[text()='Select Menu']"),
                selectDatePicker = By.xpath("//*[@id=\"item-2\"]/span[text()='Date Picker']"),
                progressBarMenu = By.xpath("//li[@id='item-4']//span[text()='Progress Bar']"),
                sliderMenu =By.xpath("//li[@id='item-3']/span[text()='Slider']");

    public SelectMenuPage clickSelectMenu(){
        scrollToElementJS(selectMenu);
        click(selectMenu);
        return new SelectMenuPage();
    }

    public DatePickerMenuPage clickDatePickerMenu(){
        scrollToElementJS(selectDatePicker);
        click(selectDatePicker);
        return new DatePickerMenuPage();
    }

    public ProgressBarPage clickProgressBarMenu(){
        scrollToElementJS(progressBarMenu);
        click(progressBarMenu);
        return new ProgressBarPage();
    }

    public SliderPage clickSliderMenu(){
        scrollToElementJS(sliderMenu);
        click(sliderMenu);
        return new SliderPage();
    }
}