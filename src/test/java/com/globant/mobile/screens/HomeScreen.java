package com.globant.mobile.screens;

import com.globant.mobile.utils.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WEBDRIVER']")
    private WebElement title;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Demo app')]")
    private WebElement subtitle;

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isHomeScreenDisplayed() {
        return isTheElementVisible(title, 5);
    }

    public boolean areElementsVisible() {
        return isTheElementVisible(subtitle, 5);
    }

}