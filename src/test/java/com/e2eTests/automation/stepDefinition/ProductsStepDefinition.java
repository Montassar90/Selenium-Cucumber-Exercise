package com.e2eTests.automation.stepDefinition;

import static org.junit.Assert.assertTrue; // Importing assertion to validate conditions in tests
import java.util.List; // Importing List to handle collections of web elements

import org.apache.logging.log4j.Logger; // Importing logger for logging info and errors
import org.openqa.selenium.WebElement; // Importing WebElement for interacting with elements on a webpage
import com.e2eTests.automation.pageObject.ProductsPageObject; // Importing the page object class for Products
import com.e2eTests.automation.utils.LoggerHelper; // Importing helper class for logger
import io.cucumber.java.en.Given; // Importing Cucumber annotation for the "Given" step
import io.cucumber.java.en.Then; // Importing Cucumber annotation for the "Then" step
import io.cucumber.java.en.When; // Importing Cucumber annotation for the "When" step

public class ProductsStepDefinition {

	// Logger declaration to log events in the class
	private static final Logger logger = LoggerHelper.getLogger(ProductsStepDefinition.class);

	// Object of ProductsPageObject to interact with the Products page
	public ProductsPageObject productsPageObject;

	// Constructor initializing the ProductsPageObject
	public ProductsStepDefinition() {
		productsPageObject = new ProductsPageObject();
	}

	// Step definition for clicking on the Products link
	@Given("I click on Products link")
	public void iClickOnProductsLink() {
		// Log the action of clicking the Products link
		logger.info("Attempting to click on the Products link");
		productsPageObject.navigateToProductsList(); // Navigates to the Products list page
		logger.info("Clicked on the Products link successfully");
	}

	// Step definition to verify that the products list is displayed
	@Then("The products list should display the products")
	public void theProductsListShouldDisplayTheProducts() {
		logger.info("Verifying that the products list is displayed");

		// Check if the product list contains at least one product
		boolean isProductListDisplayed = productsPageObject.getProductsList().size() > 0;
		assertTrue(isProductListDisplayed); // Assert that the condition is true

		if (isProductListDisplayed) {
			logger.info("Products list is displayed successfully");
		} else {
			logger.error("Products list is not displayed");
		}
	}

	// Step definition for clicking on a random product's view link
	@When("I click on view product link of a random product")
	public void iClickOnViewProductLinkOfARandomProduct() {
		logger.info("Attempting to click on view product link of a random product");
		productsPageObject.navigateToProductDetails(); // Navigates to the product details page
		logger.info("Clicked on view product link successfully");
	}

	// Step definition to verify product details visibility on the product page
	@Then("I should be redirected to the product page and the product details are visible")
	public void iShouldBeRedirectedToTheProductPageAndTheProductDetailsAreVisible() {
		logger.info("Verifying that the product details are visible on the product page");

		// Get the list of product details elements
		List<WebElement> productDetails = productsPageObject.getProductDetails();

		// Check if all product details elements are displayed
		boolean areDetailsVisible = productDetails.stream().allMatch(WebElement::isDisplayed);
		assertTrue(areDetailsVisible); // Assert that all elements are visible

		if (areDetailsVisible) {
			logger.info("Product details are visible successfully");
		} else {
			logger.error("Product details are not visible");
		}
	}
}
