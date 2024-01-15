package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BookingHistoryPage {
    public BookingHistoryPage(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "(//td[@class='pickup'])[1]")
    public WebElement pickupControl;
    @FindBy(xpath = "(//td[@class='drop'])[1]")
    public WebElement dropControl;
    @FindBy(xpath = "(//td[@class='date'])[1]")
    public WebElement dateControl;
    @FindBy(xpath = "(//td[@class='fare'])[1]")
    public WebElement subTotalControl;

}
