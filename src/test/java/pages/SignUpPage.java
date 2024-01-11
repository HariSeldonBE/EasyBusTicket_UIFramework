package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage {
    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[@class='cookies-btn']")
    public WebElement cookiesKabulButon;

    @FindBy(xpath = "//input[@id='firstname']")
    public  WebElement firstnameTextBox;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastnameTextBox;

    @FindBy(xpath = "//*[@id='country']")
    public WebElement ulkelerDDM;

    @FindBy(xpath = "//input[@id='mobile']")
    public WebElement mobileTextBox;


    @FindBy(xpath = "//input[@id='username']")
    public WebElement UsernameTextBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='password-confirm']")
    public WebElement passwordconfirmTextBox;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement acceptCheckButon;

    @FindBy(xpath =" //button[@class='account-button w-100']")
    public WebElement signUpbutton;

}
