package tests.beytullah.US24;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void test1() {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();
        // "all users, active users, banned users, Email unverified, sms unverified"
        //  sayfalarındaki "User" başlığının altındaki kullanıcı adlarını görür
        manageUsersDDM.linkAllUsers.click();
        softAssert.assertTrue(manageUsersDDM.linkIlkKullaniciAdi.isDisplayed(),"All users'ta kullanıcı adları görülemedi");
        manageUsersDDM.linkActiveUsers.click();
        softAssert.assertTrue(manageUsersDDM.linkIlkKullaniciAdi.isDisplayed(),"Banned users'ta kullanıcı adları görülemedi");
        manageUsersDDM.linkBannedUsers.click();
        softAssert.assertTrue(manageUsersDDM.linkIlkKullaniciAdi.isDisplayed(),"Email unverified'ta kullanıcı adları görülemedi");
        manageUsersDDM.linkEmailUnverified.click();
        softAssert.assertTrue(manageUsersDDM.linkIlkKullaniciAdi.isDisplayed(),"Sms unverified'ta kullanıcı adları görülemedi");

        manageUsersDDM.linkAllUsers.click();
        // bir kullanıcı adına tıklar
        manageUsersDDM.linkIlkKullaniciAdi.click();
        // "User Detail" sayfası açılır
        String expectedUrl = "https://qa.easybusticket.com/admin/user/detail";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrl), "User Detail Sayfasına Ulaşılamadı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

}
