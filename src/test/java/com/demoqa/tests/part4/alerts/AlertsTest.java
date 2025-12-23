package com.demoqa.tests.part4.alerts;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.SwitchToUtility.*;

@Test
public class AlertsTest extends BaseTest {

    public void testInformationAlert(){
        String expectedAlertText = "You clicked a button";
        var alertsPage = homePage.goToAlertsFrameWindows().clickAlerts();
        alertsPage.clickInformationAlertButton();

        Assert.assertEquals(getAlertText(), expectedAlertText,
                "\n Actual & Expected messages do not match!\n");
        acceptAlert();
    }

    public void testConfirmationAlert(){
        var alertsPage = homePage.goToAlertsFrameWindows().clickAlerts();
        alertsPage.clickConfirmationAlertButton();
        dismissAlert();
        String actual = alertsPage.getConfirmationText(), expected = "You selected Cancel";

        Assert.assertEquals(expected, actual, "You did not select cancel.");
    }

    public void testPromptAlert() {
        String txt = ".Lang";

        var alertsPage = homePage.goToAlertsFrameWindows().clickAlerts();
        alertsPage.clickPromptAlertButton();
        setAlertText(txt);
        acceptAlert();

        String actual = alertsPage.getPromptText(), expected = "You entered " + txt;
        Assert.assertEquals(actual, expected, "Prompt messages do not match");
    }
}
