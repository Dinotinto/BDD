package water.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import water.support.TestContext;

public class NavigationSteps {

    private final TestContext context;

    public NavigationSteps(TestContext context) {
        this.context = context;
    }

    @When("I tap {string} in the bottom bar")
    public void iTapInTheBottomBar(String label) {
        context.appShell().tapBottomBar(label);
    }

    @When("I open the More menu")
    public void iOpenTheMoreMenu() {
        context.appShell().openMoreMenu();
    }

    @When("I tap {string} in the More menu")
    public void iTapInTheMoreMenu(String label) {
        context.appShell().tapMoreMenuItem(label);
    }

    @When("I press the Back button in the header")
    public void iPressTheBackButtonInTheHeader() {
        context.appShell().pressBack();
    }

    @When("I refresh the page")
    public void iRefreshThePage() {
        context.appShell().refresh();
        context.appShell().waitUntilLoaded();
    }

    @Then("I land on the {string} section")
    public void iLandOnTheSection(String label) {
        context.appShell().waitUntilLoaded();
        context.appShell().waitForSection(label);
    }

    @Then("the address bar shows the {string} tab")
    public void theAddressBarShowsTheTab(String tab) {
        context.appShell().waitForTabInAddressBar(tab);
    }

    @Then("the More menu is open")
    public void theMoreMenuIsOpen() {
        context.appShell().waitForDrawer(true);
    }

    @Then("the More menu is closed")
    public void theMoreMenuIsClosed() {
        context.appShell().waitForDrawer(false);
    }

    @Then("the More menu offers {string}")
    public void theMoreMenuOffers(String label) {
        assertTrue(context.appShell().moreMenuOffers(label), "More menu should contain '" + label + "'");
    }
}
