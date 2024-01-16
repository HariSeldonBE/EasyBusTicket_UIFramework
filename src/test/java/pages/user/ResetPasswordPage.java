package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ResetPasswordPage {

    public ResetPasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    //kevser_US20_TC01_TC02
    //Reset Password yazı locate'i (expected page verification)
    @FindBy(xpath = "//*[text()='Reset Password']")
    public WebElement resetPasswordYazisi;

    // US_20 / TC_02
    @FindBy(xpath = "//*[@class='form--control']")
    public WebElement selectOneDDM;

    @FindBy(xpath = "//input[@class='form--control ']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@class='form--control ']")
    public WebElement eMailTextBox;

    @FindBy(xpath = "//*[@class='contact-button']")
    public WebElement sendPasswordCodeButton;
}
