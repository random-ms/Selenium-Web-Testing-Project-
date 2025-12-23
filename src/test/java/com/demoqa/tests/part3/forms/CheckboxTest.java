package com.demoqa.tests.part3.forms;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckboxTest extends BaseTest {

    @Test
    public void testAllCheckBoxClick(){
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickSportsCheckBox();
        formsPage.clickReadingCheckBox();
        formsPage.clickMusicCheckBox();

        boolean isSportsCheckboxSelected = formsPage.isSportsSelected(),
                isReadingCheckboxSelected = formsPage.isReadingSelected(),
                isMusicCheckboxSelected = formsPage.isMusicSelected();

        Assert.assertTrue(isSportsCheckboxSelected, "Sports Checkbox Not selected");
        Assert.assertTrue(isReadingCheckboxSelected, "Reading Checkbox Not selected");
        Assert.assertTrue(isMusicCheckboxSelected,"Music Checkbox Not selected");
    }

    @Test
    public void testUnClickAllCheckBox() throws InterruptedException {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickSportsCheckBox();
        formsPage.clickReadingCheckBox();
        formsPage.clickMusicCheckBox();

        Thread.sleep(5000);

        formsPage.unClickSportsCheckBox();
        formsPage.unClickReadingCheckBox();
        formsPage.unClickMusicCheckBox();

        boolean isSportsCheckboxSelected = formsPage.isSportsSelected(),
                isReadingCheckboxSelected = formsPage.isReadingSelected(),
                isMusicCheckboxSelected = formsPage.isMusicSelected();

        Assert.assertFalse(isSportsCheckboxSelected, "Sports Checkbox is selected");
        Assert.assertFalse(isReadingCheckboxSelected, "Reading Checkbox is selected");
        Assert.assertFalse(isMusicCheckboxSelected,"Music Checkbox is selected");
    }
}