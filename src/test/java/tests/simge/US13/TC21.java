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

public class TC21 extends TestBaseRapor {
    @Test
    public void cvcCodeNegatifTestiGecersizSayiGirilmesi(){
        extentTest=extentReports.createTest("New Counter Negatif TEST", "Yanlış bilgilerle girilmemesi gerekiyor ");
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
        // 11-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        Object selectedDropping = findTicketsPage.droppingPointSelection.getText();
        ReusableMethods.wait(2);
        extentTest.info("\"Dropping Point\" dropbox undan farklı yer seçilir");
        // 12-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));
        ReusableMethods.wait(2);
        extentTest.info("\"Date of Journey\" dropbox undan sonraki tarih seçilir");
        // 13-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        extentTest.info("\"Find Tickets\" butonu tıklanır");
        // 14- Select Seat butonu tıklanır
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
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        extentTest.info("Dropping Point doğru mu kontrol edilir");
        // 21-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        extentTest.info("Cinsiyet seçimi yapılır");



        // 24 - Koltuk seçimi yapılır
        ReusableMethods.seatSelectionMethod();
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(1);
        extentTest.info("Koltuk seçimi yapılır");


        // 26-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        extentTest.info("\"Continue\" butonu tıklanır");


        // 30-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        extentTest.info("\"Confirm\" butonu tıklanır");

        //32- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);
        extentTest.info("\"Pay Now\" butonu tıklanır");

        //28-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentReviewPayNowButton);
        ReusableMethods.wait(1);
        extentTest.info("\"Confirm\" butonu tıklanır");

        //32-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(1);
        extentTest.info("\"pay now\" butonu tıklanır");


        //9-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);
        extentTest.info("\"Name on Card\" textbox ına isim soyisim yazılır");

        //12-"Card Number" textbox ına 16 haneli geçerli kart numrası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        extentTest.info("\"Card Number\" textbox ına 16 haneli geçerli kart numrası girilir");


        //14 - "Expiration Date" textbox ına "MM/YYYY" formatında gecerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));
        extentTest.info("\"Expiration Date\" textbox ına \"MM/YYYY\" formatında gecerli tarih girilir");

        //16-"CVC Code" textbox ına 000 girilir
        selectSeatPage.cvcCode.sendKeys("000");
        extentTest.info("\"CVC Code\" textbox ına 000 girilir");


        //18-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        ReusableMethods.wait(2);
        extentTest.info("\"PAY NOW\" butonu tıklanır");
        Object expected = "Rejected";
        softAssert.assertEquals(selectSeatPage.status.getText(),expected,"Bug var");
        softAssert.assertAll();


        Driver.closeDriver();
        extentTest.info("Driver kapatılır");


    }
}
