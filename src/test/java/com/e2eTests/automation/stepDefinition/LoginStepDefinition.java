package com.e2eTests.automation.stepDefinition;

import com.e2eTests.automation.pageObject.LoginPageObject;
import com.e2eTests.automation.utils.SeleniumUtils;
import com.e2eTests.automation.utils.ConfigFileReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	public LoginPageObject loginPageObject;
	public ConfigFileReader configFileReader;
	public SeleniumUtils seleniumUtils;;

	// Constructor to initialize the LoginPageObject
	public LoginStepDefinition() {
		loginPageObject = new LoginPageObject();
		configFileReader = new ConfigFileReader();
		seleniumUtils = new SeleniumUtils();
	}

	// Step definition for entering valid login credentials
	@When("I enter a valid email address and password")
	public void iEnterEmailAddressAndPassword() {
		loginPageObject.performValidLogin(configFileReader.getProperties("email"),
				configFileReader.getProperties("password")); // Method to handle valid login input
	}

	// Step definition for clicking the login button
	@When("I click on the Login button")
	public void iClickOnTheLoginButton() {
		loginPageObject.submitForm(); // Method to submit the login form
	}

	// Step definition for asserting successful login and visibility of username
	@Then("I should be redirected to home page and my username is visible in the top")
	public void iShouldBeRedirectedToHomePageAndMyUsernameIsVisibleInTheTop() {
		// Using seleniumUtils to assert the presence of the username in the home page
		seleniumUtils.handleAsserts("loginConfirmMsg", loginPageObject.getLoginMsg().getText());
	}

	// Step definition for entering invalid login credentials
	@When("I enter invalid email address or password")
	public void iEnterInvalidEmailAddressAndPassword() {
		loginPageObject.performInvalidLogin(configFileReader.getProperties("email"),
				configFileReader.getProperties("invalidPw")); // Method to handle invalid login input
	}

	// Step definition for asserting that an error message is displayed after
	// invalid login
	@Then("An error message should be displayed")
	public void anErrorMessageShouldBeDisplayed() {
		// Using seleniumUtils to assert the presence of the error message
		seleniumUtils.handleAsserts("loginErrorMsg", loginPageObject.getErrorMsg().getText());
	}
}
