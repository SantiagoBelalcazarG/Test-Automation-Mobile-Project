package com.globant.mobile.tests;

import com.globant.mobile.screens.BottomBar;
import com.globant.mobile.screens.SwipeScreen;
import com.globant.mobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    private BottomBar bottomBar;
    private SwipeScreen swipeScreen;

    @BeforeMethod
    public void setupTest() {
        bottomBar = new BottomBar(driver);
        swipeScreen = new SwipeScreen(driver);

        bottomBar.goToSwipe();
    }

    @Test(testName = "Verify previous card is hidden after horizontal swipe")
    public void userSwipeSuccessfully() {
        Assert.assertTrue(swipeScreen.isSwipeScreenDisplayed(), "Swipe screen should be displayed");
        Assert.assertTrue(swipeScreen.isFirstCardVisible(), "First card should be visible");

        swipeScreen.swipeToLastCard();

        Assert.assertFalse(swipeScreen.isFifthCardVisible(), "Previous card should be hidden");
        Assert.assertTrue(swipeScreen.isLastCardVisible(), "Last card should be visible");

        swipeScreen.swipeVerticalUntilTextIsFound();

        Assert.assertTrue(swipeScreen.isFoundMeTextVisible(), "\"You found me!!!\" text should be visible");
    }

}