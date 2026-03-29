package com.globant.mobile.utils;

public class DataGenerator {

    public static String generateRandomEmail() {
        return "user" + System.currentTimeMillis() + "@mail.com";
    }

    public static String generateRandomPassword() {
        return "Test@" + System.currentTimeMillis();
    }

}