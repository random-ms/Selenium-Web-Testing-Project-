package com.demoqa.pages;

import com.demoqa.pages.alerts_frame_windows.AlertsFrameWindowsPage;
import com.demoqa.pages.elements.ElementsPage;
import com.demoqa.pages.widgets.WidgetsPage;
import com.demoqa.pages.forms.FormsPage;
import com.base.BasePage;
import org.openqa.selenium.By;

import static Utilities.JavascriptUtility.scrollToElementJS;

public class HomePage extends BasePage {
    private By
                formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']"),
                elementCard = By.xpath("//div[@id='app']//h5[text()='Elements']"),
                widgetCard = By.xpath("//div[@id='app']//h5[text()='Widgets']"),
                alertsFrameWindowsCard = By.xpath("//div[@id='app']//h5[contains(text(),'Alerts')]");

    // THIS CLASS CONSISTS OF ALL TRANSITION METHODS

    public AlertsFrameWindowsPage goToAlertsFrameWindows(){
        scrollToElementJS(alertsFrameWindowsCard);
        click(alertsFrameWindowsCard);
        return new AlertsFrameWindowsPage();
    }

    public FormsPage goToForms(){
        scrollToElementJS(formsCard);
        click(formsCard);
        return new FormsPage();
    }

    public ElementsPage goToElements(){
        scrollToElementJS(elementCard);
        click(elementCard);
        return new ElementsPage();
    }

    public WidgetsPage goToWidgets(){
        scrollToElementJS(widgetCard);
        click(widgetCard);
        return new WidgetsPage();
    }
}