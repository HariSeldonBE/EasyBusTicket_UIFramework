package tests.simge.US14;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.BookingHistoryPage;
import pages.user.SelectSeatPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void bookingHistorySayfasıDogrulamaTesti(){

        // 1-Browser açılır ve Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2-Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3-SignIn butonuna tıklanır
        easyBusTicketPage.signInButton.click();
        ReusableMethods.wait(2);
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        // 4-Geçerli Username girilir
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        // 5-Geçerli Password girilir
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        // 6-Log In butonuna tıklanır
        userLoginPage.loginButton.click();
        ReusableMethods.wait(1);
        //6-"Booking" ddm menüsünden "Booking History" butonu tıklanır
        userDashBoardPage.bookingDdm.click();
        //7 - "Booking" ddm menüsünden "Booking History" tıklanır
        userDashBoardPage.bookingHistory.click();
        ReusableMethods.wait(1);
        //9-Booking table görüntülenir ve boş olmadığı doğrulanır
        BookingHistoryPage bookingHistoryPage=new BookingHistoryPage();
        Assert.assertFalse(bookingHistoryPage.bookingHistoryTable.isEmpty());
        Driver.closeDriver();


    }
}
