package com.globant.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected AppiumDriver driver;
    protected Properties properties;

    @BeforeMethod
    public void setUp() {
        loadProperties();
        driver = createAppiumDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void loadProperties() {
        properties = new Properties();
        try (FileInputStream file = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    private AppiumDriver createAppiumDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(properties.getProperty("platform.name"))
                    .setAutomationName(properties.getProperty("automation.name"))
                    .setDeviceName(properties.getProperty("device.name"))
                    .setUdid(properties.getProperty("udid"))
                    .setApp(properties.getProperty("app.path"))
                    .setAppPackage(properties.getProperty("app.package"))
                    .setAppActivity(properties.getProperty("app.activity"));

            AndroidDriver androidDriver = new AndroidDriver(new URL(properties.getProperty("appium.server.url")), options);

            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(properties.getProperty("implicit.wait"))));

            return androidDriver;
        } catch (Exception e) {
            throw new RuntimeException("Could not create Appium driver", e);
        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public Properties getProperties() {
        return properties;
    }

}