package com.e2eTests.automation.stepDefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.e2eTests.automation.pageObject.LoginPageObject;
import com.e2eTests.automation.utils.ConfigFileReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	public LoginPageObject loginPageObject;
	public ConfigFileReader configFileReader;
	
	public LoginStepDefinition() {
		loginPageObject = new LoginPageObject();
		configFileReader = new ConfigFileReader();
	}

	@When("I enter a valid email address and password")
	public void iEnterEmailAddressAndPassword() {
	    loginPageObject.performValidLogin();
	}
	@When("I click on the Login button")
	public void iClickOnTheLoginButton() {
	    loginPageObject.submitForm();
	}
	@Then("I should be redirected to home page and my username is visible in the top")
	public void iShouldBeRedirectedToHomePageAndMyUsernameIsVisibleInTheTop() {
	    assertEquals(configFileReader.getProperties("name"), loginPageObject.getLoginMsg().getText());
	}
	

	@When("I enter invalid email address or password")
	public void iEnterInvalidEmailAddressAndPassword() {
		 loginPageObject.performInvalidLogin();
	}
	
	@Then("An error message should be displayed")
	public void anErrorMessageShouldBeDisplayed() {
	    assertEquals(configFileReader.getProperties("loginErrorMsg"),loginPageObject.getErrorMsg().getText());
	}







}
