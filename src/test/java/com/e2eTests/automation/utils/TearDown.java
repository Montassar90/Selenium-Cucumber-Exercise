package com.e2eTests.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class TearDown {

	// This method is executed after each test scenario due to the @After annotation
	@After
	public void quitDriver(Scenario scenario) {

		// Check if the scenario has failed
		if (scenario.isFailed()) {

			// If the scenario failed, take a screenshot
			final byte[] screenshot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);

			// Attach the screenshot to the Cucumber report as a PNG image
			scenario.attach(screenshot, "image/png", "screenshot");
		}

		// Quit the WebDriver instance, closing the browser
		Setup.getDriver().quit();
	}
}
