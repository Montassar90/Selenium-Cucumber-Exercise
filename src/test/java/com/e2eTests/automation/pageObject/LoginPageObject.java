package com.e2eTests.automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.automation.utils.Setup;

public class LoginPageObject {
	
	// Locates the "Email" input field using its XPath attribute
	@FindBy(how = How.XPATH, using = "//div[@class='login-form']//input[@type='email']")
	private WebElement emailInput;

	// Locates the "Password" input field using its 'name' attribute
	@FindBy(how = How.NAME, using = "password")
	private WebElement pwInput;

	// Locates the "Login" button using its XPath attribute
	@FindBy(how = How.XPATH, using = "//div[@class='login-form']//button[@type='submit']")
	private WebElement loginButton;

	// Locates the confirmation message by its XPath
	@FindBy(how = How.XPATH, using = "//div[@class='shop-menu pull-right']//a[i[@class='fa fa-user']]")
	private WebElement loginMsg;

	// Locates the error message by its XPath
	@FindBy(how = How.XPATH, using = "//div[@class='login-form']//p[text()='Your email or password is incorrect!']")
	private WebElement errorMsg;

	// Object to read configuration properties like email and password

	// Constructor: Initializes web elements on the page and creates a

	public LoginPageObject() {
		// Initializes all elements with @FindBy annotations using the driver instance
		PageFactory.initElements(Setup.getDriver(), this);

	}

	// Method to perform a valid login using the correct credentials
	public void performValidLogin(String email, String password) {
		// Enters the valid email from the configuration file into the email input field
		emailInput.sendKeys(email);
		// Enters the valid password from the configuration file into the password input
		// field
		pwInput.sendKeys(password);
	}

	// Method to perform an invalid login using an incorrect password
	public void performInvalidLogin(String email, String invalidPw) {
		// Enters the valid email from the configuration file into the email input field
		emailInput.sendKeys(email);
		// Enters an invalid password from the configuration file into the password
		// input field
		pwInput.sendKeys(invalidPw);
	}

	// Clicks the login button to submit the form
	public void submitForm() {
		loginButton.click();
	}

	// Returns the error message element
	public WebElement getErrorMsg() {
		return errorMsg;
	}

	// Returns the succes message element
	public WebElement getLoginMsg() {
		return loginMsg;
	}

}
