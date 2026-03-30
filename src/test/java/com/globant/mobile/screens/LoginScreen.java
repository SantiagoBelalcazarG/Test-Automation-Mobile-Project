package com.globant.mobile.screens;

import com.globant.mobile.utils.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login / Sign up Form']")
    private WebElement loginTitle;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginButton;

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isLoginScreenDisplayed() {
        return isTheElementVisible(loginTitle, 5);
    }

    public boolean areElementsVisible() {
        return isTheElementVisible(emailInput, 5) && isTheElementVisible(passwordInput, 5) && isTheElementVisible(loginButton, 5);
    }

}