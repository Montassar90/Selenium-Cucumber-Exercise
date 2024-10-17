package com.e2eTests.automation.stepDefinition;

import java.util.logging.Logger;
import com.e2eTests.automation.pageObject.ContactUsPageObject;
import com.e2eTests.automation.utils.BrowserUtils;
import com.e2eTests.automation.utils.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsStepDefinition {

    // Logger instance
    private static final Logger logger = Logger.getLogger(ContactUsStepDefinition.class.getName());

    // Declaring page object and configuration file reader instances
    public ContactUsPageObject contactUsPageObject;
    public ConfigFileReader configFileReader;

    // Constructor to initialize page object and config file reader
    public ContactUsStepDefinition() {
        contactUsPageObject = new ContactUsPageObject();
        configFileReader = new ConfigFileReader();
        logger.info("Initialized ContactUsPageObject and ConfigFileReader");
    }

    // Step definition for clicking on "Contact Us" link
    @Given("I click on Contact Us link")
    public void iClickOnContactUsLink() {
        logger.info("Clicking on Contact Us link");
        contactUsPageObject.navigateToContact();
    }

    // Step definition for filling out the contact form
    @When("I fill the form")
    public void iFillTheForm() {
        logger.info("Filling the contact form");
        contactUsPageObject.fillForm();
    }

    // Step definition for submitting the form
    @When("I click on the Submit button")
    public void iClickOnTheSubmitButton() {
        logger.info("Clicking the Submit button");
        contactUsPageObject.submitForm();

        // Handling any alert that appears after submitting the form
        logger.info("Handling alert after submitting the form");
        BrowserUtils.handleAlert();
    }

    // Step definition for verifying the success message
    @Then("A success message should display")
    public void aSuccesMessageShouldDisplay() {
        String actualSuccessMessage = contactUsPageObject.getSuccessMsg().getText();
        logger.info("Verifying success message: " + actualSuccessMessage);
        
        // Asserting that the success message is displayed as expected
        BrowserUtils.handleAsserts("contactSuccessMsg", actualSuccessMessage);
    }
}
