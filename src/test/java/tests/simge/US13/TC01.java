package tests.simge.US13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.FindTicketsPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void buyTicketDogrulamaTesti(){

        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü görüntülenir ve tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        Assert.assertTrue(userDashBoardPage.bookingDdm.isDisplayed());
        userDashBoardPage.bookingDdm.click();
        // 8-"Booking" ddm menüsünden "Buy Ticket" butonu görüntülenir ve aktif olduğu  doğrulanır
        ReusableMethods.wait(2);
        Assert.assertTrue(userDashBoardPage.buyTicket.isDisplayed());
        Assert.assertTrue(userDashBoardPage.buyTicket.isEnabled());
        // 9-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        // 10-Bilet arama sayfasının açıldığı doğrulanır
        ReusableMethods.wait(2);
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        Assert.assertTrue(findTicketsPage.findTicketsButton.isDisplayed());

        Driver.closeDriver();


    }
}
