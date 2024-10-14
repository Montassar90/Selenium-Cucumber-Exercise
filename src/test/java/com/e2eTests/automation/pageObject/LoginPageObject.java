package com.e2eTests.automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

public class LoginPageObject {

	// Locates the "Email" input field using its XPath attribute
	@FindBy(how = How.XPATH, using = "//input[@data-qa='login-email']")
	private WebElement emailInput;

	// Locates the "Password" input field using its 'name' attribute
	@FindBy(how = How.NAME, using = "password")
	private WebElement pwInput;

	// Locates the "Login" button using its XPath attribute
	@FindBy(how = How.XPATH, using = "//button[@data-qa='login-button']")
	private WebElement loginButton;
	
	// Locates the confirmation message by its XPath
		@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[10]//b")
		private WebElement loginMsg;


	// Locates the error message by its XPath
	@FindBy(how = How.XPATH, using = "//div[@class='login-form']//p")
	private WebElement errorMsg;

	// Object to read configuration properties like email and password
	public ConfigFileReader configFileReader;

	// Constructor: Initializes web elements on the page and creates a
	// ConfigFileReader instance
	public LoginPageObject() {
		// Initializes all elements with @FindBy annotations using the driver instance
		PageFactory.initElements(Setup.getDriver(), this);
		// Initializes the configFileReader to read properties from a configuration file
		configFileReader = new ConfigFileReader();
	}

	// Method to perform a valid login using the correct credentials
	public void performValidLogin() {
		// Enters the valid email from the configuration file into the email input field
		emailInput.sendKeys(configFileReader.getProperties("email"));
		// Enters the valid password from the configuration file into the password input
		// field
		pwInput.sendKeys(configFileReader.getProperties("password"));
	}

	// Method to perform an invalid login using an incorrect password
	public void performInvalidLogin() {
		// Enters the valid email from the configuration file into the email input field
		emailInput.sendKeys(configFileReader.getProperties("email"));
		// Enters an invalid password from the configuration file into the password
		// input field
		pwInput.sendKeys(configFileReader.getProperties("invalid_pw"));
	}
	
	// Clicks the login button to submit the form
	public void submitForm() {
		loginButton.click();
	}

	// Returns the error message element
	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getLoginMsg() {
		return loginMsg;
	}
	
	
}
