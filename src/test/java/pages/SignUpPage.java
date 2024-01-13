package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage {
    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


 @FindBy(xpath = "//*[text()='Welcome to Easy Bus Ticket']")
 public WebElement welcometoeasyBusTicketText;

    @FindBy(xpath = "//span[text()='Sign Up your Account']")
    public WebElement signUpYourAccountText;
    @FindBy(xpath = "//input[@id='firstname']")
    public  WebElement firstnameTextBox;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastnameTextBox;

    @FindBy(xpath = "//*[@id='country']")
    public WebElement countryDDM;

    @FindBy(xpath = "//input[@id='mobile']")
    public WebElement mobileTextBox;


    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextBox;

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


    @FindBy(xpath = "//small[@class='text-danger usernameExist']")
   public WebElement usernameAlreadyExist;

    @FindBy(xpath ="//p[@class='iziToast-message slideIn']" )
      public WebElement Theusernamehasalreadybeentaken;

    @FindBy(xpath = "//a[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='Sign In your Account']") //Normalde SignIn sayfasinda ama tek locate için class açmak istemedim.
    public WebElement SignInYourAccountText;


}
