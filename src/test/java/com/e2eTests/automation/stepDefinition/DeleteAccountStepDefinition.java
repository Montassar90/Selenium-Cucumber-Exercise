package com.e2eTests.automation.stepDefinition;

import com.e2eTests.automation.pageObject.DeleteAccountPageObject;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.SeleniumUtils;
import io.cucumber.java.en.*;

public class DeleteAccountStepDefinition {
	// Declaring page object and configuration file reader instances
	public DeleteAccountPageObject deleteAccountPageObject;
	public ConfigFileReader configFileReader;
	public SeleniumUtils seleniumUtils;

	// Constructor to initialize page object and config file reader
	public DeleteAccountStepDefinition() {
		deleteAccountPageObject = new DeleteAccountPageObject();
		configFileReader = new ConfigFileReader();
		seleniumUtils = new SeleniumUtils();

	}
	
	// Step definition for clicking on "Delete Account" link
	@When("I click on the Delete Account link")
	public void i_click_on_the_delete_account_link() {
		deleteAccountPageObject.clickDeleteAccountLink();
	}

	// Step definition for verifying the success message
	@Then("My account should be deleted and I should see a confirmation message")
	public void my_account_should_be_deleted_and_i_should_see_a_confirmation_message() {
		seleniumUtils.handleAsserts("deleteAccountMsg", deleteAccountPageObject.getConfirmMsg().getText());
	}

}
