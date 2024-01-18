package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserLoginPage {
    public UserLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Homepage >> Sign-in Button >> User Login Page >> Login Panel at the right of the page  -->Huseyin_US10
    @FindBy(className="account-form-wrapper")
    public WebElement logInPanel;

    // Homepage >> Sign-in Button >> User Login Page >> Username Text Box in Login Panel  -->Huseyin_US10
    @FindBy(id="username")
    public WebElement usernameBox;

    // Homepage >> Sign-in Button >> User Login Page >> Password Text Box in Login Panel  -->Huseyin_US10
    @FindBy(id="password")
    public WebElement passwordBox;

    // Homepage >> Sign-in Button >> User Login Page >> Login Button in Login Panel  -->Huseyin_US10
    @FindBy(xpath= "//*[@type='submit']")
    public WebElement loginButton;

    // Homepage >> Sign-in Button >> User Login Page >> Slide-in Box on the right top pf the page displayed after invalid login  -->Huseyin_US10_TC03,TC04,TC05
    @FindBy(xpath= "//*[@class='iziToast-message slideIn']")
    public WebElement slideInBox;

    @FindBy(xpath = "//a[text()='Sign Up']")
    public WebElement signUpButton;

}