package com.e2eTests.automation.pageObject;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.automation.hooks.Setup;
import lombok.Getter;

@Getter
public class ProductsPageObject {

	// Locator for the Products link in the navigation bar
	@FindBy(how = How.CSS, using = "a[href='/products']")
	private WebElement productsLink;

	// Locator for the list of products displayed on the page
	@FindBy(how = How.CSS, using = ".features_items")
	private List<WebElement> productsList;

	@FindBy(how = How.ID, using = "scrollUp")
	private WebElement scrollUpBtn;

	// Locator for the 'View Product' link of the specific product 'Blue Top'
	@FindBy(how = How.CSS, using = "a[href='/product_details/1'] ")
	private WebElement viewProductLink;

	// Locator for the product name in the product details page
	@FindBy(how = How.CSS, using = ".product-information h2")
	private WebElement productName;

	// Locator for the product category in the product details page
	@FindBy(how = How.CSS, using = ".product-information p:first-of-type")
	private WebElement productCategory;

	// Locator for the product price in the product details page
	@FindBy(how = How.CSS, using = ".product-information span:first-child")
	private WebElement productPrice;

	// Locator for the product availability status in the product details page
	@FindBy(how = How.CSS, using = ".product-information :nth-child(6)")
	private WebElement productAvailability;

	// Locator for the product condition in the product details
	// page
	@FindBy(how = How.CSS, using = ".product-information :nth-child(7)")
	private WebElement productCondition;

	// Locator for the product brand in the product details page
	@FindBy(how = How.CSS, using = ".product-information :nth-child(8)")
	private WebElement productBrand;

	// Constructor: Initializes the web elements on the page using Selenium's
	// PageFactory
	public ProductsPageObject() {
		PageFactory.initElements(Setup.getDriver(), this);
	}

	// Method to navigate to the list of products by clicking on the Products link
	public void navigateToProductsList() {
		productsLink.click();
	}

	// Cast the driver to JavascriptExecutor and execute a script to scroll the
	// window to the bottom of the page
	public void scrollDownPage() {
		((JavascriptExecutor) Setup.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// Simulate a click on the scroll up button (assumes scrollUpBtn is defined
	// elsewhere in the class)
	public void clickScrollUpBtn() {
		((JavascriptExecutor) Setup.getDriver()).executeScript("arguments[0].click();", scrollUpBtn);
	}

	// Method to navigate to the product details of the specific product by clicking
	// the 'View Product' link
	public void navigateToProductDetails() {
		((JavascriptExecutor) Setup.getDriver()).executeScript("arguments[0].scrollIntoView(true);", viewProductLink);
		viewProductLink.click();
	}

	// Method to retrieve the details of the currently viewed product, including its
	// name, category, price, availability, condition, and brand
	public List<WebElement> getProductDetails() {
		List<WebElement> productDetails = new ArrayList<>();
		productDetails.add(productName);
		productDetails.add(productCategory);
		productDetails.add(productPrice);
		productDetails.add(productAvailability);
		productDetails.add(productCondition);
		productDetails.add(productBrand);
		return productDetails;
	}

}
