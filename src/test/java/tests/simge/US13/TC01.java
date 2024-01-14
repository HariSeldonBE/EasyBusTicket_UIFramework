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
