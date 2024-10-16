package com.e2eTests.automation.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

// This class is responsible for setting up the WebDriver used for browser automation
public class Setup {
    
    // WebDriver instance to control the browser
    private static WebDriver driver;
    private static final Logger logger = LoggerHelper.getLogger(Setup.class);

    // This method is executed before each Cucumber scenario using the @Before annotation
    // It initializes the WebDriver, specifically a ChromeDriver instance
    @Before
    public void setWebDriver(Scenario scenario) {
        // Initializes the ChromeDriver (used to control Chrome browser)
    	logger.info("Starting scenario: " + scenario.getName());
        driver = new ChromeDriver();
        // Maximizes the browser window for better visibility during testing
        driver.manage().window().maximize();
    }

    // Static method to return the WebDriver instance, allowing other classes to access it
    public static WebDriver getDriver() {
        return driver;
    }
}
