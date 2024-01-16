package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AboutPage {

    public  AboutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//div[@class='section-header'])[1]")
    public WebElement aboutPageHeader;

    @FindBy (xpath = "/html/body/section[2]/div/div[1]/div[1]/div/div[2]/p[3]/b/span")
    public WebElement fastAndSecureTicketSalesText;

    @FindBy (xpath = "/html/body/section[2]/div/div[1]/div[1]/div/div[2]/p[8]/b/span")
    public WebElement relaxedTravelPlanningText;

    @FindBy (xpath = "/html/body/section[2]/div/div[1]/div[1]/div/div[2]/p[12]/b/span")
    public WebElement customerSatisfactionFocusedServiceText;

    @FindBy (xpath = "/html/body/section[2]/div/div[1]/div[1]/div/div[2]/p[17]/b/span")
    public WebElement ourAdvantagesText;
}
