package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminLoginPage {
    public AdminLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='username']")
    public WebElement inputUsername;

    @FindBy(xpath = "//*[@id='pass']")
    public WebElement inputPass;

    @FindBy(xpath = "//button")
    public WebElement buttonLogin;












}
