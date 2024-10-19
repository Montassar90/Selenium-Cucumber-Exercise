@Products

Feature: As a user I want to test the products page

Background: 
Given I navigate to the automationexercise application
And I click on Products link

Scenario: I check the products list is visible
Then The products list should display the products

Scenario: I check the product details are visible
When I click on view product link of a random product
Then I should be redirected to the product page and the product details are visible

Scenario: I check the ScrollUp arrow button is working

When I Scroll to the bottom end of the products page
And I Click on the arrow button at the bottom right side of the page
Then The page should be scrolled up to the top