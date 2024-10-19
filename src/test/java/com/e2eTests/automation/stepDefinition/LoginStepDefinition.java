package com.e2eTests.automation.stepDefinition;

import org.apache.logging.log4j.Logger;

import com.e2eTests.automation.pageObject.LoginPageObject;
import com.e2eTests.automation.utils.BrowserUtils;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.LoggerHelper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	// Logger instance
	private static final Logger logger = LoggerHelper.getLogger(LoginStepDefinition.class);
	// Instance of the LoginPageObject to interact with the login page elements
	public LoginPageObject loginPageObject;
	public ConfigFileReader configFileReader;

	// Constructor to initialize the LoginPageObject
	public LoginStepDefinition() {
		loginPageObject = new LoginPageObject();
		configFileReader = new ConfigFileReader();
		logger.info("LoginStepDefinition initialized");
	}

	// Step definition for entering valid login credentials
	@When("I enter a valid email address and password")
	public void iEnterEmailAddressAndPassword() {
		logger.info("Entering valid email and password");
		loginPageObject.performValidLogin(configFileReader.getProperties("email"),
				configFileReader.getProperties("password")); // Method to handle valid login input
	}

	// Step definition for clicking the login button
	@When("I click on the Login button")
	public void iClickOnTheLoginButton() {
		logger.info("Clicking on the Login button");
		loginPageObject.submitForm(); // Method to submit the login form
	}

	// Step definition for asserting successful login and visibility of username
	@Then("I should be redirected to home page and my username is visible in the top")
	public void iShouldBeRedirectedToHomePageAndMyUsernameIsVisibleInTheTop() {
		// Using BrowserUtils to assert the presence of the username in the home page
		logger.info("Asserting visibility of username on the home page");
		BrowserUtils.handleAsserts("loginConfirmMsg", loginPageObject.getLoginMsg().getText());
	}

	// Step definition for entering invalid login credentials
	@When("I enter invalid email address or password")
	public void iEnterInvalidEmailAddressAndPassword() {
		logger.info("Entering valid email and invalid password");
		loginPageObject.performInvalidLogin(configFileReader.getProperties("email"),
				configFileReader.getProperties("invalid_pw")); // Method to handle invalid login input
	}

	// Step definition for asserting that an error message is displayed after
	// invalid login
	@Then("An error message should be displayed")
	public void anErrorMessageShouldBeDisplayed() {
		// Using BrowserUtils to assert the presence of the error message
		logger.info("Asserting visibility of error message");
		BrowserUtils.handleAsserts("loginErrorMsg", loginPageObject.getErrorMsg().getText());
	}
}
