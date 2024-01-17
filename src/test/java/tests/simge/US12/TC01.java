package tests.simge.US12;

import com.beust.ah.A;
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
    public void dashboardButtonDogrulamaTesti(){

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
        // 7-Açılan user dashboard sayfasında sol üstte görüntülenen site logosuna tıklanır
        Assert.assertTrue(userDashBoardPage.logo.isDisplayed());
        Assert.assertTrue(userDashBoardPage.logo.isEnabled());
        userDashBoardPage.logo.click();
        // 8-Anasayfanın açıldığı doğrulanır
        String expectedURL= "https://qa.easybusticket.com/";
        String actualURL=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
        // 8-Anasayfada header bölümünde sağ üstte Dashboard butonu görüntülenir
        Assert.assertTrue(easyBusTicketPage.dashboardButton.isDisplayed());
        Assert.assertTrue(easyBusTicketPage.dashboardButton.isEnabled());
        // 9-Dashboard butonuna tıklanır
        easyBusTicketPage.dashboardButton.click();
        // 10-User Dashboard sayfasının açıldığı doğrulanır
        Assert.assertTrue(userDashBoardPage.labelDashBoard.isDisplayed());


        Driver.closeDriver();


    }
}
