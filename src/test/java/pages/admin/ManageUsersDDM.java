package pages.admin;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ManageUsersDDM {
    public ManageUsersDDM(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
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
    @FindBy(xpath = "//td[2]")
    public List<WebElement> listEmail;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/span[2]/a")
    public  WebElement linkIlkKullaniciAdi; // Sayfalarda var
    // --------------------------------EmailToAll linki--------------------------------
    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputSubjectText;
    @FindBy(xpath = "//div[@contenteditable='true']")
    public WebElement inputMessageText;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement buttonSendEmail;

    //--------------------------------User Detail Sayfası--------------------------------
    @FindBy(xpath = "//*[@class=\"page-title\"]")
    public WebElement labelTitleBaslik;
    @FindBy(xpath = "(//body//li[1]/text())[27]")
    public WebElement labelUserInformationBaslik;

    @FindBy(xpath = "//a[@class='btn btn--primary btn--shadow btn-block btn-lg']")
    public WebElement  buttonLoginLogs;
    @FindBy(xpath = "//a[@class='btn btn--info btn--shadow btn-block btn-lg']")
    public WebElement  buttonSendEmailUserDetailPage;
    @FindBy(xpath = "//a[@class='btn btn--dark btn--shadow btn-block btn-lg']")
    public WebElement  buttonLoginAsUser;
    @FindBy(xpath = "//a[@class='btn btn--warning btn--shadow btn-block btn-lg']")
    public WebElement  buttonEmailLog;
    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement inputFirstName;
    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement inputLastName;
    @FindBy(xpath = "(//input[@class='form-control'])[3]")
    public WebElement inputEmail ;
    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement inputMobileNumber;
    @FindBy(xpath = "(//input[@class='form-control'])[5]")
    public WebElement inputAddress;
    @FindBy(xpath = "(//input[@class='form-control'])[6]")
    public WebElement inputCity;
    @FindBy(xpath = "(//input[@class='form-control'])[7]")
    public WebElement inputState;
    @FindBy(xpath = "(//input[@class='form-control'])[8]")
    public WebElement inputZipPostal;
    @FindBy(xpath = "//select[@name='country']")
    public WebElement dropDownCountry;
    @FindBy(xpath = "(//div[@class='toggle-group'])[1]")
    public WebElement buttonStatus;
    @FindBy(xpath = "(//label[@class='btn btn--success toggle-on'])[1]")
    public WebElement buttonStatusActive;
    @FindBy(xpath = "(//label[@class='btn btn--danger active toggle-off'])[1]")
    public WebElement buttonStatusBanned;
    @FindBy(xpath = "(//div[@class='toggle-group'])[2]")
    public WebElement buttonEmailVerification;
    @FindBy(xpath = "(//label[@class='btn btn--success toggle-on'])[2]")
    public WebElement buttonEmailVerified;
    @FindBy(xpath = "(//label[@class='btn btn--danger active toggle-off'])[2]")
    public WebElement buttonEmailUnVerified;
    @FindBy(xpath = "(//div[@class='toggle-group'])[3]")
    public WebElement buttonSMSVerification;
    @FindBy(xpath = "(//label[@class='btn btn--success toggle-on'])[3]")
    public WebElement buttonSmsVerified;
    @FindBy(xpath = "(//label[@class='btn btn--danger active toggle-off'])[3]")
    public WebElement buttonSmsUnVerified;
    @FindBy(xpath = "//button[@class='btn btn--primary btn-block btn-lg']")
    public WebElement buttonSaveChanges;
    @FindBy(xpath = "(//a[@href='https://qa.easybusticket.com/admin/user/detail/172'])[1]")
    public WebElement linkFakeKullanici;
    //---------------------------------------------------------------------------------------------
    @FindBy(xpath = "//i[@class='fa fa-angle-right']")
    public WebElement buttonRight;
    //---------------------------------------------------------------------------------------------
    @FindBy(xpath = "//i[@class='las la-desktop text--shadow']")
    public WebElement linkEmailDetail;
    @FindBy(xpath = "(//*[@data-label=\"Email-Phone\"])[1]")
    public WebElement labelMail;
    @FindBy(xpath = "//p[@class='iziToast-message slideIn']")
    public WebElement alert;


}
