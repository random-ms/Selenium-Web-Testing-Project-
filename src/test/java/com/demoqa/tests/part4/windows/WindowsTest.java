package com.demoqa.tests.part4.windows;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.GetUtility.getURL;

public class WindowsTest extends BaseTest {

    @Test
    public void testNewWindowURL(){
        var windowsPage = homePage.goToAlertsFrameWindows().clickBrowserWindowsMenu();
        windowsPage.clickNewWindowButton();
        windowsPage.switchToNewWindow();

        String actualURL = getURL(),
                expectedURL = "https://demoqa.com/sample";

        Assert.assertEquals(actualURL, expectedURL,"Actual and Expected URLs do not match.");
    }
}