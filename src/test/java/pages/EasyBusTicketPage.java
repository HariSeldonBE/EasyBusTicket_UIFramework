package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EasyBusTicketPage {
    public EasyBusTicketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "cookies-btn") //(xpath = "(//*[@name=\"cookieAccept\"])")
    public WebElement cookiesButton;
    @FindBy(className = "sign-in")
    public WebElement signInButton;

    @FindBy(xpath = "(//a[text()='Contact'])[1]")
    public WebElement contactButton;

    @FindBy (xpath = "//h2[@class='title']")
    public WebElement contactUsText;

    @FindBy(xpath = "//*[text()=\"Every Journey is an Adventure, Every Ticket is a Story\"]")
    public WebElement EveryJourneyisanAdventureEveryTicketisaStoryYazisi;

    @FindBy(className = "sign-up")//(xpath = "//a[@class='sign-up']")
    public WebElement signUpButton;

    // "Forgot Password?" link -->kevser_US20_TC01
    @FindBy(xpath = "//*[text()='Forgot Password?']")
    public WebElement forgotPasswordLink;

}
