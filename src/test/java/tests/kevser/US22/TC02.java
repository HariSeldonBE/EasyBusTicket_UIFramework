package tests.kevser.US22;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashboardUS22;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    @Test
    public void dashboardisVisibleTest() {
        // ---> TC02
        // Admin Dashboard'da yeralan, US22'de istenen Webelementlerin, View All Buton'larının aktif olduğu doğrulanmalı

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys("admin12");
        ReusableMethods.wait(1);
        adminLoginPage.passwordBox.sendKeys("123123123");
        ReusableMethods.wait(1);
        adminLoginPage.loginButton.click(); // Admin Dashboard sayfasına ulaştık.

        AdminDashboardUS22 adminDashboardUS22 = new AdminDashboardUS22();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(adminDashboardUS22.totalUserViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.totalVerifiedUserViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.totalEmailUnverifiedUsersViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.totalSMSUnverifiedUsersViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.successfulPeymentViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.pendingPaymentViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.rejectedPaymentViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.acVehicleViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.nonACVehicleViewButton.isEnabled());
        softAssert.assertTrue(adminDashboardUS22.totalCounterViewButton.isEnabled());

        ReusableMethods.wait(2);
        softAssert.assertAll();
        Driver.closeDriver();



    }

}
