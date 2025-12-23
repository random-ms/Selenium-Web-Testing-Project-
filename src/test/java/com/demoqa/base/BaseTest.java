package com.demoqa.base;

import Utilities.WebDriverFactory;
import com.demoqa.pages.HomePage;
import com.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.io.*;

import static Utilities.Utility.setUtilityDriver;

public class BaseTest {

    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private final String DEMOQA_URL = "https://demoqa.com";

    @BeforeClass
    public void setUp(){
        try{
            this.driver = WebDriverFactory.getWebDriver();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        // Waits after driver is called. Each element implements implicit wait.
        // Should never mix 'waits'.
    }

    @BeforeMethod
    public void loadApplication() throws IOException {
        driver.get(DEMOQA_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
    }

    //@AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/" +
                    java.time.LocalDate.now() + "--"+
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot Located At " + destination);
        }
    }

    //@AfterClass
    public void tearDown() {
        driver.quit();
    }
}