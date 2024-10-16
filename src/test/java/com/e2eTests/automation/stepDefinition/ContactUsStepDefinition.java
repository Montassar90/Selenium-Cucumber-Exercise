package com.e2eTests.automation.stepDefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.e2eTests.automation.pageObject.ContactUsPageObject;
import com.e2eTests.automation.utils.BrowserUtils;
import com.e2eTests.automation.utils.ConfigFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsStepDefinition {

	// Declaring page object and configuration file reader instances
	public ContactUsPageObject contactUsPageObject;
	public ConfigFileReader configFileReader;

	// Constructor to initialize page object and config file reader
	public ContactUsStepDefinition() {
		contactUsPageObject = new ContactUsPageObject();
		configFileReader = new ConfigFileReader();
	}

	// Step definition for clicking on "Contact Us" link
	@Given("I click on Contact Us link")
	public void iClickOnContactUsLink() {
		contactUsPageObject.navigateToContact();
	}

	// Step definition for filling out the contact form
	@When("I fill the form")
	public void iFillTheForm() {
		contactUsPageObject.fillForm();
	}

	// Step definition for submitting the form
	@When("I click on the Submit button")
	public void iClickOnTheSubmitButton() {
		contactUsPageObject.submitForm();

		// Handling any alert that appears after submitting the form
		BrowserUtils.handleAlert();
	}

	// Step definition for verifying the success message
	@Then("A success message should display")
	public void aSuccesMessageShouldDisplay() {
		// Asserting that the success message is displayed as expected
		BrowserUtils.handleAsserts("contactSuccessMsg", contactUsPageObject.getSuccessMsg().getText());
	}

}
