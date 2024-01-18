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
    @FindBy(xpath = "//*[text()='Every Journey is an Adventure, Every Ticket is a Story']")
    public WebElement EveryJourneyisanAdventureEveryTicketisaStoryYazisi;


    //EasyBusTicket Home page header kısmının solundaki "EasyBusTicketLogo"
    @FindBy(xpath = "(//*[@class='logo'])[1]")
    public WebElement easyBusTicketHeaderLogo;

    //EasyBusTicket Home page header kısmının sagındaki "Buy Tickets Butonu"
    @FindBy(xpath = "//div[@class='d-flex flex-wrap algin-items-center']")
    public WebElement buyTicketsButton;

    //EasyBusTicket Home page header kısmının sagındaki "SignUp Butonu"
    @FindBy(xpath = "//*[@class='sign-up']")
    public WebElement signUpButton;

    @FindBy(xpath = "(//h4[@class='title'])[1]")
    public WebElement homePageChooseYourTicketPanelText;

    //@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
    @FindBy(xpath = "/html/body/section[1]/div[1]/div/div[1]/div/div/form/div[2]/div/select")
    public WebElement homePagePickUpPointContainer;

    @FindBy(xpath = "/html/body/section[1]/div[1]/div/div[1]/div/div/form/div[3]/div/select")
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

    @FindBy(xpath = "(//h4/a)[1]")
    public WebElement blogPostImgOne;

    @FindBy(xpath = "(//h4/a)[2]")
    public WebElement blogPostImgTwo;

    @FindBy(xpath = "(//h4/a)[3]")
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


    // Homepage >> Sign-up Button


    //EasyBusTicket Home page header kısmının sagındaki "Instagram icon'u"
    @FindBy(xpath = "//html/body//div[3]//div//div//div//li[4]//a")
    public WebElement instagramIcon;

    // "Forgot Password?" link -->kevser_US20_TC01
    @FindBy(xpath = "//*[text()='Forgot Password?']")
    public WebElement forgotPasswordLink;
    @FindBy(xpath = "//a[@href=\"https://qa.easybusticket.com/user/dashboard\"]")
    public WebElement dashboardButton;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[1]/div/ul/li[1]/a")
    public WebElement footerXIcon;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[1]/div/ul/li[2]/a")
    public WebElement footerFacebookIcon;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[1]/div/ul/li[3]/a")
    public WebElement footerYoutubeIcon;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[1]/div/ul/li[4]/a")
    public WebElement footerInstagramIcon;

    @FindBy(xpath = "(//*[text()='About'])[2]")
    public WebElement footerAboutButton;

    @FindBy(xpath = "(//*[text()='FAQs'])[2]")
    public WebElement footerFAQsButton;

    @FindBy(xpath = "(//*[text()='Blog'])[2]")
    public WebElement footerBlogButton;

    @FindBy(xpath = "(//*[text()='Contact'])[2]")
    public WebElement footerContactButton;

    @FindBy(xpath = "//*[text()='Privacy Policy']")
    public WebElement footerPrivacyPolicyButton;

    @FindBy(xpath = "//*[text()='Terms and Conditions']")
    public WebElement footerPrivacyTermsConditionsButton;

    @FindBy(xpath = "//*[text()='Ticket Policies']")
    public WebElement footerTicketPoliciesButton;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[4]/div/ul/li[1]")
    public WebElement footerAdresText;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[4]/div/ul/li[2]")
    public WebElement footerContactNumber;

    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[4]/div/ul/li[3]")
    public WebElement footerContactEmail;

    @FindBy(xpath = "(//*[text()='About'])[1]")
    public WebElement headerAboutButton;

    @FindBy(xpath = "(//*[text()='FAQs'])[1]")
    public WebElement headerFAQsButton;

    @FindBy(xpath = "(//*[text()='Blog'])[1]")
    public WebElement headerBlogButton;


    @FindBy(xpath = "/html/body/section[4]/div/div[2]/div/div/div/ul/li[1]/button")
    public WebElement ourTestimonialsButton;

    @FindBy(xpath = "/html/body/section[4]/div/div[2]/div/div/div/ul/li[2]/button")
    public WebElement ourTestimonialsButton2;

    @FindBy(xpath = "/html/body/section[4]/div/div[2]/div/div/div/ul/li[3]/button")
    public WebElement ourTestimonialsButton3;

    // Homepage >> Testimonial link of Emily Rodriguez (1st Testimonial)  -->Huseyin_US11_TC 15
    @FindBy(xpath = "(//button[@tabindex='0'])")
    public WebElement testimonial1;

    // Homepage >> Testimonial link of Aprilou Marwan (2nd Testimonial)  -->Huseyin_US11_TC 15
    @FindBy(xpath = "(//button[@tabindex='-1'])[1]")
    public WebElement testimonial2;

    // Homepage >> Testimonial link of Alex Thompson (3rd Testimonial)  -->Huseyin_US11_TC 15
    @FindBy(xpath = "(//button[@tabindex='-1'])[2]")
    public WebElement testimonial3;

    // Homepage >> Home Linki  -->Huseyin_US115
    @FindBy(xpath = "(//a[normalize-space()='Home'])")
    public WebElement homeLink;
    @FindBy(xpath = "(//a[@href='javascript::void()'])[2]")
    public WebElement dropDownSupportRequest;
    @FindBy(xpath = "//a[@href='https://qa.easybusticket.com/ticket/new']")
    public WebElement linkCreateNew;
    @FindBy(xpath = "//a[@href='https://qa.easybusticket.com/ticket']")
    public WebElement linkRequests;

    @FindBy(xpath = " //table[@class='booking-table']")

    public WebElement labelTable;
    @FindBy(xpath = "(//i[@class='fa fa-desktop'])[1]")
    public WebElement buttonAction;

    @FindBy(xpath = " (//a[@class='btn btn--base btn-sm'])[1]")
    public WebElement buttonNewTicket;

    @FindBy(xpath = "//a[@href='#0']")
    public WebElement dropDownProfile;

    @FindBy(xpath = "//a[@href='https://qa.easybusticket.com/user/change-password']")
    public WebElement linkChangePassword;

    @FindBy(xpath = "//h2[@class='title']")
    public WebElement labelChangePasswordText;

    @FindBy(xpath = "//section[@class='inner-banner bg_img']")
    public WebElement imageBackgroundChangePassword;

    @FindBy(xpath = "//form[@class='register']")
    public WebElement formChangePasswordPenceresi;

    @FindBy(xpath = "(//label[@class='form-label'])[1]")
    public WebElement labelCurrentPasswordText;

    @FindBy(xpath = "(//input[@class='form-contorl form--control radius-0'])[1]")
    public WebElement boxCurrentPassword;
    @FindBy(xpath = "(//label[@class='form-label'])[2]")
    public WebElement labelPasswordText;

    @FindBy(xpath = "(//input[@class='form-contorl form--control radius-0'])[2]")
    public WebElement boxPassword;
    @FindBy(xpath = "(//label[@class='form-label'])[3]")
    public WebElement labelConfirmPassword;

    @FindBy(xpath = "(//input[@class='form-contorl form--control radius-0'])[3]")
    public WebElement boxConfirmPassword;

    @FindBy(xpath = "//input[@class='btn btn--base']")
    public WebElement buttonChangePassword;

    @FindBy(xpath = "//*[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public WebElement alert;

    @FindBy(xpath = "//div[@class='input-popup']")
    public WebElement popUpSifre;

    @FindBy(xpath = "//*[@href ='tel:+1 (603) 624-1800']")
    public WebElement footerTelNumber;

    @FindBy(xpath = "//*[@href ='mailto:info@easybusticket.com']")
    public WebElement footerEmail;

    @FindBy(xpath = "//*[@class='las la-chevron-up']")
    public WebElement toTheTop;

    @FindBy(xpath = "//a[@class='cmn--btn ']")
    public WebElement getTicketNowButton;


}
