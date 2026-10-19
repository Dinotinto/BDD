package water.pages;

import java.net.URI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Everything around the section content once logged in: the top bar
 * (name · section, Back/Forward, Logout), the bottom bar and the More drawer.
 */
public class AppShell extends BasePage {

    private static final By TOP_BAR = By.cssSelector("header.app-topbar");
    // "<name> · <section>" line under the brand; it's the only leaf div in the header with a middle dot.
    private static final By SECTION_LINE = By.xpath("//header//div[not(*)][contains(., ' · ')]");
    private static final By LOGOUT = By.xpath("//header//button[normalize-space()='Logout']");
    private static final By BACK = By.xpath("//header//button[@title='Back']");
    private static final By DRAWER = By.cssSelector("div.more-drawer");

    public AppShell(WebDriver driver) {
        super(driver);
    }

    /** Waits past the "Loading factory data…" splash until the top bar is up. */
    public void waitUntilLoaded() {
        visible(TOP_BAR);
        visible(SECTION_LINE);
    }

    public boolean isShown() {
        return isPresent(TOP_BAR) && driver.findElement(TOP_BAR).isDisplayed();
    }

    public String activeSection() {
        String line = visible(SECTION_LINE).getText();
        return line.substring(line.lastIndexOf(" · ") + 3).trim();
    }

    public void waitForSection(String label) {
        wait.withMessage(() -> "Expected the top bar to show section '" + label
                        + "' but it showed '" + safeActiveSection() + "'")
                .until(d -> label.equals(safeActiveSection()));
    }

    /** Value of ?tab= in the address bar. */
    public String tabInAddressBar() {
        String query = URI.create(driver.getCurrentUrl()).getQuery();
        if (query == null) return "";
        for (String pair : query.split("&")) {
            if (pair.startsWith("tab=")) return pair.substring(4);
        }
        return "";
    }

    public void waitForTabInAddressBar(String tab) {
        wait.withMessage(() -> "Expected ?tab=" + tab + " but the URL was " + driver.getCurrentUrl())
                .until(d -> tab.equals(tabInAddressBar()));
    }

    public void tapBottomBar(String label) {
        click(bottomBarButton(label));
    }

    public void openMoreMenu() {
        tapBottomBar("More");
        waitForDrawer(true);
    }

    public void tapMoreMenuItem(String label) {
        waitForDrawer(true);
        WebElement tile = visible(moreMenuTile(label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", tile);
        wait.until(ExpectedConditions.elementToBeClickable(tile)).click();
    }

    public boolean moreMenuOffers(String label) {
        return isPresent(moreMenuTile(label));
    }

    /** The drawer always exists in the page; it's "open" when it has slid up into view. */
    public boolean isMoreMenuOpen() {
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "const r = arguments[0].getBoundingClientRect();"
                        + "return r.top < window.innerHeight && r.bottom > 0;",
                driver.findElement(DRAWER));
    }

    public void waitForDrawer(boolean open) {
        wait.withMessage(() -> "Expected the More menu to be " + (open ? "open" : "closed"))
                .until(d -> isMoreMenuOpen() == open);
    }

    public void pressBack() {
        click(BACK);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void logOut() {
        click(LOGOUT);
    }

    private String safeActiveSection() {
        try {
            String line = driver.findElement(SECTION_LINE).getText();
            return line.substring(line.lastIndexOf(" · ") + 3).trim();
        } catch (RuntimeException e) {
            return "";
        }
    }

    private static By bottomBarButton(String label) {
        return By.xpath("//nav[contains(@class,'bottom-nav')]//button[.//span[normalize-space()=" + xpathLiteral(label) + "]]");
    }

    private static By moreMenuTile(String label) {
        return By.xpath("//div[contains(@class,'more-drawer')]//button[.//span[normalize-space()=" + xpathLiteral(label) + "]]");
    }

    private static String xpathLiteral(String text) {
        if (!text.contains("'")) return "'" + text + "'";
        return "\"" + text + "\"";
    }
}
