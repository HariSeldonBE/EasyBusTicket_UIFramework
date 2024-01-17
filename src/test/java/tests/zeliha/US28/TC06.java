package tests.zeliha.US28;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC06 extends TestBaseRapor {

    @Test
    public void ActionsButonuTesti(){

        /*

        TC06 - Admin Dashboard menüsünde Support Request menüsü altında bulunan
        "Answered Request" sayfasındaki "actions" butonu ile ulaşılan
        "Reply Request" sayfasındaki detaylar görüntülenebilmeli ve işlevlerini yerine getirebilmeli.

        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	"Support Requests" linki tıklanır.
        5 -	"Pending Request" linki tıklanır.
        6 -	"Action Details" ikonun tıklanır.
        7 -	"Reply Request" başlığının görünür olduğu doğrulanır.
        8 -	"Go Back"  butonunun görünür ve aktif olduğu doğrulanır.
        9 -	Bilet no başlığının görünür olduğu doğrulanır.
        10 - "Your nessage" text box'ının görünür ve aktif olduğu doğrulanır.
        11 - "Select Your File" butonunun görünür ve aktif olduğu doğrulanır.
        12 - "Dosya sayısını arttırma" butonunun görünür ve aktif olduğu doğrulanır.
        13 - "Replay" butonunun görünür ve aktif olduğu doğrulanır.
        14 - "Delete" butonunun görünür ve aktif olduğu doğrulanır.


         */

        extentTest=extentReports.createTest("Zeliha Selçuk / "+" Answering Support Request TEST",
                "TC06 - Admin Dashboard menüsünde Support Request menüsü altında bulunan\n" +
                        "        \"Answered Request\" sayfasındaki \"actions\" butonu ile ulaşılan\n" +
                        "        \"Reply Request\" sayfasındaki detaylar görüntülenebilmeli ve\n" +
                        "        \"işlevlerini yerine getirebilmeli.");

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        Actions actions = new Actions(Driver.getDriver());
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();
        extentTest.pass("PASSED");

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

        softAssert.assertTrue(adminDashBoardPage.supportRequestButton.isDisplayed(),"Link Görüntülenemedi.");
        adminDashBoardPage.supportRequestButton.click();
        extentTest.pass("PASSED");

        softAssert.assertTrue(adminDashBoardPage.spanPendingRequests.isDisplayed(),"Link Görüntülenemedi.");
        adminDashBoardPage.spanPendingRequests.click();
        extentTest.pass("PASSED");

        adminDashBoardPage.tdAction.click();
        extentTest.pass("PASSED");
        ReusableMethods.wait(2);

        adminDashBoardPage.yourmessage.click();
        adminDashBoardPage.yourmessage.sendKeys("Biletiniz ile ilgili talep ettiğiniz değişiklik yapılmıştır.\n" +
                "\n" +
                "Teşekkür ederiz.");
        extentTest.pass("PASSED");
        ReusableMethods.wait(2);


        adminDashBoardPage.uploadBox.sendKeys("C:\\Users\\zelihaselcuk\\Desktop\\Document.docx");
        extentTest.pass("Document.docx Uploaded");
        ReusableMethods.wait(2);

        adminDashBoardPage.buttonReplayTicket.click();
        ReusableMethods.wait(10);

        softAssert.assertTrue(adminDashBoardPage.repliedAllertYesil.isDisplayed());
        extentTest.pass("PASSED");

        extentTest.info("Closed page");
        Driver.quitDriver();


    }
}
