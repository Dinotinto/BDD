package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


    public class DriverManager {


        public static WebDriver driver;

        public void startSession(String browser){
            if (driver == null) {
                if (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "//Users//Dinotinto//bin//geckodriver");
                    driver = new FirefoxDriver();
                }

            }


            }
        

        public void tearDown() {
            driver.quit();
            driver = null;

        }




    }


