package tests.simge.US13;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.FindTicketsPage;
import pages.user.SelectSeatPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC10 {
    @Test
    public void nameOnCardNegatifTestiBosluk(){

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

        FindTicketsPage findTicketsPage = new FindTicketsPage();

        // 10-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();

        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(2);
        // 11-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        ReusableMethods.wait(2);
        // 12-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourneySelection.click();
        ReusableMethods.wait(2);
        // 13-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        // 14- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage = new SelectSeatPage();
        // 21-Cinsiyet seçimi yapılır
        selectSeatPage.femaleCheckbox.click();



        // 24 - Koltuk seçimi yapılır



        int i=2;


        while(i<34){
            if(!(selectSeatPage.ladiesSelectedSeats.contains(selectSeatPage.seats.get(i))))
            {
                selectSeatPage.seats.get(i).click();

                i=34;
            }
            i++;
        }

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.wait(2);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);




        // 26-"Continue" butonu tıklanır
        ReusableMethods.wait(2);
        selectSeatPage.continueButton.click();
        ReusableMethods.wait(2);


        // 30-"Confirm" butonu tıklanır
        selectSeatPage.confirmBookingButton.click();

        //32- "Pay Now" butonu tıklanır
        selectSeatPage.paymentMethodsPayNowButton.click();
        ReusableMethods.wait(2);

        //28-"Confirm" butonu tıklanır
        selectSeatPage.paymentByStripeHostedConfirm.click();

        //32-"pay now" butonu tıklanır
        selectSeatPage.paymentReviewPayNowButton.click();

        //9-"Name on Card" textbox ına bosluk yazılır
        selectSeatPage.nameOnCard.sendKeys(" ");
        ReusableMethods.wait(2);

        //12-"Card Number" textbox ına 16 haneli geçerli kart numarası girilir
        selectSeatPage.validCardNumber.sendKeys(ConfigReader.getProperty("validCardNumber"));
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.paymentConfirmPayNowButton);
        ReusableMethods.wait(2);

        //14 - "Expiration Date" textbox ına "MM/YYYY" formatında geçerli tarih girilir
        selectSeatPage.expirationDate.sendKeys(ConfigReader.getProperty("expirationDate"));

        //16-"CVC Code" textbox ına 3 haneli sayı girilir
        selectSeatPage.cvcCode.sendKeys(ConfigReader.getProperty("cvcCode"));


        //18-"PAY NOW" butonu tıklanır
        selectSeatPage.paymentConfirmPayNowButton.click();
        //19-"payment captured successfully" yazısı görüntülenir
        Assert.assertTrue(selectSeatPage.successfulPayment.isDisplayed());

        ReusableMethods.wait(2);
        Object expected = "Rejected";
        Assert.assertEquals(selectSeatPage.status.getText(),expected);

        Driver.closeDriver();


    }
}
