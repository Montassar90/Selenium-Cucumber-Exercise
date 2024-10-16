package com.e2eTests.automation.stepDefinition;

import org.apache.logging.log4j.Logger;

import com.e2eTests.automation.pageObject.RegistrationPageObject;
import com.e2eTests.automation.utils.BrowserUtils;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.LoggerHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// This class defines the step definitions for the registration process using Cucumber
public class RegistrationStepDefinition {

	private static final Logger logger = LoggerHelper.getLogger(RegistrationStepDefinition.class);

	// Object that models the registration page (Page Object Model)
	public RegistrationPageObject registrationPageObject;
	// Utility class to read configuration properties
	public ConfigFileReader configFileReader;

	// Constructor: initializes the page object and the config file reader
	public RegistrationStepDefinition() {
		registrationPageObject = new RegistrationPageObject();
		configFileReader = new ConfigFileReader();
	}

	// Step definition for navigating to the application URL
	@Given("I navigate to the automationexercise application")
	public void iNavigateToTheAutomationexerciseApplication() {
		logger.info("Navigated to Application page.");
		registrationPageObject.connectToApp();
	}

	// Step definition for clicking on the "Signup" link
	@Given("I click on Signup\\/Login link")
	public void iClickOnSignupLoginLink() {
		logger.info("Navigated to Signup/Login page.");
		registrationPageObject.navigateToSignup();
	}

	// Step definition for entering the name and email in the signup form
	@When("I enter name and email address")
	public void iEnterNameAndEmailAddress() {
		logger.info("Entering valid username and password.");
		registrationPageObject.fillName(configFileReader.getProperties("name"));
		registrationPageObject.fillEmail(configFileReader.getProperties("email"));
	}

	// Step definition for clicking the "Signup" button
	@When("I click on Signup button")
	public void iClickOnSignupButton() {
		logger.info("Clicking the Signup button.");
		registrationPageObject.openSignupForm();
	}

	// Step definition for filling the entire signup form (including title, birth
	// date, country, etc.)
	@When("I fill the Signup form")
	public void iFillTheSignupForm() {
		 logger.info("Filling the signup form.");
		 logger.info("Selecting title.");
		registrationPageObject.selectTitle();
        logger.info("Filling the form with personal information.");
		registrationPageObject.fillForm();
        logger.info("Setting birth date.");
		registrationPageObject.setBirthDate();
        logger.info("Selecting country.");
		registrationPageObject.selectCountry();
        logger.info("Signup form filled successfully.");

	}

	// Step definition for clicking the "Create Account" button to submit the form
	@When("I click the Create Account button")
	public void iClickTheCreateAccountButton() {
		registrationPageObject.createAccount();
		logger.info("Clicking the create account button");
	}

	// Step definition for verifying that the confirmation message is displayed
	@Then("Confirmation message should be displayed")
	public void confirmationMessageShouldBeDisplayed() {
		// Verifies that the actual confirmation message matches the expected message
		// from the configuration file
		BrowserUtils.handleAsserts("SignupConfirmMsg", registrationPageObject.getMessage().getText());
	}

	// Verifies that the actual error message matches the expected message from the
	// configuration file
	@Then("An error message should be displayed and i am not able to signup")
	public void anErrorMessageShouldBeDisplayedAndIAmNotAbleToSignup() {

		BrowserUtils.handleAsserts("SignupErrorMsg", registrationPageObject.getErrorMessage().getText());
	}
}
