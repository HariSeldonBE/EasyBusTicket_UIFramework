package tests.beytullah.US23;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void TC01() {

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        SoftAssert softAssert = new SoftAssert();
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        // Admin bilgileri ile siteye girer

        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();



        // Açılan DDM'de "all users, active users,banned users, Email unverified, sms unverified,
        // email to al" linklerine tıklar

        ReusableMethods.wait(3);
        manageUsersDDM.linkAllUsers.click();
        // Linklerin sayfalarını görüntüler
        String expectedUrl1 = "https://qa.easybusticket.com/admin/users";
        String actualUrl1 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl1, actualUrl1);

        manageUsersDDM.linkActiveUsers.click();
        // Linklerin sayfalarını görüntüler
        String expectedUrl2 = "https://qa.easybusticket.com/admin/users/active";
        String actualUrl2 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl2, actualUrl2);

        manageUsersDDM.linkBannedUsers.click();
        // Linklerin sayfalarını görüntüler
        String expectedUrl3 = "https://qa.easybusticket.com/admin/users/banned";
        String actualUrl3 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl3, actualUrl3);

        manageUsersDDM.linkEmailUnverified.click();
        // Linklerin sayfalarını görüntüler
        String expectedUrl4 = "https://qa.easybusticket.com/admin/users/email-unverified";
        String actualUrl4 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl4, actualUrl4);

        manageUsersDDM.linkSmsUnverified.click();
        // Linklerin sayfalarını görüntüler
        String expectedUrl5 = "https://qa.easybusticket.com/admin/users/sms-unverified";
        String actualUrl5 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl5, actualUrl5);

        manageUsersDDM.linkEmailToAll.click();
        // Linklerin sayfalarını görüntüler
        String expectedUrl6 = "https://qa.easybusticket.com/admin/users/send-email";
        String actualUrl6 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl6, actualUrl6);
        ReusableMethods.wait(3);
        Driver.closeDriver();
    }
}
