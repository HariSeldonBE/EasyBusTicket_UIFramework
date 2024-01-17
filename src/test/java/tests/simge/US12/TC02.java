package tests.simge.US12;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void dashboardButtonDogrulamaTesti2(){

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
        // 7-Navbar menüde dashboard linki görüntülenir
        Assert.assertTrue(userDashBoardPage.dashboardButton.isDisplayed());
        Assert.assertTrue(userDashBoardPage.dashboardButton.isEnabled());
        // 8-Navbar menüdeki Dashboard linki tıklanır
        userDashBoardPage.dashboardButton.click();
        ReusableMethods.wait(1);
        // 9-Dashboard sayfasnın yenilendiği doğrulanır
        String expectedURL="https://qa.easybusticket.com/user/dashboard";
        String actualURL=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
        ReusableMethods.wait(1);
        Driver.closeDriver();


    }
}
