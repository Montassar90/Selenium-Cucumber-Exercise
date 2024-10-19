@Login
Feature: As a user i want to test the login functionality

  Background: 
    Given I navigate to the automationexercise application
    And I click on Signup/Login link

  Scenario: I Login using a valid account credentials
    When I enter a valid email address and password
    And I click on the Login button
    Then I should be redirected to home page and my username is visible in the top

  Scenario: I Login using an invalid account credentials
    When I enter invalid email address or password
    And I click on the Login button
    Then An error message should be displayed
