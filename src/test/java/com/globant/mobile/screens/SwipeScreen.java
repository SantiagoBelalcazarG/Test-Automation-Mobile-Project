package com.globant.mobile.screens;

import com.globant.mobile.utils.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe horizontal']")
    private WebElement title;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Or swipe vertical to find what I'm hiding.\"]")
    private WebElement swipeInstruction;

    @AndroidFindBy(xpath = "//*[@text='FULLY OPEN SOURCE']")
    private WebElement firstCard;

    @AndroidFindBy(xpath = "//*[@text='GREAT COMMUNITY']")
    private WebElement secondCard;

    @AndroidFindBy(xpath = "//*[@text='JS.FOUNDATION']")
    private WebElement thirdCard;

    @AndroidFindBy(xpath = "//*[@text='SUPPORT VIDEOS']")
    private WebElement fourthCard;

    @AndroidFindBy(xpath = "//*[@text='EXTENDABLE']")
    private WebElement fifthCard;

    @AndroidFindBy(xpath = "//*[@text='COMPATIBLE']")
    private WebElement lastCard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You found me!!!']")
    private WebElement foundMeText;

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isFirstCardVisible() {
        return isTheElementVisible(firstCard, 5);
    }

    public boolean isFifthCardVisible() {
        return isTheElementVisible(fifthCard, 5);
    }

    public boolean isLastCardVisible() {
        return isTheElementVisible(lastCard, 5);
    }

    public boolean isFoundMeTextVisible() {
        return isTheElementVisible(foundMeText, 3);
    }

    public void swipeToLastCard() {
        swipeHorizontal(firstCard);
        swipeHorizontal(secondCard);
        swipeHorizontal(thirdCard);
        swipeHorizontal(fourthCard);
        swipeHorizontal(fifthCard);
    }

    public void swipeVerticalUntilTextIsFound() {
        int maxRetries = 10;
        for (int i = 0; i < maxRetries; i++) {
            if (isFoundMeTextVisible()) {
                return;
            }
            scrollDown();
        }
        throw new RuntimeException("No se encontró el texto oculto tras 10 intentos.");
    }

    public boolean isSwipeScreenDisplayed() {
        return isTheElementVisible(title, 5);
    }

}