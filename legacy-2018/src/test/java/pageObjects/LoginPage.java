package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverManager;

import java.util.concurrent.TimeUnit;

public class LoginPage extends DriverManager{

    public LoginPage(){
            PageFactory.initElements(driver, this);

        }


    @FindBy(name="username")
    private WebElement usernameTextField;

    @FindBy(name="passwd")
    private WebElement passwordTextField;

    @FindBy(name="LoginButton")
    private WebElement loginButton;


    public void goToUrl()throws Throwable{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automatetillinfinity.co.uk/");
    }
  public void enterUsername (String val)throws Throwable {
      usernameTextField.sendKeys(val);
  }
    public void enterPassword (String val1)throws Throwable{
      passwordTextField.sendKeys(val1);
  }
    public void clickSignIn ()throws Throwable{
        loginButton.click();
    }
}
