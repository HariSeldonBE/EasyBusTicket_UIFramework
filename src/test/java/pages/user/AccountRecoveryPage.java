package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountRecoveryPage {
    public AccountRecoveryPage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//h3[@class='title']")
    public WebElement labelAccountRecovery;

    @FindBy(linkText = "Try to send again")
    public WebElement tryToSendAgainLink;

}
