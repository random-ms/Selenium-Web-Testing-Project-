package com.demoqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static Utilities.ActionsUtility.dragAndDropBy;
import static Utilities.GetUtility.getAttribute;

public class SliderPage extends WidgetsPage{
    private By
                sliderRange = By.xpath("//div[@id='sliderContainer']//input[@type='range']"),
                sliderValue = By.id("sliderValue");

    public String getSliderValue(){
        // return find(sliderValue).getAttribute("value");
        return getAttribute(sliderValue, "value");
    }

    public void moveSlider(int x, int y){
        dragAndDropBy(find(sliderRange), x, y);
    }
}