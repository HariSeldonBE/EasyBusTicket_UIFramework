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

    @FindBy(xpath = "//thead/tr/th[3]")
    public WebElement labelAction;

    // Admin >> Dashboard >> Manage Fleets >> Seat Layouts >> Alt başlıklar
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[1]")
    public WebElement tdSN;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[2]")
    public WebElement tdLayout;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public WebElement tdAction;

    // Admin >> Dashboard >> Manage Fleets >> Seat Layouts >> AddNew
    @FindBy(xpath = "//a[text()='Add New']")
    public WebElement buttonAddNew;

    // Admin >> Dashboard >> Manage Fleets >> Seat Layouts >> Add Seat Layout>>>>>>>>>>>>>>>>>>>>
    @FindBy(xpath = "//div[@class='modal-content']")
    public WebElement popapAddSeat;

    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement textboxLayout;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[2]/button[2]")
    public WebElement buttonSave;

    @FindBy(xpath = "//*[@class='iziToast-message slideIn']")
    public WebElement alertAddNewMesagge;
    @FindBy(xpath = "//button[@class='icon-btn ml-1 editBtn']")
    public WebElement ikonKalemManage;


    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement placeholderUpdate;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div/div/form/div[2]/button[2]")
    public WebElement buttonUpdate;

    @FindBy(xpath = "(//button[@class='icon-btn btn--danger ml-1 removeBtn'])[1]")
    public WebElement ikonDeleteManage;

    @FindBy(xpath = "//div[@class='modal-content'][.//strong]")
    public WebElement popapDeleteSeat;

    @FindBy(xpath = "//button[@class='btn btn--danger']")
    public WebElement buttonDelete;

    @FindBy(xpath = "//strong")
    public WebElement strongAreYouSureWant;

    // Admin >> Dashboard >> Manage Fleets >> FleetType>>>>>>>>>>>>>>>>>>>>>>>
    @FindBy(xpath = "//span[text()='Fleet Type']")
    public WebElement linkFleetTyp;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[1]")
    public WebElement thName;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[2]")
    public WebElement thSeat;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[3]")
    public WebElement thDeck;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[4]")
    public WebElement thTotalSeat;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[5]")
    public WebElement thFacilities;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[6]")
    public WebElement thStatus;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[7]")
    public WebElement thAction;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[1]")
    public WebElement tdName;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[2]")
    public WebElement tdSeat;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[3]")
    public WebElement tdDeck;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[4]")
    public WebElement tdTotalSeat;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[5]")
    public WebElement tdFacilities;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[6]")
    public WebElement tdStatus;


    @FindBy(xpath = "//a[@class='btn btn-sm btn--primary box--shadow1 text--small addBtn']")
    public WebElement ButtonAddNew_FleetType;

    @FindBy(xpath = "(//div[@class='modal-content'])[1]")
    public WebElement popapAddFleetType;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[1]/input")
    public WebElement inputName;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[2]/select")
    public WebElement selectSeat;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div/span")
    public WebElement buttonACStatus;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[2]/button[2]")
    public WebElement buttonAddFleetSave2;

    @FindBy(xpath = "(//button[@class='icon-btn ml-1 editBtn'])[1]")
    public WebElement buttonUpdate_Fleet;

    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement inputName2;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement buttonUpdate2;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div/div/form/div[1]/div[2]/select")
    public WebElement selectSeat3;

    @FindBy(xpath = "(//button[@class='icon-btn btn--danger ml-1 disableBtn'])[1]")
    public WebElement buttonActiveDissable_Fleet;

    @FindBy(xpath = "//button[@class='btn btn--danger']")
    public WebElement buttonDisable_FleetPopup;

    @FindBy(xpath = "//td[.//button[@data-id='41']]")
    public WebElement tdAction3;

    // Admin >> Dashboard >> Manage Fleets >> Vehicles >>>>>>>>>>>>>>>>>>>>>>

    @FindBy(xpath = "//span[text()='Vehicles']")
    public WebElement linkVehicles1;

    @FindBy(xpath = "//h6[text()='All Vehicles']")
    public WebElement labelAllVehicles;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[1]")
    public WebElement thNickName;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[2]")
    public WebElement thReg;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[3]")
    public WebElement thEngine;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[4]")
    public WebElement thChasis;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[5]")
    public WebElement thModel;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[6]")
    public WebElement thFleetType;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[7]")
    public WebElement thStatus2;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th[8]")
    public WebElement thAction2;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[1]")
    public WebElement tdNickName;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[2]")
    public WebElement tdReg;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[3]")
    public WebElement tdEngine;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[4]")
    public WebElement tdChasis;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[5]")
    public WebElement tdModel;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[6]")
    public WebElement tdFleetType;

    @FindBy(xpath = "//td[.//span[contains(@class, 'badge--warning')]]")
    public WebElement tdStatus2;

    @FindBy(xpath = "//td[.//button[@data-id='81']]")
    public WebElement tdAction2;

    @FindBy(xpath = "//input[@name='search']")
    public WebElement inputSearch_Vehicles;

   @FindBy(xpath = "//a[@class='btn btn--primary box--shadow1 addBtn']")
    public WebElement buttonAddNew_Vehicles;

    @FindBy(xpath = "//td[@data-label='Reg. No.']")
    public WebElement tdReg2;

    @FindBy(xpath = "//h6[@class='page-title']")
    public WebElement titleVehicleSearch;

    @FindBy(xpath = "(//div[@class='modal-content'])[1]")
    public WebElement tableAddVehicle;

    @FindBy(xpath = "(//input[@*='Enter nick name'])[1]")
    public WebElement inputNickName;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[2]/button[2]")
    public WebElement buttonSave_AddVehicle;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[2]/select")
    public WebElement selectFleetType_Vehicle;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[3]/input")
    public WebElement inputRegister_Vehicle;

    @FindBy(xpath = "(//button[@class='icon-btn ml-1 editBtn'])[1]")
    public WebElement buttonKalem_Vehicle;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div/div/form/div[2]/button[2]")
    public WebElement buttonUpdate_Vehicle;
    
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div/div/form/div[1]/div[1]/input")
    public WebElement textboxNickName_Update;

    @FindBy(xpath = "(//button[@class='icon-btn btn--danger ml-1 disableBtn'])[1]")
    public WebElement ikonActiveDissable_Vehicle;

    @FindBy(xpath = "//button[text()='Disable']")
    public WebElement buttonActiveDisable_Vehicle;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div/div/form/div[1]/div[2]/select")
    public WebElement selectFleetTypeUpdate_Vehicle;

    @FindBy(xpath = "(//input[@name='register_no'])[2]")
    public WebElement textboxRegister_VehicleUPdate;
    
}
