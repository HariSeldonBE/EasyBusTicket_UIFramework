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

public class TC05 {
    @Test
    public void selectSeatNegatifTesti(){
        SoftAssert softAssert = new SoftAssert();
        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü görüntülenir ve tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        FindTicketsPage findTicketsPage=new FindTicketsPage();
        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(2);
        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(2);
        Object selectedPickup= findTicketsPage.pickupPointSelection.getText();
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
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // 14- Journey Date doğru mu kontrol edilir
        selectSeatPage.seatJourneyDateBox.click();
        softAssert.assertEquals(selectSeatPage.firstSelectedDate.getText(),selectedDate,"Secilen tarih uyusmuyor");
        // 15- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup,"Secilen pickup point uyusmuyor");
        // 16- Dropping Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping,"Secilen dropping point uyusmuyor");


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.wait(2);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);

        // 17-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 18-"Select at least one seat" hatası verir
        softAssert.assertTrue(selectSeatPage.seatSelectionError.isDisplayed(),"Error görüntülenmedi");
        // 19-Koltuk seçimi yapılır
        ReusableMethods.seatSelectionMethod();
        // 20-"Continue" butonu tıklanır
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 21-Açılan Confirm Booking penceresinde "Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        ReusableMethods.wait(2);

        // 22-"The gender field is required" hatası verir
        softAssert.assertTrue(selectSeatPage.genderSelectError.isDisplayed(),"Error görüntülenmedi");
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(2);
        // 23-Journey Date doğru mu kontrol edilir

        selectSeatPage.seatJourneyDateBox.click();
        Object secondDate=selectSeatPage.secondSelectedDate.getText();
        softAssert.assertEquals(secondDate,selectedDate,"Secilen tarih uyusmuyor");
        // 24- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup,"Secilen pickup point uyusmuyor");
        // 25- Dropping Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping,"Secilen dropping point uyusmuyor");
        // 26-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        ReusableMethods.wait(2);
        // 27-Koltuk seçimi yapılır
        selectSeatPage.seats.get(30).click();
        ReusableMethods.wait(2);
        // 28-"Continue" butonu tıklanır
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 29-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        // 30-Payment Methods sayfası açıldığı doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentMethodsTitle.isDisplayed(),"Payment Methods açılmadı");
        ReusableMethods.wait(2);
        softAssert.assertAll();

        Driver.closeDriver();





    }
}
