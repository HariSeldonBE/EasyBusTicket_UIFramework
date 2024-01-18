package tests.simge.US13;

import com.beust.ah.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.FindTicketsPage;
import pages.user.SelectSeatPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC05 extends TestBaseRapor {
    @Test
    public void selectSeatNegatifTesti(){
        extentTest=extentReports.createTest("Koltuk Seçme Negatif Test", "Koltuk seçmeme/cinsiyet seçmeme test ediliyor");

        SoftAssert softAssert = new SoftAssert();
        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        extentTest.info("Browser açılır ve Url'e gidilir ve Login olunur");
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü görüntülenir ve tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        extentTest.info("Açılan user dashboard sayfasında navbar menüde \"Booking\" ddm menüsü görüntülenir ve tıklanır");
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        FindTicketsPage findTicketsPage=new FindTicketsPage();
        extentTest.info("\"Booking\" açılır menüsü açıldığında \"Buy Ticket\" butonu tıklanır");
        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(2);
        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(2);
        Object selectedPickup= findTicketsPage.pickupPointSelection.getText();
        extentTest.info("\"Pick Up Point\" dropbox undan herhangi bir yer seçilir");
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        Object selectedDropping=findTicketsPage.droppingPointSelection.getText();
        extentTest.info("\"Dropping Point\" dropbox undan farklı yer seçilir");
        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));

        ReusableMethods.wait(2);
        extentTest.info("\"Date of Journey\" dropbox undan sonraki tarih seçilir");
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        extentTest.info("\"Find Tickets\" butonu tıklanır");
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        extentTest.info("Select Seat butonu tıklanır");
        // 14- Journey Date doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatJourneyDateBox.getAttribute("value"),ConfigReader.getProperty("date"),"Find Ticket Page'de secilen tarih ile Select Seat Page'ki journey date uyusmuyor");
        extentTest.info("Journey Date doğru mu kontrol edilir");
        // 15- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup,"Secilen pickup point uyusmuyor");
        extentTest.info("Pickup Point doğru mu kontrol edilir");
        // 16- Dropping Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping,"Secilen dropping point uyusmuyor");
        extentTest.info("Dropping Point doğru mu kontrol edilir");


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);

        // 17-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        extentTest.info("\"Continue\" butonu tıklanır");
        // 18-"Select at least one seat" hatası verir
        softAssert.assertTrue(selectSeatPage.seatSelectionError.isDisplayed(),"Error görüntülenmedi");
        extentTest.info("\"Select at least one seat\" hatası verir");
        // 19-Koltuk seçimi yapılır
        ReusableMethods.seatSelectionMethod();
        extentTest.info("Koltuk seçimi yapılır");
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(1);
        // 20-"Continue" butonu tıklanır
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        extentTest.info("\"Continue\" butonu tıklanır");
        // 21-Açılan Confirm Booking penceresinde "Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        ReusableMethods.wait(2);
        extentTest.info("Açılan Confirm Booking penceresinde \"Confirm\" butonu tıklanır");

        // 22-"The gender field is required" hatası verir
        softAssert.assertTrue(selectSeatPage.genderSelectError.isDisplayed(),"Error görüntülenmedi");
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(2);
        extentTest.info("\"The gender field is required\" hatası verir");
        // 23-Journey Date doğru mu kontrol edilir

        softAssert.assertEquals(selectSeatPage.seatJourneyDateBox.getAttribute("value"),ConfigReader.getProperty("date"),"Find Ticket Page'de secilen tarih ile Select Seat Page'ki journey date uyusmuyor");
        extentTest.info("Journey Date doğru mu kontrol edilir");

        // 24- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup,"Secilen pickup point uyusmuyor");
        extentTest.info("Pickup Point doğru mu kontrol edilir");
        // 25- Dropping Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping,"Secilen dropping point uyusmuyor");
        extentTest.info("Dropping Point doğru mu kontrol edilir");
        // 26-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        ReusableMethods.wait(2);
        extentTest.info("Cinsiyet seçimi yapılır");
        // 27-Koltuk seçimi yapılır
        selectSeatPage.seats.get(30).click();
        ReusableMethods.wait(2);
        extentTest.info("Koltuk seçimi yapılır");
        // 28-"Continue" butonu tıklanır
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        extentTest.info("\"Continue\" butonu tıklanır");
        // 29-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        extentTest.info("\"Confirm\" butonu tıklanır");
        // 30-Payment Methods sayfası açıldığı doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentMethodsTitle.isDisplayed(),"Payment Methods açılmadı");
        ReusableMethods.wait(2);
        extentTest.info("Payment Methods sayfası açıldığı doğrulanır");
        softAssert.assertAll();

        Driver.closeDriver();





    }
}
