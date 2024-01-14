package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashBoard_CounterPage {
    public AdminDashBoard_CounterPage(){ PageFactory.initElements(Driver.getDriver(),this);
    }
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
    @FindBy(xpath = "//a[@class='btn btn-sm btn--primary box--shadow1 text--small addBtn']")
    public WebElement counterAddNewButton;

    // Admin Dashboard  >> "Counter" linki >> All Counter >> Add New >> Name TextBox
    @FindBy(xpath = "//div[1]/div[2]/div/div[3]/div/div/form/div[1]/div[1]/input")
    public WebElement nameTextBox;


    // Admin Dashboard  >> "Counter" linki >> All Counter >> Add New >> Save Button
    @FindBy(xpath = "//div[1]/div[2]/div/div[3]//div[2]/button[2]")
    public WebElement counterSaveButton;


    // Admin Dashboard  >> "Counter" linki >> All Counter Tablosu
    @FindBy(xpath = "//table[@class='table table--light style--two']")
    public WebElement counterTablo;

    @FindBy(xpath = "//tbody")
    public WebElement tbodyCounterTablo;

    @FindBy(xpath = "//*[@class='iziToast-message slideIn']")
    public WebElement counterHata;

    @FindBy(xpath = "//div[2]/div/div[2]//tr[20]/td[6]/button[1]/i")
    public WebElement kalemİkon;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div/div/form/div[1]/div[1]/input")
    public WebElement counterUpdateNameTextBox;



    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[4]/div/div/form/div[2]/button[2]")
    public WebElement counterUpdateButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[20]/td[6]/button[1]/i")
    public WebElement i;

    @FindBy(xpath = "//button[@data-id='62']")
    public WebElement ikonCounterActiveDisable;



    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[5]/div/div/form/div[2]/button[2]")
    public WebElement buttonActive;

    @FindBy(xpath = "//button[@class='btn btn--danger']")
    public WebElement buttonDisable;



}



