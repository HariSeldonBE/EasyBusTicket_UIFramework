package tests.simge.US13;

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

public class TC12 extends TestBaseRapor {
    @Test
    public void nameOnCardNegatifTestiSoyad(){
        extentTest=extentReports.createTest("Name on Card Negatif Test", "Name on Card alanına sadece isim giriliyor soyad girilmiyor");
        SoftAssert softAssert = new SoftAssert();

        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        extentTest.info("Browser açılır ve Url'e gidilir ve Login olunur");
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü görüntülenir ve tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        extentTest.info("Açılan user dashboard sayfasında navbar menüde \"Booking\" ddm menüsü görüntülenir ve tıklanır");
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();

        FindTicketsPage findTicketsPage = new FindTicketsPage();
        extentTest.info("\"Booking\" açılır menüsü açıldığında \"Buy Ticket\" butonu tıklanır");

        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();

        findTicketsPage.pickupPointSelection.click();
        Object selectedPickup = findTicketsPage.pickupPointSelection.getText();
        ReusableMethods.wait(2);
        extentTest.info("\"Pick Up Point\" dropbox undan herhangi bir yer seçilir");
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        Object selectedDropping = findTicketsPage.droppingPointSelection.getText();
        ReusableMethods.wait(2);
        extentTest.info("\"Dropping Point\" dropbox undan farklı yer seçilir");
        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));
        ReusableMethods.wait(2);
        extentTest.info("Date of Journey dropbox undan sonraki tarih seçilir");
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
        Assert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup,"Secilen pickup point uyusmuyor");
        extentTest.info("Pickup Point doğru mu kontrol edilir");
        // 16- Dropping Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping,"Secilen dropping point uyusmuyor");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        extentTest.info("Dropping Point doğru mu kontrol edilir");

        // 17-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        extentTest.info("Cinsiyet seçimi yapılır");


        // 18 - Koltuk seçimi yapılır
        ReusableMethods.seatSelectionMethod();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(1);
        extentTest.info("Koltuk seçimi yapılır");
        // 19-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        extentTest.info("\"Continue\" butonu tıklanır");


        // 20-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        extentTest.info("\"Confirm\" butonu tıklanır");

        // 21- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);
        extentTest.info("\"Pay Now\" butonu tıklanır");

        // 22-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentReviewPayNowButton);
        ReusableMethods.wait(1);
        extentTest.info("\"Confirm\" butonu tıklanır");

        // 23-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(1);
        extentTest.info("\"pay now\" butonu tıklanır");

        // 24-"Name on Card" textbox ına sadece isim yazılır
        selectSeatPage.nameOnCard.sendKeys("wise");
        ReusableMethods.wait(2);
        extentTest.info("\"Name on Card\" textbox ına sadece isim yazılır");

        // 25-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        extentTest.info("\"Card Number\" textbox ına 16 haneli geçerli kart numarası girilir");


        // 26 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));
        extentTest.info("\"Expiration Date\" textbox ına \"MM/YYYY\" formatında geçerli tarih girilir");

        // 27-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));
        extentTest.info("\"CVC Code\" textbox ına 3 haneli sayı girilir");


        // 28-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        extentTest.info("\"PAY NOW\" butonu tıklanır");


        ReusableMethods.wait(2);
        Object expected = "Rejected";
        softAssert.assertEquals(selectSeatPage.status.getText(),expected,"Bug var");
        softAssert.assertAll();

        Driver.closeDriver();
        extentTest.info("Driver kapatılır");


    }
}
