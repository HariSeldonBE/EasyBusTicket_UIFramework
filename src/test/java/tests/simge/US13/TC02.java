package tests.simge.US13;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        // 9-Bilet arama sayfasının açıldığı doğrulanır
        ReusableMethods.wait(2);
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        Assert.assertTrue(findTicketsPage.findTicketsButton.isDisplayed());
        // 10 - "Filter" menüsünden "Vehicle Type" checkbox larının aktif olduğu doğrulanır
        for (WebElement vehicleCheckbox : findTicketsPage.vehicleCheckboxes) {
            Assert.assertTrue(vehicleCheckbox.isEnabled());
        }
        // 11 - "Filter" menüsünden "Routes" checkbox larının aktif olduğu doğrulanır
        for (WebElement routesCheckbox : findTicketsPage.routesCheckboxes) {
            Assert.assertTrue(routesCheckbox.isEnabled());
        }
        // 12 - "Pick Up Point" dropbox unun görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(findTicketsPage.pickupPoint.isDisplayed());
        Assert.assertTrue(findTicketsPage.pickupPoint.isEnabled());
        // 13 - "Dropping Point" dropbox unun görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(findTicketsPage.droppingPoint.isDisplayed());
        Assert.assertTrue(findTicketsPage.droppingPoint.isEnabled());
        // 14 - "Date of Jouney" tarih kutusunun görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(findTicketsPage.dateOfJourney.isDisplayed());
        Assert.assertTrue(findTicketsPage.dateOfJourney.isEnabled());
        // 15 - "Find Ticket" butonunun görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(findTicketsPage.findTicketsButton.isDisplayed());
        Assert.assertTrue(findTicketsPage.findTicketsButton.isEnabled());
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
        Assert.assertTrue(findTicketsPage.selectSeatButton.isDisplayed());
        Assert.assertTrue(findTicketsPage.selectSeatButton.isEnabled());
        ReusableMethods.wait(2);


        Driver.closeDriver();





    }
}
