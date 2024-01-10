package pages.admin;

import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashBoardPage {
    public AdminDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Admin dashboard sayfasının side bar'ındaki "Manage trips" linki
    @FindBy(xpath = "//*[text()='Manage Trips']")
    public WebElement manageTripsLink;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Route" item'i
    @FindBy(xpath = "//*[text()='Route']")
    public WebElement routeElement;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Schedule" item'i
    @FindBy(xpath = "//*[text()='Schedule']")
    public WebElement scheduleElement;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Ticket Price" item'i
    @FindBy(xpath = "//*[text()='Ticket Price']")
    public WebElement ticketPriceElement;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Trip" item'i
    @FindBy(xpath = "//*[text()='Trip']")
    public WebElement tripElement;

    // Admin dashboard sayfasının sidebar'ındaki "Manage Trips" linki altındaki "Assigned Vehicle" item'i
    @FindBy(xpath = "//*[text()='Assigned Vehicle']")
    public WebElement assignedVehicleElement;
}
