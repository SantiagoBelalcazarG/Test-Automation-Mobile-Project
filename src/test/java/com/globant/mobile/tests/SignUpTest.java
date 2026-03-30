package com.globant.mobile.tests;

import com.globant.mobile.screens.BottomBar;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.utils.BaseTest;
import com.globant.mobile.utils.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    private BottomBar bottomBar;
    private LoginScreen loginScreen;

    @BeforeMethod
    public void setupTest() {
        bottomBar = new BottomBar(driver);
        loginScreen = new LoginScreen(driver);

        bottomBar.goToLogin();
    }

    @Test
    public void userSignUpSuccessfully() {
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed(), "Login screen should be displayed");
        Assert.assertTrue(loginScreen.isSignUpTabVisible(), "Sign up tab should be visible");

        String email = DataGenerator.generateRandomEmail();
        String password = DataGenerator.generateRandomPassword();

        loginScreen.openSignUpTab();

        Assert.assertTrue(loginScreen.isSignUpFormVisible(), "Sign up form should be visible");

        loginScreen.completeSignUpForm(email, password, password);
        loginScreen.tapSignUpButton();

        Assert.assertEquals(loginScreen.getSuccessMessageText(), "You successfully signed up!", "Success message is incorrect");

        loginScreen.confirmSuccessPopup();
    }

}