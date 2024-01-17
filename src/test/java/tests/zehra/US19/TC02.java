package tests.zehra.US19;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void test(){
      // TC02
      // Sistemden çıkış yaptığımda site login sayfasına ulaşabilmeliyim

      // STEPLER:
      // 1-Kayıtlı kullanıcı olarak Browser'ı açar ve Url'e gider
      // 2-Kullanıcı sayfasının header kısmındaki Profile menüsünden "logout" linkine tıklar
      // 3-Açılan sayfanın Url'nin "https://qa.easybusticket.com/login" olduğunu doğrular.

        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage = new UserLoginPage();

        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        userLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        actions.moveToElement(userDashBoardPage.headerDdmProfileButton).click().build().perform();
        ReusableMethods.wait(1);

        userDashBoardPage.headerDdmLogoutButton.click();
        String expectedURL = "https://qa.easybusticket.com/login";
        String actualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualURL,expectedURL,"login sayfasına gitmedi");

        ReusableMethods.wait(1);
        softAssert.assertAll();
        Driver.quitDriver();

    }
}
