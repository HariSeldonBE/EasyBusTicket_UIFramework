package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FAQsPage {

    public  FAQsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Frequently Asked Questions']")
    public WebElement frequentlyAskedQuestionsHeader;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[1]/div/div[1]")
    public WebElement sıkSorulanSorularContainer;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[1]/div/div[2]")
    public WebElement sıkSorulanSorularContainer2;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[1]/div/div[3]")
    public WebElement sıkSorulanSorularContainer3;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[1]/div/div[4]")
    public WebElement sıkSorulanSorularContainer4;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[1]/div/div[5]")
    public WebElement sıkSorulanSorularContainer5;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[1]/div/div[6]")
    public WebElement sıkSorulanSorularContainer6;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[1]/div/div[7]")
    public WebElement sıkSorulanSorularContainer7;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/div/div[1]")
    public WebElement sıkSorulanSorularContainer8;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/div/div[2]")
    public WebElement sıkSorulanSorularContainer9;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/div/div[3]")
    public WebElement sıkSorulanSorularContainer10;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/div/div[4]")
    public WebElement sıkSorulanSorularContainer11;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/div/div[5]")
    public WebElement sıkSorulanSorularContainer12;

    @FindBy(xpath = "/html/body/section[2]/div/div[2]/div[2]/div/div[6]")
    public WebElement sıkSorulanSorularContainer13;





}
