package tests.simge.US13;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TC07 {
    @Test
    public void paymentDogrulamaTesti() {
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
        Object pickupSelection = findTicketsPage.pickupPointSelection.getText();

        ReusableMethods.wait(2);
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        Object dropSelection = findTicketsPage.droppingPointSelection.getText();

        ReusableMethods.wait(2);
        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));

        Object[] dateSelection = ConfigReader.getProperty("date").split("/");
        ReusableMethods.wait(2);
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // 14- Journey Date doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatJourneyDateBox.getAttribute("value"),ConfigReader.getProperty("date"),"Find Ticket Page'de secilen tarih ile Select Seat Page'ki journey date uyusmuyor");
        // 15- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(), pickupSelection,"Secilen pickup point uyusmuyor");
        // 16- Dropping Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatDropping.getText(), dropSelection,"Secilen dropping point uyusmuyor");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);

        // 17-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();

        // 18 - Koltuk seçimi yapılır
        //ReusableMethods.seatSelectionMethod();
        selectSeatPage.seats.get(5).click();
        selectSeatPage.seats.get(6).click();

        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.continueButton);
        ReusableMethods.wait(1);
        Object sbTtlPymnt = selectSeatPage.subTotal.get(selectSeatPage.subTotal.size() - 1).getText().replaceAll("\\D", "");


        // 19-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 20-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        // 21- Payment Methods sayfasında "Pay Now" butonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentMethodsPayNowButton.isDisplayed(),"Payment Methods pay now buton görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.paymentMethodsPayNowButton.isEnabled(),"Payment Methods pay now buton aktif değil");
        // 22- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);
        // 23-"Payment By Stripe Hosted" penceresi açıldığı doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentByStripeHostedTitle.isDisplayed(),"Payment by stripe hosted görüntülenmedi");
        // 24-Çıkan "Confirm Booking" penceresinde "Close" butonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentByStripeHostedClose.isDisplayed(),"Close buton görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.paymentByStripeHostedClose.isEnabled(),"Close buton aktif değil");
        // 25-Çıkan "Confirm Booking" penceresinde "Confirm" butonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentByStripeHostedConfirm.isDisplayed(),"Confirm buton görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.paymentByStripeHostedConfirm.isEnabled(),"Confirm buton aktif değil");
        // 26-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        // 27-Payment Preview sayfası açıldığı doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentPreviewTitle.isDisplayed(),"Payment Preview sayfası açılmadı");
        // 28-Amount tutarının Sub Total'e eşit olduğu doğrulanır
        Object ttl = selectSeatPage.tolalPayment.getText().replaceAll(".00", "");
        softAssert.assertEquals(sbTtlPymnt, ttl,"Sub total ile amount uyusmuyor");
        // 29-"pay now" butonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentReviewPayNowButton.isDisplayed(),"Payment preview pay now buton görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.paymentReviewPayNowButton.isEnabled(),"Payment preview pay now buton aktif değil");
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.paymentReviewPayNowButton);
        ReusableMethods.wait(1);
        // 30-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(1);
        // 31-Payment Confirm sayfası açıldığı doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentConfirmTitle.isDisplayed(),"Payment confirm sayfası açılmadı");
        // 32- "Name on Card" textbox ında placeholder olarak "Name on Card" yazısı görüntülenir
        softAssert.assertTrue(selectSeatPage.nameOnCard.isDisplayed(),"Name on card görüntülenmedi");

        // 33- "Name on Card" textbox ının aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.nameOnCard.isEnabled(),"Name on card aktif değil");

        // 34-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);
        // 35- "Card Number" textbox ında placeholder olarak "Valid Card Number" yazısı görüntülenir
        softAssert.assertTrue(selectSeatPage.validCardNumber.isDisplayed(),"Valid card number görüntülenmedi");

        // 36- "Card Number" textbox ının aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.validCardNumber.isEnabled(),"Valid card number aktif değil");
        // 37-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        // 38 - "Expiration Date" textbox ında place holder olarak "MM/YYYY" yazısı görüntülenir
        softAssert.assertTrue(selectSeatPage.expirationDate.isDisplayed(),"Expiration Date görüntülenmedi");
        // 39 - "Expiration Date" textbox ının aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.expirationDate.isEnabled(),"Expiration date aktif değil");
        // 40 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));
        // 41 - "CVC Code" textbox ında placeholder olarak "CVC" yazısı görüntülenir
        softAssert.assertTrue(selectSeatPage.cvcCode.isDisplayed(),"Cvc code görüntülenmedi");
        // 42 - "CVC Code" textbox ının aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.cvcCode.isEnabled(),"Cvc code aktif değil");
        // 43-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));

        // 44-"PAY NOW" butonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.paymentConfirmPayNowButton.isDisplayed(),"Payment confirm pay now buton görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.paymentConfirmPayNowButton.isEnabled(),"Payment confirm pay now buton aktif değil");
        // 45-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        // 46-"payment captured successfully" yazısı görüntülenir
        softAssert.assertTrue(selectSeatPage.successfulPayment.isDisplayed(),"Successful payment görüntülenmedi");
        // 47-Booking History sayfasının açıldığı doğrulanır
        softAssert.assertTrue(selectSeatPage.bookingHistoryTitle.isDisplayed(),"Booking History sayfası açılmadı");
        // 48-Booking History sayfasında pickup point kontrol edilir
        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();
        softAssert.assertEquals(bookingHistoryPage.pickupControl.getText(), pickupSelection,"Booking History pickup point uyusmuyor");
        // 49-Booking History sayfasında drop point kontrol edilir
        softAssert.assertEquals(bookingHistoryPage.dropControl.getText(), dropSelection,"Booking history drop point uyusmuyor");
        // 50-Booking History sayfasında journey date kontrol edilir
        Object date = bookingHistoryPage.dateControl.getText().substring(0, 2);

        softAssert.assertEquals(date, dateSelection[1],"Booking History date uyusmuyor");
        // 51-Booking History sayfasında alınan biletin status'u "Booked" olarak görüntülenir
        Object expected = "Booked";
        softAssert.assertEquals(selectSeatPage.status.getText(), expected,"Bug var");
        // 52-Booking Histosy sayfasında tutar kontrol edilir
        Object fare = bookingHistoryPage.subTotalControl.getText().replaceAll(".00 USD", "");
        softAssert.assertEquals(fare, sbTtlPymnt,"Booking history tutar uyusmuyor");
        // 53-Action kısmının altında bulunan yazıcı ikonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.yaziciIkonu.isDisplayed(),"Yazıcı ikonu görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.yaziciIkonu.isEnabled(),"Yazıcı ikonu aktif değil");
        // 54-Yazıcı ikonuna tıklanır
        selectSeatPage.yaziciIkonu.click();
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                // Şu anda açık olan pencerede e-bilet sayfasının olduğunu doğrula
                // Bu doğrulamayı, e-bilet sayfasının belirli bir locator'ı ile yapabilirsiniz
                softAssert.assertTrue(bookingHistoryPage.downloadTicket.isDisplayed(),"Download Ticket butonu görüntülenmedi");
                softAssert.assertTrue(bookingHistoryPage.downloadTicket.isEnabled(),"Download Ticket butonu aktif değil");
                // 57-Download Ticket tıklanır
                bookingHistoryPage.downloadTicket.click();
                ReusableMethods.wait(2);

                break;
            }


        }
        softAssert.assertAll();
        Driver.closeDriver();

    }





}
