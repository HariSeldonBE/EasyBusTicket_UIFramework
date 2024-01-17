package tests.simge.US13;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.FindTicketsPage;
import pages.user.SelectSeatPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC06 {
    @Test
    public void selectSeatDogrulamaPozitifTesti(){

        // 1-Browser açılır ve Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2-Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        if (easyBusTicketPage.cookiesButton.isDisplayed()){
        easyBusTicketPage.cookiesButton.click();}
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
        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(2);
        findTicketsPage.pickupPointSelection.click();
        Object selectedPickup = findTicketsPage.pickupPointSelection.getText();
        ReusableMethods.wait(2);
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
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage =new SelectSeatPage();
        // 14- Journey Date doğru mu kontrol edilir
        selectSeatPage.seatJourneyDateBox.click();
        Assert.assertEquals(selectSeatPage.firstSelectedDate.getText(),selectedDate);
        // 15- Pickup Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup);
        // 16- Dropping Point doğru mu kontrol edilir
        Assert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping);




        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.wait(2);
        js.executeScript("arguments[0].scrollIntoView()",selectSeatPage.continueButton);
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.wait(2);
        // 16 - Rezerve edilen koltuklardan koltuk seçimi yapılamadığı doğrulanır

        if(!selectSeatPage.ladiesSelectedSeats.isEmpty()){
            for (WebElement ladiesSelectedSeat:selectSeatPage.ladiesSelectedSeats) {
                Assert.assertTrue(ladiesSelectedSeat.isDisplayed());
                try {
                    if(ladiesSelectedSeat.isEnabled()){
                        ladiesSelectedSeat.click();
                    }
                } catch (Exception e) {
                    System.out.println("Element is not clickable at point");
                }

                break;
            }
        }
        if(!selectSeatPage.gentsSelectedSeats.isEmpty()){
            for (WebElement gentsSelectedSeat:selectSeatPage.gentsSelectedSeats) {
                Assert.assertTrue(gentsSelectedSeat.isDisplayed());
                try {
                    if(gentsSelectedSeat.isEnabled()){
                        gentsSelectedSeat.click();
                    }
                } catch (Exception e) {
                    System.out.println("Element is not clickable at point");
                }
                break;
            }
        }
        if(!selectSeatPage.othersSelectedSeats.isEmpty()){
            for (WebElement othersSelectedSeat:selectSeatPage.othersSelectedSeats) {
                Assert.assertTrue(othersSelectedSeat.isDisplayed());
                try {
                    if(othersSelectedSeat.isEnabled()){
                        othersSelectedSeat.click();
                    }
                } catch (Exception e) {
                    System.out.println("Element is not clickable at point");
                }
                break;
            }
        }

        Assert.assertTrue(selectSeatPage.selectedSeats.isEmpty());

        Driver.closeDriver();


    }
}
