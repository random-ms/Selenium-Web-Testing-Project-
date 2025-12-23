package com.demoqa.pages.alerts_frame_windows;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import java.util.Set;

import static Utilities.SwitchToUtility.switchToWindow;

public class BrowserWindowsPage extends AlertsFrameWindowsPage {

    private By
                newWindowButton = By.xpath("//div[@id='windowButtonWrapper']//button");


    public void clickNewWindowButton(){
        click(newWindowButton);
    }

    /* Steps
    * 1: Get the Current "Main" Window handle
    * 2: Get All Window Handles
    * 3: Switch to the new window using the window handle.
    */

    public void switchToNewWindow(){
        String currentHandle = driver.getWindowHandle();
        System.out.println("Main Window ID: " + currentHandle + "\n");

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("# of Open Windows: " + allHandles.size());

        for (String handle : allHandles){
            if(currentHandle.equals(handle)){
                System.out.println("1st Window ID: " + handle);
            } else{
                switchToWindow(handle);
                System.out.println("2nd Window ID: " + handle);
            }
        }

    }
}