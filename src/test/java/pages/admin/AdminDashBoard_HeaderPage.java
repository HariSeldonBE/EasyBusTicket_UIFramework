package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashBoard_HeaderPage {
    public AdminDashBoard_HeaderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
   // Admin Dashboard >> Header >> Fullscreen İkonu
    @FindBy(xpath = "//i[@onclick='openFullscreen();']")
    public WebElement ikonOpenFullscreen;

    @FindBy(xpath = "//i[@onclick='closeFullscreen();']")
    public WebElement ikonCloseFullscreen;

    // Admin Dashboard >> Header >> Search İkonu
    @FindBy(xpath = "/html/body/div/nav/div[2]/ul/li[1]/button/i")
    public WebElement buttonHeaderSearch;

    // Admin Dashboard >> Header >> Search Pleaceholder (navbar)
    @FindBy(xpath = "//*[@id='navbar-search__field']")
    public WebElement navbarSearchField;

    // Admin Dashboard >> Header >> Search Result (alt pencere)
    @FindBy(xpath = "//*[@id='navbar_search_result_area']")
    public WebElement navbarSearchResult;

    @FindBy(xpath = "//a[text()='Booked Ticket']")
    public WebElement labelSearchBookedTicket;

    // Admin Dashboard >> Header >> Search sonucunda gidilen sayfanın başlık kısmı
    @FindBy(xpath = "//div[contains(@class, 'align-items-center')]")
    public WebElement labelSayfaBaşlıkları;

 // Admin Dashboard >> Header >> Bildirim ikonu
    @FindBy(xpath = "//i[contains(@class, 'la-bell')]")
    public WebElement ikonBildirim;

 // Admin Dashboard >> Header >> Bildirim ikonu >> Notification
    @FindBy(xpath = "//p")
    public WebElement pUnreadNotification;

 // Admin Dashboard >> Header >> Bildirim ikonu >> Bildirimler
   @FindBy(xpath = "/html/body/div/nav/div[2]/ul/li[2]/div/div[2]/div[1]/a[1]/div")
   public WebElement ddmNewMemberRegisteredHours;
    
    @FindBy(xpath = "//h6[@class='page-title']")
    public  WebElement bildirimTitle;

    @FindBy(xpath = "/html/body/div/nav/div[2]/ul/li[2]/div/div[2]/div[1]/a[1]/div/div[2]")
    public WebElement divNewSupportTicketHas;

    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu--md p-0 border-0 box--shadow1 dropdown-menu-right show']")
    public WebElement ddmBildirimPenceresi;

   @FindBy(xpath = "//a[@class='view-all-message']")
   public WebElement ddmViewAllNotification;

   @FindBy(xpath = "//a[@class='btn btn--primary']")
   public WebElement buttonTümüOkundu;

  @FindBy(xpath = "//div[@class='iziToast-texts']")
    public WebElement alertTümBildirimlerOkundu;

    

    
    

}
