package com.globant.mobile.screens;

import com.globant.mobile.utils.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
    private WebElement title;

    @AndroidFindBy(accessibility = "renew")
    private WebElement renewbtn;

    public DragScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isDragScreenDisplayed() {
        return isTheElementVisible(title, 5);
    }

    public boolean areElementsVisible() {
        return isTheElementVisible(renewbtn, 5);
    }

}