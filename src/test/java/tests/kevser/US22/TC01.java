package tests.kevser.US22;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashboardUS22;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys("admin12");
        ReusableMethods.wait(1);
        adminLoginPage.passwordBox.sendKeys("123123123");
        ReusableMethods.wait(1);
        adminLoginPage.loginButton.click(); // Admin Dashboard sayfasına ulaştık.

        // --> TC01
        // Admin Dashboard'daki, US22'de istenen elementlerin görüntülenebilir olduğunun doğrulanması:

        AdminDashboardUS22 adminDashboardUS22 = new AdminDashboardUS22();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminDashboardUS22.totalUser.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.totalVerifiedUser.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.totalEmailUnverifiedUsers.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.totalSMSUnverifiedUsers.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.successfulPeyment.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.pendingPayment.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.rejectedPayment.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.acVehicle.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.nonACVehicle.isDisplayed());
        softAssert.assertTrue(adminDashboardUS22.totalCounter.isDisplayed());

        ReusableMethods.wait(3);
        Driver.closeDriver();


    }
}
