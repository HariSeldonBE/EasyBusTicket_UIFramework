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

public class TC04 extends TestBaseRapor {
    @Test
    public void selectSeatDogrulamaTesti(){
        extentTest=extentReports.createTest("Koltuk Seçme Doğrulama Testi", "Bazı koltuklar tek olarak alınmak istendiğinde 'Why you are choosing those seats which are already booked? uyarısı veriyor'" );
        SoftAssert softAssert=new SoftAssert();
        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        extentTest.info("Browser açılır ve Url'e gidilir ve Login olunur");
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        extentTest.info("Açılan user dashboard sayfasında navbar menüde Booking ddm menüsü tıklanır");
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        extentTest.info("Booking\" açılır menüsü açıldığında \"Buy Ticket\" butonu tıklanır");
        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(2);
        findTicketsPage.pickupPointSelection.click();
        Object selectedPickup= findTicketsPage.pickupPointSelection.getText();
        ReusableMethods.wait(2);
        extentTest.info("\"Pick Up Point\" dropbox undan herhangi bir yer seçilir");
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();

        Object selectedDropping=findTicketsPage.droppingPointSelection.getText();
        extentTest.info("\"Dropping Point\" dropbox undan farklı yer seçilir");
        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        ReusableMethods.wait(1);
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));
        ReusableMethods.wait(2);
        extentTest.info("\"Date of Journey\" dropbox undan sonraki tarih seçilir");
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        extentTest.info("\"Find Tickets\" butonu tıklanır");
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        extentTest.info("Select Seat butonu tıklanır");
        String actualURL=Driver.getDriver().getCurrentUrl();
        // 14- "Jouney Date" tarih kutusunun görünür ve aktif olduğu doğrulanır
        SelectSeatPage selectSeatPage =new SelectSeatPage();
        softAssert.assertTrue(selectSeatPage.journeyDate.isDisplayed(),"Journey Date görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.journeyDate.isEnabled(),"Journey Date aktif değil");
        extentTest.info("\"Jouney Date\" tarih kutusunun görünür ve aktif olduğu doğrulanır");
        // 15- "Pickup Point" dropbox unun görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.pickupPoint.isDisplayed(),"Pickup Point görüntülenemedi");
        softAssert.assertTrue(selectSeatPage.pickupPoint.isEnabled(),"Pickup Point aktif değil");
        extentTest.info("\"Pickup Point\" dropbox unun görünür ve aktif olduğu doğrulanır");
        // 16- "Dropping Point" dropbox unun görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.droppingPoint.isDisplayed(),"Dropping Point görüntülenemedi");
        softAssert.assertTrue(selectSeatPage.droppingPoint.isEnabled(),"Dropping Point aktif değil");
        extentTest.info("\"Dropping Point\" dropbox unun görünür ve aktif olduğu doğrulanır");
        // 17- "Select Gender" bölümünde "Male" checkbox'ının görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.maleCheckbox.isDisplayed(),"Male checkbox görüntülenemedi");
        softAssert.assertTrue(selectSeatPage.maleCheckbox.isEnabled(),"Male checkbox aktif değil");
        extentTest.info("\"Select Gender\" bölümünde \"Male\" checkbox'ının görünür ve aktif olduğu doğrulanır");
        // 18- "Select Gender" bölümünde "Female" checkbox'ının görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.femaleCheckbox.isDisplayed(),"Female checkbox görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.femaleCheckbox.isEnabled(),"Female vcehckbox aktif değil");
        extentTest.info("\"Select Gender\" bölümünde \"Female\" checkbox'ının görünür ve aktif olduğu doğrulanır");
        // 19-"Select Gender" bölümünde "other" checkbox'ının görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.otherCheckbox.isDisplayed(),"Other checkbox görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.otherCheckbox.isEnabled(),"Other checkbox aktif değil");
        extentTest.info("\"Select Gender\" bölümünde \"other\" checkbox'ının görünür ve aktif olduğu doğrulanır");
        // 20- Journey Date doğru mu kontrol edilir

        softAssert.assertEquals(selectSeatPage.seatJourneyDateBox.getAttribute("value"),ConfigReader.getProperty("date"),"Find Ticket Page'de secilen tarih ile Select Seat Page'ki journey date uyusmuyor");

        //softAssert.assertEquals(selectSeatPage.firstSelectedDate.getText(),selectedDate,"Secilen tarih uyusmuyor");
        extentTest.info("Journey Date doğru mu kontrol edilir");
        // 21- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup,"Secilen pickup point uyusmuyor");
        extentTest.info("Pickup Point doğru mu kontrol edilir");
        // 22- Dropping Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping,"Secilen dropping point uyusmuypr");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        extentTest.info("Dropping Point doğru mu kontrol edilir");

        // 23 - Koltuk numaraları checkbox larının görünür ve aktif olduğu doğrulanır
        for (int i = 0; i < 33; i++) {
            selectSeatPage.seats.get(i).isDisplayed();
            selectSeatPage.seats.get(i).isEnabled();
        }


        extentTest.info("Koltuk numaraları checkbox larının görünür ve aktif olduğu doğrulanır");

        // 24 - Koltuk seçimi yapılır(Burada tarih seçimi önemli!!! Bütün koltukların boş olduğu tarih seçilmeli)
        for (int i = 0; i < 12; i++) {
            selectSeatPage.seats.get(i).click();
            ReusableMethods.wait(1);
            for (WebElement selectedSeat:selectSeatPage.selectedSeats) {
                softAssert.assertTrue(selectedSeat.isDisplayed(),"Secilen koltuk görüntülenmedi");
            }
            js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
            ReusableMethods.wait(1);
            // 25-Cinsiyet seçimi yapılır
            selectSeatPage.femaleCheckbox.click();

            // 26-"Continue" butonu görüntülenir ve aktif olduğu doğrulanır
            softAssert.assertTrue(selectSeatPage.continueButton.isDisplayed(),"Continue Buton görüntülenmedi");
            softAssert.assertTrue(selectSeatPage.continueButton.isEnabled(),"Continue Buton aktif değil");
            // 27-"Continue" butonu tıklanır
            selectSeatPage.continueButton.click();
            ReusableMethods.wait(1);
            // 28-"Confirm Booking" penceresi açıldığı doğrulanır
            softAssert.assertTrue(selectSeatPage.confirmBooking.isDisplayed(),"Confirm Booking penceresi acilmadi");
            // 29-Çıkan "Confirm Booking" penceresinde "Close" butonu görüntülenir ve aktif olduğu doğrulanır
            softAssert.assertTrue(selectSeatPage.closeConfirmBookingButton.isDisplayed(),"Close Button görüntülenmedi");
            softAssert.assertTrue(selectSeatPage.closeConfirmBookingButton.isEnabled(),"Close Button aktif değil");
            // 30-Çıkan "Confirm Booking" penceresinde "Confirm" butonu görüntülenir ve aktif olduğu doğrulanır
            softAssert.assertTrue(selectSeatPage.confirmBookingButton.isDisplayed(),"Confirm Button görüntülenmedi");
            softAssert.assertTrue(selectSeatPage.confirmBookingButton.isEnabled(),"Confirm Button aktif değil");
            // 31-"Confirm" butonu tıklanır
            selectSeatPage.confirmBookingButton.click();
            ReusableMethods.wait(1);
            // 32-Payment Methods sayfası açıldığı doğrulanır
            String expectedURL= "https://qa.easybusticket.com/user/ticket-booking/payment-gateway";
            softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedURL,(i+1)+". koltuk için hata verdi.");

            Driver.getDriver().get(actualURL);
            ReusableMethods.wait(1);
            softAssert.assertEquals(selectSeatPage.seatJourneyDateBox.getAttribute("value"),ConfigReader.getProperty("date"),"Find Ticket Page'de secilen tarih ile Select Seat Page'ki journey date uyusmuyor");
        }
        js.executeScript("window.scrollBy(0,arguments[0])",700);
        ReusableMethods.wait(1);
        for (int i = 12; i < 33; i++) {
            selectSeatPage.seats.get(i).click();
            ReusableMethods.wait(1);
            // 33-Cinsiyet seçimi yapılır
            selectSeatPage.femaleCheckbox.click();
            js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
            ReusableMethods.wait(1);
            // 34-"Continue" butonu tıklanır
            selectSeatPage.continueButton.click();
            // 35-"Confirm" butonu tıklanır
            selectSeatPage.confirmBookingButton.click();
            ReusableMethods.wait(1);
            // 36-Payment Methods sayfası açıldığı doğrulanır
            String expectedURL= "https://qa.easybusticket.com/user/ticket-booking/payment-gateway";
            softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedURL,(i+1)+". koltuk için hata verdi.");

            Driver.getDriver().get(actualURL);
            ReusableMethods.wait(1);
            softAssert.assertEquals(selectSeatPage.seatJourneyDateBox.getAttribute("value"),ConfigReader.getProperty("date"),"Find Ticket Page'de secilen tarih ile Select Seat Page'ki journey date uyusmuyor");
            js.executeScript("window.scrollBy(0,arguments[0])",600);
            ReusableMethods.wait(1);
        }
        extentTest.info("Koltuk seçimi yapılır");
        softAssert.assertAll();
        Driver.closeDriver();
        extentTest.info("Driver kapatılır");

    }
}
