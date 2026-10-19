package water.support;

import org.openqa.selenium.WebDriver;
import water.pages.AppShell;
import water.pages.LoginPage;

/**
 * Per-scenario state, shared between step classes by PicoContainer.
 * Each scenario gets a brand-new browser, so no login carries over between scenarios.
 */
public class TestContext {

    private WebDriver driver;
    private LoginPage loginPage;
    private AppShell appShell;

    public WebDriver driver() {
        if (driver == null) {
            driver = DriverFactory.create();
        }
        return driver;
    }

    public boolean hasDriver() {
        return driver != null;
    }

    public LoginPage loginPage() {
        if (loginPage == null) loginPage = new LoginPage(driver());
        return loginPage;
    }

    public AppShell appShell() {
        if (appShell == null) appShell = new AppShell(driver());
        return appShell;
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
            loginPage = null;
            appShell = null;
        }
    }
}
