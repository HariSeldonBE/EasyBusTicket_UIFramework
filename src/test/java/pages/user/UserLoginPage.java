package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserLoginPage {
    public UserLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Homepage >> Sign-in Button >> User Login Page >> Username Text Box |
    @FindBy(id="username")
    public WebElement usernameBox;

    // Homepage >> Sign-in Button >> User Login Page >> Password Text Box |
    @FindBy(id="password")
    public WebElement passwordBox;

    // Homepage >> Sign-in Button >> User Login Page >> Login Button |
    @FindBy(xpath= "//*[@type='submit']")
    public WebElement loginButton;

    // Homepage >> Sign-in Button >> User Login Page >> Slide-in Box on the right top pf the page displayed after invalid login|
    @FindBy(xpath= "//*[@class='iziToast-message slideIn']")
    public WebElement slideInBox;

}