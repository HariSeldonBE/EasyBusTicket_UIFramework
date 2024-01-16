package tests.zehra.US19;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void test(){

     // 1-Kayıtlı kullanıcı olarak Browser'ı açar ve Url'e gider
     // 2-Ana sayfaya eriştiğinde header kısmındaki "Dashboard" linkine tıklar
     // 3-Kullanıcı sayfasına eriştiğinde header kısmındaki "Profile".menüsünün görüldüğünü doğrular.
     // 4-Profile menüsünün DDM olduğunu görüntüler ve üzerine geldiğinde DDM 'nün açıldığını "logout" linkinin görüldüğünü ve aktif olduğunu doğrular.
     // 5- "logout" linkinin tıklandığını dogrular.

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
        softAssert.assertTrue(userDashBoardPage.headerDdmProfileButton.isDisplayed(),"Profile DDM görünmedi");
        actions.moveToElement(userDashBoardPage.headerDdmProfileButton).click().build().perform();
        ReusableMethods.wait(1);
        softAssert.assertTrue(userDashBoardPage.headerDdmLogoutButton.isDisplayed(),"logout görünmedi");
        softAssert.assertTrue(userDashBoardPage.headerDdmLogoutButton.isEnabled());

        softAssert.assertAll();
        Driver.quitDriver();
    }
}
