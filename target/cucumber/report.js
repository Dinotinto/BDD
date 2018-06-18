$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("verifyTest.feature");
formatter.feature({
  "line": 2,
  "name": "As user,",
  "description": "I want to be able\nto filling the contact form",
  "id": "as-user,",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@cii"
    }
  ]
});
formatter.before({
  "duration": 31872579333,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Fill form details",
  "description": "",
  "id": "as-user,;fill-form-details",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@TestCompleted"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "A user is on the landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user enters username as \"dino\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "enters password as \"gy7pgI673\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "clicks login button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user clicks Contact support tab",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user enters \"Ade\" in name text field",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "user enters \"Olu\" in the Middlename text field",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "user enters \"Ido\" in the Surname text field",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "user enters \"2 manor close\" in the Address text field",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user enters \"SE28\" in the Postcode text field",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "user enters \"Ade@yahoo.com\" in the Email text field",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "user enters \"Ade is alright\" in the Message text box",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "clicks submit button",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "take me to the confirmation page with title  \"WEG Group\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.aUserIsOnTheLandingPage()"
});
formatter.result({
  "duration": 6273865330,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dino",
      "offset": 25
    }
  ],
  "location": "StepDefinition.user_enters_username_as(String)"
});
formatter.result({
  "duration": 2203605694,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "gy7pgI673",
      "offset": 20
    }
  ],
  "location": "StepDefinition.enters_password_as(String)"
});
formatter.result({
  "duration": 1384667945,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.clicks_login_button()"
});
formatter.result({
  "duration": 1003506110,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_clicks_Contact_support_tab()"
});
formatter.result({
  "duration": 5196233605,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ade",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_enters_in_name_text_field(String)"
});
formatter.result({
  "duration": 3646602684,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Olu",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_enters_in_the_Middlename_text_field(String)"
});
formatter.result({
  "duration": 573401720,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ido",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_enters_in_the_Surname_text_field(String)"
});
formatter.result({
  "duration": 381529650,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2 manor close",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_enters_in_the_Address_text_field(String)"
});
formatter.result({
  "duration": 609866890,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SE28",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_enters_in_the_Postcode_text_field(String)"
});
formatter.result({
  "duration": 254402500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ade@yahoo.com",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_enters_in_the_Email_text_field(String)"
});
formatter.result({
  "duration": 449015300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ade is alright",
      "offset": 13
    }
  ],
  "location": "StepDefinition.user_enters_in_the_Message_text_box(String)"
});
formatter.result({
  "duration": 463705225,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.clicks_submit_button()"
});
formatter.result({
  "duration": 723627715,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "WEG Group",
      "offset": 46
    }
  ],
  "location": "StepDefinition.take_me_to_the_confirmation_page_with_title(String)"
});
formatter.result({
  "duration": 112174245,
  "status": "passed"
});
formatter.after({
  "duration": 932981335,
  "status": "passed"
});
});