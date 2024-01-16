package tests.simge.US13;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;


public class TC25 {
    @Test
    public void aktarmalidaPaymentDogrulamaTesti(){

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
        String findTicketHandle = Driver.getDriver().getWindowHandle();
        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        findTicketsPage.pickupPointSelectionaktarma.click();
        Object pickupSelection = findTicketsPage.pickupPointSelectionaktarma.getText();


        ReusableMethods.wait(2);
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelectionaktarma.click();
        Object dropSelection = findTicketsPage.droppingPointSelectionaktarma.getText();

        ReusableMethods.wait(2);
        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourneySelection.click();
        Object dateSelection = findTicketsPage.dateOfJourneySelection.getText();

        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.wait(2);
        Object aktarma12=selectSeatPage.aktarmali2.getText();
        Object aktarma13=selectSeatPage.aktarmali4.getText();
        // 13- Select Seat ilk buton tıklanır

        js.executeScript("arguments[0].scrollIntoView()",findTicketsPage.selectSeatButton);
        ReusableMethods.wait(2);
        Actions actions = new Actions(Driver.getDriver());
        String openLinkInNewTab=Keys.chord(Keys.CONTROL,Keys.RETURN);
        findTicketsPage.selectSeatButton.sendKeys(openLinkInNewTab);
        ReusableMethods.wait(2);
        ReusableMethods.switchToNewTab();

        ReusableMethods.wait(2);

        // 14- Journey Date doğru mu kontrol edilir
        selectSeatPage.seatJourneyDateBox.click();
        Assert.assertEquals(selectSeatPage.firstSelectedDate.getText(),dateSelection);
        // 15- Pickup Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatPickup.getText(),pickupSelection);
        // 16- Dropping Point doğru mu kontrol edilir

        Assert.assertEquals(selectSeatPage.seatDropping.getText(),aktarma12);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(2);
        // 17-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        // 18 - Koltuk seçimi yapılır
        selectSeatPage.seats.get(22).click();

        ReusableMethods.wait(2);

        Object sbTtlPymnt = selectSeatPage.subTotal.get(selectSeatPage.subTotal.size()-1).getText().replaceAll("\\D","");


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

        // 23-Amount tutarının Sub Total'e eşit olduğu doğrulanır
        Object ttl = selectSeatPage.tolalPayment.getText().replaceAll(".00","");
        Assert.assertEquals(sbTtlPymnt,ttl);
        // 24-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();


        // 25-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);
        // 26-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(2);

        // 27 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));

        // 28-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));

        // 29-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        // 30-"payment captured successfully" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.successfulPayment.isDisplayed());
        // 31-Booking History sayfasında pickup point kontrol edilir
        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();
        Assert.assertEquals(bookingHistoryPage.pickupControl.getText(),pickupSelection);
        // 32-Booking History sayfasında drop point kontrol edilir
        Assert.assertEquals(bookingHistoryPage.dropControl.getText(),aktarma12);
        // 32-Booking History sayfasında journey date kontrol edilir
        Object date = bookingHistoryPage.dateControl.getText().substring(0,2);
        Assert.assertEquals(date,dateSelection);
        // 33-Booking History sayfasında alınan biletin status'u "Booked" olarak görüntülenir
        Object expected = "Booked";
        Assert.assertEquals(selectSeatPage.status.getText(),expected);
        // 34-Booking History sayfasında tutar kontrol edilir
        Object fare = bookingHistoryPage.subTotalControl.getText().replaceAll(".00 USD","");
        Assert.assertEquals(fare,sbTtlPymnt);
        // 35-Yazıcı ikonuna tıklanır
        selectSeatPage.yaziciIkonu.click();
        // 36-Find Ticket sayfasına geri dönülür
        Driver.getDriver().switchTo().window(findTicketHandle);
        // 37-İkinci select seat button tıklanır
        findTicketsPage.selectSeatButton2.sendKeys(openLinkInNewTab);
        ReusableMethods.wait(2);
        ReusableMethods.switchToNewTab();
        // 38- Journey Date doğru mu kontrol edilir
        selectSeatPage.seatJourneyDateBox.click();
        Assert.assertEquals(selectSeatPage.firstSelectedDate.getText(),dateSelection);
        // 39- Pickup Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatPickup.getText(),aktarma12);
        // 40- Dropping Point doğru mu kontrol edilir

        Assert.assertEquals(selectSeatPage.seatDropping.getText(),aktarma13);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(2);
        // 41-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        // 42 - Koltuk seçimi yapılır
        selectSeatPage.seats.get(21).click();

        ReusableMethods.wait(2);
        // 43-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 44-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        // 45- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);

        // 46-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        // 47-Amount tutarının Sub Total'e eşit olduğu doğrulanır
        Assert.assertEquals(sbTtlPymnt,ttl);
        // 48-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();


        // 49-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);
        // 50-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(2);

        // 51 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));

        // 52-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));

        // 53-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        // 54-"payment captured successfully" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.successfulPayment.isDisplayed());
        // 55-Booking History sayfasında pickup point kontrol edilir
        Assert.assertEquals(bookingHistoryPage.pickupControl.getText(),pickupSelection);
        // 56-Booking History sayfasında drop point kontrol edilir
        Assert.assertEquals(bookingHistoryPage.dropControl.getText(),aktarma12);
        // 57-Booking History sayfasında journey date kontrol edilir
        Assert.assertEquals(date,dateSelection);
        // 58-Booking History sayfasında alınan biletin status'u "Booked" olarak görüntülenir
        Object Expected = "Booked";
        Assert.assertEquals(selectSeatPage.status.getText(),Expected);
        // 59-Booking Histosy sayfasında tutar kontrol edilir
        Assert.assertEquals(fare,sbTtlPymnt);
        // 60-Yazıcı ikonuna tıklanır
        selectSeatPage.yaziciIkonu.click();
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                // Bu doğrulamayı, e-bilet sayfasının belirli bir locator'ı ile yapabilirsiniz
                Assert.assertTrue(bookingHistoryPage.downloadTicket.isDisplayed());
                Assert.assertTrue(bookingHistoryPage.downloadTicket.isEnabled());
                // 57-Download Ticket tıklanır
                bookingHistoryPage.downloadTicket.click();

                break;
            }

        }

        String pdfFilePath = "file:///C:/Users/ATALAY/Downloads/testerteam2_1704836836.pdf";
        boolean isPrintable = ReusableMethods.isPdfPrintable(pdfFilePath);
        System.out.println("PDF yazdırılabilir:"+isPrintable);
        Driver.closeDriver();



        Driver.closeDriver();


    }
}
