package tests.simge.US13;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;


public class TC25 {
    @Test
    public void aktarmalidaPaymentDogrulamaTesti(){
        SoftAssert softAssert = new SoftAssert();

        // 1-Login yapılır
        ReusableMethods.userLoginButton();
        // 2-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü görüntülenir ve tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 3-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        FindTicketsPage findTicketsPage=new FindTicketsPage();

        String findTicketHandle = Driver.getDriver().getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // 4-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        findTicketsPage.pickupPointSelectionaktarma.click();
        Object pickupSelection = findTicketsPage.pickupPointSelectionaktarma.getText();


        ReusableMethods.wait(2);
        // 5-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelectionaktarma.click();
        Object dropSelection = findTicketsPage.droppingPointSelectionaktarma.getText();

        ReusableMethods.wait(2);
        // 6-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourneySelection.click();
        Object dateSelection = findTicketsPage.dateOfJourneySelection.getText();

        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // 7-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();

        ReusableMethods.wait(2);
        Object aktarma12=selectSeatPage.aktarmali2.getText();
        Object aktarma13=selectSeatPage.aktarmali4.getText();
        String findTicketWindowHandle = Driver.getDriver().getWindowHandle();
        // 8- Select Seat ilk buton tıklanır

        js.executeScript("arguments[0].scrollIntoView()",findTicketsPage.selectSeatButton);
        ReusableMethods.wait(2);
        Actions actions = new Actions(Driver.getDriver());
        String openLinkInNewTab=Keys.chord(Keys.CONTROL,Keys.RETURN);
        findTicketsPage.selectSeatButton.sendKeys(openLinkInNewTab);
        ReusableMethods.wait(2);
        ReusableMethods.switchToNewTab();

        ReusableMethods.wait(2);

        // 9- Journey Date doğru mu kontrol edilir
        selectSeatPage.seatJourneyDateBox.click();
        Object selectedDate=selectSeatPage.firstSelectedDate.getText();
        softAssert.assertEquals(selectedDate,dateSelection,"Secilen tarih uyusmuyor");
        // 9- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(),pickupSelection,"Secilen pickup point uyusmuyor");
        // 10- Dropping Point doğru mu kontrol edilir

        softAssert.assertEquals(selectSeatPage.seatDropping.getText(),aktarma12,"Secilen dropping point uyusmuyor");

        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        // 11-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        // 12 - Koltuk seçimi yapılır
         ReusableMethods.seatSelectionMethod();
         //selectSeatPage.seats.get(1).click();
         ReusableMethods.wait(1);
        // selectSeatPage.seats.get(2).click();
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(1);

        Object sbTtlPymnt = selectSeatPage.subTotal.get(selectSeatPage.subTotal.size()-1).getText().replaceAll("\\D","");


        // 13-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 14-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        ReusableMethods.wait(1);

        // 15- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(1);

        // 16-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();

        // 17-Amount tutarının Sub Total'e eşit olduğu doğrulanır
        Object ttl = selectSeatPage.tolalPayment.getText().replaceAll(".00","");
        softAssert.assertEquals(sbTtlPymnt,ttl,"Sub Total ve amount uyusmuyor");
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentReviewPayNowButton);
        ReusableMethods.wait(1);
        // 18-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(1);

        // 19-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);
        // 20-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));


        // 21 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));

        // 22-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));

        // 23-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        // 24-"payment captured successfully" yazısı görüntülenir
        softAssert.assertTrue(selectSeatPage.successfulPayment.isDisplayed(),"Successful payment uyarısı görüntülenmedi");
        // 25-Booking History sayfasında pickup point kontrol edilir
        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();
        softAssert.assertEquals(bookingHistoryPage.pickupControl.getText(),pickupSelection,"Booking History pickup uyusmuyor");
        // 26-Booking History sayfasında drop point kontrol edilir
        softAssert.assertEquals(bookingHistoryPage.dropControl.getText(),aktarma12,"Booking History drop uyusmuyor");
        // 27-Booking History sayfasında journey date kontrol edilir
        Object date = bookingHistoryPage.dateControl.getText().substring(0,2);
        softAssert.assertEquals(date,dateSelection,"Booking History date uyusmuyor");
        // 28-Booking History sayfasında alınan biletin status'u "Booked" olarak görüntülenir
        Object expected = "Booked";
        softAssert.assertEquals(selectSeatPage.status.getText(),expected,"Bug var");
        // 29-Booking History sayfasında tutar kontrol edilir
        Object fare = bookingHistoryPage.subTotalControl.getText().replaceAll(".00 USD","");
        softAssert.assertEquals(fare,sbTtlPymnt,"Booking History tutar uyusmuyor");
        String bookingWindowHandle = Driver.getDriver().getWindowHandle();
        // 30-Yazıcı ikonuna tıklanır
        selectSeatPage.yaziciIkonu.click();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        String yaziciWindowHandle="";
        for (String handle : allWindowHandles) {
            if (!handle.equals(bookingWindowHandle)&&!handle.equals(findTicketWindowHandle)) {

                Driver.getDriver().switchTo().window(handle);
                yaziciWindowHandle=handle;
                // Bu doğrulamayı, e-bilet sayfasının belirli bir locator'ı ile yapabilirsiniz
                softAssert.assertTrue(bookingHistoryPage.downloadTicket.isDisplayed(),"Download Ticket butonu görüntülenmedi");
                softAssert.assertTrue(bookingHistoryPage.downloadTicket.isEnabled(),"Download Ticket butonu aktif değil");
                // 57-Download Ticket tıklanır
                bookingHistoryPage.downloadTicket.click();
                ReusableMethods.wait(2);

            }

        }

        // 31-Find Ticket sayfasına geri dönülür
        ReusableMethods.wait(1);
        Driver.getDriver().switchTo().window(findTicketHandle);
        ReusableMethods.wait(1);
        // 32-İkinci select seat button tıklanır
        findTicketsPage.selectSeatButton2.sendKeys(openLinkInNewTab);
        ReusableMethods.wait(1);
        ReusableMethods.switchToNewTab();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        // 33- Journey Date doğru mu kontrol edilir

        selectSeatPage.seatJourneyDateBox.click();
        ReusableMethods.wait(2);
        Object selectedDate2 = selectSeatPage.secondSelectedDate.getText();
        softAssert.assertEquals(selectedDate2,dateSelection,"Journey Date'ler uyuşmuyor.");
        // 34- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(),aktarma12,"Pickup point uyusmuyor");
        // 35- Dropping Point doğru mu kontrol edilir

        softAssert.assertEquals(selectSeatPage.seatDropping.getText(),aktarma13,"Dropping point uyusmuyor");

        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        // 36-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        // 37 - Koltuk seçimi yapılır
        ReusableMethods.seatSelectionMethod();

        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        ReusableMethods.wait(1);
        // 38-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);
        // 39-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentMethodsPayNowButton);
        ReusableMethods.wait(1);
        // 40- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);

        // 41-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        // 42-Amount tutarının Sub Total'e eşit olduğu doğrulanır
        softAssert.assertEquals(sbTtlPymnt,ttl,"Sub Total ve amount uyusmuyor");
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentReviewPayNowButton);
        ReusableMethods.wait(1);
        // 43-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        ReusableMethods.wait(2);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(1);

        // 44-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);
        // 45-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));

        // 46 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));

        // 47-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));

        // 48-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        // 49-"payment captured successfully" yazısı görüntülenir
        softAssert.assertTrue(selectSeatPage.successfulPayment.isDisplayed(),"Successful payment uyarısı görüntülenmedi");
        // 50-Booking History sayfasında pickup point kontrol edilir
        softAssert.assertEquals(bookingHistoryPage.pickupControl.getText(),pickupSelection,"Booking history pickup point uyusmuyor");
        // 51-Booking History sayfasında drop point kontrol edilir
        softAssert.assertEquals(bookingHistoryPage.dropControl.getText(),aktarma12,"Booking History drop point ıuyusmuyor");
        // 52-Booking History sayfasında journey date kontrol edilir
        softAssert.assertEquals(date,dateSelection,"Booking History date uyusmuyor");
        // 53-Booking History sayfasında alınan biletin status'u "Booked" olarak görüntülenir
        Object Expected = "Booked";
        softAssert.assertEquals(selectSeatPage.status.getText(),Expected,"Bug var");
        // 54-Booking History sayfasında tutar kontrol edilir
        softAssert.assertEquals(fare,sbTtlPymnt,"Booking History tutar uyusmuyor");
        String bookingHistoryWingowHandle2= Driver.getDriver().getWindowHandle();
        // 55-Yazıcı ikonuna tıklanır
        selectSeatPage.yaziciIkonu.click();

        for (String handle : allWindowHandles) {
            if (!handle.equals(findTicketWindowHandle)&&!handle.equals(bookingWindowHandle)&&!handle.equals(yaziciWindowHandle)&&!handle.equals(bookingHistoryWingowHandle2)) {
                Driver.getDriver().switchTo().window(handle);
                // Bu doğrulamayı, e-bilet sayfasının belirli bir locator'ı ile yapabilirsiniz
                softAssert.assertTrue(bookingHistoryPage.downloadTicket.isDisplayed(),"Download Ticket görüntülenmedi");
                softAssert.assertTrue(bookingHistoryPage.downloadTicket.isEnabled(),"Download Ticket aktif değil");
                // 57-Download Ticket tıklanır
                bookingHistoryPage.downloadTicket.click();

                break;
            }

        }
       softAssert.assertAll();

        Driver.closeDriver();


    }
}
