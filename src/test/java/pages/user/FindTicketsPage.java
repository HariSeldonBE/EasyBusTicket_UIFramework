package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class FindTicketsPage {
    public FindTicketsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='form--group'])[4]")
    public WebElement findTicketsButton;

    @FindBy(xpath="//input[@name='fleetType[]']")
    public List<WebElement> vehicleCheckboxes;

    @FindBy(xpath = "//input[@name='routes[]']")
    public List<WebElement> routesCheckboxes;

    @FindBy(xpath = "(//span[@role='combobox'])[1]")
    public WebElement pickupPoint;

    @FindBy(xpath = "(//span[@role='combobox'])[2]")
    public WebElement droppingPoint;

    @FindBy(xpath = "(//input[@name='date_of_journey'])[1]")
    public WebElement dateOfJourney;

    @FindBy(xpath = "(//option[@value='1'])[1]")
    public WebElement pickupPointSelection;
    @FindBy(xpath = "(//option[@value='2'])[2]")
    public WebElement droppingPointSelection;
    @FindBy(xpath = "(//option[@value='1'])[2]")
    public WebElement droppingPointNegatifSelection;
    @FindBy(xpath = "(//td[@data-handler='selectDay'])[20]")
    public WebElement dateOfJourneySelection;
    @FindBy(xpath = "(//td[@data-handler='selectDay'])[10]")
    public WebElement dateOfJourneyNegatifSelection;
    @FindBy(xpath = "//p[text()='Please select pickup point and destination point properly']")
    public WebElement properlyError;

    @FindBy(xpath = "//div[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public WebElement journeyDateError;

    @FindBy(xpath = "//a[@class='btn btn--base']")
    public WebElement selectSeatButton;
    @FindBy(xpath = "//span[@id='select2-pickup-z9-container']")
    public WebElement selectSeatPickup;
}
