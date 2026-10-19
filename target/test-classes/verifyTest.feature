@cii
Feature: As user,
 I want to be able
 to filling the contact form

 @TestCompleted
 Scenario: Fill form details
  Given A user is on the landing page
  When user enters username as "test-user"
  And enters password as "<redacted>"
  And clicks login button
  When  user clicks Contact support tab
  And  user enters "Test" in name text field
  And  user enters "Middle" in the Middlename text field
  And  user enters "User" in the Surname text field
  And  user enters "1 Test Street" in the Address text field
  And  user enters "AB1 2CD" in the Postcode text field
  And  user enters "test.user@example.com" in the Email text field
  And  user enters "Test message" in the Message text box
  And  clicks submit button
  Then  take me to the confirmation page with title  "WEG Group"
