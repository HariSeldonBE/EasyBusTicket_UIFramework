package tests.beytullah.US24;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC04 extends TestBaseRapor {
    @Test
    public void test1() {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Hatalı karakter girişiyle kayıt yapma", "Kullnıcının biligilerini değiştirirken kabul edilmemesi gereken karakterler kabul ediliyor");

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        extentTest.info("URL'e gider");

        ReusableMethods.adminLoginMethod("admin14", "123123123");
        extentTest.info("Admin bilgilerini girer");

        manageUsersDDM.dropDownManageUsers.click();
        extentTest.info("\"Manage Users\" DDM'ye tıklar");

        manageUsersDDM.linkAllUsers.click();
        extentTest.info("\"All Users\" linkine tıklar");

        softAssert.assertTrue(manageUsersDDM.linkEmailDetail.isDisplayed(), "Actions başlığının altında TV simgesi görünmedi");
        manageUsersDDM.linkEmailDetail.click();
        extentTest.info("\"Actions\" başlığının altında TV simgesini görür ve tıklar");

        String expectedTitle = "Email Detail";
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle), "Email Detail sayfasına ulaşılamadı");
        extentTest.info("\"Email Detail\" sayfasına ulaşır");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
