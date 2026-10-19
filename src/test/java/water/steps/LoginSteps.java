package water.steps;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.UUID;
import water.support.Config;
import water.support.TestContext;

public class LoginSteps {

    private final TestContext context;
    private Scenario scenario;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Before
    public void captureScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("I open the dashboard")
    public void iOpenTheDashboard() {
        context.loginPage().open();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        context.loginPage().open();
        context.loginPage().logInAs(Config.testEmail(), Config.testPassword());
        context.appShell().waitUntilLoaded();
    }

    @When("I log in with the test account")
    public void iLogInWithTheTestAccount() {
        context.loginPage().logInAs(Config.testEmail(), Config.testPassword());
    }

    /** A throwaway address on the reserved example.com domain, so it can never belong to anyone. */
    @When("I log in with an unregistered account")
    public void iLogInWithAnUnregisteredAccount() {
        String email = "qa-unregistered-" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
        context.loginPage().logInAs(email, "not-a-real-password-" + UUID.randomUUID());
    }

    @When("I press Login without filling anything in")
    public void iPressLoginWithoutFillingAnythingIn() {
        context.loginPage().isShown();
        context.loginPage().pressLogin();
    }

    @When("I log out")
    public void iLogOut() {
        context.appShell().logOut();
    }

    @Then("I see the login screen")
    public void iSeeTheLoginScreen() {
        assertTrue(context.loginPage().isShown(), "Login form should be visible");
    }

    @Then("I am still on the login screen")
    public void iAmStillOnTheLoginScreen() {
        assertTrue(context.loginPage().isShown(), "Login form should still be visible");
        assertFalse(context.appShell().isShown(), "Dashboard top bar should not be visible");
    }

    @Then("I see a login error")
    public void iSeeALoginError() {
        String message = context.loginPage().errorText();
        assertFalse(message.isBlank(), "An error message should be shown");
        scenario.log("Login error shown: " + message);
    }

    @Then("no login error is shown")
    public void noLoginErrorIsShown() {
        assertTrue(context.loginPage().emailFieldIsInvalid(), "Browser should flag the empty email field");
        assertFalse(context.loginPage().hasError(), "No server error should appear when nothing was submitted");
    }
}
