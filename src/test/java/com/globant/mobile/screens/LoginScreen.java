package com.globant.mobile.screens;

import com.globant.mobile.utils.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login / Sign up Form']")
    private WebElement loginTitle;

    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement loginTab;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signUpTab;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement signUpEmailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement signUpPasswordInput;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement signUpConfirmPasswordInput;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUpButton;

    @AndroidFindBy(id = "android:id/message")
    private WebElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement alertOkButton;

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public void completeLoginForm(String email, String password) {
        sendText(emailInput, email);
        sendText(passwordInput, password);
    }

    public void login(String email, String password) {
        completeLoginForm(email, password);
        tapLoginButton();
    }

    public void tapLoginButton() {
        click(loginButton, "Login button");
    }

    public void openLoginTab() {
        click(loginTab, "login tab");
    }

    public void openSignUpTab() {
        click(signUpTab, "Sign up tab");
    }

    public void completeSignUpForm(String email, String password, String confirmPassword) {
        sendText(signUpEmailInput, email);
        sendText(signUpPasswordInput, password);
        sendText(signUpConfirmPasswordInput, confirmPassword);
    }

    public void tapSignUpButton() {
        click(signUpButton, "Sign up button");
    }

    public String getSuccessMessageText() {
        return getText(alertMessage);
    }

    public void confirmSuccessPopup() {
        click(alertOkButton, "Success OK button");
    }

    public boolean isLoginScreenDisplayed() {
        return isTheElementVisible(loginTitle, 5);
    }

    public boolean areElementsVisible() {
        return isTheElementVisible(emailInput, 5) && isTheElementVisible(passwordInput, 5) && isTheElementVisible(loginButton, 5);
    }

    public boolean isSignUpTabVisible() {
        return isTheElementVisible(signUpTab, 5);
    }

    public boolean isSignUpFormVisible() {
        return isTheElementVisible(signUpEmailInput, 5) && isTheElementVisible(signUpPasswordInput, 5) && isTheElementVisible(signUpConfirmPasswordInput, 5) && isTheElementVisible(signUpButton, 5);
    }

}