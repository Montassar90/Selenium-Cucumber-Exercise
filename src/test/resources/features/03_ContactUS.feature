@ContactUs
Feature: As a user i want to test the Contact Us functionality

  Scenario: I send a correctly filled Contact Us form
    Given I navigate to the automationexercise application
    And I click on Contact Us link
    When I fill the form
    And I click on the Submit button
    Then A success message should display
