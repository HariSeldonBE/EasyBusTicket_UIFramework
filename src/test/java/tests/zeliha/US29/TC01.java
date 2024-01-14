package tests.zeliha.US29;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void Report(){
        /*
        TC - Admin olarak giriş yapıldığında "Report" menüsü görüntülenebilmeli.

        STEPLER

        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	Dashboard sayfasının solunda  " "Report" " linkinin görünür olduğu doğrulanır.
        5 -	"Report"  linki tıklanır.
        6 -	"Report"  Linkine tıklandığında, "Login History" linkinin görünür ve aktif olduğu doğrulanır.
        7 -	"Report"  Linkine tıklandığında, "Email History" linkinin görünür ve aktif olduğu doğrulanır.

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

        softAssert.assertTrue(adminDashBoardPage.spanLoginHistory.isDisplayed(),"Login History linki Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanAutomaticGateways.isEnabled(),"Login History linki Aktif Değil.");

        softAssert.assertTrue(adminDashBoardPage.spanEmailHistory.isDisplayed(),"E mail History linki Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanEmailHistory.isEnabled(),"Email history linki Aktif Değil.");

        Driver.quitDriver();







    }

}
