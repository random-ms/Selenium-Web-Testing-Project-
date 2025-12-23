package com.demoqa.tests.part4.frames;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class FramesTest extends BaseTest {

    final String
                message = "\n Actual & Expected Texts Do Not Match \n",
                expectedResult = "This is a sample page",
                expectedHeaderText = "Frames";

    public void testFramesBigBox(){
        var framesPage = homePage.goToAlertsFrameWindows().clickFrames();

        String actualBigFrameText = framesPage.getTextInBigBoxFrame(),
                actualHeaderText = framesPage.getHeaderFramesText();

        Assert.assertEquals(actualBigFrameText, expectedResult, message );
        Assert.assertEquals(actualHeaderText, expectedHeaderText, "Header Text: " + message);
    }

    public void testFramesSmallBox(){
        var framesPage = homePage.goToAlertsFrameWindows().clickFrames();
        String smallFrameText = framesPage.getTextInSmallBoxFrame();
        Assert.assertEquals(smallFrameText, expectedResult, message);
    }

    public void testFrameSmallBoxUsingIndex(){
        var framesPage = homePage.goToAlertsFrameWindows().clickFrames();
        String smallBoxText = framesPage.getTextInSmallBoxFrameUsingIndex();

        Assert.assertEquals(smallBoxText, expectedResult, message);
    }

    public void testFrameSmallBoxUsingElement(){
        var framesPage = homePage.goToAlertsFrameWindows().clickFrames();
        String smallBoxText = framesPage.getTextInSmallBoxFrameUsingElement();
        System.out.println(smallBoxText);

        Assert.assertEquals(smallBoxText, expectedResult, message);
    }
}