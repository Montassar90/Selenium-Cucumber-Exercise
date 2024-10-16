package com.e2eTests.automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

public class ContactUsPageObject {

	// Locating the "Contact Us" link using XPath
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li/a[text()=' Contact us']")
	private WebElement contactLink;

	// Locating the "Name" input field
	@FindBy(how = How.NAME, using = "name")
	private WebElement nameInput;

	// Locating the "Email" input field
	@FindBy(how = How.NAME, using = "email")
	private WebElement emailInput;

	// Locating the "Subject" input field
	@FindBy(how = How.NAME, using = "subject")
	private WebElement subjectInput;

	// Locating the "Message" input field
	@FindBy(how = How.ID, using = "message")
	private WebElement messageInput;

	// Locating the file upload element
	@FindBy(how = How.NAME, using = "upload_file")
	private WebElement fileUpload;

	// Locating the "Submit" button
	@FindBy(how = How.NAME, using = "submit")
	private WebElement submitBtn;

	// Locating the success message element after form submission
	@FindBy(how = How.CSS, using = ".status.alert.alert-success")
	private WebElement successMsg;

	// ConfigFileReader object to read data from configuration files
	public ConfigFileReader configFileReader;

	// Constructor to initialize the WebElements and ConfigFileReader
	public ContactUsPageObject() {
		// Initializing WebElements using PageFactory
		PageFactory.initElements(Setup.getDriver(), this);
		// Instantiating ConfigFileReader to access config data
		configFileReader = new ConfigFileReader();
	}

	// Method to navigate to the "Contact Us" page by clicking the contact link
	public void navigateToContact() {
		contactLink.click();
	}

	// Generic method to fill any input field with the specified value
	public void fillInputField(WebElement field, String value) {
		field.sendKeys(value);
	}

	// Method to fill out the contact form using values from the config file
	public void fillForm() {
		// Filling name, email, subject, message, and file upload
		fillInputField(nameInput, configFileReader.getProperties("name"));
		fillInputField(emailInput, configFileReader.getProperties("email"));
		fillInputField(subjectInput, configFileReader.getProperties("contactSubject"));
		fillInputField(messageInput, configFileReader.getProperties("contactMsg"));
		fileUpload.sendKeys(configFileReader.getProperties("filePath"));
	}

	// Method to submit the form by clicking the submit button
	public void submitForm() {
		submitBtn.click();
	}

	// Getter method to retrieve the success message after form submission
	public WebElement getSuccessMsg() {
		return successMsg;
	}
}
