package tests.simge.US14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.SelectSeatPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void bookingHistoryButonuDogrulamaTesti(){

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
        //6-"Booking" ddm menüsünden "Booking History" butonu görüntülenir ve aktif olduğu  doğrulanır
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(userDashBoardPage.bookingHistory.isDisplayed());
        Assert.assertTrue(userDashBoardPage.bookingHistory.isEnabled());
        //7 - "Booking" ddm menüsünden "Booking History" tıklanır
        userDashBoardPage.bookingHistory.click();
        //8-Booking History sayfasının açıldığı doğrulanır
        SelectSeatPage selectSeatPage=new SelectSeatPage();
        Assert.assertTrue(selectSeatPage.bookingHistoryTitle.isDisplayed());
        ReusableMethods.wait(1);
        Driver.closeDriver();


    }
}
