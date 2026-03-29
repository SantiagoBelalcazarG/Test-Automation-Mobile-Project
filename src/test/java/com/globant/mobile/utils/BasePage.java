package com.globant.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void click(WebElement element, String description) {
        if (isTheElementVisible(element, 5)) {
            element.click();
        } else {
            throw new RuntimeException("Element not found: " + description);
        }
    }

    public void sendText(WebElement element, String text) {
        try {
            if (isTheElementVisible(element, 5)) {
                element.clear();
                element.sendKeys(text);
            } else {
                throw new RuntimeException("Element not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error typing into element", e);
        }
    }

    public String getText(WebElement element) {
        try {
            if (isTheElementVisible(element, 5)) {
                return element.getText();
            }
            throw new RuntimeException("Element not found");
        } catch (Exception e) {
            throw new RuntimeException("Error getting text", e);
        }
    }

    public boolean isTheElementVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            return visibleElement != null;
        } catch (Exception e) {
            return false;
        }
    }

}