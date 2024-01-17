package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PaymentHistoryDDM {
    public PaymentHistoryDDM(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //    -----Admin Dashboard Payment History DDM-------
    // Admin Dashboard  >>  Payment History DDM
    @FindBy(xpath= "//span[text()='Payment History']")
    public WebElement dropDownPaymentHistory;
    // Admin Dashboard  >> Payment History DDM >> Pending Payment
    @FindBy(xpath= "//span[text()='Pending Payment']")
    public WebElement linkPendingPayment;
    // Admin Dashboard  >> Payment History DDM >> Successful Payment
    @FindBy(xpath= "//span[text()='Successful Payment']")
    public WebElement linkSuccessfulPayment;
    // Admin Dashboard  >> Payment History DDM >> Rejected Payment
    @FindBy(xpath= "//span[text()='Rejected Payment']")
    public WebElement linkRejectedPayment;
    // Admin Dashboard  >> Payment History DDM >> All Payment
    @FindBy(xpath= "//span[text()='All Payment']")
    public WebElement linkAllPayment;
    // Admin Dashboard  >> Payment History DDM >> Tüm sayfalar >>  Trx/Username Arama Kutusu
    @FindBy(xpath= "//input[@class='form-control']")
    public WebElement boxTrxUsername;
    // Admin Dashboard  >> Payment History DDM >> Tüm sayfalar >> Date Arama Kutusu
    @FindBy(xpath= "(//i[@class='fa fa-search'])[1]")
    public WebElement buttonTrxUsername;
    // Admin Dashboard  >> Payment History DDM >> Tüm sayfalar >> Successful Payment
    @FindBy(xpath= "//input[@class='datepicker-here form-control']")
    public WebElement boxDate;
    // Admin Dashboard  >> Payment History DDM >> Tüm sayfalar >> Successful Payment

    @FindBy(xpath= "(//i[@class='fa fa-search'])[2]")
    public WebElement buttonDate;
    // Admin Dashboard  >> Payment History DDM >> Tüm sayfalar >> Successful Payment
    @FindBy(xpath= "/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr/td[1]/small")
    public WebElement linkIlkKullanici;
    @FindBy(xpath= "(//i[@class='fa fa-search'])[2]")
    public WebElement bu;
}
