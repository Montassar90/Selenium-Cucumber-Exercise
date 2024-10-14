@Signup
Feature: RegistrationFeature

  Scenario: As a new user i want to signup to the application
    Given I navigate to the automationexercise application
    And I click on Signup/Login link
    When I enter name and email address
    And I click on Signup button
    And I fill the Signup form
    And I click the Create Account button
    Then Confirmation message should be displayed
