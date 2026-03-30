# Test Automation Mobile Project

## Overview
Mobile automation framework built using **Appium + Java + TestNG + Maven**, following **Page Object Model (POM)** and best practices for scalable test automation.

---

## Tech Stack

- Java 17  
- Appium (Java Client)  
- Selenium API  
- TestNG  
- Maven  

---

## Project Structure

```
src
 └── test
     ├── java
     │   ├── screens      → Page Objects
     │   ├── tests        → Test classes
     │   └── utils        → Base classes & helpers
     │
     └── resources
         ├── config.properties
         └── testng.xml
```

---

## Features Implemented

### Authentication
- User Sign Up
- User Login (with precondition setup)

### Swipe Gestures
- Horizontal swipe on carousel
- Validation of card transitions
- Navigation to last card
- Vertical swipe to find hidden element

---

## Setup Instructions

### 1. Prerequisites

- Java 17 installed
- Android Studio + SDK configured
- Appium Server running
- Emulator or real device connected

---

### 2. Environment Variables

```
ANDROID_HOME = <your_android_sdk_path>
JAVA_HOME = <your_jdk_17_path>
```

Add to PATH:
```
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\emulator
%JAVA_HOME%\bin
```

---

### 3. Run Tests

From IntelliJ:
- Run `testng.xml`

Or with Maven:

```
mvn clean test
```

---

## Framework Design

- Page Object Model (POM)
- Base classes:
  - `BaseTest` → driver setup/teardown
  - `BasePage` → reusable actions (click, swipe, wait)
- Data generation using Faker
- Test isolation with `@BeforeMethod`

---

## Test Strategy

- Each test is independent
- Preconditions handled inside tests
- UI validations based on visibility and text assertions
