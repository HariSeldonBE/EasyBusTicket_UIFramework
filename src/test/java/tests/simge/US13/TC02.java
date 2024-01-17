package tests.simge.US13;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.FindTicketsPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void biletAramaPozitifTesti(){
        SoftAssert softAssert = new SoftAssert();
        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        // 9-Bilet arama sayfasının açıldığı doğrulanır
        ReusableMethods.wait(2);
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        softAssert.assertTrue(findTicketsPage.findTicketsButton.isDisplayed(),"Find Ticket Button görüntülenemedi");
        // 10 - "Filter" menüsünden "Vehicle Type" checkbox larının aktif olduğu doğrulanır
        for (WebElement vehicleCheckbox : findTicketsPage.vehicleCheckboxes) {
            softAssert.assertTrue(vehicleCheckbox.isEnabled(),"Vehicle checkbox aktif değil");
        }
        // 11 - "Filter" menüsünden "Routes" checkbox larının aktif olduğu doğrulanır
        for (WebElement routesCheckbox : findTicketsPage.routesCheckboxes) {
            softAssert.assertTrue(routesCheckbox.isEnabled(),"Routes checkboxes aktif değil");
        }
        // 12 - "Pick Up Point" dropbox unun görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(findTicketsPage.pickupPoint.isDisplayed(),"Pickup Point görüntülenemedi");
        softAssert.assertTrue(findTicketsPage.pickupPoint.isEnabled(),"Pickup Point aktif değil");
        // 13 - "Dropping Point" dropbox unun görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(findTicketsPage.droppingPoint.isDisplayed(),"Dropping Point görüntülenemedi");
        softAssert.assertTrue(findTicketsPage.droppingPoint.isEnabled(),"Dropping Point aktif değil");
        // 14 - "Date of Jouney" tarih kutusunun görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(findTicketsPage.dateOfJourney.isDisplayed(),"Date of Journey görüntülenemedi");
        softAssert.assertTrue(findTicketsPage.dateOfJourney.isEnabled(),"Date of Journey aktif değil");
        // 15 - "Find Ticket" butonunun görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(findTicketsPage.findTicketsButton.isDisplayed(),"Find Ticket Button görüntülenemedi");
        softAssert.assertTrue(findTicketsPage.findTicketsButton.isEnabled(),"Find Ticket Button aktif değil");
        // 16-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(2);
        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(2);
        // 17-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        // 18-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourneySelection.click();
        ReusableMethods.wait(2);
        // 19-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();

        // 20-"Select Seat" butonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(findTicketsPage.selectSeatButton.isDisplayed(),"Select Seat Button görüntülenemedi");
        softAssert.assertTrue(findTicketsPage.selectSeatButton.isEnabled(),"Select Seat Button aktif değil");
        ReusableMethods.wait(2);


        Driver.closeDriver();
        softAssert.assertAll();




    }
}
