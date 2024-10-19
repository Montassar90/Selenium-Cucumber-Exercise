package com.e2eTests.automation.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.automation.utils.Setup;

public class ProductsPageObject {

    // Locator for the Products link in the navigation bar
    @FindBy(how = How.XPATH, using = "//div[@class='shop-menu pull-right']//a[@href='/products' and contains(., 'Products')]")
    private WebElement productsLink;

    // Locator for the list of products displayed on the page
    @FindBy(how = How.CSS, using = ".features_items")
    private List<WebElement> productsList;

    // Locator for the 'View Product' link of the specific product 'Blue Top'
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'product-image-wrapper')]//p[text()='Blue Top']/following::a[contains(text(), 'View Product')]")
    private WebElement viewProductLink;

    // Locator for the product name in the product details page
    @FindBy(how = How.XPATH, using = "//div[@class='product-information']//h2[text()='Blue Top']")
    private WebElement productName;

    // Locator for the product category in the product details page
    @FindBy(how = How.XPATH, using = "//div[@class='product-information']//p[contains(text(), 'Category: Women > Tops')]")
    private WebElement productCategory;

    // Locator for the product price in the product details page
    @FindBy(how = How.XPATH, using = "//div[@class='product-information']//span[text()='Rs. 500']")
    private WebElement productPrice;

    // Locator for the product availability status in the product details page
    @FindBy(how = How.XPATH, using = "//div[@class='product-information']//p[b[text()='Availability:']]")
    private WebElement productAvailability;

    // Locator for the product condition (e.g., new or used) in the product details page
    @FindBy(how = How.XPATH, using = "//div[@class='product-information']//p[b[text()='Condition:']]")
    private WebElement productCondition;

    // Locator for the product brand in the product details page
    @FindBy(how = How.XPATH, using = "//div[@class='product-information']//p[b[text()='Brand:']]")
    private WebElement productBrand;

    // Constructor: Initializes the web elements on the page using Selenium's PageFactory
    public ProductsPageObject() {
        PageFactory.initElements(Setup.getDriver(), this);
    }

    // Method to navigate to the list of products by clicking on the Products link
    public void navigateToProductsList() {
        productsLink.click();
    }

    // Method to navigate to the product details of the specific product by clicking the 'View Product' link
    public void navigateToProductDetails() {
    	((JavascriptExecutor) Setup.getDriver()).executeScript("arguments[0].scrollIntoView(true);", viewProductLink);
    	viewProductLink.click();
    }

    // Method to retrieve the list of products displayed on the page
    public List<WebElement> getProductsList() {
        return productsList;
    }

    // Method to retrieve the details of the currently viewed product, including its name, category, price, availability, condition, and brand
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
