package com.globant.mobile.tests;

import com.globant.mobile.screens.BottomBar;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.utils.BaseTest;
import com.globant.mobile.utils.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private BottomBar bottomBar;
    private LoginScreen loginScreen;
    private String email;
    private String password;

    @BeforeMethod
    public void setupTest() {
        bottomBar = new BottomBar(driver);
        loginScreen = new LoginScreen(driver);

        email = DataGenerator.generateRandomEmail();
        password = DataGenerator.generateRandomPassword();

        bottomBar.goToLogin();


        loginScreen.openSignUpTab();

        loginScreen.completeSignUpForm(email, password, password);
        loginScreen.tapSignUpButton();
        loginScreen.confirmSuccessPopup();

        loginScreen.openLoginTab();
    }

    @Test(testName = "Verify successful login flow")
    public void userLoginSuccessfully() {
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed(), "Login screen should be displayed");
        Assert.assertTrue(loginScreen.isSignUpTabVisible(), "Sign up tab should be visible");

        loginScreen.login(email, password);

        String message = loginScreen.getSuccessMessageText();

        Assert.assertNotNull(message, "Login success message should be present");
        Assert.assertEquals(message, "You are logged in!", "Login success message is incorrect");

        loginScreen.confirmSuccessPopup();
    }

}