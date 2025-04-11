package com.e2eTests.automation.utils;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.NoAlertPresentException;

import com.e2eTests.automation.hooks.Setup;


public class SeleniumUtils {

	// Method to handle browser alerts (accepts the alert if present)
	public void handleAlert() {
		try {
			// Switch to the alert and accept it (click OK)
		Setup.getDriver().switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// If no alert is present, print a message
			System.out.println("No alert present.");
		}
	}

	// Instance of ConfigFileReader to read configuration properties
	private ConfigFileReader configFileReader = new ConfigFileReader();

	// Method to handle assertions (compares expected and actual values)
	public void handleAsserts(String expected, String actual) {
		// Asserts that the expected value from the config file matches the actual value
		assertEquals(configFileReader.getProperties(expected), actual);
	}
	
}
