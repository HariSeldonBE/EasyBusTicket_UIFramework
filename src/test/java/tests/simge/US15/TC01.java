package tests.simge.US15;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.SelectSeatPage;
import pages.user.SupportRequestPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void supportRequestButonuDogrulamaTesti(){

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
        //"Support Request" DDM görülür ve aktif olduğu doğrulanır
        Assert.assertTrue(userDashBoardPage.supportRequest.isDisplayed());
        Assert.assertTrue(userDashBoardPage.supportRequest.isEnabled());
        //Support Request tıklanır ve alt menüde Create New görüntülenir ve aktif olduğu doğrulanır
        userDashBoardPage.supportRequest.click();
        Assert.assertTrue(userDashBoardPage.createNew.isDisplayed());
        Assert.assertTrue(userDashBoardPage.createNew.isEnabled());
        //Create New tıklanır ve Support Tickets sayfası açıldığı doğrulanır
        SupportRequestPage supportRequestPage = new SupportRequestPage();
        userDashBoardPage.createNew.click();
        Assert.assertTrue(supportRequestPage.supportTicketsTitle.isDisplayed());
        Driver.closeDriver();

    }
}
