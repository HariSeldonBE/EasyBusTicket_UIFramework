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

public class TC04 {
    @Test
    public void selectSeatDogrulamaTesti(){
        SoftAssert softAssert=new SoftAssert();
        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(2);
        findTicketsPage.pickupPointSelection.click();
        Object selectedPickup= findTicketsPage.pickupPointSelection.getText();
        ReusableMethods.wait(2);
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        Object selectedDropping=findTicketsPage.droppingPointSelection.getText();
        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourneySelection.click();
        Object selectedDate = findTicketsPage.dateOfJourneySelection.getText();
        ReusableMethods.wait(2);
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        // 14- "Jouney Date" tarih kutusunun görünür ve aktif olduğu doğrulanır
        SelectSeatPage selectSeatPage =new SelectSeatPage();
        Assert.assertTrue(selectSeatPage.journeyDate.isDisplayed());
        Assert.assertTrue(selectSeatPage.journeyDate.isEnabled());
        // 15- "Pickup Point" dropbox unun görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.pickupPoint.isDisplayed());
        Assert.assertTrue(selectSeatPage.pickupPoint.isEnabled());
        // 16- "Dropping Point" dropbox unun görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.droppingPoint.isDisplayed());
        Assert.assertTrue(selectSeatPage.droppingPoint.isEnabled());
        // 17- "Select Gender" bölümünde "Male" checkbox'ının görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.maleCheckbox.isDisplayed());
        Assert.assertTrue(selectSeatPage.maleCheckbox.isEnabled());
        // 18- "Select Gender" bölümünde "Female" checkbox'ının görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.femaleCheckbox.isDisplayed());
        Assert.assertTrue(selectSeatPage.femaleCheckbox.isEnabled());
        // 19-"Select Gender" bölümünde "other" checkbox'ının görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.otherCheckbox.isDisplayed());
        Assert.assertTrue(selectSeatPage.otherCheckbox.isEnabled());
        // 20- Journey Date doğru mu kontrol edilir
        selectSeatPage.seatJourneyDateBox.click();
        Assert.assertEquals(selectSeatPage.firstSelectedDate.getText(),selectedDate);
        // 21- Pickup Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup);
        // 22- Dropping Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);

        // 23 - Koltuk numaraları checkbox larının görünür ve aktif olduğu doğrulanır
        for (int i = 1; i < 33; i++) {
            selectSeatPage.seats.get(i).isDisplayed();
            selectSeatPage.seats.get(i).isEnabled();
        }




        // 24 - Koltuk seçimi yapılır(Burada tarih seçimi önemli!!! Bütün koltukların boş olduğu tarih seçilmeli)
        for (int i = 0; i < 15; i++) {
            selectSeatPage.seats.get(i).click();
            ReusableMethods.wait(1);
            for (WebElement selectedSeat:selectSeatPage.selectedSeats) {
                Assert.assertTrue(selectedSeat.isDisplayed());
            }
            // 25-Cinsiyet seçimi yapılır
            selectSeatPage.femaleCheckbox.click();
            js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
            ReusableMethods.wait(1);
            // 26-"Continue" butonu görüntülenir ve aktif olduğu doğrulanır
            Assert.assertTrue(selectSeatPage.continueButton.isDisplayed());
            Assert.assertTrue(selectSeatPage.continueButton.isEnabled());
            // 27-"Continue" butonu tıklanır
            selectSeatPage.continueButton.click();
            ReusableMethods.wait(1);
            // 28-"Confirm Booking" penceresi açıldığı doğrulanır
            Assert.assertTrue(selectSeatPage.confirmBooking.isDisplayed());
            // 29-Çıkan "Confirm Booking" penceresinde "Close" butonu görüntülenir ve aktif olduğu doğrulanır
            Assert.assertTrue(selectSeatPage.closeConfirmBookingButton.isDisplayed());
            Assert.assertTrue(selectSeatPage.closeConfirmBookingButton.isEnabled());
            // 30-Çıkan "Confirm Booking" penceresinde "Confirm" butonu görüntülenir ve aktif olduğu doğrulanır
            Assert.assertTrue(selectSeatPage.confirmBookingButton.isDisplayed());
            Assert.assertTrue(selectSeatPage.confirmBookingButton.isEnabled());
            // 31-"Confirm" butonu tıklanır
            selectSeatPage.confirmBookingButton.click();
            ReusableMethods.wait(1);
            // 32-Payment Methods sayfası açıldığı doğrulanır
            String expectedURL= "https://qa.easybusticket.com/user/ticket-booking/payment-gateway";
            softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedURL,i+". koltuk için hata verdi.");

            Driver.getDriver().get("https://qa.easybusticket.com/ticket/22/lux-bus-austin-dallas");
            ReusableMethods.wait(1);
        }
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        for (int i = 15; i < selectSeatPage.seats.size(); i++) {
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
            softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedURL,i+". koltuk için hata verdi.");

            Driver.getDriver().get("https://qa.easybusticket.com/ticket/22/lux-bus-austin-dallas");
            js.executeScript("window.scrollBy(0,arguments[0])",500);
            ReusableMethods.wait(1);
        }
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
