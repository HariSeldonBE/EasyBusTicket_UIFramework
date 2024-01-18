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


        extentTest = extentReports.createTest("Contact Us support message TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        ReusableMethods.wait(4);

        easyBusTicketPage.getTicketNowButton.click();
        ReusableMethods.wait(4);
        Actions actions = new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        findTicketsPage.pickupPoint.click();

        ReusableMethods.wait(4);;
        SoftAssert softAssert = new SoftAssert();

        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(4);

        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        extentTest.info("Dropping Point\" dropbox undan farklı yer seçilir");
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        ReusableMethods.wait(4);


        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        extentTest.info("'Date of Journey' dropbox undan sonraki tarih seçilir.");
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));
        // Object selectedDate = findTicketsPage.dateOfJourneySelection.getText();
        ReusableMethods.wait(4);

        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();

        ReusableMethods.wait(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(4);
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(4);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(4);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("window.scrollBy(0,arguments[0])", 500);
        ReusableMethods.wait(4);
        // - Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        ReusableMethods.wait(4);
       // js.executeScript("arguments[0].click",selectSeatPage.femaleCheckbox);


        //  selectSeatPage.femaleCheckbox.click();


        // - Koltuk seçimi yapılır
        selectSeatPage.seats.get(0).click();
        // js.executeScript("arguments[0].click",selectSeatPage.seats.get(0));


        ReusableMethods.wait(5);


        // 26-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        // js.executeScript("arguments[0].click",selectSeatPage.continueButton);
        selectSeatPage.continueButton.click();
        // 30-"Confirm" butonu tıklanır
       // js.executeScript("arguments[0].click",selectSeatPage.confirmBookingButton);
        selectSeatPage.confirmBookingButton.click();
        ReusableMethods.wait(4);
        UserLoginPage userLoginPage = new UserLoginPage();
        Faker faker = new Faker();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(3);
        userLoginPage.signUpButton.click();
        // js.executeScript("arguments[0].click",userLoginPage.signUpButton);
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(4);
        extentTest.info("2 seconds wait");
        Driver.getDriver().get("https://qa.easybusticket.com/register");

        String email =faker.internet().emailAddress();
        String password=ConfigReader.getProperty("userPass");
        signUpPage.firstnameTextBox.click();
        // actions.click(signUpPage.firstnameTextBox)
        signUpPage.firstnameTextBox
                .sendKeys(faker.name().firstName());
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
        extentTest.info("Information is filled with appropriate criteria");

        ReusableMethods.wait(3);
        extentTest.info("1 seconds wait");
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // extentTest.info("Page down");
        ReusableMethods.wait(3);
        extentTest.info("1 seconds wait");
        signUpPage.acceptCheckButon.click();
        // js.executeScript("arguments[0].click",signUpPage.acceptCheckButon);
        extentTest.info("Sign Up accept check box clicked");
        signUpPage.signUpbutton.click();;
          //js.executeScript("arguments[0].click",signUpPage.signUpbutton);
        extentTest.info("Sign Up button  clicked");
        ReusableMethods.wait(3);




        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        ReusableMethods.wait(4);
       // js.executeScript("arguments[0].click",userDashBoardPage.bookingDdm);
        userDashBoardPage.bookingDdm.click();

        ReusableMethods.wait(1);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
       // js.executeScript("arguments[0].click",userDashBoardPage.buyTicket);
        userDashBoardPage.buyTicket.click();
        ReusableMethods.wait(3);
        findTicketsPage.pickupPoint.click();

        ReusableMethods.wait(4);


        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(4);

        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();


        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));

        ReusableMethods.wait(4);

        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();

        ReusableMethods.wait(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(3);
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(4);

        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(3);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("window.scrollBy(0,arguments[0])", 500);
        ReusableMethods.wait(3);
        // - Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
        // js.executeScript("arguments[0].click",selectSeatPage.femaleCheckbox);


        //  selectSeatPage.femaleCheckbox.click();


        // - Koltuk seçimi yapılır
        selectSeatPage.seats.get(0).click();
        // js.executeScript("arguments[0].click",selectSeatPage.seats.get(0));


        ReusableMethods.wait(4);


        // 26-"Continue" butonu tıklanır
        ReusableMethods.wait(4);
        // js.executeScript("arguments[0].click",selectSeatPage.continueButton);
        selectSeatPage.continueButton.click();
        // 30-"Confirm" butonu tıklanır
        // js.executeScript("arguments[0].click",selectSeatPage.confirmBookingButton);
        selectSeatPage.confirmBookingButton.click();
        ReusableMethods.wait(4);
        // 22- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(4);

        // 26-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();

        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.paymentReviewPayNowButton);
        ReusableMethods.wait(3);
        // 30-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();
        ReusableMethods.wait(3);
        js.executeScript("arguments[0].scrollIntoView()", selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(3);


        // 34-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(4);

        // 37-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));

        // 40 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));

        // 43-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));


        // 45-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();


        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();

        Object expected = "Booked";
        softAssert.assertEquals(selectSeatPage.status.getText(), expected,"Bug var");

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
                ReusableMethods.wait(4);
                Driver.getDriver().close();
                Driver.getDriver().switchTo().window(mainWindowHandle);

                break;
            }


        }
        softAssert.assertAll();
        ReusableMethods.wait(4);
        //Support Request tıklanır
        userDashBoardPage.supportRequest.click();
        ReusableMethods.wait(4);

        //Create New tıklanır
        SupportRequestPage supportRequestPage = new SupportRequestPage();
        userDashBoardPage.createNew.click();
        ReusableMethods.wait(3);
        //Subject yazılır
        supportRequestPage.subject.sendKeys("Bilet İptal Talebi");
        ReusableMethods.wait(4);
        //Priority seçilir
        supportRequestPage.priority.click();
        ReusableMethods.wait(3);
        supportRequestPage.high.click();
        ReusableMethods.wait(4);
        //Mesaj yazılır
        supportRequestPage.message.sendKeys("Merhaba, mümkünse biletimin tarihinin değiştirilmesini, mümkün değilse iptalini talep ediyorum.");


        js.executeScript("arguments[0].scrollIntoView()",supportRequestPage.submit);
        ReusableMethods.wait(4);
        //Submit tıklanır
        supportRequestPage.submit.click();
        ReusableMethods.wait(4);
        Assert.assertTrue(supportRequestPage.requestSuccessful.isDisplayed());
        extentTest.info("PASSED");
        Assert.assertTrue(supportRequestPage.statusOpen.isDisplayed());
        extentTest.info("PASSED");
        extentTest.info("Driver kapatılır");

        Driver.closeDriver();



    }




    }