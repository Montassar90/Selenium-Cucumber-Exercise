package com.e2eTests.automation.stepDefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.e2eTests.automation.pageObject.RegistrationPageObject;
import com.e2eTests.automation.utils.ConfigFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// This class defines the step definitions for the registration process using Cucumber
public class RegistrationStepDefinition {

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
        registrationPageObject.connectToApp();
    }

    // Step definition for clicking on the "Signup" link
    @Given("I click on Signup link")
    public void iClickOnSignupLink() {
        registrationPageObject.navigateToSignup();
    }

    // Step definition for entering the name and email in the signup form
    @When("I enter name and email address")
    public void iEnterNameAndEmailAddress() {
        registrationPageObject.fillName();
        registrationPageObject.fillEmail();
    }

    // Step definition for clicking the "Signup" button
    @When("I click on Signup button")
    public void iClickOnSignupButton() {
        registrationPageObject.openSignupForm();
    }

    // Step definition for filling the entire signup form (including title, birth date, country, etc.)
    @When("I fill the Signup form")
    public void iFillTheSignupForm() {
        registrationPageObject.selectTitle();
        registrationPageObject.fillForm();
        registrationPageObject.setBirthDate();
        registrationPageObject.selectCountry();
    }

    // Step definition for clicking the "Create Account" button to submit the form
    @When("I click the Create Account button")
    public void iClickTheCreateAccountButton() {
        registrationPageObject.createAccount();
    }

    // Step definition for verifying that the confirmation message is displayed
    @Then("Confirmation message should be displayed")
    public void confirmationMessageShouldBeDisplayed() {
        // Verifies that the actual confirmation message matches the expected message from the configuration file
        assertEquals(configFileReader.getProperties("confirmMsg"), registrationPageObject.getMessage().getText());
    }
}
