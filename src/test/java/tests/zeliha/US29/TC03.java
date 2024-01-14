package tests.zeliha.US29;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class TC03 {


    @Test
    public void LocationFind() {

    /*
    TC03 - Login History linkinden siteye giren bir kullanıcının
    IP'sinden coğrafi konum bilgilerini görme

    STEPLER

    1 - Browser açılır.
    2 -	URL'e gidilir.
    3 -	Admin olarak giriş yapılır.
    4 -	"Report"  linki tıklanır.
    5 -	"Login History" linki tıklanır.
    6 -	İstenen IP ye tıklar
    7 -	Ip History sayfası görünür oldugu doğrulanır.
    8 -	"Lookup IP" butonunu görünür ve aktif olduğu doğrulanır.
    9 -	"ip2location.com" sayfasında kullanıcının coğrafi konum bilgilerini görüntülrndiği doğrulanır.

    */

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        Actions actions = new Actions(Driver.getDriver());

        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        softAssert.assertTrue(adminDashBoardPage.reportButton.isDisplayed(),"Report linki Görüntülenemedi.");
        adminDashBoardPage.reportButton.click();
        adminDashBoardPage.spanLoginHistory.click();
        ReusableMethods.wait(2);
        adminDashBoardPage.itdLocationLink.click();
        Driver.getDriver().get(ConfigReader.getProperty("ipLocationUrl"));
        adminDashBoardPage.locationbuttonClick.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertTrue(adminDashBoardPage.td2.isDisplayed(),"Locasyon bilgisi Görüntülenemedi.");

        Driver.quitDriver();



    }
}
