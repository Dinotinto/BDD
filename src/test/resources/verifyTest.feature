@ci
Feature: As user,
 I want to be able
 to filling the contact form

 @TestCompleted
 Scenario: Fill form details
  Given A user is on the landing page
  When user enters username as "dino"
  And enters password as "gy7pgI673"
  And clicks login button
  When  user clicks Contact support tab
  And  user enters "Ade" in name text field
  And  user enters "Olu" in the Middlename text field
  And  user enters "Ido" in the Surname text field
  And  user enters "2 manor close" in the Address text field
  And  user enters "SE28" in the Postcode text field
  And  user enters "Ade@yahoo.com" in the Email text field
  And  user enters "Ade is alright" in the Message text box
  And  clicks submit button
  Then  display confirmation message as "Thank you fo your Message! We will get in touch as soon as possible."
