package com.demoqa.pages.alerts_frame_windows;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavascriptUtility.scrollToElementJS;

public class AlertsFrameWindowsPage extends HomePage {
    private By
            modalsDialogsMenu = By.xpath("//li[@id='item-4']//span[text()='Modal Dialogs']"),
            alertsButton = By.xpath("//li[@id='item-1']//span[text()='Alerts']"),
            framesButton = By.xpath("//li[@id='item-2']//span[text()='Frames']"),
            browserWindows = By.xpath("//li[@id='item-0']//span[text()='Browser Windows']");

    public ModalDialoguesPage clickModalsDialogsMenu(){
        scrollToElementJS(modalsDialogsMenu);
        click(modalsDialogsMenu);
        return new ModalDialoguesPage();
    }

    public AlertsPage clickAlerts(){
        click(alertsButton);
        return new AlertsPage();
    }

    public FramesPage clickFrames(){
        scrollToElementJS(framesButton);
        click(framesButton);
        return new FramesPage();
    }

    public BrowserWindowsPage clickBrowserWindowsMenu(){
        scrollToElementJS(browserWindows);
        click(browserWindows);
        return new BrowserWindowsPage();
    }
}