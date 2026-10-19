package water.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    /** Every scenario's final screen is saved here as a PNG (and uploaded by CI). */
    private static final Path SCREENSHOT_DIR = Paths.get("target", "screenshots");

    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    /** Scenarios that need a real account are skipped (not failed) when no test account is configured. */
    @Before(value = "@auth", order = 0)
    public void requireTestAccount() {
        Assumptions.assumeTrue(Config.hasTestAccount(),
                "Skipped: set WATER_EMAIL and WATER_PASSWORD to run logged-in scenarios");
    }

    /**
     * Takes a screenshot at the end of every scenario, pass or fail. It's attached to the
     * Cucumber HTML report under that scenario and also saved as a standalone PNG.
     *
     * Logged-in (@auth) scenarios are never screenshotted by default: their screens show live
     * factory data, and CI artifacts on a public repo can be downloaded by anyone. They log the
     * URL and open section instead. Set SCREENSHOT_LOGGED_IN=true to capture them on a local run.
     */
    @After
    public void tearDown(Scenario scenario) {
        if (!context.hasDriver()) return;
        try {
            scenario.log("URL: " + context.driver().getCurrentUrl());
            boolean loggedIn = scenario.getSourceTagNames().contains("@auth");
            if (loggedIn && !Config.screenshotLoggedIn()) {
                if (context.appShell().isShown()) {
                    scenario.log("Open section: " + context.appShell().activeSection());
                }
                scenario.log("No screenshot: logged-in screens contain live business data");
                return;
            }
            byte[] png = ((TakesScreenshot) context.driver()).getScreenshotAs(OutputType.BYTES);
            String label = scenario.isFailed() ? "screen at failure" : "final screen";
            scenario.attach(png, "image/png", label);
            savePng(scenario, png);
        } catch (RuntimeException e) {
            scenario.log("Could not capture screenshot: " + e.getMessage());
        } finally {
            context.quit();
        }
    }

    /** e.g. target/screenshots/passed__navigation__L26__opening-a-section-from-the-bottom-bar.png */
    private static void savePng(Scenario scenario, byte[] png) {
        String uri = scenario.getUri().toString();
        String feature = uri.substring(uri.lastIndexOf('/') + 1).replace(".feature", "");
        String status = scenario.getStatus().name().toLowerCase(Locale.ROOT);
        String name = String.format("%s__%s__L%d__%s.png",
                status, feature, scenario.getLine(), slug(scenario.getName()));
        try {
            Files.createDirectories(SCREENSHOT_DIR);
            Files.write(SCREENSHOT_DIR.resolve(name), png);
        } catch (IOException e) {
            scenario.log("Could not save screenshot file: " + e.getMessage());
        }
    }

    private static String slug(String text) {
        String s = text.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]+", "-").replaceAll("(^-|-$)", "");
        return s.length() > 60 ? s.substring(0, 60) : s;
    }
}
