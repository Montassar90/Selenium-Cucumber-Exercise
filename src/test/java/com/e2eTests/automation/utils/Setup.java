package com.e2eTests.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;

public class Setup {
	private static WebDriver driver;

	@Before
	public void setWebDriver() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	// Getter
	public static WebDriver getDriver() {
		return driver;
	}
}
