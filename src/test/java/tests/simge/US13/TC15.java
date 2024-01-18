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

public class TC15 {
    @Test
    public void validCardNumberNegatifTestiKarakterHiclikBoslukHarf(){
        SoftAssert softAssert = new SoftAssert();

        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü görüntülenir ve tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();

        FindTicketsPage findTicketsPage = new FindTicketsPage();

        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();

        findTicketsPage.pickupPointSelection.click();
        Object selectedPickup = findTicketsPage.pickupPointSelection.getText();
        ReusableMethods.wait(2);
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        Object selectedDropping = findTicketsPage.droppingPointSelection.getText();
        ReusableMethods.wait(2);
        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourneySelection.click();
        Object selectedDate =findTicketsPage.dateOfJourneySelection.getText();
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
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);

        // 17-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();



        // 18 - Koltuk seçimi yapılır
        ReusableMethods.seatSelectionMethod();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(1);



        // 19-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);


        // 20-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();

        // 21- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);

        // 22-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentReviewPayNowButton);
        ReusableMethods.wait(1);

        // 23-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(1);

        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        // 24-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(1);

        // 25-"Card Number" textbox ına harf/karakter/bosluk/hiclik girilemediği dogrulanır
        selectSeatPage.validCardNumber.sendKeys("a");
        selectSeatPage.validCardNumber.sendKeys("*");
        selectSeatPage.validCardNumber.sendKeys(" ");
        selectSeatPage.validCardNumber.sendKeys("");

        ReusableMethods.wait(2);

        // 26 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));

        // 27-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));
        // 28-"PAY NOW" butonu tıklanır
        ReusableMethods.wait(1);
        selectSeatPage.paymentConfirmPayNowButton.click();
        String expectedURL="https://qa.easybusticket.com/user/ticket-booking/payment/confirm";
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedURL,"Bug var");
        ReusableMethods.wait(2);

        softAssert.assertAll();

        Driver.closeDriver();


    }
}
