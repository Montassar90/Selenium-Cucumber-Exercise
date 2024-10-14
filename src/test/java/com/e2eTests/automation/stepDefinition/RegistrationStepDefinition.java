package com.e2eTests.automation.stepDefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.e2eTests.automation.pageObject.RegistrationPageObject;
import com.e2eTests.automation.utils.ConfigFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinition {

	public RegistrationPageObject registrationPageObject;
	public ConfigFileReader configFileReader;

	public RegistrationStepDefinition() {
		registrationPageObject = new RegistrationPageObject();
		configFileReader = new ConfigFileReader();
	}

	@Given("I navigate to the automationexercise application")
	public void iNavigateToTheAutomationexerciseApplication() {
		registrationPageObject.connectToApp();
	}

	@Given("I click on Signup link")
	public void iClickOnSignupLink() {
		registrationPageObject.navigateToSignup();
	}

	@When("I enter name and email address")
	public void iEnterNameAndEmailAddress() {
		registrationPageObject.fillName();
		registrationPageObject.fillEmail();
	}

	@When("I click on Signup button")
	public void iClickOnSignupButton() {
		registrationPageObject.openSignupForm();
	}

	@When("I fill the Signup form")
	public void iFillTheSignupForm() {
		registrationPageObject.selectTitle();
		registrationPageObject.fillForm();
		registrationPageObject.setBirthDate();
		registrationPageObject.selectCountry();
	}

	@When("I click the Create Account button")
	public void iClickTheCreateAccountButton() {
		registrationPageObject.createAccount();
	}

	@Then("Confirmation message should be displayed")
	public void confirmationMessageShouldBeDisplayed() {
		// String expectedMsg = registrationPageObject.message.getText();

		assertEquals(configFileReader.getProperties("confirmMsg"), registrationPageObject.getMessage().getText());
	}

}
