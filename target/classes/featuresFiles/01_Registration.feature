@Signup
Feature: RegistrationFeature

  Background: 
    Given I navigate to the automationexercise application
    And I click on Signup/Login link
    When I enter name and email address
    And I click on Signup button

  @Positive-scenario
  Scenario: As a new user i want to signup to the application
    And I fill the Signup form
    And I click the Create Account button
    Then Confirmation message should be displayed

  @Negative-scenario
  Scenario: As a user i want to signup with an existing Email adress
    Then An error message should be displayed and i am not able to signup
