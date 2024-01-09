package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserLoginPage {
    public UserLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="username")
    public WebElement usernameBox;
    @FindBy(id="password")
    public WebElement passwordBox;
    @FindBy(xpath= "//*[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath= "//*[@class='iziToast-message slideIn']")
    public WebElement slideInBox;

}