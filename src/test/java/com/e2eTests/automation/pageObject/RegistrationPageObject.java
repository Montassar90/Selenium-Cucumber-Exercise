package com.e2eTests.automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

// This class models the page object for the registration form
public class RegistrationPageObject {

	// Locates the "Sign Up" menu item using its XPath
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li/a[text()=' Signup / Login']")
	private static WebElement signupMenu;

	// Locates the "Name" input field by its name attribute
	@FindBy(how = How.NAME, using = "name")
	private WebElement nameInput;

	// Locates the "Email" input field using its XPath
	@FindBy(how = How.XPATH, using = "//input[@data-qa='signup-email']")
	private WebElement emailInput;

	// Locates the "Sign Up" button using XPath
	@FindBy(how = How.XPATH, using = "//button[@data-qa='signup-button']")
	private WebElement signupButton;

	// Locates the "Title" (gender) radio button by its ID
	@FindBy(how = How.ID, using = "id_gender1")
	private WebElement title;

	// Locates the "Password" input field by its ID
	@FindBy(how = How.ID, using = "password")
	private WebElement password;

	// Locates the dropdown for birth day by its ID
	@FindBy(how = How.ID, using = "days")
	private WebElement birthDay;

	// Locates the dropdown for birth month by its ID
	@FindBy(how = How.ID, using = "months")
	private WebElement birthMonth;

	// Locates the dropdown for birth year by its ID
	@FindBy(how = How.ID, using = "years")
	private WebElement birthYear;

	// Locates the "First Name" input field by its ID
	@FindBy(how = How.ID, using = "first_name")
	private WebElement firstName;

	// Locates the "Last Name" input field by its ID
	@FindBy(how = How.ID, using = "last_name")
	private WebElement lastName;

	// Locates the "Company" input field by its ID
	@FindBy(how = How.ID, using = "company")
	private WebElement company;

	// Locates the "Address" input field by its ID
	@FindBy(how = How.ID, using = "address1")
	private WebElement address;

	// Locates the "Country" dropdown by its ID
	@FindBy(how = How.ID, using = "country")
	private WebElement country;

	// Locates the "State" input field by its ID
	@FindBy(how = How.ID, using = "state")
	private WebElement state;

	// Locates the "City" input field by its ID
	@FindBy(how = How.ID, using = "city")
	private WebElement city;

	// Locates the "Zip Code" input field by its ID
	@FindBy(how = How.ID, using = "zipcode")
	private WebElement zipCode;

	// Locates the "Mobile Number" input field by its ID
	@FindBy(how = How.ID, using = "mobile_number")
	private WebElement mobileNumber;

	// Locates the "Create Account" button by its XPath
	@FindBy(how = How.XPATH, using = "//button[@data-qa='create-account']")
	private WebElement createButton;

	// Locates the confirmation message (e.g., "Account Created") by its XPath
	@FindBy(how = How.XPATH, using = "//h2[@class='title text-center']/b")
	private WebElement message;

	// Locates the error message by its XPath
	@FindBy(how = How.XPATH, using = "//div[@class='signup-form']//p")
	private WebElement errorMessage;

	// Handles reading configuration properties
	public ConfigFileReader configFileReader;

	// Constructor: initializes the web elements and the config file reader
	public RegistrationPageObject() {
		PageFactory.initElements(Setup.getDriver(), this);
		configFileReader = new ConfigFileReader();
	}

	// Opens the application by fetching the URL from the configuration file
	public void connectToApp() {
		Setup.getDriver().get(configFileReader.getProperties("baseUrl"));
	}

	// Navigates to the signup page by clicking on the signup menu
	public void navigateToSignup() {
		signupMenu.click();
	}

	// Fills the "Name" input field with the name from the configuration file
	public void fillName() {
		nameInput.sendKeys(configFileReader.getProperties("name"));
	}

	// Fills the "Email" input field with the email from the configuration file
	public void fillEmail() {
		emailInput.sendKeys(configFileReader.getProperties("email"));
	}

	// Opens the signup form by clicking the signup button
	public void openSignupForm() {
		signupButton.click();
	}

	// Selects the "Title" (gender) radio button
	public void selectTitle() {
		title.click();
	}

	// Helper method: fills a given input field with the provided value
	public void fillField(WebElement element, String value) {
		element.sendKeys(value);
	}

	// Fills the entire form with the data from the configuration file
	public void fillForm() {
		fillField(password, configFileReader.getProperties("password"));
		fillField(firstName, configFileReader.getProperties("firstName"));
		fillField(lastName, configFileReader.getProperties("lastName"));
		fillField(company, configFileReader.getProperties("company"));
		fillField(address, configFileReader.getProperties("address"));
		fillField(state, configFileReader.getProperties("state"));
		fillField(city, configFileReader.getProperties("city"));
		fillField(zipCode, configFileReader.getProperties("zip"));
		fillField(mobileNumber, configFileReader.getProperties("mobile"));
	}

	// Helper method: selects a value from a dropdown element
	public void selectDropDown(WebElement element, String value) {
		Select dropDown = new Select(element);
		dropDown.selectByValue(value);
	}

	// Fills the birth date (day, month, year) using dropdown selections
	public void setBirthDate() {
		selectDropDown(birthDay, configFileReader.getProperties("birthDay"));
		selectDropDown(birthMonth, configFileReader.getProperties("birthMonth"));
		selectDropDown(birthYear, configFileReader.getProperties("birthYear"));
	}

	// Selects a country from the "Country" dropdown using a value from the
	// configuration file
	public void selectCountry() {
		Select dropDownCountry = new Select(country);
		dropDownCountry.selectByValue(configFileReader.getProperties("country"));
	}

	// Clicks the "Create Account" button to submit the form
	public void createAccount() {
		createButton.click();
	}

	// Returns the confirmation message element (e.g., to verify account creation)
	public WebElement getMessage() {
		return message;
	}

	// Returns the error message element
	public WebElement getErrorMessage() {
		return errorMessage;
	}

}
