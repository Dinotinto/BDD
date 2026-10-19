@login
Feature: Logging in to the D'tinto Water dashboard
  Staff sign in with their email and password before they can see any factory data.
  The test account's details come from the WATER_EMAIL and WATER_PASSWORD
  environment variables, never from this file.

  Scenario: A signed-out visitor sees the login screen
    Given I open the dashboard
    Then I see the login screen

  Scenario: Login is not attempted while the fields are empty
    Given I open the dashboard
    When I press Login without filling anything in
    Then I am still on the login screen
    And no login error is shown

  Scenario: An unregistered account is rejected
    Given I open the dashboard
    When I log in with an unregistered account
    Then I see a login error
    And I am still on the login screen

  @auth
  Scenario: The test account can log in
    Given I open the dashboard
    When I log in with the test account
    Then I land on the "Dashboard" section

  @auth
  Scenario: A logged-in user can log out
    Given I am logged in
    When I log out
    Then I see the login screen
