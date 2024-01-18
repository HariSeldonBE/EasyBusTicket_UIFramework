package tests.yusuf.demo_senaryo;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import pages.user.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class DS03 extends TestBaseRapor {
    @Test
    public void DS03 (){


        // 1- http://qa.easybusticket.com  anasayfasina gidilir
        // 2- Cookies kabul edilir
        // 3- Ana sayfa dan "Contact" ButtonLink e tıklanır.
        // 4- Sayfa asagi kaydirilir
        // 5- Name,email, subject ,Your Message  TextBoxlari doldurulur.
        // 6- Send Us Message Button tıklanilir
        // 7- " Your message has been sent. Thank you for contacting us. " goruntulendigi dogrulanir

        extentTest=extentReports.createTest("Contact Us support message TEST", "User tests the contact button");

        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.contactButton.click();
        extentTest.info("User presses the contact button");

        ContactPage contactPage=new ContactPage();
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");

        Actions actions=new Actions(Driver.getDriver());
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();


        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",contactPage.nameTextBox);
        ReusableMethods.wait(1);
        Faker faker=new Faker();
        actions.click(contactPage.nameTextBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("fakesubject"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("fakemessage"))
                .perform();
        extentTest.info("Fills boxes with appropriate criteria");
        contactPage.sendUsButton.click();
        extentTest.info("\"send us button\" Click");
        ReusableMethods.wait(1);
        contactPage.succesclosebutton.click();
        ReusableMethods.wait(2);



        easyBusTicketPage.signUpButton.click();
        extentTest.info("User presses the signUp button");

        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);
        extentTest.info("2 seconds wait");


        String email =faker.internet().emailAddress();
        String password=ConfigReader.getProperty("userPass");
        actions.click(signUpPage.firstnameTextBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Page down");
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");


        signUpPage.acceptCheckButon.click();
        extentTest.info("Sign Up accept check box clicked");

        signUpPage.signUpbutton.click();
        extentTest.info("Sign Up button  clicked");
        ReusableMethods.wait(1);




        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        ReusableMethods.wait(1);
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        ReusableMethods.wait(1);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
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

        ReusableMethods.wait(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(1);
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // 21-Cinsiyet seçimi yapılır

        selectSeatPage.femaleCheckbox.click();



        // 24 - Koltuk seçimi yapılır

        selectSeatPage.seats.get(4).click();


        ReusableMethods.wait(2);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);


        // 26-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        // 30-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.wait(1);
        //32- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);

        //28-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        //32-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();

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



        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",selectSeatPage.paymentConfirmPayNowButton);

        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.wait(1);
        //18-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
BookingHistoryPage bookingHistoryPage=new BookingHistoryPage();
        String mainWindowHandle=Driver.getDriver().getWindowHandle();
        ReusableMethods.wait(1);
        selectSeatPage.yaziciIkonu.click();
        Set<String> allWindowHandles=Driver.getDriver().getWindowHandles();


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


        Driver.closeDriver();


    }














    }

