package tests.beytullah.US23;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {
    @Test
    public void test() {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert=new SoftAssert();

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();
        // Email to All linkine tıklar
        manageUsersDDM.linkEmailToAll.click();
        // "Subject" ve "Message" text boxlarını ve "Send Email" butonunu görür
        ReusableMethods.wait(2);
        manageUsersDDM.inputSubjectText.isDisplayed();
        manageUsersDDM.inputMessageText.isDisplayed();
        manageUsersDDM.buttonSendEmail.isDisplayed();
        // "Subject" ve "Message" text boxlarına tıklar ve Text boxları doldurur
        manageUsersDDM.inputSubjectText.click();
        manageUsersDDM.inputSubjectText.sendKeys("merhaba" + Keys.TAB);
        manageUsersDDM.inputMessageText.sendKeys("merhaba");

        // "Send Email" butonuna tıklar
        manageUsersDDM.buttonSendEmail.click();
        // Tüm kullanıcılara başarıyla mail gönderir
        ReusableMethods.wait(2);
        softAssert.assertTrue(manageUsersDDM.alert.isDisplayed(),"Başarılı veya başarısız mesajı görüntülenmedi");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
