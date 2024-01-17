package tests.zeliha.US28;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC03 {

    @Test
    public void PendingRequestTesti(){

/*      TC - Admin Dashboard menüsünde Support Request menüsü altında bulunan
        "Pending Request" sayfasındaki talepler görüntülenebilmeli.
        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	"Support Requests" linki tıklanır.
        5 -	"Pending Request" linki tıklanır.
        6 -	"Pending Request" başlığının görünür olduğu doğrulanır.
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

        softAssert.assertTrue(adminDashBoardPage.spanPendingRequests.isDisplayed(),"Link Görüntülenemedi.");
        adminDashBoardPage.spanPendingRequests.click();

        softAssert.assertTrue(adminDashBoardPage.thSubject3.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thSubmitted2.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thStatus8.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thPriority2.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thLastReply2.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thAction4.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanHigh2.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdLastReply2.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanOpen2.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdSubmitted.isDisplayed(),"Link Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdSubject2.isDisplayed(),"Link Görüntülenemedi.");

        Driver.quitDriver();

    }




}
