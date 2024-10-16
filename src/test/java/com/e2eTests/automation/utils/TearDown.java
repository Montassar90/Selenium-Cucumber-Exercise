package com.e2eTests.automation.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class TearDown {
	private static final Logger logger = LoggerHelper.getLogger(Setup.class);

	// This method is executed after each test scenario due to the @After annotation
	@After
	public void quitDriver(Scenario scenario) {


		// Log the result of the scenario (pass/fail)
		if (scenario.isFailed()) {
			logger.error("Scenario failed: " + scenario.getName());
		} else {
			logger.info("Scenario passed: " + scenario.getName());
		}
		logger.info("Tearing down WebDriver after scenario: " + scenario.getName());

		// Quit the WebDriver instance, closing the browser
		Setup.getDriver().quit();
	}
}
