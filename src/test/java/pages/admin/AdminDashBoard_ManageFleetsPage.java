package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashBoard_ManageFleetsPage {
    public AdminDashBoard_ManageFleetsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Transport Manager']" )
    public WebElement labelTransportManager;

    // Admin >> Dashboard >> Manage Fleets
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[10]/a/span")
    public WebElement linkManageFleets;

    // Admin >> Dashboard >> Manage Fleets >> Alt Başlıklar
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[10]/div/ul/li[1]/a/span")
    public WebElement linkSeatLayouts;

    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[10]/div/ul/li[2]/a/span")
    public WebElement linkFleetType;

    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[10]/div/ul/li[3]/a/span")
    public WebElement linkVehicles;

    // Admin >> Dashboard >> Manage Fleets >> Seat Layouts >> Başlıklar
    @FindBy(xpath = "//div[2]/div/div[2]/div/div/div[1]//tr[1]/td[1]")
    public WebElement labelSN;

    @FindBy(xpath = "//div[2]/div/div[2]//div[1]//tr[1]/td[2]")
    public WebElement labelLayout;

    @FindBy(xpath = "//td[.//button[@data-id='118']]")
    public WebElement labelAction;

    // Admin >> Dashboard >> Manage Fleets >> Seat Layouts >> Alt başlıklar
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[1]")
    public WebElement tdSN;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[2]")
    public WebElement tdLayout;

    @FindBy(xpath = "//td[.//button[@data-id='118']]")
    public WebElement tdAction;

    // Admin >> Dashboard >> Manage Fleets >> Seat Layouts >> AddNew
    @FindBy(xpath = "//a[text()='Add New']")
    public WebElement buttonAddNew;

    // Admin >> Dashboard >> Manage Fleets >> Seat Layouts >> Add Seat Layout
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div")
    public WebElement popapAddSeat;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div/input")
    public WebElement textboxLayout;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[2]/button[2]")
    public WebElement buttonSave;

    @FindBy(xpath = "//*[@class='iziToast-message slideIn']")
    public WebElement alertAddNewMesagge;


  

 



}
