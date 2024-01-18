package tests.yusuf.demo_senaryo;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import pages.user.FindTicketsPage;
import pages.user.SelectSeatPage;
import pages.user.UserDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class DS02 extends TestBaseRapor {
    @Test
    public void Demosenaryo(){










        extentTest=extentReports.createTest("SignUp Page  TEST", "User tests the signUp Page ");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.signUpButton.click();
        extentTest.info("User presses the signUp button");

        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);
        extentTest.info("2 seconds wait");

        Actions actions = new Actions(Driver.getDriver());
        Faker faker=new Faker();
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

        selectSeatPage.seats.get(9).click();


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
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();


        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",selectSeatPage.paymentConfirmPayNowButton);

        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.wait(1);
        //18-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
}
