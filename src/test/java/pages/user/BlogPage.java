package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlogPage {

    public  BlogPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/section[2]/div/div/div/div/div[1]/div/div[2]/h4/a")
    public static WebElement blogPost1;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/div/div[2]/div/div[2]/h4/a")
    public static WebElement blogPost2;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/div/div[3]/div/div[2]/h4/a")
    public static WebElement blogPost3;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/div/div[4]/div/div[2]/h4/a")
    public static WebElement blogPost4;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/div/div[5]/div/div[2]/h4/a")
    public static WebElement blogPost5;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/div/div[6]/div/div[2]/h4/a")
    public static WebElement blogPost6;

    @FindBy(xpath = "/html/body/section[2]/div/div/div/div/div[7]/div/div[2]/h4/a")
    public static WebElement blogPost7;

    @FindBy(xpath = "//*[text()='Recent Blog Post']")
    public WebElement recentBlogPostHeader;

    @FindBy(xpath = "/html/body/section[3]/div/div[2]/div[1]")
    public static WebElement recentBlogPost1;

    @FindBy(xpath = "/html/body/section[3]/div/div[2]/div[2]")
    public static WebElement recentBlogPost2;

    @FindBy(xpath = "/html/body/section[3]/div/div[2]/div[3]")
    public static WebElement recentBlogPost3;

    @FindBy(xpath = "//*[text()='Travel Trends: The Best Times to Explore New Places']")
    public static WebElement travelTrendsHeader;

    @FindBy(xpath = "//*[text()='Traveling with Technology: Making Your Journey Easier with Apps and Devices']")
    public WebElement travelingWithTechnologyHeader;

    @FindBy(xpath = "//*[text()='Safety Measures: What to Pay Attention to During Travel']")
    public WebElement safetyMeasuresHeader;

    @FindBy(xpath = "//*[text()='Culinary Odyssey Across America: Must-Try Regional Delicacies']")
    public WebElement culinaryOdysseyAcrossAmericaHeader;

    @FindBy(xpath = "//*[text()='Tips for Comfort During Travel']")
    public WebElement tipsForComfortDuringTravelHeader;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[2]/div[1]/h4[1]")
    public WebElement americasMustSeeIconicCitiesHeader;

    @FindBy(xpath = "//*[text()='Nature Retreat in America: The Most Beautiful National Parks']")
    public WebElement natureRetreatInAmericaHeader;


}
