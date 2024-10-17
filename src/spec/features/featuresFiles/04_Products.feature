@Products

Feature: As a user I want to test the products page

Background: 
Given I navigate to the automationexercise application
And I click on Products link

@Products-List
Scenario: I check the products list is visible
Then The products list should display the products

@Product-Details
Scenario: I check the product details are visible
When I click on view product link of a random product
Then I should be redirected to the product page and the product details are visible 