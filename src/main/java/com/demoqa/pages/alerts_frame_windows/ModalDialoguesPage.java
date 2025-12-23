package com.demoqa.pages.alerts_frame_windows;

import org.openqa.selenium.By;

public class ModalDialoguesPage extends AlertsFrameWindowsPage{

    private By
                smallModalButton = By.id("showSmallModal"),
                smallModalText = By.className("modal-body"),
                closeButton = By.id("closeSmallModal");

    public void clickSmallModalButton(){
        click(smallModalButton);
    }

    public String getSmallModalBody(){
        return find(smallModalText).getText();
    }

    public void clickCloseButton(){
        click(closeButton);
    }
}