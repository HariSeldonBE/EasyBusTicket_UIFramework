package tests.beytullah.US24;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.*;

import java.time.Duration;

public class TC05 extends TestBaseRapor {
    @Test
    public void test1() {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Send Email linki istene sayfaya ulaştırmıyor", "User Detail sayfasındaki Send Email linkine tıklandığında başka bir lik olan Login Logs'un sayfasına gidiliyor");

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        extentTest.info("URL'e gider");

        ReusableMethods.adminLoginMethod("admin14", "123123123");
        extentTest.info("Admin bilgilerini girer");

        manageUsersDDM.dropDownManageUsers.click();
        String manageUsersPage=Driver.getDriver().getWindowHandle();
        extentTest.info("\"Manage Users\" DDM'ye tıklar");

        manageUsersDDM.linkAllUsers.click();
        extentTest.info("\"All Users\" linkine tıklar");

        manageUsersDDM.linkIlkKullaniciAdi.click();
        extentTest.info("Herhangi bir kullanıcıya tıklar");

        softAssert.assertTrue(manageUsersDDM.buttonLoginLogs.isDisplayed());
        manageUsersDDM.buttonLoginLogs.click();
        extentTest.info("\"User Detail\" sayfasında  \"User Action\" panelinin altındaki\n" +
                " \"Login Logs\" linkini görüntüler tıklar");

        String expectedTitle1="User Login History";
        String actualTitle1=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle1.contains(expectedTitle1),"User Login History sayfasına ulasılamadi");
        extentTest.info("URL'e gider");
        Driver.getDriver().navigate().back();

        softAssert.assertTrue(manageUsersDDM.buttonSendEmailUserDetailPage.isDisplayed());
        manageUsersDDM.buttonSendEmailUserDetailPage.click();
        extentTest.info("\"User Detail\" sayfasında  \"User Action\" panelinin altındaki\n" +
                "        // \"Send Email\"  linkini görüntüler tıklar");

        String expectedTitle2="Send Email";
        String actualTitle2=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle2,expectedTitle2,"Send Email sayfasınsa ulasılamadi");
        extentTest.info("\"Send Email\" sayfası açılır ve email gönderir");
        Driver.getDriver().navigate().back();

        softAssert.assertTrue(manageUsersDDM.buttonLoginAsUser.isDisplayed());
        manageUsersDDM.buttonLoginAsUser.click();

        extentTest.info("\"User Detail\" sayfasında  \"User Action\" panelinin altındaki\n" +
                " \"Login as User\" linkini görüntüler tıklar");

        String expectedUrl="user/detail/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        JSUtilities.waitForPageLoadWithJS(Driver.getDriver(), Duration.ofSeconds(10));
        softAssert.assertTrue(actualUrl.contains(expectedUrl),"Kullanıcı olarak giriş yapılamadı");
        extentTest.info("Kullnıcı olarak giriş yapar");

        ReusableMethods.wait(2);
        Driver.getDriver().switchTo().window(manageUsersPage);
        softAssert.assertTrue(manageUsersDDM.buttonEmailLog.isDisplayed());
        manageUsersDDM.buttonEmailLog.click();
        extentTest.info("\"User Detail\" sayfasında  \"User Action\" panelinin altındaki\n" +
                " \"Email Log\" linkini görüntüler tıklar");

        String expectedTitle4="Email log";
        String actualTitle4=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle4.contains(expectedTitle4),"Email log sayfasına ulaşılamadı");
        extentTest.info("\"Email log\" sayfasına ulaşır");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
