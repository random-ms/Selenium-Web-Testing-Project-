package com.demoqa.tests.part3.forms;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillInTheFormTest extends BaseTest {

    String
            name = "Mdot",
            surname = "Simz",
            email = "Simz",
            gender = "male",
            mobile = "0123456789",

            // Date Of Birth
            day = "3",
            month = "6", // July
            year = "2008"
    ;

    String[] dateOfBirth = {year, month, day};

    @Test
    public void testFormFillUp(){
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.fillInForm(name, surname, email, gender, mobile, dateOfBirth);
    }
}