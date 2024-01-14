package tests.simge.US13;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class TC07 {
    @Test
    public void paymentDogrulamaTesti(){

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
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü görüntülenir ve tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        FindTicketsPage findTicketsPage=new FindTicketsPage();
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
        Object dateSelection = findTicketsPage.dateOfJourneySelection.getText();
        ReusableMethods.wait(2);
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // 14-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        // 15 - Koltuk seçimi yapılır
        selectSeatPage.seats.get(4).click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.wait(2);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(2);
        Object sbTtlPymnt = selectSeatPage.subTotal.get(selectSeatPage.subTotal.size()-1).getText().replaceAll("\\D","");


        // 16-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 17-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        // 18- Payment Methods sayfasında "Pay Now" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentMethodsPayNowButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentMethodsPayNowButton.isEnabled());
        // 19- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);
        // 20-"Payment By Stripe Hosted" penceresi açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedTitle.isDisplayed());
        // 21-Çıkan "Confirm Booking" penceresinde "Close" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedClose.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedClose.isEnabled());
        // 22-Çıkan "Confirm Booking" penceresinde "Confirm" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedConfirm.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentByStripeHostedConfirm.isEnabled());
        // 23-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        // 24-Payment Preview sayfası açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.paymentPreviewTitle.isDisplayed());
        // 25-Amount tutarının Sub Total'e eşit olduğu doğrulanır
        Object ttl = selectSeatPage.tolalPayment.getText().replaceAll(".00","");
        Assert.assertEquals(sbTtlPymnt,ttl);
        // 26-"pay now" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentReviewPayNowButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentReviewPayNowButton.isEnabled());
        // 27-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        // 28-Payment Confirm sayfası açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.paymentConfirmTitle.isDisplayed());
        // 29- "Name on Card" textbox ında placeholder olarak "Name on Card" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.nameOnCard.isDisplayed());

        // 30- "Name on Card" textbox ının aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.nameOnCard.isEnabled());

        // 31-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);
        // 32- "Card Number" textbox ında placeholder olarak "Valid Card Number" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.validCardNumber.isDisplayed());

        // 33- "Card Number" textbox ının aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.validCardNumber.isEnabled());
        // 34-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(2);

        // 35 - "Expiration Date" textbox ında place holder olarak "MM/YYYY" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.expirationDate.isDisplayed());
        // 36 - "Expiration Date" textbox ının aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.expirationDate.isEnabled());
        // 37 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));
        // 38 - "CVC Code" textbox ında placeholder olarak "CVC" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.cvcCode.isDisplayed());
        // 39 - "CVC Code" textbox ının aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.cvcCode.isEnabled());
        // 40-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));

        // 41-"PAY NOW" butonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.paymentConfirmPayNowButton.isDisplayed());
        Assert.assertTrue(selectSeatPage.paymentConfirmPayNowButton.isEnabled());
        // 42-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        // 43-"payment captured successfully" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.successfulPayment.isDisplayed());
        // 44-Booking History sayfasının açıldığı doğrulanır
        Assert.assertTrue(selectSeatPage.bookingHistoryTitle.isDisplayed());
        // 45-Booking Histosy sayfasında pickup point kontrol edilir
        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();
        Assert.assertEquals(bookingHistoryPage.pickupControl.getText(),pickupSelection);
        // 46-Booking Histosy sayfasında drop point kontrol edilir
        Assert.assertEquals(bookingHistoryPage.dropControl.getText(),dropSelection);
        // 47-Booking Histosy sayfasında journey date kontrol edilir
        Object date = bookingHistoryPage.dateControl.getText().substring(0,2);
        Assert.assertEquals(date,dateSelection);
        // 48-Booking History sayfasında alınan biletin status'u "Booked" olarak görüntülenir
        Object expected = "Booked";
        Assert.assertEquals(selectSeatPage.status.getText(),expected);
        // 49-Booking Histosy sayfasında tutar kontrol edilir
        Object fare = bookingHistoryPage.subTotalControl.getText().replaceAll(".00 USD","");
        Assert.assertEquals(fare,sbTtlPymnt);

        // 50-Action kısmının altında bulunan yazıcı ikonu görüntülenir ve aktif olduğu doğrulanır
        Assert.assertTrue(selectSeatPage.yaziciIkonu.isDisplayed());
        Assert.assertTrue(selectSeatPage.yaziciIkonu.isEnabled());
        // 51-Yazıcı ikonuna tıklanır
        selectSeatPage.yaziciIkonu.click();


        Driver.closeDriver();


    }
}
