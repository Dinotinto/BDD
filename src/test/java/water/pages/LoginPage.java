package water.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import water.support.Config;

/** The email + password card shown to anyone who isn't signed in. */
public class LoginPage extends BasePage {

    private static final By TITLE = By.xpath("//h1[normalize-space()=\"D'tinto Water\"]");
    private static final By EMAIL = By.cssSelector("form input[type='email']");
    private static final By PASSWORD = By.cssSelector("form input[type='password']");
    private static final By LOGIN_BUTTON = By.cssSelector("form button[type='submit']");
    // The error banner is the only direct child of the form that holds no input.
    private static final By ERROR = By.xpath("//form/div[not(.//input)]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(Config.baseUrl() + "/");
    }

    /** Waits past the "Checking login…" splash until the form is up. */
    public boolean isShown() {
        visible(EMAIL);
        return driver.findElement(TITLE).isDisplayed()
                && driver.findElement(PASSWORD).isDisplayed()
                && driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public void logInAs(String email, String password) {
        WebElement emailField = visible(EMAIL);
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(PASSWORD);
        passwordField.clear();
        passwordField.sendKeys(password);
        click(LOGIN_BUTTON);
    }

    public void pressLogin() {
        click(LOGIN_BUTTON);
    }

    public String errorText() {
        return visible(ERROR).getText().trim();
    }

    public boolean hasError() {
        return isPresent(ERROR) && driver.findElement(ERROR).isDisplayed();
    }

    /** True while the browser's own "please fill in this field" check is blocking submission. */
    public boolean emailFieldIsInvalid() {
        return !(Boolean) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return arguments[0].checkValidity();", driver.findElement(EMAIL));
    }
}
