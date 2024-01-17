package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserDashBoardPage {
    public UserDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//h2[@class=\"title\"])")
    public WebElement labelDashBoard;

    @FindBy(xpath="(//a[@href='javascript::void()'])[1]")
    public WebElement bookingDdm;

    @FindBy(xpath = "(//a[@href='https://qa.easybusticket.com/tickets'])[1]")
    public WebElement buyTicket;
    @FindBy(xpath = "(//div[@class='logo'])[1]")
    public WebElement logo;
    @FindBy(xpath = "//a[@href=\"https://qa.easybusticket.com/user/dashboard\"]")
    public WebElement dashboardButton;
    @FindBy(xpath = "//a[@href=\"https://qa.easybusticket.com/user/booked-ticket/history\"]")
    public WebElement bookingHistory;
    @FindBy(xpath = "(//li[@class=\"has-sub-menu\"])[2]")
    public WebElement supportRequest;
    @FindBy(xpath = "//a[@href=\"https://qa.easybusticket.com/ticket/new\"]")
    public WebElement createNew;
    @FindBy(xpath = "//a[@href=\"https://qa.easybusticket.com/ticket\"]")
    public WebElement requests;

    @FindBy(xpath = "(//a/img)")
    public WebElement eBTLogo;

    //User Dashboard >>Header >> Profile DDM
    @FindBy(xpath = "(//a[text()='Profile'])[1]")
    public WebElement headerDdmProfileButton;


    @FindBy(xpath = "(//a[@href='https://qa.easybusticket.com/logout'])")
    public WebElement headerDdmLogoutButton;
}
