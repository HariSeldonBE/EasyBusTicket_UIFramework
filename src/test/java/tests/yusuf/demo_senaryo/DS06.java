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

public class DS06 extends TestBaseRapor {
    @Test
    public void DS06 (){


        extentTest=extentReports.createTest("Contact Us support message TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        Faker faker=new Faker();
        Actions actions = new Actions(Driver.getDriver());
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        SoftAssert softAssert = new SoftAssert();
      /*  easyBusTicketPage.cookiesButton.click();
        ReusableMethods.wait(1);

        easyBusTicketPage.getTicketNowButton.click();
        ReusableMethods.wait(1);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        findTicketsPage.pickupPoint.click();

        ReusableMethods.wait(2);
        SoftAssert softAssert=new SoftAssert();

        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(2);
        Object selectedPickup = findTicketsPage.pickupPointSelection.getText();
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        Object selectedDropping=findTicketsPage.droppingPointSelection.getText();

        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));
       // Object selectedDate = findTicketsPage.dateOfJourneySelection.getText();
        ReusableMethods.wait(2);

        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();

        ReusableMethods.wait(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(1);
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);

       // actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
       // actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        // - Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();
       // js.executeScript("arguments[0].click",selectSeatPage.femaleCheckbox);



      //  selectSeatPage.femaleCheckbox.click();



        // - Koltuk seçimi yapılır
       selectSeatPage.seats.get(0).click();
       // js.executeScript("arguments[0].click",selectSeatPage.seats.get(0));


        ReusableMethods.wait(2);


        // 26-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
       // js.executeScript("arguments[0].click",selectSeatPage.continueButton);
        selectSeatPage.continueButton.click();
        // 30-"Confirm" butonu tıklanır
        //js.executeScript("arguments[0].click",selectSeatPage.confirmBookingButton);
        selectSeatPage.confirmBookingButton.click();
        ReusableMethods.wait(2);
       UserLoginPage userLoginPage=new UserLoginPage();

       //actions.sendKeys(Keys.PAGE_DOWN).perform();
       ReusableMethods.wait(1);
       userLoginPage.signUpButton.click();
       // js.executeScript("arguments[0].click",userLoginPage.signUpButton);

        extentTest.info("User presses the signUp button");
*/
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);
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

        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
       // actions.sendKeys(Keys.PAGE_DOWN).perform();
       // extentTest.info("Page down");
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
        signUpPage.acceptCheckButon.click();
       // js.executeScript("arguments[0].click",signUpPage.acceptCheckButon);
        extentTest.info("Sign Up accept check box clicked");
        signUpPage.signUpbutton.click();;
      //  js.executeScript("arguments[0].click",signUpPage.signUpbutton);
        extentTest.info("Sign Up button  clicked");
        ReusableMethods.wait(1);




        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].click",userDashBoardPage.bookingDdm);

        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        js.executeScript("arguments[0].click",userDashBoardPage.buyTicket);
        ReusableMethods.wait(1);

        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
      //  js.executeScript("arguments[0].click", findTicketsPage.pickupPoint);


        ReusableMethods.wait(2);


        js.executeScript("arguments[0].click", findTicketsPage.pickupPointSelection);
        ReusableMethods.wait(2);
        //Object selectedPickups= findTicketsPage.pickupPointSelection.getText();
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        js.executeScript("arguments[0].click", findTicketsPage.droppingPoint);
        js.executeScript("arguments[0].click", findTicketsPage.droppingPointSelection);

        // Object selectedDroppings=findTicketsPage.droppingPointSelection.getText();

        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        js.executeScript("arguments[0].click", findTicketsPage.dateOfJourney);
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));

       // Object selectedDates= findTicketsPage.dateOfJourneySelection.getText();
        ReusableMethods.wait(2);

        // 12-"Find Tickets" butonu tıklanır
        js.executeScript("arguments[0].click", findTicketsPage.findTicketsButton);



        ReusableMethods.wait(1);
        // 13- Select Seat butonu tıklanır
        js.executeScript("arguments[0].click", findTicketsPage.selectSeatButton);

        ReusableMethods.wait(2);

        // - Cinsiyet seçimi yapılır
        js.executeScript("arguments[0].click", selectSeatPage.femaleCheckbox);




        // - Koltuk seçimi yapılır
        js.executeScript("arguments[0].click", selectSeatPage.seats.get(6));
        selectSeatPage.seats.get(17).click();


        ReusableMethods.wait(2);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);


        // 26-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        js.executeScript("arguments[0].click", selectSeatPage.continueButton);

        // 30-"Confirm" butonu tıklanır
        js.executeScript("arguments[0].click", selectSeatPage.confirmBookingButton);

        ReusableMethods.wait(1);


        ReusableMethods.wait(1);
        //32- "Pay Now" butonu tıklanır
        js.executeScript("arguments[0].click", selectSeatPage.paymentMethodsPayNowButton);

        ReusableMethods.wait(2);

        //28-"Confirm" butonu tıklanır
        js.executeScript("arguments[0].click", selectSeatPage.paymentByStripeHostedConfirm);


        ReusableMethods.wait(1);
        //32-"pay now" butonu tıklanır
        js.executeScript("arguments[0].click", selectSeatPage.paymentReviewPayNowButton);


        //9-"Name on Card" textbox ına isim soyisim yazılır
        selectSeatPage.nameOnCard.sendKeys(ConfigReader.getProperty("nameOnCard"));
        ReusableMethods.wait(2);

        //12-"Card Number" textbox ına 16 haneli geçerli kart numrası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));

        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(2);

        //14 - "Expiration Date" textbox ına "MM/YYYY" formatında gecerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));

        // 52-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));





        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.wait(1);
        //18-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        softAssert.assertTrue(selectSeatPage.successfulPayment.isDisplayed(),"Successful payment görüntülenmedi");
        // 47-Booking History sayfasının açıldığı doğrulanır
        softAssert.assertTrue(selectSeatPage.bookingHistoryTitle.isDisplayed(),"Booking History sayfası açılmadı");
        // 48-Booking History sayfasında pickup point kontrol edilir
        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();

        // 49-Booking History sayfasında drop point kontrol edilir

        // 50-Booking History sayfasında journey date kontrol edilir
        Object date = bookingHistoryPage.dateControl.getText().substring(0, 2);

        // 51-Booking History sayfasında alınan biletin status'u "Booked" olarak görüntülenir
        Object expected = "Booked";
        softAssert.assertEquals(selectSeatPage.status.getText(), expected,"Bug var");
        // 52-Booking Histosy sayfasında tutar kontrol edilir
        Object fare = bookingHistoryPage.subTotalControl.getText().replaceAll(".00 USD", "");

        // 53-Action kısmının altında bulunan yazıcı ikonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(selectSeatPage.yaziciIkonu.isDisplayed(),"Yazıcı ikonu görüntülenmedi");
        softAssert.assertTrue(selectSeatPage.yaziciIkonu.isEnabled(),"Yazıcı ikonu aktif değil");
        // 54-Yazıcı ikonuna tıklanır
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
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
            ReusableMethods.wait(5);

        }
        softAssert.assertAll();
        //Driver.closeDriver();

    }


}
















