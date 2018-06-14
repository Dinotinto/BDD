@tag
Feature: FillForm

 @tag1
  Scenario: Fill form details

Given A user is on the landing page
When user enters login details
And clicks login button
When  user clicks Contact support tab
And  user enters parameters
And  clicks submit button
Then  display confirmation message
