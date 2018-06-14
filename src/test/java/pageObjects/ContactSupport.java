package pageObjects;

import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;

import utility.DriverManager;

public class ContactSupport extends DriverManager {
    By CSTab = By.id("contactsupporttab");
    By Name = By.id("q1");
    By Middlename = By.id("q2");
    By Surname = By.id("q3");
    By Address = By.id("q8");
    By Postcode = By.id("q9");
    By Email = By.id("q10");
    By Message = By.id("q11");
    By SubmitEnquiry = By.id("a1");
    public void clickTab() throws Throwable{
        driver.findElement(CSTab).click();

    }
    public void fillInDetails () throws Throwable {
        driver.findElement(Name).sendKeys("Ade");
        driver.findElement(Middlename).sendKeys("Olu");
        driver.findElement(Surname).sendKeys("Ido");
        driver.findElement(Address).sendKeys("2 manor close");
        driver.findElement(Postcode).sendKeys("se28");
        driver.findElement(Email).sendKeys("Ade@yahoo.com");
        driver.findElement(Message).sendKeys("Ade is alright");

    }
    public void submitDetails () throws Throwable{
        driver.findElement(SubmitEnquiry).click();


    }
    public void confirmEnquiry()throws Throwable{
        driver.getPageSource().contains("Thank you for your Message! We will get in touch as soon as possible.");
    }
}
