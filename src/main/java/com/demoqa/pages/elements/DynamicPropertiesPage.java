package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import static Utilities.GetUtility.getText;
import static Utilities.WaitUtility.*;

public class DynamicPropertiesPage extends ElementsPage{
    private By
            visibleAfterButton = By.id("visibleAfter");

    public String getVisibleAfterButtonText(){
        explicitWaitUntilVisible(5, visibleAfterButton);
        String txt = getText(visibleAfterButton);
        System.out.println(txt);
        return txt;
    }
}
