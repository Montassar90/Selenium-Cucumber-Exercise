package com.e2eTests.automation.stepDefinition;

import static org.junit.Assert.assertTrue; 
import java.util.List; 
import org.openqa.selenium.WebElement; 
import com.e2eTests.automation.pageObject.ProductsPageObject;
import io.cucumber.java.en.*;


public class ProductsStepDefinition {

// Object of ProductsPageObject to interact with the Products page
	public ProductsPageObject productsPageObject;

	// Constructor initializing the ProductsPageObject
	public ProductsStepDefinition() {
		productsPageObject = new ProductsPageObject();
	}

	// Step definition for clicking on the Products link
	@Given("I click on Products link")
	public void iClickOnProductsLink() {
		productsPageObject.navigateToProductsList(); // Navigates to the Products list page
	}

	// Step definition to verify that the products list is displayed
	@Then("The products list should display the products")
	public void theProductsListShouldDisplayTheProducts() {

		// Check if the product list contains at least one product
		boolean isProductListDisplayed = productsPageObject.getProductsList().size() > 0;
		assertTrue(isProductListDisplayed);// Assert that the condition is true
	}

	// Step definition for clicking on a random product's view link
	@When("I click on view product link of a random product")
	public void iClickOnViewProductLinkOfARandomProduct() {
		productsPageObject.navigateToProductDetails(); // Navigates to the product details page
	}

	// Step definition to verify product details visibility on the product page
	@Then("I should be redirected to the product page and the product details are visible")
	public void iShouldBeRedirectedToTheProductPageAndTheProductDetailsAreVisible() {
		// Get the list of product details elements
		List<WebElement> productDetails = productsPageObject.getProductDetails();

		// Check if all product details elements are displayed
		boolean areDetailsVisible = productDetails.stream().allMatch(WebElement::isDisplayed);
		assertTrue(areDetailsVisible); // Assert that all elements are visible
	}

	// Call the method to scroll down to the bottom of the products page
	@When("I Scroll to the bottom end of the products page")
	public void iScrollToTheBottomEndOfTheProductsPage() {
		productsPageObject.scrollDownPage();
	}

	// Call the method to click on the scroll up button (located at the bottom right of the page)
	@When("I Click on the arrow button at the bottom right side of the page")
	public void iClickOnTheArrowButtonAtTheBottomRightSideOfThePage() {
		productsPageObject.clickScrollUpBtn();
	}

	// Assert that the products link is displayed, indicating that the page has been scrolled back to the top
	@Then("The page should be scrolled up to the top")
	public void thePageShouldBeScrolledUpToTheTop() {
		assertTrue(productsPageObject.getProductsLink().isDisplayed());
	}

}
