package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import static Utilities.GetUtility.getText;
import static Utilities.JavascriptUtility.scrollToElementJS;
import static Utilities.WaitUtility.*;

public class ProgressBarPage extends WidgetsPage{
    private By
                startButton = By.id("startStopButton"),
                progressValue = By.xpath("//div[@id='progressBar']/div[@aria-valuenow='100']");

    public void clickStartButton(){
        explicitWaitUntilVisible(5, startButton);
        scrollToElementJS(startButton);
        click(startButton);
    }

    public String getProgressValue(){
        fluentWaitUntilVisible(30, progressValue);
        return getText(progressValue);
    }
}
