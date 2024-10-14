package com.e2eTests.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;

// This class is responsible for setting up the WebDriver used for browser automation
public class Setup {
    
    // WebDriver instance to control the browser
    private static WebDriver driver;

    // This method is executed before each Cucumber scenario using the @Before annotation
    // It initializes the WebDriver, specifically a ChromeDriver instance
    @Before
    public void setWebDriver() {
        // Initializes the ChromeDriver (used to control Chrome browser)
        driver = new ChromeDriver();
        // Maximizes the browser window for better visibility during testing
        driver.manage().window().maximize();
    }

    // Static method to return the WebDriver instance, allowing other classes to access it
    public static WebDriver getDriver() {
        return driver;
    }
}
