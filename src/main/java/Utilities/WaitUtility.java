package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility extends Utility{

    public static void pauseFor(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
            System.out.println("PAUSE ACTIVATED.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Dynamic Selenium Explicit Wait Statement
    public static void explicitWaitUntilVisible(int seconds, By locator){
        //Will wait up to 5secs max.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void fluentWaitUntilVisible(int seconds, By locator){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchFieldException.class,
                        StaleElementReferenceException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}