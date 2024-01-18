package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProfilePage {public ProfilePage(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//input[@name=\"firstname\"]")
    public WebElement profileName;
    @FindBy(xpath = "//input[@name=\"lastname\"]")
    public WebElement profileLastName;
    @FindBy(xpath = "//input[@id=\"email\"]")
    public WebElement profilEmail;
    @FindBy(xpath = "(//li[@class=\"has-sub-menu\"])[3]")
    public WebElement profileDDM;
    @FindBy(xpath = "//a[@href=\"https://qa.easybusticket.com/user/profile-setting\"]")
    public WebElement profileButton;



}
