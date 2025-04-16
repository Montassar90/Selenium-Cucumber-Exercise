@DeleteAccount
Feature: As a registred user I want to be able to delete my account

  Scenario: I succesfully delete my account
    Given I navigate to the automationexercise application
    And I click on Signup/Login link
    When I enter a valid email address and password
    And I click on the Login button
    Then I should be redirected to home page and my username is visible in the top
    When I click on the Delete Account link
    Then My account should be deleted and I should see a confirmation message
