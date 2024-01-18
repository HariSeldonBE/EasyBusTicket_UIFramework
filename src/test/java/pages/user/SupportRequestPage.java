package pages.user;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SupportRequestPage { public SupportRequestPage(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//h2[@class=\"title\"]")
    public WebElement supportTicketsTitle;
    @FindBy(xpath = "//input[@value=\"Team2 Tester\"]")
    public WebElement name;
    @FindBy(xpath = "(//input[@class=\"form--control\"])[2]")
    public WebElement mail;
    @FindBy(xpath = "(//input[@class=\"form--control\"])[3]")
    public WebElement subject;
    @FindBy(xpath = "//textarea[@name=\"message\"]")
    public WebElement message;
    @FindBy(xpath = "//select[@name=\"priority\"]")
    public WebElement priority;
    @FindBy(xpath = "//input[@type=\"file\"]")
    public WebElement dosyaSec;
    @FindBy(xpath = "//i[@class=\"fas fa-plus\"]")
    public WebElement dosyaSecEkleme;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;
    @FindBy(xpath = "//option[@value=\"3\"]")
    public WebElement high;
    @FindBy(xpath = "//option[@value=\"2\"]")
    public WebElement medium;
    @FindBy(xpath = "//option[@value=\"1\"]")
    public WebElement low;
    @FindBy(xpath = "(//span[text()='Open'])")
    public WebElement statusOpen;
    @FindBy(xpath = "//table[@class=\"booking-table\"]")
    public List<WebElement> requestTable;
    @FindBy(xpath = "//td[@data-label=\"Last Reply\"]")
    public  List<WebElement> lastReplies;
    @FindBy(xpath = "//tr/th")
    public List<WebElement> sutunSayisi;
    @FindBy(xpath = "//i[@class=\"fa fa-desktop\"]")
    public List<WebElement> actionButton;
    @FindBy(xpath = "(//a[@class=\"btn btn--base btn-sm\"])[1]")
    public WebElement newTicketButton;
    @FindBy(xpath = "//td[@data-label=\"Priority\"]")
    public List<WebElement> tablePriority;
    @FindBy(xpath = "//a[@class=\"font-weight-bold\"]")
    public List<WebElement> subjectList;
    @FindBy(xpath = "//h5[@class=\"card-title m-0 text-white\"]")
    public  WebElement cardTitle;
    @FindBy(xpath = "//i[@class=\"fa fa-reply\"]")
    public WebElement replyButton;
    @FindBy(xpath = "//i[@class=\"fa fa-plus\"]")
    public WebElement plusButton;
    @FindBy(xpath = "//i[@class=\"fa fa-lg fa-times-circle\"]")
    public  WebElement closeButton;
    @FindBy(xpath = "//input[@id=\"inputAttachments\"]")
    public WebElement attachments;
    @FindBy(xpath = "//div[@class=\"row border border-primary border-radius-3 my-sm-3 my-2 py-3 mx-0 mx-sm-2\"]")
    public WebElement requestText;
    @FindBy(xpath = "//textarea[@name=\"message\"]")
    public WebElement text;
    @FindBy(xpath = "//span[@class=\"badge badge--warning py-2 px-3\"]")
    public WebElement replied;
    @FindBy(xpath = "(//div[@class=\"row border border-primary border-radius-3 my-sm-3 my-2 py-3 mx-0 mx-sm-2\"])[1]")
    public WebElement repliedMessage;
    @FindBy(xpath = "//*[text()=\"Support ticket replied successfully!\"]")
    public WebElement successfullRepliedMessage;
    @FindBy(xpath = "//p[@class=\"iziToast-message slideIn\"]")
    public WebElement uyari;
    @FindBy(xpath = "//span[@class=\"badge badge--warning py-2 px-3\"]")
    public List<WebElement> customerReplies;
    @FindBy(xpath = "//p[@class=\"iziToast-message slideIn\"]")
    public WebElement error;
    @FindBy(xpath = "//p[@class=\"iziToast-message slideIn\"]")
    public WebElement requestSuccessful;
    @FindBy(xpath = "//a[@class=\"btn btn-sm bg-white float-right support-ticket\"]")
    public WebElement mySupportTicket;






}


