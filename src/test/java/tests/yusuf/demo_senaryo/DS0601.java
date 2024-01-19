package tests.yusuf.demo_senaryo;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import pages.user.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class DS0601 extends TestBaseRapor {
    @Test
    public void DS06_01 () {


        extentTest = extentReports.createTest("WiseQuarter T127 - Team2 - Otomasyon Seneryosu Testi", "Senaryo Koşumu");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("01-URL'e gidilir");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("02-\"Cookies\" Butonu tıklanır");
        ReusableMethods.wait(4);
        extentTest.info("03-Bekleme eklenir");
        easyBusTicketPage.getTicketNowButton.click();
        extentTest.info("04-\"GET TICKET NOW\" Butonu tıklanır");
        ReusableMethods.wait(4);
        extentTest.info("05-Bekleme eklenir");
        Actions actions = new Actions(Driver.getDriver());
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(4);
        SoftAssert softAssert = new SoftAssert();
        findTicketsPage.pickupPointSelection.click();
        extentTest.info("06-\"Pickup Point\" dropBox'dan kalkış noktası seçimi yapılır");
        ReusableMethods.wait(4);
        extentTest.info("07-Bekleme eklenir");

        // "Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        extentTest.info("08-\"Dropping Point\" dropBox'dan varış noktası seçimi yapılır");
        ReusableMethods.wait(4);
        extentTest.info("09-Bekleme eklenir");

        // "Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));
        extentTest.info("10-\"Date of Journey\" dropBox'dan yolculuk tarihi seçilir.");
        ReusableMethods.wait(4);
        extentTest.info("11-Bekleme eklenir");


        // "Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        extentTest.info("12-\"Find Tickets\" Butonu tıklanır");

        ReusableMethods.wait(4);
        extentTest.info("13-Bekleme eklenir");



        ReusableMethods.wait(4);


        // Select Seat butonu tıklanır

        findTicketsPage.selectSeatButton.click();
        extentTest.info("14- \"Select Seat\" Butonu tıklanır");
        ReusableMethods.wait(4);
        extentTest.info("15-Bekleme eklenir");
        SelectSeatPage selectSeatPage = new SelectSeatPage();

        ReusableMethods.wait(4);

        js.executeScript("window.scrollBy(0,arguments[0])", 500);
        extentTest.info("16-Pencere aşağı kaydırılır");
        ReusableMethods.wait(4);
        extentTest.info("17-Bekleme eklenir");

        // Cinsiyet seçimi yapılır


        selectSeatPage.femaleCheckbox.click();
        extentTest.info("18-Cinsiyet seçimi yapılır");
        ReusableMethods.wait(4);
        extentTest.info("19-Bekleme eklenir");
       // js.executeScript("arguments[0].click",selectSeatPage.femaleCheckbox);




        // Koltuk seçimi yapılır
        selectSeatPage.seats.get(0).click();
        extentTest.info("20-Koltuk seçimi yapılır");

        // js.executeScript("arguments[0].click",selectSeatPage.seats.get(0));
        ReusableMethods.wait(5);
        extentTest.info("21-Bekleme eklenir");


        // "Continue" butonu tıklanır
        ReusableMethods.wait(2);
        // js.executeScript("arguments[0].click",selectSeatPage.continueButton);
        selectSeatPage.continueButton.click();
        extentTest.info("22-\"Continue\" Butonu tıklanır");

        // "Confirm" butonu tıklanır

       // js.executeScript("arguments[0].click",selectSeatPage.confirmBookingButton);
        selectSeatPage.confirmBookingButton.click();
        extentTest.info("23-\"Confirm\" Butonu tıklanır");
        ReusableMethods.wait(4);
        extentTest.info("24-Bekleme eklenir");
        UserLoginPage userLoginPage = new UserLoginPage();
        Faker faker = new Faker();
        ReusableMethods.wait(3);
        userLoginPage.signUpButton.click();
        extentTest.info("25-\"SignUp\" Butonu tıklanır");
        // js.executeScript("arguments[0].click",userLoginPage.signUpButton);
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(4);
        extentTest.info("26-Bekleme eklenir");
        Driver.getDriver().get("https://qa.easybusticket.com/register");
        extentTest.info("27-Signup sayfasına gidilir");

        String email =faker.internet().emailAddress();
        String password=ConfigReader.getProperty("userPass");
        signUpPage.firstnameTextBox.click();
        signUpPage.firstnameTextBox
                .sendKeys(faker.name().firstName());
        extentTest.info("28-\"firstName\" textBox'a isim bilgisi girilir");
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("phonenumber"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("userName2"))
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        extentTest.info("29-\"Kullanıcı Kayıt Formu\" doğru bilgilerle doldurulur");

        ReusableMethods.wait(3);
        extentTest.info("30-Bekleme eklenir");

        ReusableMethods.wait(3);


        signUpPage.acceptCheckButon.click();
        // js.executeScript("arguments[0].click",signUpPage.acceptCheckButon);
        extentTest.info("31-\"Sign Up Accept\" checkBox tıklanır");
        signUpPage.signUpbutton.click();;
        extentTest.info("32-\"Sign Up\" Buttonu tıklanır");

        //js.executeScript("arguments[0].click",signUpPage.signUpbutton);

        ReusableMethods.wait(3);


        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        ReusableMethods.wait(4);
        extentTest.info("33-Bekleme eklenir");

       // js.executeScript("arguments[0].click",userDashBoardPage.bookingDdm);
        userDashBoardPage.bookingDdm.click();
        extentTest.info("34-\"Booking\" açılır menüsü tıklanır");


        ReusableMethods.wait(1);
        // "Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
       // js.executeScript("arguments[0].click",userDashBoardPage.buyTicket);
        userDashBoardPage.buyTicket.click();
        extentTest.info("35-\"Booking\" açılır menüsü açıldığında \"Buy Ticket\" Butonu tıklanır");
        ReusableMethods.wait(3);
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(4);
        extentTest.info("36-Bekleme eklenir");
        findTicketsPage.pickupPointSelection.click();
        extentTest.info("37-\"Pickup Point\" dropBox'dan kalkış noktası seçimi yapılır");
        ReusableMethods.wait(4);
        extentTest.info("38-Bekleme eklenir");
        // "Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        extentTest.info("39-\"Dropping Point\" dropBox'dan varış noktası seçimi yapılır");


        // "Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));
        extentTest.info("40-\"Departure Date\" dropBox'dan yolculuk tarihi seçimi yapılır");

        ReusableMethods.wait(4);
        extentTest.info("41-Bekleme eklenir");
        // "Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        extentTest.info("42-\"Find Tickets\" Butonu tıklanır");

        ReusableMethods.wait(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(3);
        extentTest.info("43-Bekleme eklenir");
        // Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        extentTest.info("44-\"Select Seat\" Butonu tıklanır");
        ReusableMethods.wait(4);


        ReusableMethods.wait(3);
        extentTest.info("45-Bekleme eklenir");
        js.executeScript("window.scrollBy(0,arguments[0])", 500);
        extentTest.info("46-Pencere aşağı kaydırılır");

        ReusableMethods.wait(3);
        extentTest.info("47-Bekleme eklenir");
        // Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        extentTest.info("48-Cinsiyet seçimi yapılır");

        // js.executeScript("arguments[0].click",selectSeatPage.femaleCheckbox);
        //  selectSeatPage.femaleCheckbox.click();

        // Koltuk seçimi yapılır
        selectSeatPage.seats.get(0).click();
        extentTest.info("49-Koltuk seçimi yapılır");


        // js.executeScript("arguments[0].click",selectSeatPage.seats.get(0));
        ReusableMethods.wait(4);


        // "Continue" butonu tıklanır
        ReusableMethods.wait(4);
        extentTest.info("50-Bekleme eklenir");


        // js.executeScript("arguments[0].click",selectSeatPage.continueButton);
        selectSeatPage.continueButton.click();
        extentTest.info("51-\"Continue\" Butonu tıklanır");

        // "Confirm" butonu tıklanır
        // js.executeScript("arguments[0].click",selectSeatPage.confirmBookingButton);

        selectSeatPage.confirmBookingButton.click();
        extentTest.info("52-\"Confirm\" Butonu tıklanır");

        ReusableMethods.wait(4);
        extentTest.info("53-Bekleme eklenir");
        // "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        extentTest.info("54-\"Pay Now\" Butonu tıklanır");
        ReusableMethods.wait(4);
        extentTest.info("55-Bekleme eklenir");
        // "Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        extentTest.info("56-\"Confirm\" Butonu tıklanır");

        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.paymentReviewPayNowButton);
        extentTest.info("57-\"Pay Now\" Butonu görülür olana kadar scroll kaydırlır");
        ReusableMethods.wait(3);
        extentTest.info("58-Bekleme eklenir");
        // "pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        extentTest.info("59-\"Pay Now\" Butonu tıklanır");
        ReusableMethods.wait(3);
        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(3);
        extentTest.info("60-Bekleme eklenir");
        // "Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        extentTest.info("61-\"Name on Card\" textBox'a isim soyisim yazılır");
        ReusableMethods.wait(4);
        extentTest.info("62-Bekleme eklenir");
        // "Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        extentTest.info("63-\"Card Number\" textBox'a 16 haneli geçerli kart numarası girilir");
        // "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));
        extentTest.info("64-\"Expiration Date\" textBox'a \"MM/YYYY\" formatında geçerli tarih girilir");
        // "CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));
        extentTest.info("65-\"CVC Code\" textBox'a 3 haneli CVC kodu girilir");
        // "PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        extentTest.info("66-\"PAY NOW\" Butonu tıklanır");
        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();
        Object expected = "Booked";
        softAssert.assertEquals(selectSeatPage.status.getText(), expected,"Bug var");
        extentTest.info("PASSED");
        // Yazıcı ikonuna tıklanır
        selectSeatPage.yaziciIkonu.click();
        extentTest.info("67-Yazıcı ikonuna tıklanır");

        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        extentTest.info("68-Bowser ekranı değiştirilir");
        extentTest.info("69-Elektronik bilet görüntülenir");

        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Driver.getDriver().switchTo().window(handle);
                // Şu anda açık olan pencerede e-bilet sayfasının olduğunu doğrula
                // Bu doğrulamayı, e-bilet sayfasının belirli bir locator'ı ile yapabilirsiniz
                softAssert.assertTrue(bookingHistoryPage.downloadTicket.isDisplayed(),"Download Ticket butonu görüntülenmedi");
                extentTest.info("70-PASSED");
                softAssert.assertTrue(bookingHistoryPage.downloadTicket.isEnabled(),"Download Ticket butonu aktif değil");
                extentTest.info("71-PASSED");
                // 57-Download Ticket tıklanır
                bookingHistoryPage.downloadTicket.click();
                extentTest.info("72-\"Download Ticket\" tıklanır");
                ReusableMethods.wait(4);
                extentTest.info("73-Bekleme eklenir");
                Driver.getDriver().close();
                extentTest.info("74-Driver kapatılır");
                Driver.getDriver().switchTo().window(mainWindowHandle);
                extentTest.info("75-Pencere değiştirilir");

                break;
            }


        }
        softAssert.assertAll();
        extentTest.info("76-PASSED");
        ReusableMethods.wait(4);
        extentTest.info("77-Bekleme eklenir");
        //Support Request tıklanır
        userDashBoardPage.supportRequest.click();
        extentTest.info("78-\"Support Request\" tıklanır");
        ReusableMethods.wait(4);
        extentTest.info("79-Bekleme eklenir");
        //Create New tıklanır
        SupportRequestPage supportRequestPage = new SupportRequestPage();
        userDashBoardPage.createNew.click();
        extentTest.info("80-\"Create New\" tıklanır");

        ReusableMethods.wait(3);
        extentTest.info("81-Bekleme eklenir");
        //Subject yazılır
        supportRequestPage.subject.sendKeys("Bilet İptal Talebi");
        extentTest.info("82-Subject yazılır");

        ReusableMethods.wait(4);

        //Priority seçilir
        supportRequestPage.priority.click();
        ReusableMethods.wait(3);
        extentTest.info("83-Bekleme eklenir");
        supportRequestPage.high.click();
        extentTest.info("84-Priority seçilir");
        ReusableMethods.wait(4);
        extentTest.info("85-Bekleme eklenir");
        //Mesaj yazılır
        supportRequestPage.message.sendKeys("Merhaba, mümkünse biletimin tarihinin değiştirilmesini, mümkün değilse iptalini talep ediyorum.");
        extentTest.info("86-Destek talep mesajı yazılır");



        js.executeScript("arguments[0].scrollIntoView()",supportRequestPage.submit);
        ReusableMethods.wait(4);
        extentTest.info("87-Bekleme eklenir");
        //Submit tıklanır
        supportRequestPage.submit.click();
        extentTest.info("88-\"Submit\" Butonu tıklanır");

        ReusableMethods.wait(4);
        extentTest.info("89-Bekleme eklenir");
        Assert.assertTrue(supportRequestPage.requestSuccessful.isDisplayed());
        extentTest.info("90-PASSED");
        Assert.assertTrue(supportRequestPage.statusOpen.isDisplayed());
        extentTest.info("91-PASSED");
        Driver.closeDriver();
        extentTest.info("92-Driver kapatılır");
    }
}