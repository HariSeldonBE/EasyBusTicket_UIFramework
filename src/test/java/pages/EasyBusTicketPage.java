package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EasyBusTicketPage {
    public EasyBusTicketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Homepage >> Cookies Button
    1@FindBy(className = "cookies-btn") //(xpath = "(//*[@name=\"cookieAccept\"])")
    public WebElement cookiesButton;

    // Homepage >> Sign-in Button
    @FindBy(className = "sign-in")
    public WebElement signInButton;

    // Homepage >> Contact Button
    @FindBy(xpath = "(//a[text()='Contact'])[1]")
    public WebElement contactButton;

    // Homepage >> Contact Us Text
    @FindBy (xpath = "//h2[@class='title']")
    public WebElement contactUsText;

    // Homepage >> Banner area text
    @FindBy(xpath = "//*[text()=\"Every Journey is an Adventure, Every Ticket is a Story\"]")
    public WebElement EveryJourneyisanAdventureEveryTicketisaStoryYazisi;


    // Homepage >> Sign-up Button
    @FindBy(className = "sign-up")//(xpath = "//a[@class='sign-up']")
    public WebElement signUpButton;

    // "Forgot Password?" link -->kevser_US20_TC01
    @FindBy(xpath = "//*[text()='Forgot Password?']")
    public WebElement forgotPasswordLink;

}
