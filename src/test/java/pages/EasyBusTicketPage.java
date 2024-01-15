package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EasyBusTicketPage {
    public EasyBusTicketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Homepage >> Cookies Button  -->Huseyin_US10
    @FindBy(className = "cookies-btn") //(xpath = "(//*[@name=\"cookieAccept\"])")
    public WebElement cookiesButton;

    // Homepage >> Sign-in Button  -->Huseyin_US10
    @FindBy(className = "sign-in")
    public WebElement signInButton;

    // Homepage >> Contact Button
    @FindBy(xpath = "(//a[text()='Contact'])[1]")
    public WebElement contactButton;

    // Homepage >> Contact Us Text
    @FindBy (xpath = "//h2[@class='title']")
    public WebElement contactUsText;

    // Homepage >> Banner area text
    @FindBy(xpath = "//*[text()=\"Every Journey is an Adventure, Every Ticket is a Story\"]")
    public WebElement EveryJourneyisanAdventureEveryTicketisaStoryYazisi;


    //EasyBusTicket Home page header kısmının solundaki "EasyBusTicketLogo"
    @FindBy(xpath = "(//div[@class='logo'])[1]")
    public WebElement easyBusTicketHeaderLogo;

    //EasyBusTicket Home page header kısmının sagındaki "Buy Tickets Butonu"
    @FindBy(xpath = "//div[@class='d-flex flex-wrap algin-items-center']")
    public WebElement buyTicketsButton;

    //EasyBusTicket Home page header kısmının sagındaki "SignUp Butonu"
    @FindBy(xpath = "//*[@class='sign-up']")
    public WebElement signUpButton;

    @FindBy(xpath = "(//h4[@class='title'])[1]")
    public WebElement homePageChooseYourTicketPanelText;

    @FindBy(xpath = "(//span[@class='selection'])[1]")
    public WebElement homePagePickUpPointContainer;

    @FindBy(xpath = "(//span[@class='selection'])[2]")
    public WebElement homePageDroppingPointContainer;


    @FindBy(xpath = "//*[@name='date_of_journey']")
    public WebElement homePageDepartureDatePicker;

    //EasyBusTicket Home page banner kısmındaki bilet alma panelindeki "Find Ticket Butonu"
    @FindBy(xpath = "(//div[@class='form--group'])[4]")
    public WebElement homePageFindTicketButton;

    @FindBy(xpath = "//*[@class='cmn--btn ']")
    public  WebElement homePageGetTicketNowButton;

    //EasyBusTicket Home page banner kısmındaki bilet alma panelindeki "In Just 3 Simple Steps, Get Your Bus Ticket texti"
    @FindBy(xpath = "(//h2[@class='title'])[1]")
    public  WebElement inJust3SimpleStepsGetYourBusTicketText;

    //EasyBusTicket Home page banner kısmındaki bilet alma panelindeki "In Just 3 Simple Steps, Get Your Bus Ticket"
    //altındaki 3 logodan 1.si
    @FindBy(xpath = "(//div[@class='thumb-wrapper'])[1]")
    public  WebElement lookingForABusLogo;

    //EasyBusTicket Home page banner kısmındaki bilet alma panelindeki "In Just 3 Simple Steps, Get Your Bus Ticket"
    //altındaki 3 logodan 2.si
    @FindBy(xpath = "(//div[@class='thumb-wrapper'])[2]")
    public  WebElement selectYourTicketLogo;

    //EasyBusTicket Home page banner kısmındaki bilet alma panelindeki "In Just 3 Simple Steps, Get Your Bus Ticket"
    //altındaki 3 logodan 3.sü
    @FindBy(xpath = "(//div[@class='thumb-wrapper'])[3]")
    public  WebElement payYourBillLogo;

    @FindBy(xpath = "(//h2[@class='title'])[2]")
    public WebElement offeredFacilitiesText;


    //EasyBusTicket Home page banner kısmındaki bilet alma panelindeki "Offered Facilities"
    //altındaki 4 logo
    @FindBy(xpath = "(//div[@class='thumb'])[1]")
    public WebElement wifiLogo;

    @FindBy(xpath = "(//div[@class='thumb'])[2]")
    public WebElement pillowLogo;

    @FindBy(xpath = "(//div[@class='thumb'])[3]")
    public WebElement waterLogo;

    @FindBy(xpath = "(//div[@class='thumb'])[4]")
    public WebElement teaAndCoffeLogo;

    @FindBy(xpath = "(//h2[@class='title'])[3]")
    public WebElement ourTestimonialsTitle;

    @FindBy(xpath = "(//h2[@class='title'])[4]")
    public WebElement recentBlogPostTitle;

    @FindBy(xpath = "(//div[@class='post-thumb'])[1]")
    public WebElement blogPostImgOne;

    @FindBy(xpath = "(//div[@class='post-thumb'])[2]")
    public WebElement blogPostImgTwo;

    @FindBy(xpath = "(//div[@class='post-thumb'])[3]")
    public WebElement blogPostImgThree;

    @FindBy(xpath = "(//div[@class='post-content'])[1]")
    public WebElement postContentOne;

    @FindBy(xpath = "(//div[@class='post-content'])[2]")
    public WebElement postContentTwo;

    @FindBy(xpath = "(//div[@class='post-content'])[3]")
    public WebElement postContentThree;

    //Easy Bus Ticket footer kısmındaki "Sosyal Medya İconları"
    @FindBy(xpath = "(//*[@class='social-icons'])[2]")
    public WebElement sosyalMedyaIcons;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[2]/div/h4")
    public WebElement usefulLinksTitle;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[3]/div/h4")
    public WebElement policiesTitle;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[4]/div/h4")
    public WebElement contactInfoTitle;

    @FindBy(xpath = "(//div[@class='logo'])[2]")
    public WebElement easyBusTicketFooterLogo;

    // "Forgot Password?" link -->kevser_US20_TC01
    @FindBy(xpath = "//*[text()='Forgot Password?']")
    public WebElement forgotPasswordLink;

}
