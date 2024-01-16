package tests.zeliha.US28;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC04 {

    @Test
    public void ClosedRequestTesti(){

        /*
        TC04 - Admin Dashboard menüsünde Support Request menüsü altında bulunan
        "Closed Request" sayfasındaki talepler görüntülenebilmeli.

        STEPLER

        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	"Support Requests" linki tıklanır.
        5 -	"Closed Request" linki tıklanır.
        6 -	"Closed Request" başlığının görünür olduğu doğrulanır.
        7 -	"Subject" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        8 -	"Submitted By"  başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        9 -	"Status" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        10 - "Priority" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        11 - "Last Reply" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        12 - "Action" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        13 - "Action Details" ikonunun aktif olduğu doğrulanır.

        */


        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        Actions actions = new Actions(Driver.getDriver());
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

        softAssert.assertTrue(adminDashBoardPage.supportRequestButton.isDisplayed(),"Link Görüntülenemedi.");
        adminDashBoardPage.supportRequestButton.click();

        softAssert.assertTrue(adminDashBoardPage.spanClosedRequests.isDisplayed(),"Link Görüntülenemedi.");
        adminDashBoardPage.spanClosedRequests.click();

        softAssert.assertTrue(adminDashBoardPage.thSubject4.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thSubmitted3.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thStatus9.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thPriority3.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thLastReply3.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thAction5.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdSubject3.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdSubmitted2.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdStatus4.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdPriority.isDisplayed(),"Web Element Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdLastReply3.isDisplayed(),"Web Element Görüntülenemedi.");


        Driver.quitDriver();
    }
}
