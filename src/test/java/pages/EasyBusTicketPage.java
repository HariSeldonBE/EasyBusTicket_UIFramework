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
}
