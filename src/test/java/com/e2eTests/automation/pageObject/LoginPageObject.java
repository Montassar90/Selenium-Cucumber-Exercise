package com.e2eTests.automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.automation.hooks.Setup;
import lombok.Getter;

@Getter
public class LoginPageObject {
	
	// Locates the "Email" input field using its CSS locator attribute
	@CacheLookup
	@FindBy(how = How.CSS, using = "input[data-qa='login-email']")
	private WebElement emailInput;

	// Locates the "Password" input field using its 'name' attribute
	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	private WebElement pwInput;

	// Locates the "Login" button using its CSS locator attribute
	@CacheLookup
	@FindBy(how = How.CSS, using = "button[data-qa='login-button']")
	private WebElement loginButton;

	// Locates the confirmation message by its CSS locator
	@FindBy(how = How.CSS, using = ".nav.navbar-nav li:last-of-type a")
	private WebElement loginMsg;

	// Locates the error message by its CSS locator
	@FindBy(how = How.CSS, using = ".login-form p")
	private WebElement errorMsg;

	public LoginPageObject() {
		// Initializes all elements with @FindBy annotations 
		PageFactory.initElements(Setup.getDriver(), this);

	}

	// Method to perform login
	public void performLogin(String email, String password) {
		// Enters the email from the configuration file into the email input field
		emailInput.sendKeys(email);
		// Enters the password from the configuration file into the password input
		// field
		pwInput.sendKeys(password);
	}

	// Clicks the login button to submit the form
	public void submitForm() {
		loginButton.click();
	}

}
