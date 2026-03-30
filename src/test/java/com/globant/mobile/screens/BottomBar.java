package com.globant.mobile.screens;

import com.globant.mobile.utils.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class BottomBar extends BasePage {

    @AndroidFindBy(accessibility = "Home")
    private WebElement homeBtn;

    @AndroidFindBy(accessibility = "Webview")
    private WebElement webBtn;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginBtn;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsBtn;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeBtn;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragBtn;

    public BottomBar(AppiumDriver driver) {
        super(driver);
    }

    public void goToHome() {
        click(homeBtn, "Home button");
    }

    public void goToWeb() {
        click(webBtn, "Webview button");
    }

    public void goToLogin() {
        click(loginBtn, "Login button");
    }

    public void goToForms() {
        click(formsBtn, "Forms button");
    }

    public void goToSwipe() {
        click(swipeBtn, "Swipe button");
    }

    public void goToDrag() {
        click(dragBtn, "Drag button");
    }

}