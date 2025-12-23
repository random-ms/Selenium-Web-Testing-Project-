package com.demoqa.tests.part4.dynamic_wait;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class DynamicWaitTest extends BaseTest {

    public void testVisibleAfterButtonText(){
        var dynamicPage = homePage.goToElements().clickDynamicProperties();
        String
                actualText = dynamicPage.getVisibleAfterButtonText(),
                expectedText = "Visible After 5 Seconds",
                message = "Actual and Expected text do not match";

        Assert.assertEquals(actualText, expectedText, message);
    }

    public void testProgressBar(){
        var progressBarPage = homePage.goToWidgets().clickProgressBarMenu();
        progressBarPage.clickStartButton();
        String
                actualValue = progressBarPage.getProgressValue(),
                expectedValue = "100%",
                message = "\nValue is Not 100%\n";

        Assert.assertEquals(actualValue, expectedValue, message);
    }
}
