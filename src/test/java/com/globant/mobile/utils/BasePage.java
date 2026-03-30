package com.globant.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    private void performSwipe(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);

        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(sequence));
    }

    public void swipeHorizontal(WebElement element) {
        var rect = element.getRect();
        int centerY = rect.getY() + (rect.getHeight() / 2);
        int startX = rect.getX() + (int) (rect.getWidth() * 0.9);
        int endX = rect.getX() + (int) (rect.getWidth() * 0.1);
        performSwipe(startX, centerY, endX, centerY);
    }

    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.8);
        int endY = (int) (size.getHeight() * 0.2);
        performSwipe(startX, startY, startX, endY);
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