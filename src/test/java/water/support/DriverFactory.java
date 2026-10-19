package water.support;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/** Starts a fresh browser per scenario. Selenium Manager fetches the matching driver automatically. */
public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver create() {
        boolean headless = Config.headless();
        WebDriver driver = switch (Config.browser()) {
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) options.addArguments("-headless");
                yield new FirefoxDriver(options);
            }
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                if (headless) options.addArguments("--headless=new");
                options.addArguments("--mute-audio");
                yield new EdgeDriver(options);
            }
            default -> {
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                // The app plays a short welcome chime after login; keep test runs silent.
                options.addArguments("--mute-audio", "--disable-notifications", "--no-sandbox", "--disable-dev-shm-usage");
                yield new ChromeDriver(options);
            }
        };
        int[] size = Config.windowSize();
        driver.manage().window().setSize(new Dimension(size[0], size[1]));
        return driver;
    }
}
