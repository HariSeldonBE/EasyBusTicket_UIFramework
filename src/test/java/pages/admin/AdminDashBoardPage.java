/* package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminDashBoardPage {
    public AdminDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Admin dashboard sayfasının side bar'ındaki "Manage trips" linki
    @FindBy(xpath = "//*[text()='Manage Trips']")
    public WebElement manageTripsLink;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Route" item'i
    @FindBy(xpath = "//*[text()='Route']")
    public WebElement routeElement;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Schedule" item'i
    @FindBy(xpath = "//*[text()='Schedule']")
    public WebElement scheduleElement;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Ticket Price" item'i
    @FindBy(xpath = "//*[text()='Ticket Price']")
    public WebElement ticketPriceElement;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Trip" item'i
    @FindBy(xpath = "//*[text()='Trip']")
    public WebElement tripElement;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Assigned Vehicle" item'i
    @FindBy(xpath = "//*[text()='Assigned Vehicle']")
    public WebElement assignedVehicleElement;


    //-------

    // Route sayfasındaki son rotanın ismi
    @FindBy(xpath = "(//tr/td)[134]")
    public WebElement lastRouteName;

    // Route sayfasındaki ilk rotanın ismi
    @FindBy(xpath = "(//tr/td)[1]")
    public WebElement firstRouteName;

    //Route sayfasının sağ üstündeki "Add New" butonu
    @FindBy(xpath = "//a[@class='btn btn-sm btn--primary box--shadow1 text--small addBtn']")
    public WebElement routeAddNewButton;

    // Create Route sayfasındaki Name kutusu
    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement nameOfTheNewRouteBox;

    // Create Route sayfasındaki "Start From" kutusu
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[1]")
    public WebElement startFromBox;
    // Create Route sayfasındaki "Start from" kutusunun select tagı
    @FindBy(xpath = "(//select[@class='select2-basic select2-hidden-accessible'])[1]")
    public WebElement selectStartFromBox;

    // Create Route sayfasındaki "End To" kutusu
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[2]")
    public WebElement endToBox;
    // Create Route sayfasındaki "End To" kutusunun select tagı
    @FindBy(xpath = "(//select[@class='select2-basic select2-hidden-accessible'])[2]")
    public WebElement selectEndToBox;

    // Create Route sayfasındaki "Time" kutusu
    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement timeOfTheNewRoute;

    // Create Route sayfasındaki "Distance" kutusu
    @FindBy(xpath = "(//input[@class='form-control'])[3]")
    public WebElement distanceOfTheNewRoute;

    // Create Route sayfasındaki "Save" butonu
    @FindBy(xpath = "//button[@class='btn btn--primary btn-block btn-lg']")
    public WebElement routeSaveButton;

    // Create Route sayfasındaki "Go Back" butonu
    @FindBy(xpath = "//a[@class='btn btn-sm btn--primary box--shadow1 text--small addBtn']")
    public WebElement routeAddNewGoBackButton;

    // Route sayfasındaki Action sütunundaki 1. satırdaki kalem butonu
    @FindBy(xpath = "(//i[@class='la la-pen'])[1]")
    public WebElement routeIlkRotaKalemButton;

    // Information Of Route sayfasındaki Name box
    @FindBy(xpath = "(//*[@class='form-control'])[1]")
    public WebElement routeInfoNameBox;
    // Update Route sayfasındaki Name box
    @FindBy(xpath = "(//*[@class='form-control'])[2]")
    public WebElement routeInfoTimeBox;
    // Update Route sayfasındaki Name box
    @FindBy(xpath = "(//*[@class='form-control'])[3]")
    public WebElement routeInfoDistanceBox;

    // Update Route sayfasındaki "Go Back" butonu
    @FindBy(xpath = "//a[@class='btn btn-sm btn--primary box--shadow1 text--small addBtn']")
    public WebElement routeUpdateGoBackButton;

    // Route sayfasının action sütunundaki 1. disable butonu
    @FindBy(xpath = "(//button[@class='icon-btn btn--danger ml-1 disableBtn '])[1]")
    public WebElement routeFirstRowDisableButton;

    // route sayfasındaki ilk sıradaki status active elementi
    @FindBy(xpath = "(//span[text()='Active'])[1]")
    public WebElement routeActiveStatusElement;

    // route sayfasındaki ilk sıradaki status disable elementi
    @FindBy(xpath = "(//span[text()='Disabled'])[1]")
    public WebElement routeDisableStatusElement;

    // route sayfasındaki Disable butonuna basıldığında çıkan pop-up penceredeki Disable butonu
    @FindBy(xpath = "//button[@class='btn btn--danger']")
    public WebElement routedisablePopUpButton;

    // Schedule sayfasındaki listedeki ilk sıra "Start From" elementi
    @FindBy(xpath = "(//tr/td)[1]")
    public WebElement scheduleFirstRowStartFromElement;
    // Schedule sayfasındaki listedeki ilk sıra "End At" elementi
    @FindBy(xpath = "(//tr/td)[2]")
    public WebElement scheduleFirstRowEndAtElement;
    // Schedule sayfasındaki listedeki ilk sıra "Duration" elementi
    @FindBy(xpath = "(//tr/td)[3]")
    public WebElement scheduleFirstRowDurationElement;
    // Schedule sayfasındaki listedeki ilk sıra "Status" elementi
    @FindBy(xpath = "(//tr/td)[4]")
    public WebElement scheduleFirstRowStatusElement;
    // Schedule sayfasındaki listedeki ilk sıra "Action" elementi
    @FindBy(xpath = "(//tr/td)[5]")
    public WebElement scheduleFirstRowActionElement;

    // Schedule sayfasındaki "Add New" butonu
    @FindBy(xpath = "//a[@class='btn btn-sm btn--primary box--shadow1 text--small addBtn']")
    public WebElement scheduleAddNewButton;

    // schedule sayfasındaki Add New pop-up sayfasındaki Start from input box
    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement scheduleAddNewStartFromBox;
    // schedule sayfasındaki Add New pop-up sayfasındaki "End At" input box
    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement scheduleAddNewEndAtBox;

    // schedule sayfasındaki Add New Pop-up sayfasındaki "Save" butonu
    @FindBy(xpath = "(//button[@class='btn btn--primary'])[1]")
    public WebElement scheduleAddNewSaveButton;

    // schedule sayfasındaki Listenin 1. satırındaki Kalem butonu
    @FindBy(xpath = "(//button[@class='icon-btn ml-1 editBtn'])[1]")
    public WebElement scheduleFirstRowPenButton;

    // schedule sayfasındaki Listenin 1. satırındaki disable butonu
    @FindBy(xpath = "(//button[@class='icon-btn btn--danger ml-1 disableBtn '])[1]")
    public WebElement scheduleFirstRawDisableButton;

    // schedule sayfasındaki Update schedule pop-up sayfasındaki "Start From" input boxu
    @FindBy(xpath = "(//input[@class='form-control'])[3]")
    public WebElement scheduleupdatePopUpStartFromBox;

    // schedule sayfasındaki Update schedule pop-up sayfasındaki "End at" input boxu
    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement scheduleupdatePopUpEndAtBox;

    // schedule sayfasındaki Update schedule pop-up sayfasındaki start from boxuna basinca cikan clock-picker
    @FindBy(xpath = "(//div[@class='clockpicker-tick'])[11]")
    public WebElement scheduleUpdatePopUpStartFromClockPickerElement;
    // schedule sayfasındaki Update schedule pop-up sayfasındaki start from boxuna basinca cikan 2. clock-picker
    @FindBy(xpath = "(//div[@class='clockpicker-tick'])[36]")
    public WebElement scheduleUpdatePopUpStartFromSecondClockPickerElement;

    // schedule sayfasındaki Update schedule pop-up sayfasındaki End At boxuna basinca cikan ilk clock-picker
    @FindBy(xpath = "(//div[@class='clockpicker-tick'])[51]")
    public WebElement scheduleUpdatePopUpEndAtClockPickerElement;
    // schedule sayfasındaki Update schedule pop-up sayfasındaki End At boxuna basinca cikan 2. clock-picker
    @FindBy(xpath = "(//div[@class='clockpicker-tick'])[72]")
    public WebElement scheduleUpdatePopUpEndAtSecondClockPickerElement;

    // schedule sayfasındaki Update schedule pop-up sayfasındaki Update
    @FindBy(xpath = "(//button[@class='btn btn--primary'])[2]")
    public WebElement scheduleUpdatePopUpUpdateButton;



    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/tbody")
    public WebElement counterNamesList;

    // Admin Dashboard >>  "Counter" linki
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[9]/a/span")
    public WebElement linkCounter;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> name
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/thead/tr/th[1]")
    public WebElement thName;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> MobileNumber
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/thead/tr/th[2]")
    public WebElement thMobileNumber;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> City
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/thead/tr/th[3]")
    public WebElement thCity;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Location
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/thead/tr/th[4]")
    public WebElement thLocation;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Status
   @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/thead/tr/th[5]")
    public WebElement thStatus;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Name başlığı >> Name elementi
     @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[1]")
    public WebElement tdName;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> MobileNumber başlığı >> MobilNumber elementi
     @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]")
    public WebElement tdMobileNumber;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> City başlığı >> City elementi
     @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[3]")
    public WebElement tdCity;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Location başlığı >> Location elementi
      @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[4]")
    public WebElement tdLocation;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Status başlığı >> Status elementi
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[5]")
    public WebElement tdStatus;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Add New
    @FindBy(xpath = "//div[contains(@class, 'mt-3')]")
    public WebElement counterAddNewButton;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Add New >> Name TextBox
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[1]/input")
    public WebElement inputName;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Add New >> City TextBox
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[2]/input")
    public WebElement inputCity;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Add New >> Location TextBox
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[3]/textarea")
    public WebElement inputLocation;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Add New >> Mobile TextBox
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[4]/input")
    public WebElement inputMobile;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[2]/button[2]")
    public WebElement counterSaveButton;


    // Admin Dashboard  >> "Booking History" Button
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[4]/a/span")
    public WebElement bookingHistoryButton;

    // Admin Dashboard  >> Booking History >>  Pending Ticket
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[4]/div/ul/li[1]/a/span")
    public WebElement pendingTicketButton;

    // Admin Dashboard  >> Booking History >>  Booked Ticket Button
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[4]/div/ul/li[2]/a/span")
    public WebElement bookedTicketButton;

    // Admin Dashboard  >> Booking History >> Rejected Ticket Button
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[4]/div/ul/li[3]/a/span")
    public WebElement rejectedTicketButton;

    // Admin Dashboard  >> Booking History >> All Ticket Button
    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[4]/div/ul/li[4]/a/span")
    public WebElement allTicketButton;

    // Admin Dashboard >> Booking History >> Pending Ticket >> Pending Ticket Başligi
    @FindBy(xpath = "/html/body/div/div[2]/div/div[1]/div[1]/h6")
    public WebElement headerPendingTicket;

    // Admin Dashboard >> Booking History >> Pending Ticket >> Arama Kutusu
    @FindBy(xpath = "//input[@type='text']")
    public WebElement aramaKutusu;

    // Admin Dashboard >> Booking History >> Pending Ticket >> Arama Enter ikonu
    @FindBy(xpath = "//button[@class='btn btn--primary']")
    public WebElement aramaButtonu;

    // Admin Dashboard >> Booking History >> Pending Ticket >> User tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[1]")
    public WebElement thUser;

    // Admin Dashboard >> Booking History >> Pending Ticket >> PNR Number tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[2]")
    public WebElement thPNRNumber;

    // Admin Dashboard >> Booking History >> Pending Ticket >> JourneyDate tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[3]")
    public WebElement thJourneyDate;

    // Admin Dashboard >> Booking History >> Pending Ticket >> Trip tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[4]")
    public WebElement thTrip;

    // Admin Dashboard >> Booking History >> Pending Ticket >> PickupPoint tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[5]")
    public WebElement thPickupPoint;

    // Admin Dashboard >> Booking History >> Pending Ticket >> DroppingPoint tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[6]")
    public WebElement thDroppingPoint;

    // Admin Dashboard >> Booking History >> Pending Ticket >> Status tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[7]")
    public WebElement thStatus1;

    // Admin Dashboard >> Booking History >> Pending Ticket >> TicketCount tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[8]")
    public WebElement thTicketCount;

    // Admin Dashboard >> Booking History >> Pending Ticket >> Fare tablo başlığı
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[9]")
    public WebElement thFare;



    




    // "//*[text()='Assigned Vehicle']"
    //  @FindBy(id = "username")



    //    -----Admin Dashboard  >>  Manage Users DDM-------
    // Admin Dashboard  >> "Manage Users" DDM
    @FindBy(xpath= "(//a[@href='javascript:void(0)'])[1]")
    public WebElement dropDownManageUsers;
    // Admin Dashboard  >> "Manage Users" DDM >> AllUsers
    @FindBy(xpath= "//a[@href='https://qa.easybusticket.com/admin/users']")
    public WebElement linkAllUsers;
    // Admin Dashboard  >> "Manage Users" DDM >> ActiveUsers
    @FindBy(xpath= "//a[@href='https://qa.easybusticket.com/admin/users/active']")
    public WebElement linkActiveUsers;
    // Admin Dashboard  >> "Manage Users" DDM >> BannedUsers
    @FindBy(xpath= "//a[@href='https://qa.easybusticket.com/admin/users/banned']")
    public WebElement linkBannedUsers;
    // Admin Dashboard  >> "Manage Users" DDM >> EmailUnverified
    @FindBy(xpath= "//a[@href='https://qa.easybusticket.com/admin/users/email-unverified']")
    public WebElement linkEmailUnverified;
    // Admin Dashboard  >> "Manage Users" DDM >> SmsUnverified
    @FindBy(xpath= "//a[@href='https://qa.easybusticket.com/admin/users/sms-unverified']")
    public WebElement linkSmsUnverified;
    // Admin Dashboard  >> "Manage Users" DDM >> EmailToAll
    @FindBy(xpath = "//a[@href='https://qa.easybusticket.com/admin/users/send-email']")
    public WebElement linkEmailToAll;


    @FindBy(xpath = "//span[@class='menu-badge pill bg--primary ml-auto']")
    public List<WebElement> listSayiManageUsers;
    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputAramaKutusu;
}

*/