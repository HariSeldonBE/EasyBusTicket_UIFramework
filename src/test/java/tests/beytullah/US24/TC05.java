package tests.beytullah.US24;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC05 {
    @Test
    public void test1(){
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();
        String manageUsersPage=Driver.getDriver().getWindowHandle();
        // "All Users" linkine tıklar
        manageUsersDDM.linkAllUsers.click();
        // Herhangi bir kullanıcıya tıklar
        manageUsersDDM.linkIlkKullaniciAdi.click();
        //"User Detail" sayfasında  "User Action" panelinin altındaki
        // "Login Logs" linkini görüntüler tıklar

        softAssert.assertTrue(manageUsersDDM.buttonLoginLogs.isDisplayed());
        manageUsersDDM.buttonLoginLogs.click();
        //"User Login History" sayfasına ulaşır
        String expectedTitle1="User Login History";
        String actualTitle1=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle1.contains(expectedTitle1),"User Login History sayfasına ulasılamadi");
        Driver.getDriver().navigate().back();

        //"User Detail" sayfasında  "User Action" panelinin altındaki
        // "Send Email"  linkini görüntüler tıklar
        softAssert.assertTrue(manageUsersDDM.buttonSendEmailUserDetailPage.isDisplayed());
        manageUsersDDM.buttonSendEmailUserDetailPage.click();
        //"Send Email" sayfası açılır ve email gönderir
        String expectedTitle2="Send Email";
        String actualTitle2=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle2,expectedTitle2,"Send Email sayfasınsa ulasılamadi");
        Driver.getDriver().navigate().back();

        //"User Detail" sayfasında  "User Action" panelinin altındaki
        // "Login as User" linkini görüntüler tıklar
        softAssert.assertTrue(manageUsersDDM.buttonLoginAsUser.isDisplayed());
        manageUsersDDM.buttonLoginAsUser.click();
        //Kullnıcı olarak giriş yapar
        String expectedTitle3=" Easy Bus Ticket - Dashboard";
        String actualTitle3=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle3.contains(expectedTitle3),"Kullanıcı olarak giriş yapılamadı");

        //"User Detail" sayfasında  "User Action" panelinin altındaki
        // "Email Log" linkini görüntüler tıklar
        ReusableMethods.wait(2);
        Driver.getDriver().switchTo().window(manageUsersPage);
        softAssert.assertTrue(manageUsersDDM.buttonEmailLog.isDisplayed());
        manageUsersDDM.buttonEmailLog.click();
        //"Email log" sayfasına ulaşır
        String expectedTitle4="Email log";
        String actualTitle4=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle4.contains(expectedTitle4),"Email log sayfasına ulaşılamadı");

        softAssert.assertAll();
        Driver.closeDriver();
    }
}
