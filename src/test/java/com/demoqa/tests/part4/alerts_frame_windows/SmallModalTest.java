package com.demoqa.tests.part4.alerts_frame_windows;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmallModalTest extends BaseTest {
    @Test
    public void SmallModalTest() throws InterruptedException {
        var smallModal = homePage.goToAlertsFrameWindows().clickModalsDialogsMenu();
        smallModal.clickSmallModalButton();
        Thread.sleep(3000);
        String actualBody = smallModal.getSmallModalBody(),
                expectedBody = "This is a small modal. It has very less content";
        Thread.sleep(2000);
        smallModal.clickCloseButton();

        Assert.assertEquals(actualBody, expectedBody,
                "Bodies do not match.");
    }
}
