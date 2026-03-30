package com.globant.mobile.screens;

import com.globant.mobile.utils.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Form components']")
    private WebElement title;

    @AndroidFindBy(accessibility = "text-input")
    private WebElement inputField;

    @AndroidFindBy(accessibility = "button-Active")
    private WebElement activeBtn;

    @AndroidFindBy(accessibility = "button-Inactive")
    private WebElement inactiveBtn;

    public FormsScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isFormsScreenDisplayed() {
        return isTheElementVisible(title, 5);
    }

    public boolean areElementsVisible() {
        return isTheElementVisible(inputField, 5) && isTheElementVisible(activeBtn, 5) && isTheElementVisible(inactiveBtn, 5);
    }

}