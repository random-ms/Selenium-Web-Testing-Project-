package com.demoqa.pages.alerts_frame_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utilities.JavascriptUtility.scrollToElementJS;
import static Utilities.SwitchToUtility.*;


public class FramesPage extends AlertsFrameWindowsPage {
    private By
                textInFrame = By.id("sampleHeading"),
                headerFramesText = By.xpath("//div[@id='app']//h1[text()='Frames']"),
                iFrameSmallElement = By.xpath("//div[@id='frame2Wrapper']/iframe");

    private String
                    iFrameBigBox = "frame1",
                    iFrameSmallBox = "frame2";

    private int INDEX = 2;

    private void switchToElement(){
        scrollToElementJS(iFrameSmallElement);
        switchToFrame(find(iFrameSmallElement));
    }

    public String getHeaderFramesText(){
        return find(headerFramesText).getText();
    }

    // Instead of driver.switchTo().defaultContent(); see, ln 48
    public String getTextInBigBoxFrame(){
        switchToFrame(iFrameBigBox);
        String bigFrameText = find(textInFrame).getText();
        System.out.println("Big Frame Text: " + bigFrameText);
        switchToDefault();
        return bigFrameText;
    }

    public String getTextInSmallBoxFrame(){
        switchToFrame(iFrameSmallBox);
        String smallFrameText = find(textInFrame).getText();
        System.out.println("Small Frame Text: " + smallFrameText);
        switchToDefault();
        return smallFrameText;
    }

    public String getTextInSmallBoxFrameUsingIndex(){
        switchToFrame(INDEX);
        String smallFrameText = find(textInFrame).getText();
        System.out.println("Small Frame Text: " + smallFrameText);
        switchToDefault();
        return smallFrameText;
    }

    public String getTextInSmallBoxFrameUsingElement(){
        switchToElement();
        String smallFrameElement = find(iFrameSmallElement).getText();
        System.out.println("Small Frame Text: " + smallFrameElement);
        switchToDefault();
        return smallFrameElement;
    }
}