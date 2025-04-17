package com.e2eTests.automation.stepDefinition;

import com.e2eTests.automation.pageObject.RegistrationPageObject;
import com.e2eTests.automation.utils.SeleniumUtils;
import com.e2eTests.automation.utils.ConfigFileReader;
import io.cucumber.java.en.*;


// This class defines the step definitions for the registration process using Cucumber
public class RegistrationStepDefinition {
	// Object that models the registration page (Page Object Model)
	public RegistrationPageObject registrationPageObject;
	// Utility class to read configuration properties
	public ConfigFileReader configFileReader;
    public SeleniumUtils seleniumUtils;


	// Constructor: initializes the page object and the config file reader
	public RegistrationStepDefinition() {
		registrationPageObject = new RegistrationPageObject();
		configFileReader = new ConfigFileReader();
		seleniumUtils = new SeleniumUtils();

	}

	// Step definition for navigating to the application URL
	@Given("I navigate to the automationexercise application")
	public void iNavigateToTheAutomationexerciseApplication() {
		registrationPageObject.connectToApp();
	}

	// Step definition for clicking on the "Signup" link
	@Given("I click on Signup\\/Login link")
	public void iClickOnSignupLoginLink() {
		registrationPageObject.navigateToSignup();
	}

	// Step definition for entering the name and email in the signup form
	@When("I enter name and email address")
	public void iEnterNameAndEmailAddress() {
		registrationPageObject.fillField(registrationPageObject.getNameInput(),configFileReader.getProperties("name"));
		registrationPageObject.fillField(registrationPageObject.getEmailInput(),configFileReader.getProperties("email"));
	}

	// Step definition for clicking the "Signup" button
	@When("I click on Signup button")
	public void iClickOnSignupButton() {
		registrationPageObject.openSignupForm();
	}

	// Step definition for filling the entire signup form (including title, birth
	// date, country, etc.)
	@When("I fill the Signup form")
	public void iFillTheSignupForm() {
		registrationPageObject.selectTitle();
		registrationPageObject.fillField(registrationPageObject.getPassword(), configFileReader.getProperties("password"));
		registrationPageObject.fillField(registrationPageObject.getFirstName(), configFileReader.getProperties("firstName"));
		registrationPageObject.fillField(registrationPageObject.getLastName(), configFileReader.getProperties("lastName"));
		registrationPageObject.fillField(registrationPageObject.getCompany(), configFileReader.getProperties("company"));
		registrationPageObject.fillField(registrationPageObject.getAddress(), configFileReader.getProperties("address"));
		registrationPageObject.fillField(registrationPageObject.getState(), configFileReader.getProperties("state"));
		registrationPageObject.fillField(registrationPageObject.getCity(), configFileReader.getProperties("city"));
		registrationPageObject.fillField(registrationPageObject.getZipCode(), configFileReader.getProperties("zip"));
		registrationPageObject.fillField(registrationPageObject.getMobileNumber(), configFileReader.getProperties("mobile"));
		registrationPageObject.setBirthDate(configFileReader.getProperties("birthDay"),
				configFileReader.getProperties("birthMonth"), configFileReader.getProperties("birthYear"));
		registrationPageObject.selectCountry(configFileReader.getProperties("country"));

	}

	// Step definition for clicking the "Create Account" button to submit the form
	@When("I click the Create Account button")
	public void iClickTheCreateAccountButton() {
		registrationPageObject.createAccount();
	}

	// Step definition for verifying that the confirmation message is displayed
	@Then("Confirmation message should be displayed")
	public void confirmationMessageShouldBeDisplayed() {
		// Verifies that the actual confirmation message matches the expected message
		// from the configuration file
		seleniumUtils.handleAsserts("SignupConfirmMsg", registrationPageObject.getConfirmMsg().getText());
	}

	// Verifies that the actual error message matches the expected message from the
	// configuration file
	@Then("An error message should be displayed and i am not able to signup")
	public void anErrorMessageShouldBeDisplayedAndIAmNotAbleToSignup() {

		seleniumUtils.handleAsserts("SignupErrorMsg", registrationPageObject.getErrorMessage().getText());
	}
}
