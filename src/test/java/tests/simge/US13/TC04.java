package tests.simge.US13;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
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

        // 1-Browser açılır ve Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2-Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3-SignIn butonuna tıklanır
        easyBusTicketPage.signInButton.click();
        ReusableMethods.wait(2);
        // 4-Geçerli Username girilir
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        // 5-Geçerli Password girilir
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        // 6-Log In butonuna tıklanır
        userLoginPage.loginButton.click();
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
        // 23-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();

        // 24 - Koltuk numaraları checkbox larının görünür ve aktif olduğu doğrulanır
        for (int i = 1; i < 34; i++) {
            selectSeatPage.seats.get(i).isDisplayed();
            selectSeatPage.seats.get(i).isEnabled();
        }

        // 25 - Koltuk seçimi yapılır
            selectSeatPage.seats.get(1).click();

        // 26 - Seçilen koltukların seçili olarak görüntülendiği doğrulanır
        for (WebElement selectedSeat:selectSeatPage.selectedSeats) {
            Assert.assertTrue(selectedSeat.isDisplayed());
        }
          JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
          js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);


        // 27-"Continue" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.continueButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.continueButton.isEnabled());
        // 28-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 29-"Confirm Booking" penceresi açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.confirmBooking.isDisplayed());
        // 30-Çıkan "Confirm Booking" penceresinde "Close" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.closeConfirmBookingButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.closeConfirmBookingButton.isEnabled());
        // 31-Çıkan "Confirm Booking" penceresinde "Confirm" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.confirmBookingButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.confirmBookingButton.isEnabled());
        // 32-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        // 33-Payment Methods sayfası açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.paymentMethodsTitle.isDisplayed());
        ReusableMethods.wait(2);


        Driver.closeDriver();





    }
}
