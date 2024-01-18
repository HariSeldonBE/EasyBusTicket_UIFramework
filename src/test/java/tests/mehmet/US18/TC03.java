package tests.mehmet.US18;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;

public class TC03 {
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
        // 3-Kullanıcı sayfasının header kısmındaki Profile menüsünden "change password" linkine tıklar
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(easyBusTicketPage.dropDownProfile).perform();
        easyBusTicketPage.linkChangePassword.click();
        // 3-Açılan sayfanın üst yarısında "Change password" yazısının arka planında görsel, alt tarafında change password penceresi olduğunu doğrular.
        softAssert.assertTrue(easyBusTicketPage.imageBackgroundChangePassword.isDisplayed(),"\"Change password\" yazısının arka planında görsel görülemedi");
        JSUtilities.scrollToElement(Driver.getDriver(),easyBusTicketPage.formChangePasswordPenceresi);
        softAssert.assertTrue(easyBusTicketPage.formChangePasswordPenceresi.isDisplayed());

        Driver.closeDriver();
    }
}
