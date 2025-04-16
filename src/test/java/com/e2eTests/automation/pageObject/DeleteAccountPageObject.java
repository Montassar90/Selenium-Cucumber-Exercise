package com.e2eTests.automation.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.automation.hooks.Setup;

import lombok.Getter;

@Getter
public class DeleteAccountPageObject {
	
	// Locating the "Delete Account" link using CSS selector
	@FindBy(how= How.CSS, using = "a[href='/delete_account']" )
	private WebElement deleteAccountLink;
	// Locating the success message element after account deletion
	@FindBy(how= How.CSS, using = "h2[data-qa='account-deleted'] b" )
	private WebElement confirmMsg;
	
	// Constructor to initialize the WebElements 
	public DeleteAccountPageObject() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
	
	// Method to click on the "Delete Account" link
	public void clickDeleteAccountLink() {
		deleteAccountLink.click();
	}

}
