package com.demoqa.tests.part4.interactions;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.WaitUtility.pauseFor;

@Test
public class KeyboardTest extends BaseTest {

    public void testKeySend() {
        String
                name = "Green Machine",
                email = "GreenMachine123@info.com",
                currentAddressLine1 = "123 Green Road",
                currentAddressLine2 = "Greener Estate",
                currentAddressLine3 = "Amelika",
                permanentAddress = "Greenville Village";

        var testBoxPage = homePage.goToElements().clickTextBoxMenu();
        pauseFor(3);
        testBoxPage.setFullName(name);
        testBoxPage.setEmail(email);
        testBoxPage.setCurrentAddress(currentAddressLine1);
        testBoxPage.setCurrentAddress(currentAddressLine2);
        testBoxPage.setCurrentAddress(currentAddressLine3);
        testBoxPage.setPermanentAddress(permanentAddress);
        testBoxPage.clickSubmit();

        String
                actualName = testBoxPage.getNameResult(),
                actualEmail = testBoxPage.getEmailResult(),
                actualCurrentAddress = testBoxPage.getCurrentAddressResult(),
                actualPermanentAddress = testBoxPage.getPermanentAddressResult(),
                message = "\nActual value Does Not Contain ";


        Assert.assertTrue(actualName.contains(name), message + actualName);
        Assert.assertTrue(actualEmail.contains(email), message + email);
        Assert.assertTrue(actualCurrentAddress.contains(currentAddressLine3), message + currentAddressLine3);
        Assert.assertTrue(actualPermanentAddress.contains(permanentAddress), message + permanentAddress);
    }
}
