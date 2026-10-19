@auth @navigation
Feature: Moving around the dashboard
  Once logged in, staff move between sections with the bottom bar and the More menu.
  These scenarios expect a test account with the staff role or higher, since
  lower roles can't see every tab used here.

  Background:
    Given I am logged in

  Scenario Outline: Opening a section from the bottom bar
    When I tap "<section>" in the bottom bar
    Then I land on the "<section>" section
    And the address bar shows the "<tab>" tab

    Examples:
      | section     | tab       |
      | Daily Entry | daily     |
      | Inventory   | inventory |
      | Reports     | reports   |
      | Dashboard   | dashboard |

  Scenario: Opening the More menu
    When I open the More menu
    Then the More menu is open
    And the More menu offers "Help"

  Scenario: Opening a section from the More menu
    When I open the More menu
    And I tap "Help" in the More menu
    Then I land on the "Help" section
    And the address bar shows the "help" tab
    And the More menu is closed

  Scenario: Closing the More menu without choosing anything
    When I open the More menu
    And I tap "More" in the bottom bar
    Then the More menu is closed

  Scenario: Going back to the previous section
    When I tap "Inventory" in the bottom bar
    And I tap "Reports" in the bottom bar
    And I press the Back button in the header
    Then I land on the "Inventory" section

  Scenario: The open section survives a page refresh
    When I tap "Reports" in the bottom bar
    And I refresh the page
    Then I land on the "Reports" section
