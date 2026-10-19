package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ContactSupportPage;
import pageObjects.LoginPage;
import utility.DriverManager;

public class StepDefinition {
   private LoginPage loginPage = new LoginPage();
    private DriverManager driverManager = new DriverManager();
    private ContactSupportPage contactSupport = new ContactSupportPage();


    @Before
    public void start_setup(){
        driverManager.startSession("firefox");
    }

    @Given("^A user is on the landing page$")
    public void aUserIsOnTheLandingPage() throws Throwable {
       loginPage= new LoginPage();
       loginPage.goToUrl();
    }

    @When("^user enters username as \"([^\"]*)\"$")
    public void user_enters_username_as(String val) throws Throwable {
       loginPage.enterUsername(val);
    }

    @When("^enters password as \"([^\"]*)\"$")
    public void enters_password_as(String val1) throws Throwable {
       loginPage.enterPassword(val1);
    }


    @When("^clicks login button$")
    public void clicks_login_button() throws Throwable {
        loginPage.clickSignIn();
    }

    @When("^user clicks Contact support tab$")
    public void user_clicks_Contact_support_tab() throws Throwable {
        contactSupport = new ContactSupportPage();
        contactSupport.clickTab();
    }

    @When("^user enters \"([^\"]*)\" in name text field$")
    public void user_enters_in_name_text_field(String name) throws Throwable {
       contactSupport.fillInName(name);
    }
    @When("^user enters \"([^\"]*)\" in the Middlename text field$")
    public void user_enters_in_the_Middlename_text_field(String Middlename) throws Throwable {
        contactSupport.fillInMiddlename(Middlename);
    }

    @When("^user enters \"([^\"]*)\" in the Surname text field$")
    public void user_enters_in_the_Surname_text_field(String Surname) throws Throwable {
        contactSupport.fillInSurname(Surname);
    }

    @When("^user enters \"([^\"]*)\" in the Address text field$")
    public void user_enters_in_the_Address_text_field(String Address) throws Throwable {
       contactSupport.fillInAddress(Address);
    }

    @When("^user enters \"([^\"]*)\" in the Postcode text field$")
    public void user_enters_in_the_Postcode_text_field(String Postcode) throws Throwable {
       contactSupport.fillInPostcode(Postcode);
    }

    @When("^user enters \"([^\"]*)\" in the Email text field$")
    public void user_enters_in_the_Email_text_field(String Email) throws Throwable {
       contactSupport.fillInEmail(Email);
    }

    @When("^user enters \"([^\"]*)\" in the Message text box$")
    public void user_enters_in_the_Message_text_box(String Message) throws Throwable {
       contactSupport.fillInMessage(Message);
    }

    @When("^clicks submit button$")
    public void clicks_submit_button() throws Throwable {
       contactSupport.submitDetails();
    }

    @Then("^take me to the confirmation page with title  \"([^\"]*)\"$")
    public void take_me_to_the_confirmation_page_with_title(String value) throws Throwable {
       contactSupport.confirmEnquiryText(value);
    }

    @After
    public void close_setup(){
    driverManager.tearDown();
    }

}
