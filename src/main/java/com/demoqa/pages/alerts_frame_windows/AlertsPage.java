package com.demoqa.pages.alerts_frame_windows;

import org.openqa.selenium.By;

public class AlertsPage extends AlertsFrameWindowsPage {
    private By
            informationButton = By.id("alertButton"),
            confirmationButton = By.id("confirmButton"),
            confirmationResult = By.id("confirmResult"),
            promptAlertButton = By.id("promtButton"),
            promptMessage = By.id("promptResult");

    public void clickInformationAlertButton(){
        click(informationButton);
    }

    public void clickConfirmationAlertButton(){
        click(confirmationButton);
    }

    public String getConfirmationText(){
        return find(confirmationResult).getText();
    }

    public void clickPromptAlertButton(){
        click(promptAlertButton);
    }

    public String getPromptText(){
        return find(promptMessage).getText();
    }
}
