package tests.simge.US13;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        findTicketsPage.dateOfJourneySelection.click();
        Object selectedDate = findTicketsPage.dateOfJourneySelection.getText();
        Object dateSelection = findTicketsPage.dateOfJourneySelection.getText();
        ReusableMethods.wait(2);
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // 14- Journey Date doğru mu kontrol edilir
        selectSeatPage.seatJourneyDateBox.click();
        Assert.assertEquals(selectSeatPage.firstSelectedDate.getText(), selectedDate);
        // 15- Pickup Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatPickup.getText(), pickupSelection);
        // 16- Dropping Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatDropping.getText(), dropSelection);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);

        // 17-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();

        // 18 - Koltuk seçimi yapılır
        ReusableMethods.seatSelectionMethod();
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
        Assert.assertTrue(selectSeatPage.paymentMethodsPayNowButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentMethodsPayNowButton.isEnabled());
        // 22- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);
        // 23-"Payment By Stripe Hosted" penceresi açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedTitle.isDisplayed());
        // 24-Çıkan "Confirm Booking" penceresinde "Close" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedClose.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedClose.isEnabled());
        // 25-Çıkan "Confirm Booking" penceresinde "Confirm" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedConfirm.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedConfirm.isEnabled());
        // 26-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        // 27-Payment Preview sayfası açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.paymentPreviewTitle.isDisplayed());
        // 28-Amount tutarının Sub Total'e eşit olduğu doğrulanır
        Object ttl = selectSeatPage.tolalPayment.getText().replaceAll(".00", "");
        Assert.assertEquals(sbTtlPymnt, ttl);
        // 29-"pay now" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentReviewPayNowButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentReviewPayNowButton.isEnabled());
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.paymentReviewPayNowButton);
        ReusableMethods.wait(1);
        // 30-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(1);
        // 31-Payment Confirm sayfası açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.paymentConfirmTitle.isDisplayed());
        // 32- "Name on Card" textbox ında placeholder olarak "Name on Card" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.nameOnCard.isDisplayed());

        // 33- "Name on Card" textbox ının aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.nameOnCard.isEnabled());

        // 34-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);
        // 35- "Card Number" textbox ında placeholder olarak "Valid Card Number" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.validCardNumber.isDisplayed());

        // 36- "Card Number" textbox ının aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.validCardNumber.isEnabled());
        // 37-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        // 38 - "Expiration Date" textbox ında place holder olarak "MM/YYYY" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.expirationDate.isDisplayed());
        // 39 - "Expiration Date" textbox ının aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.expirationDate.isEnabled());
        // 40 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));
        // 41 - "CVC Code" textbox ında placeholder olarak "CVC" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.cvcCode.isDisplayed());
        // 42 - "CVC Code" textbox ının aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.cvcCode.isEnabled());
        // 43-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));

        // 44-"PAY NOW" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentConfirmPayNowButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentConfirmPayNowButton.isEnabled());
        // 45-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        // 46-"payment captured successfully" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.successfulPayment.isDisplayed());
        // 47-Booking History sayfasının açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.bookingHistoryTitle.isDisplayed());
        // 48-Booking History sayfasında pickup point kontrol edilir
        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();
        Assert.assertEquals(bookingHistoryPage.pickupControl.getText(), pickupSelection);
        // 49-Booking History sayfasında drop point kontrol edilir
        Assert.assertEquals(bookingHistoryPage.dropControl.getText(), dropSelection);
        // 50-Booking History sayfasında journey date kontrol edilir
        Object date = bookingHistoryPage.dateControl.getText().substring(0, 2);
        Assert.assertEquals(date, dateSelection);
        // 51-Booking History sayfasında alınan biletin status'u "Booked" olarak görüntülenir
        Object expected = "Booked";
        Assert.assertEquals(selectSeatPage.status.getText(), expected);
        // 52-Booking Histosy sayfasında tutar kontrol edilir
        Object fare = bookingHistoryPage.subTotalControl.getText().replaceAll(".00 USD", "");
        Assert.assertEquals(fare, sbTtlPymnt);
        // 53-Action kısmının altında bulunan yazıcı ikonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.yaziciIkonu.isDisplayed());
        Assert.assertTrue(selectSeatPage.yaziciIkonu.isEnabled());
        // 54-Yazıcı ikonuna tıklanır
        selectSeatPage.yaziciIkonu.click();
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                // Şu anda açık olan pencerede e-bilet sayfasının olduğunu doğrula
                // Bu doğrulamayı, e-bilet sayfasının belirli bir locator'ı ile yapabilirsiniz
                Assert.assertTrue(bookingHistoryPage.downloadTicket.isDisplayed());
                Assert.assertTrue(bookingHistoryPage.downloadTicket.isEnabled());
                // 57-Download Ticket tıklanır
                bookingHistoryPage.downloadTicket.click();
                ReusableMethods.wait(2);

                break;
            }


        }

        Driver.closeDriver();

    }





}
