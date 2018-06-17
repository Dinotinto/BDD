package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverManager;




public class ContactSupportPage extends DriverManager {



    @FindBy(id="contactsupporttab")
    private WebElement contactSupportTab;

    @FindBy(className = "content2")
    private WebElement confirmText;

    @FindBy(id="q1")
    private WebElement nameTextField;

    @FindBy(id="q2")
    private WebElement MiddlenameTextField;

    @FindBy(id="q3")
    private WebElement SurnameTextField;

    @FindBy(id="q8")
    private WebElement AddressTextField;

    @FindBy(id="q9")
    private WebElement PostcodeTextField;

    @FindBy(id="q10")
    private WebElement EmailTextField;

    @FindBy(id="q11")
    private WebElement MessageTextField;

    @FindBy(id="a1")
    private WebElement SubmitEnquiryButton;

    public ContactSupportPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickTab() throws Throwable{
        contactSupportTab.click();

    }
    public void fillInName (String name) throws Throwable {
        nameTextField.sendKeys(name);
    }

    public void fillInMiddlename (String Middlename) throws Throwable {
        MiddlenameTextField.sendKeys(Middlename);
    }

    public void fillInSurname (String Surname) throws Throwable {
        SurnameTextField.sendKeys(Surname);
    }

    public void fillInAddress (String Address) throws Throwable {
        AddressTextField.sendKeys(Address);
    }

    public void fillInPostcode (String Postcode) throws Throwable {
        PostcodeTextField.sendKeys(Postcode);
    }

    public void fillInEmail (String Email) throws Throwable {
        EmailTextField.sendKeys(Email);
    }

    public void fillInMessage (String Message) throws Throwable {
        MessageTextField.sendKeys(Message);

    }
    public void submitDetails () throws Throwable{
        SubmitEnquiryButton.click();


    }
    public void confirmEnquiryText(String value){
       boolean text =  driver.getPageSource().contains(value);


    }
}
