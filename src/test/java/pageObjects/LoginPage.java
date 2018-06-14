package pageObjects;

import org.openqa.selenium.By;
import utility.DriverManager;

import java.util.concurrent.TimeUnit;

public class LoginPage extends DriverManager{


    By Username = By.name("username");
    By Password = By.name("passwd");
    By Login_Btn = By.name("LoginButton");


    public void goToUrl()throws Throwable{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automatetillinfinity.co.uk/");
    }
  public void sign_In ()throws Throwable{
      driver.findElement(Username).sendKeys("dino");
      driver.findElement(Password).sendKeys("gy7pgI673");
  }
    public void clickSign_In ()throws Throwable{
        driver.findElement(Login_Btn).click();
    }
}
