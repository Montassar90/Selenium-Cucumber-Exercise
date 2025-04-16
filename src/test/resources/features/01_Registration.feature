@Signup
Feature: As a user I want to be able to register in the application

  Background: 
    Given I navigate to the automationexercise application
    And I click on Signup/Login link
    When I enter name and email address
    And I click on Signup button

  @ValidSignup
  Scenario: Signup to the application with valid data
    And I fill the Signup form
    And I click the Create Account button
    Then Confirmation message should be displayed

  @DuplicateSignup
  Scenario: Signup with an existing Email Address
    Then An error message should be displayed and i am not able to signup
