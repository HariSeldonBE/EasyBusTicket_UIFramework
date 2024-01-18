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
    @FindBy(xpath = "//h2[@class=\"title\"]")
    public WebElement profileSetting;
    @FindBy(xpath = "//input[@id=\"phone\"]")
    public WebElement phone;
    @FindBy(xpath = "//input[@id=\"address\"]")
    public WebElement address  ;
    @FindBy(xpath = "//input[@id=\"state\"]")
    public WebElement state;
    @FindBy(xpath = "//input[@id=\"zip\"]")
    public WebElement zipCode;
    @FindBy(xpath = "//input[@id=\"city\"]")
    public WebElement city;
    @FindBy(xpath = "//input[@value=\"United States\"]")
    public WebElement countryProfile;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement updateProfileButton;
    @FindBy(xpath = "(//input[@type=\"text\"])[7]")
    public WebElement ikinciZip;
    @FindBy(xpath ="//p[@class='iziToast-message slideIn']" )
    public WebElement basariliGiris;









}
