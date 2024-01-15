package tests.zeliha.US29;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC04 {

    @Test
    public void EmailHistory() {

    /*
    TC04 - Admin Dashboard menüsünde "Report" menüsü altında bulunan
    "Email History" sayfasındaki bilgiler görüntülenebilmeli.

    STEPLER

    1 - Browser açılır.
    2 -	URL'e gidilir.
    3 -	Admin olarak giriş yapılır.
    4 -	"Report"  linki tıklanır.
    5 -	"Email History" linki tıklanır.
    6 -	"Email history" başlığının görünür olduğu doğrulanır.
    7 -	"User" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    8 -	"User" başlık öğesinin altındaki kullanıcı bilgisinin aktif olduğu doğrulanır.
    9 -	"Sent"  başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    10 - "Mail Sender" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    11 - "Subject" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    12 - "Action" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
    13 - "Action" başlık öğesinin ve altındaki ikonun aktif olduğu doğrulanır.
    14 - Sayfa değiştirme elementlerinin görünür ve aktif olduğu doğrulanır."

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
        adminDashBoardPage.spanEmailHistory.click();

        softAssert.assertTrue(adminDashBoardPage.thUser6.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thSent.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thMailSender.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thSubject.isDisplayed(),"ElementGörüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thAction2.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanFontBold2.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdSent.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdMailSender.isDisplayed(),"ElementGörüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdSubject.isDisplayed(),"ElementDatası Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.iDesktop.isDisplayed(),"SElement Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.inputSearch3.isDisplayed(),"Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.iDesktop.isEnabled(),"");


        Driver.quitDriver();

    }
    }
