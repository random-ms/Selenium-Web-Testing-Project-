package com.demoqa.pages.elements;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import static Utilities.JavascriptUtility.scrollToElementJS;

public class ElementsPage extends HomePage {
    private By
            webTableMenuItem = By.xpath("//li[@id='item-3']//span[text()='Web Tables']"),
            linksMenuItem = By.xpath("//li[@id='item-5']/span[text()='Links']"),
            dynamicPropItem = By.xpath("//li[@id='item-8']//span[text()='Dynamic Properties']"),
            textBoxMenu = By.xpath("//li[@id='item-0']//span[text()='Text Box']");


    public WebTablesPage clickWebTables(){
        click(webTableMenuItem);
        return new WebTablesPage();
    }

    public LinksPage clickLinks(){
        click(linksMenuItem);
        return new LinksPage();
    }

    public DynamicPropertiesPage clickDynamicProperties(){
        scrollToElementJS(dynamicPropItem);
        click(dynamicPropItem);
        return new DynamicPropertiesPage();
    }

    public TextBoxPage clickTextBoxMenu(){
        scrollToElementJS(textBoxMenu);
        click(textBoxMenu);
        return new TextBoxPage();
    }
}