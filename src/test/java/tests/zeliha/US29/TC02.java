package tests.zeliha.US29;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    @Test
    public void LoginHistory() {

    /*
    TC02 - Admin Dashboard menüsünde "Report" menüsü altında bulunan
    "User Login History" sayfasındaki bilgiler görüntülenebilmeli.

    STEPLER

    1 - Browser açılır.
    2 -	URL'e gidilir.
    3 -	Admin olarak giriş yapılır.
    4 -	"Report" linki tıklanır.
    5 -	"Login History" linki tıklanır.
    6 -	"User Login History" başlığının görünür olduğu doğrulanır.
    7 -	"User" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    8 -	"User" başlık öğesinin altındaki kullanıcı bilgisinin aktif olduğu doğrulanır.
    9 -	"Login at"  başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    10 - "IP" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    11 - "Location" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    12 - "Browser | OS" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    13 - "Arama Kutusu" öğesinin görünür ve aktif olduğu doğrulanır.
    14 - Sayfa değiştirme elementlerinin görünür ve aktif olduğu doğprulanır.

     */

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        softAssert.assertTrue(adminDashBoardPage.reportButton.isDisplayed(),"Report linki Görüntülenemedi.");
        adminDashBoardPage.reportButton.click();
        adminDashBoardPage.spanLoginHistory.click();

        softAssert.assertTrue(adminDashBoardPage.thUser5.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thLogin.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.th.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thLocation2.isDisplayed(),"ElementGörüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thBrowser.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanAzimKaya.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdLogin.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.td.isDisplayed(),"ElementGörüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdLocation2.isDisplayed(),"ElementDatası Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdBrowser.isDisplayed(),"SElement Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.inputSearch3.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.inputSearch3.isEnabled(),"");

        Driver.quitDriver();







    }
}
