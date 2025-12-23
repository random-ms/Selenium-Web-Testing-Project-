package com.demoqa.tests.part3.widgets;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateTest extends BaseTest {

    @Test
    public void testSelectingDate(){
        final String
                MONTH = "July",
                MONTH_NUMBER = "07",
                DAY = "31",
                YEAR = "2034";

        var datePickerPage = homePage.goToWidgets().clickDatePickerMenu();
        datePickerPage.clickSelectDate();
        datePickerPage.selectMonth(MONTH);
        datePickerPage.selectYear(YEAR);
        datePickerPage.clickDay(DAY);

        String actualDate = datePickerPage.getDate();
        String expectedDate = MONTH_NUMBER + "/" + DAY + "/" + YEAR;

        Assert.assertEquals(actualDate, expectedDate,
                "\nActual Date: " + actualDate + " & Expected Date: " + expectedDate + " -- Do Not Match.\n");
    }
}
