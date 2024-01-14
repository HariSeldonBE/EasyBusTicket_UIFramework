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
        // "all users, active users, banned users, Email unverified, sms unverified, email to al" sayfalarındaki "User" başlığının altındaki kullanıcı adlarını görür
        manageUsersDDM.linkAllUsers.click();
        // bir kullanıcı adına tıklar
        manageUsersDDM.linkKullaniciAdi.click();
        // "User Detail" sayfası açılır
        String expectedUrl = "https://qa.easybusticket.com/admin/user/detail";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrl), "User Detail Sayfasına Ulaşılamadı");

        String expectedTitle = "User Detail";
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle, "Title'lar aynı değil");
        // Kullanıcı bilgilerinin ayrıntılarını görüntüler
    }

    private String kullaniciAdiCikar(String metin) {
        int atIndex = metin.indexOf('@');
        if (atIndex != -1 && atIndex < metin.length() - 1) {
            return metin.substring(atIndex + 1).trim();
        }
        return "";
    }
}
