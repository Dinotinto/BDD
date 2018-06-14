package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ContactSupport;
import pageObjects.LoginPage;
import utility.DriverManager;

public class StepDefinition {
    LoginPage log = new LoginPage();
    DriverManager setDriver = new DriverManager();
    ContactSupport get = new ContactSupport();


    @Before
    public void start_setup(){
        setDriver.startSession("firefox");
    }

    @Given("^A user is on the landing page$")
    public void a_user_is_on_the_landing_page() throws Throwable {
    log.goToUrl();
    }

    @When("^user enters login details$")
    public void user_enters_login_details() throws Throwable {
    log.sign_In();
    }

    @When("^clicks login button$")
    public void clicks_login_button() throws Throwable {
    log.clickSign_In();
    }



    @When("^user clicks Contact support tab$")
    public void user_clicks_Contact_support_tab() throws Throwable {
    get.clickTab();
    }


    @When("^user enters parameters$")
    public void user_enters_parameters() throws Throwable {
    get.fillInDetails();
    }

    @When("^clicks submit button$")
    public void clicks_submit_button() throws Throwable {
    get.submitDetails();
    }

    @Then("^display confirmation message$")
    public void display_confirmation_message() throws Throwable {
    get.confirmEnquiry();
    }
    @After
    public void close_setup(){
    setDriver.tearDown();
    }

}
