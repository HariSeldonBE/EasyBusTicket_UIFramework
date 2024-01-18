package pages.user;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;
import java.util.List;

public class SelectSeatPage {public SelectSeatPage(){PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//input[@name='date_of_journey']")
    public WebElement journeyDate;

    @FindBy(xpath = "(//span[@role='combobox'])[1]")
    public WebElement pickupPoint;
    @FindBy(xpath = "(//span[@role='combobox'])[2]")
    public WebElement droppingPoint;
    @FindBy(xpath = "//input[@id='male']")
    public WebElement maleCheckbox;
    @FindBy(xpath = "//input[@id='female']")
    public WebElement femaleCheckbox;
    @FindBy(xpath = "//input[@id='other']")
    public WebElement otherCheckbox;
    @FindBy(xpath="//span[@class='seat']")
    public List<WebElement> seats;
    @FindBy(xpath = "//span[@class='seat selected']")
    public List<WebElement> selectedSeats;
    @FindBy(xpath = "//div[@class='seat-condition selected-by-ladies disabled']")
    public List<WebElement> ladiesSelectedSeats;
    @FindBy(xpath = "//div[@class='seat-condition selected-by-gents disabled']")
    public List<WebElement> gentsSelectedSeats;
    @FindBy(xpath = "//div[@class='seat-condition selected-by-others disabled']")
    public List<WebElement> othersSelectedSeats;
    @FindBy(xpath = "//button[@class='book-bus-btn']")
    public WebElement continueButton;
    @FindBy(xpath = "//*[text()=' Confirm Booking']")
    public WebElement confirmBooking;
    @FindBy(xpath = "//button[@id='btnBookConfirm']")
    public WebElement confirmBookingButton;
    @FindBy(xpath = "(//button[@class='btn btn--danger w-auto btn--sm px-3'])[1]")
    public WebElement closeConfirmBookingButton;
    @FindBy(xpath = "//*[text()='Payment Methods']")
    public WebElement paymentMethodsTitle;

    @FindBy(xpath = "//div[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public WebElement seatSelectionError;

    @FindBy(xpath = "//*[text()='The gender field is required.']")
    public WebElement genderSelectError;
    @FindBy(xpath = "//div[@class='selected-seat-details']")
    public WebElement selectedSeatDetails;
    @FindBy(xpath = "//a[@data-name=\"Stripe Hosted\"]")
    public WebElement paymentMethodsPayNowButton;
    @FindBy(xpath = "//h5[@id='depositModalLabel']")
    public WebElement paymentByStripeHostedTitle;
    @FindBy(xpath = "//button[@type='button']")
    public WebElement paymentByStripeHostedClose;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement paymentByStripeHostedConfirm;
    @FindBy(xpath = "//*[text()='Payment Preview']")
    public WebElement paymentPreviewTitle;
    @FindBy(xpath = "//span[@class='list-group-item d-flex justify-content-between']")
    public List<WebElement> subTotal;
    @FindBy(xpath = "//span[@class='text--primary']")
    public WebElement tolalPayment;
    @FindBy(xpath = "//a[@class='btn btn--base btn--md w-100 radius-5 mt-3 ']")
    public WebElement paymentReviewPayNowButton;
    @FindBy(xpath = "//h2[@class='title']")
    public WebElement paymentConfirmTitle;
    @FindBy(xpath = "//input[@placeholder='Name on Card']")
    public WebElement nameOnCard;
    @FindBy(xpath = "//input[@placeholder='Valid Card Number']")
    public WebElement validCardNumber;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement paymentConfirmPayNowButton;
    @FindBy(xpath = "//input[@placeholder='MM / YYYY']")
    public WebElement expirationDate;
    @FindBy(xpath = "//input[@placeholder='CVC']")
    public WebElement cvcCode;
    @FindBy(xpath = "//div[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public WebElement successfulPayment;
    @FindBy(xpath = "//h2[@class='title']")
    public WebElement bookingHistoryTitle;

    @FindBy(xpath = "(//i[@class='las la-print'])[1]")
    public WebElement yaziciIkonu;

    @FindBy(xpath = "(//td[@data-label='Status'])[1]")
    public WebElement status;

    @FindBy(xpath = "//a[@class='ui-state-default ui-state-active']")
    public WebElement seatJourneyDateSelection;
    @FindBy(xpath = "//td[@class=\" ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today\"]")
    public WebElement secondSelectedDate;

    @FindBy(xpath = "//input[@id='date_of_journey']")
    public WebElement seatJourneyDateBox;
    @FindBy(xpath = "//span[@id='select2-pickup_point-container']")
    public WebElement seatPickup;
    @FindBy(xpath = "//span[@id='select2-dropping_point-container']")
    public WebElement seatDropping;
    @FindBy(xpath = "//a[@class='ui-state-default ui-state-active']")
    public WebElement firstSelectedDate;
   @FindBy(xpath = "//span[@class='seat']")
    public WebElement koltuk;
    @FindBy(xpath = "(//p[@class='place'])[1]")
    public WebElement aktarmali1;
    @FindBy(xpath = "(//p[@class='place'])[2]")
    public WebElement aktarmali2;
    @FindBy(xpath = "(//p[@class='place'])[4]")
    public WebElement aktarmali4;
    @FindBy(xpath = "//p[@class='iziToast-message slideIn']")
    public WebElement seatSelectionError2;
    @FindBy(xpath = "//span[@class='rear']")
    public WebElement rear;
    @FindBy(xpath = "//img[@src=\"https://qa.easybusticket.com/assets/images/logoIcon/logo_2.png\"]")
    public WebElement logo;
    @FindBy(xpath = "//span[@data-seat=\"1-F1\"]")
    public WebElement F1;
    @FindBy(xpath= "//*[@class='iziToast-message slideIn']")
    public WebElement depositError;


}
