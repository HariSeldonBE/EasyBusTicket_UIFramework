package tests.beytullah.US23;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC04 extends TestBaseRapor {
    @Test
    public void test() {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert=new SoftAssert();
        extentTest=extentReports.createTest("Tüm kullanıcılara mail gönderme", "Kullanıcılara mail göndermek için butona tıklandığında gönderildi mesajı gelmiyor");

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        extentTest.info("URL'e gider");

        ReusableMethods.adminLoginMethod("admin14", "123123123");
        extentTest.info("Admin bilgilerini girer");

        manageUsersDDM.dropDownManageUsers.click();
        extentTest.info("\"Manage Users\" DDM'e tıklar");

        manageUsersDDM.linkEmailToAll.click();
        extentTest.info("\"Email to All\" linkine tıklar");

        ReusableMethods.wait(2);
        manageUsersDDM.inputSubjectText.isDisplayed();
        manageUsersDDM.inputMessageText.isDisplayed();
        manageUsersDDM.buttonSendEmail.isDisplayed();

        extentTest.info("\"Subject\" ve \"Message\" text boxlarını ve \"Send Email\" butonunu görür");
        manageUsersDDM.inputSubjectText.click();
        manageUsersDDM.inputSubjectText.sendKeys("merhaba" + Keys.TAB);
        manageUsersDDM.inputMessageText.sendKeys("merhaba");
        extentTest.info("\"Subject\" ve \"Message\" text boxlarına tıklar ve Text boxları doldurur");

        manageUsersDDM.buttonSendEmail.click();
        extentTest.info("\"Send Email\" butonuna tıklar");

        ReusableMethods.wait(2);
        softAssert.assertTrue(manageUsersDDM.alert.isDisplayed(),"Başarılı veya başarısız mesajı görüntülenmedi");
        extentTest.info("Tüm kullanıcılara başarıyla mail gönderir");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
