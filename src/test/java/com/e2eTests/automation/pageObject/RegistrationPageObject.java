package com.e2eTests.automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

public class RegistrationPageObject {

	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[4]/a")
	private static WebElement signupMenu;

	@FindBy(how = How.NAME, using = "name")
	private WebElement nameInput;

	@FindBy(how = How.XPATH, using = "//div[@class='signup-form']/form/input[3]")
	private WebElement emailInput;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Signup')]")
	private WebElement signupButton;

	@FindBy(how = How.ID, using = "id_gender1")
	private WebElement title;

	@FindBy(how = How.ID, using = "password")
	private WebElement password;

	@FindBy(how = How.ID, using = "days")
	private WebElement birthDay;

	@FindBy(how = How.ID, using = "months")
	private WebElement birthMonth;

	@FindBy(how = How.ID, using = "years")
	private WebElement birthYear;

	@FindBy(how = How.ID, using = "first_name")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "last_name")
	private WebElement lastName;

	@FindBy(how = How.ID, using = "company")
	private WebElement company;

	@FindBy(how = How.ID, using = "address1")
	private WebElement address;

	@FindBy(how = How.ID, using = "country")
	private WebElement country;

	@FindBy(how = How.ID, using = "state")
	private WebElement state;

	@FindBy(how = How.ID, using = "city")
	private WebElement city;

	@FindBy(how = How.ID, using = "zipcode")
	private WebElement zipCode;

	@FindBy(how = How.ID, using = "mobile_number")
	private WebElement mobileNumber;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Create Account')]")
	private WebElement createButton;
	
	@FindBy(how = How.XPATH, using = "//h2[@class='title text-center']/b")
	private  WebElement message;

	public ConfigFileReader configFileReader;

	public RegistrationPageObject() {
		PageFactory.initElements(Setup.getDriver(), this);
		configFileReader = new ConfigFileReader();
	}

	public void connectToApp() {
		Setup.getDriver().get(configFileReader.getProperties("baseUrl"));
	}

	public void navigateToSignup() {
		signupMenu.click();
	}

	public void fillName() {
		nameInput.sendKeys(configFileReader.getProperties("name"));
	}

	public void fillEmail() {
		emailInput.sendKeys(configFileReader.getProperties("email"));
	}

	public void openSignupForm() {
		signupButton.click();
	}

	public void selectTitle() {
		title.click();
	}

	public void fillField(WebElement element, String value) {
		element.sendKeys(value);
	}

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

	public void selectDropDown(WebElement element, String value) {
	    Select dropDown = new Select(element);
	    dropDown.selectByValue(value);
	}

	public void setBirthDate() {
	    selectDropDown(birthDay, configFileReader.getProperties("birthDay"));
	    selectDropDown(birthMonth, configFileReader.getProperties("birthMonth"));
	    selectDropDown(birthYear, configFileReader.getProperties("birthYear"));
	}

	public void selectCountry() {
		Select dropDownCountry = new Select(country);
		dropDownCountry.selectByValue(configFileReader.getProperties("country"));
	}
	
	public void createAccount() {
		createButton.click();
	}

	public WebElement getMessage() {
		return message;
	}

	/*public void setMessage(WebElement message) {
		this.message = message;
	}*/
	
	

}
