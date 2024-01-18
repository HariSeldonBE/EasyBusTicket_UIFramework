package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashBoard_ProfilePage {

    public AdminDashBoard_ProfilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='navbar-user__info']")
    public WebElement linkProfile;

    @FindBy(xpath = "(//span[@class='dropdown-menu__caption'])[1]")
    public WebElement ddmProfile;

    @FindBy(xpath = "(//span[@class='font-weight-bold'])[1]")
    public WebElement labelName;


    @FindBy(xpath = "(//span[@class='font-weight-bold'])[3]")
    public WebElement labelEmail;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement textboxName;

    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement textboxEmail;

    @FindBy(xpath = "(//button[@class='btn btn--primary btn-block btn-lg'])[1]")
    public WebElement SaveChangesButton;


}
