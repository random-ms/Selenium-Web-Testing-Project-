package com.demoqa.tests.part4.interactions;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.widgets.SliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SliderTest extends BaseTest {

    public void testSliderResult(){
        int
            x = 228, // horizontal left to right...
            y = 0; // vertical up and down....
        SliderPage sliderPage = homePage.goToWidgets().clickSliderMenu();
        sliderPage.moveSlider(x, y);
        String
                actualValue = sliderPage.getSliderValue(),
                expectedValue = "95",
                message = "\nActual and Expected values do not match.\n";

        Assert.assertEquals(actualValue, expectedValue, message);
    }
}