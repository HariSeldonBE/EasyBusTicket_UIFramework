package tests.beytullah.US24;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {
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
        // "All Users" linkine tıklar
        manageUsersDDM.linkAllUsers.click();
        //"Actions" başlığının altında TV simgesini görür ve tıklar
        softAssert.assertTrue(manageUsersDDM.linkEmailDetail.isDisplayed(), "Actions başlığının altında TV simgesi görünmedi");
        manageUsersDDM.linkEmailDetail.click();
        //"Email Detail" sayfasına ulaşır
        String expectedTitle="Email Detail";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Email Detail sayfasına ulaşılamadı");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
