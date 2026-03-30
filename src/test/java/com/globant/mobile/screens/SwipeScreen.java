package com.globant.mobile.screens;

import com.globant.mobile.utils.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe horizontal']")
    private WebElement title;

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isSwipeScreenDisplayed() {
        return isTheElementVisible(title, 5);
    }

}