package com.globant.mobile.tests;

import com.globant.mobile.screens.*;
import com.globant.mobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void validateBottomNavigation() {
        BottomBar nav = new BottomBar(driver);

        // HOME
        HomeScreen home = new HomeScreen(driver);
        Assert.assertTrue(home.isHomeScreenDisplayed(), "Home screen not displayed");
        Assert.assertTrue(home.areElementsVisible(), "Home content not visible");

        // LOGIN
        nav.goToLogin();
        LoginScreen login = new LoginScreen(driver);
        Assert.assertTrue(login.isLoginScreenDisplayed(), "Login screen not displayed");
        Assert.assertTrue(login.areElementsVisible(), "Login elements not visible");

        // FORMS
        nav.goToForms();
        FormsScreen forms = new FormsScreen(driver);
        Assert.assertTrue(forms.isFormsScreenDisplayed(), "Forms screen not displayed");
        Assert.assertTrue(forms.areElementsVisible(), "Forms elements not visible");

        // SWIPE
        nav.goToSwipe();
        SwipeScreen swipe = new SwipeScreen(driver);
        Assert.assertTrue(swipe.isSwipeScreenDisplayed(), "Swipe screen not displayed");

        // DRAG
        nav.goToDrag();
        DragScreen drag = new DragScreen(driver);
        Assert.assertTrue(drag.isDragScreenDisplayed(), "Drag screen not displayed");
        Assert.assertTrue(drag.areElementsVisible(), "Drag elements not visible");
    }

}