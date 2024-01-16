package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashboardUS22 {public AdminDashboardUS22(){PageFactory.initElements(Driver.getDriver(),this);}

    // US22, TC01 ve TC02 Locate'leri
    // Admin Dashboard sayfasında görünen renkli kutuların ve View All Butonlarının Locate'leri.

    @FindBy(xpath= "//*[@class='dashboard-w1 bg--primary b-radius--10 box-shadow']")
    public WebElement totalUser;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[1]")
    public WebElement totalUserViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--cyan b-radius--10 box-shadow']")
    public WebElement totalVerifiedUser;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[2]")
    public WebElement totalVerifiedUserViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--orange b-radius--10 box-shadow ']")
    public WebElement totalEmailUnverifiedUsers;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[3]")
    public WebElement totalEmailUnverifiedUsersViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--pink b-radius--10 box-shadow ']")
    public WebElement totalSMSUnverifiedUsers;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[4]")
    public WebElement totalSMSUnverifiedUsersViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--success b-radius--10 box-shadow']")
    public WebElement successfulPeyment;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[5]")
    public WebElement successfulPeymentViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--warning b-radius--10 box-shadow']")
    public WebElement pendingPayment;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[6]")
    public WebElement pendingPaymentViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--danger b-radius--10 box-shadow ']")
    public WebElement rejectedPayment;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[7]")
    public WebElement rejectedPaymentViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--1 b-radius--10 box-shadow']")
    public WebElement acVehicle;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[8]")
    public WebElement acVehicleViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--2 b-radius--10 box-shadow']")
    public WebElement nonACVehicle;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[9]")
    public WebElement nonACVehicleViewButton;

    @FindBy(xpath = "//div[@class='dashboard-w1 bg--4 b-radius--10 box-shadow ']")
    public WebElement totalCounter;
    @FindBy(xpath = "(//a[@class='btn btn-sm text--small bg--white text--black box--shadow3 mt-3'])[10]")
    public WebElement totalCounterViewButton;

    //--------------------------------------------------------------------------------------------------------------

    // US22, TC03 :
    // Dashboard Latest Booking History Locateleri:
    @FindBy(xpath = "(//div[@class='card-body'])[1]")
    public WebElement latestBookingHistoryCard;
    @FindBy(xpath = "(//a[@class='icon-btn ml-1 '])[1]")
    public WebElement latestBookingHistoryDetailButton;

    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement bookedTicketsayfasi; // details butonuna tıklayınca bu sayfaya ulaşılması bekleniyor.


    //Last 30 Days Payment History Grafiğinin Locate'leri
    @FindBy(xpath = "(//div[@class='card-body'])[2]")
    public WebElement last30DaysPaymentGrafik;

    // Login By Browser Chart,
    // Login By OS Chart,
    // Login By Country Chart.
    @FindBy(xpath = "(//div[@class='card-body'])[3]")
    public WebElement browserChart;
    @FindBy(xpath = "(//div[@class='card-body'])[4]")
    public WebElement oSChart;
    @FindBy(xpath = "(//div[@class='card-body'])[5]")
    public WebElement countryChart;



}
