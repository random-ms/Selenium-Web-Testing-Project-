package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToUtility extends Utility{

    private static WebDriver.TargetLocator switchTo(){
        return driver.switchTo();
    }

    public static String getAlertText(){
        return switchTo().alert().getText();
    }

    // Designed to click the 'Ok' button on alerts.
    public static void acceptAlert() {
        switchTo().alert().accept();
    }

    // Designed to click the 'Cancel/Close' button on alerts.
    public static void dismissAlert() {
        switchTo().alert().dismiss();
    }

    public static void setAlertText(String text){
        switchTo().alert().sendKeys(text);
    }

    // Using String
    public static void switchToFrame(String value){
        switchTo().frame(value);
    }

    // Using int
    public static void switchToFrame(int index){
        switchTo().frame(index);
    }

    // Using WebElement
    public static void switchToFrame(WebElement element){
        switchTo().frame(element);
    }

    public static void switchToDefault(){
        switchTo().defaultContent();
    }

    public static void switchToWindow(String handle){
        driver.switchTo().window(handle);
    }
}