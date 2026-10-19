package water.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

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

    @After
    public void tearDown(Scenario scenario) {
        if (!context.hasDriver()) return;
        try {
            if (scenario.isFailed()) {
                byte[] png = ((TakesScreenshot) context.driver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(png, "image/png", "screen at failure");
                scenario.log("URL at failure: " + context.driver().getCurrentUrl());
            }
        } finally {
            context.quit();
        }
    }
}
