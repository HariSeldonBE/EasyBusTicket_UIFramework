package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountRecoveryPage {
    public AccountRecoveryPage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//*[text()='Account Recovery']")
    public WebElement labelAccountRecovery;

    @FindBy(linkText = "Try to send again")
    public WebElement tryToSendAgainLink;

    @FindBy(xpath = "//input[@placeholder='Enter Your username']")
    public WebElement verificationCodePlaceholderYazisi;

}
