package tests.mehmet.US18;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void Test01(){

        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage=new UserLoginPage();
        SoftAssert softAssert=new SoftAssert();

        //1-Kayıtlı kullanıcı olarak Browser'ı açar ve Url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        userLoginPage.loginButton.click();

        //2-Ana sayfaya eriştiğinde header kısmındaki "Dashboard" linkine tıklar
        easyBusTicketPage.dashboardButton.click();
        //3-Kullanıcı sayfasına eriştiğinde header kısmındaki "Profile".menüsünün görüldüğünü
        // doğrular.
        softAssert.assertTrue(easyBusTicketPage.dropDownProfile.isDisplayed(),"\"Profile\" menüsü görülemedi");
        //4-Profile menüsünün DDM olduğunu görüntüler ve üzerine geldiğinde DDM 'nün açıldığını
        // "change password" linkinin görüldüğünü ve aktif olduğunu doğrular.
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(easyBusTicketPage.dropDownProfile).perform();
        softAssert.assertTrue(easyBusTicketPage.linkChangePassword.isDisplayed(),"\"change password\" linki görülemedi");
        softAssert.assertTrue(easyBusTicketPage.linkChangePassword.isEnabled(),"\"change password\" linki aktif değil");

        Driver.closeDriver();
    }
}
