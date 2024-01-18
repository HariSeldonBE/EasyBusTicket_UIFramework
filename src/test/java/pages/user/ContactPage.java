package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactPage {

    public  ContactPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "//i[@class='flaticon-location']")
    public WebElement ourAdressText;

    @FindBy(xpath = "//*[text()='Call Us']")
    public  WebElement callUsText;

    @FindBy(xpath = "//*[text()='Email Us']")
    public  WebElement emailUsText;

    @FindBy(xpath = "//a[text()='+1 (603) 624-1800']")
    public WebElement numberbutton;

@FindBy(xpath = "//*[text()='info@easybusticket.com']")
    public WebElement emailbutton;

    @FindBy(xpath = "//iframe[contains(@src, 'maps.google.com')]")
    public WebElement map;

@FindBy(xpath = "//*[text()='Have any Questions?']")
    public WebElement haveAnyQuestionsText;

@FindBy( id="name")
    public WebElement nameTextBox;
@FindBy(id="email")
    public WebElement emailTextBox;

    @FindBy(id="subject")
    public WebElement subjectTextBox;


    @FindBy(id="msg")
    public WebElement messageTextBox;

    @FindBy(xpath = "//button[@class='contact-button']")
    public WebElement sendUsButton;

    @FindBy(xpath = "//p[@class='iziToast-message slideIn']")
    public WebElement yourmessagehasbeensentbutton;

    @FindBy (xpath = "//h2[@class='title']")
    public WebElement contactUsText;

    @FindBy(xpath = "//button[@type='button'] ")
    public WebElement succesclosebutton;













}
