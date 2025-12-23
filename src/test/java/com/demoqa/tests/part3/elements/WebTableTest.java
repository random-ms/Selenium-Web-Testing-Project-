package com.demoqa.tests.part3.elements;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest {

    @Test
    public void testWebTable(){
        final String ACTUAL_AGE = "10",
                EMAIL = "cierra@example.com";

        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit(EMAIL);
        webTablePage.setAge(ACTUAL_AGE);
        webTablePage.clickSubmitButton();
        String editedAge = webTablePage.getWebTableAge(EMAIL);
        Assert.assertEquals(ACTUAL_AGE, editedAge, "\n Actual and Expected Ages do not match. \n");
    }
}