package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EasyBusTicketPage {
    public EasyBusTicketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "cookies-btn") //(xpath = "(//*[@name=\"cookieAccept\"])")
    public WebElement cookiesButton;
    @FindBy(className = "sign-in")
    public WebElement signInButton;


    @FindBy(xpath = "//a[text()='Contact']")
    public WebElement contactButton;

    @FindBy (xpath = "//h2[@class='title']")
    public WebElement contactUsText;

    @FindBy(xpath = "//*[text()=\"Every Journey is an Adventure, Every Ticket is a Story\"]")
    public WebElement EveryJourneyisanAdventureEveryTicketisaStoryYazisi;

    //EasyBusTicket Home page header kısmının solundaki "MobileNumber"
    @FindBy(xpath = "//html/body//div[3]//div//div//a")
    public WebElement headerMobileNumberLinki;

    //EasyBusTicket Home page header kısmının solundaki "Email Adresi"
    @FindBy(xpath = "//html/body//div[3]//div//div//li[2]//a")
    public WebElement headerEmail;

    //EasyBusTicket Home page header kısmının sagındaki "X icon'u"
    @FindBy(xpath = "//html/body//div[3]//div//div//div//li[1]//a")
    public WebElement xIcon;

    //EasyBusTicket Home page header kısmının sagındaki "Facebook icon'u"
    @FindBy(xpath = "//html/body//div[3]//div//div//div//li[2]//a")
    public WebElement facebookIcon;

    //EasyBusTicket Home page header kısmının sagındaki "Youtube icon'u"
    @FindBy(xpath = "//html/body//div[3]//div//div//div//li[3]//a")
    public WebElement youtubeIcon;

    //EasyBusTicket Home page header kısmının sagındaki "Instagram icon'u"
    @FindBy(xpath = "//html/body//div[3]//div//div//div//li[4]//a")
    public WebElement instagramIcon;

    //EasyBusTicket Home page header kısmının solundaki "EasyBusTicketLogo"
    @FindBy(xpath = "(//div[@class='logo'])[1]")
    public WebElement easyBusTicketHeaderLogo;

    //EasyBusTicket Home page header kısmının sagındaki "Buy Tickets Butonu"
    @FindBy(xpath = "//div[@class='d-flex flex-wrap algin-items-center']")
    public WebElement buyTicketsButton;

    //EasyBusTicket Home page header kısmının sagındaki "SignUp Butonu"
    @FindBy(className = "sign-up")
    public WebElement signUpButton;

    @FindBy(className = "Choose Your Ticket")
    public WebElement homePageChooseYourTicketPanelText;

    @FindBy(xpath = "(//span[@class='selection'])[1]")
    public WebElement homePagePickUpPointContainer;

    @FindBy(xpath = "(//span[@class='selection'])[2]")
    public WebElement homePageDroppingPointContainer;

    @FindBy(className = "form--control datepicker hasDatepicker")
    public WebElement homePageDepartureDatePicker;

    @FindBy(xpath = "(//div[@class='form--group'])[4]")
    public WebElement homePageFindTicketButton;


}
