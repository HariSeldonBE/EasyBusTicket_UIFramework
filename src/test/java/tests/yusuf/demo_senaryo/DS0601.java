package tests.yusuf.demo_senaryo;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import pages.user.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class DS0601 extends TestBaseRapor {
    @Test
    public void DS06_01 () {


        extentTest = extentReports.createTest("Contact Us support message TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        ReusableMethods.wait(1);

        easyBusTicketPage.getTicketNowButton.click();
        ReusableMethods.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        findTicketsPage.pickupPoint.click();

        ReusableMethods.wait(2);
        SoftAssert softAssert = new SoftAssert();

        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(2);
        Object selectedPickup = findTicketsPage.pickupPointSelection.getText();
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        Object selectedDropping = findTicketsPage.droppingPointSelection.getText();

        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));
        // Object selectedDate = findTicketsPage.dateOfJourneySelection.getText();
        ReusableMethods.wait(2);

        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();

        ReusableMethods.wait(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(1);
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("window.scrollBy(0,arguments[0])", 500);
        ReusableMethods.wait(1);
        // - Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        // js.executeScript("arguments[0].click",selectSeatPage.femaleCheckbox);


        //  selectSeatPage.femaleCheckbox.click();


        // - Koltuk seçimi yapılır
        selectSeatPage.seats.get(0).click();
        // js.executeScript("arguments[0].click",selectSeatPage.seats.get(0));


        ReusableMethods.wait(2);


        // 26-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        // js.executeScript("arguments[0].click",selectSeatPage.continueButton);
        selectSeatPage.continueButton.click();
        // 30-"Confirm" butonu tıklanır
        //js.executeScript("arguments[0].click",selectSeatPage.confirmBookingButton);
        selectSeatPage.confirmBookingButton.click();
        ReusableMethods.wait(2);
        UserLoginPage userLoginPage = new UserLoginPage();
        Faker faker = new Faker();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        userLoginPage.signUpButton.click();
        // js.executeScript("arguments[0].click",userLoginPage.signUpButton);
    }}