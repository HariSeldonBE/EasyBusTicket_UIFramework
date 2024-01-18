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
        SoftAssert softAssert = new SoftAssert();
        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
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
        findTicketsPage.dateOfJourney.sendKeys(ConfigReader.getProperty("date"));

        ReusableMethods.wait(1);
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        // 13- Select Seat butonu tıklanır
        findTicketsPage.selectSeatButton.click();
        ReusableMethods.wait(2);
        SelectSeatPage selectSeatPage =new SelectSeatPage();
        // 14- Journey Date doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatJourneyDateBox.getAttribute("value"),ConfigReader.getProperty("date"),"Find Ticket Page'de secilen tarih ile Select Seat Page'ki journey date uyusmuyor");
        // 15- Pickup Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatPickup.getText(),selectedPickup,"Secilen pickup point uyusmuyor");
        // 16- Dropping Point doğru mu kontrol edilir
        softAssert.assertEquals(selectSeatPage.seatDropping.getText(),selectedDropping,"Secilen dropping point uyusmuyor");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        // 16 - Rezerve edilen koltuklardan koltuk seçimi yapılamadığı doğrulanır

        if(!selectSeatPage.ladiesSelectedSeats.isEmpty()){
            for (WebElement ladiesSelectedSeat:selectSeatPage.ladiesSelectedSeats) {
                softAssert.assertTrue(ladiesSelectedSeat.isDisplayed(),"Ladies rezerve koltuklar görüntülenmedi");
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
                softAssert.assertTrue(gentsSelectedSeat.isDisplayed(),"Gents rezerve koltuklar görüntülenmedi");
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
                softAssert.assertTrue(othersSelectedSeat.isDisplayed(),"Others rezerve koltuklar görüntülenmedi");
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

        softAssert.assertTrue(selectSeatPage.selectedSeats.isEmpty(),"Rezerve koltuklar secilebildi");
        softAssert.assertAll();

        Driver.closeDriver();


    }
}
