package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlogPage {

    public  BlogPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-3 col-sm-10'])[1]")
    public WebElement blogPost1;

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-3 col-sm-10'])[2]")
    public WebElement blogPost2;

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-3 col-sm-10'])[3]")
    public WebElement blogPost3;

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-3 col-sm-10'])[4]")
    public WebElement blogPost4;

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-3 col-sm-10'])[5]")
    public WebElement blogPost5;

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-3 col-sm-10'])[6]")
    public WebElement blogPost6;

    @FindBy(xpath = "(//div[@class='col-lg-3 col-md-3 col-sm-10'])[7]")
    public WebElement blogPost7;

    @FindBy(xpath = "//*[text()='Recent Blog Post']")
    public WebElement recentBlogPostHeader;

    @FindBy(xpath = "/html/body/section[3]/div/div[2]/div[1]")
    public WebElement recentBlogPost1;

    @FindBy(xpath = "/html/body/section[3]/div/div[2]/div[2]")
    public WebElement recentBlogPost2;

    @FindBy(xpath = "/html/body/section[3]/div/div[2]/div[3]")
    public WebElement recentBlogPost3;
}
