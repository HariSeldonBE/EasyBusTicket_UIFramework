package tests.kevser.US22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.admin.AdminDashboardUS22;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {

    @Test
    public void dashboardisActiveTesti() {

        // US22 / TC03
        // Admin Dahsboar'da bulunan:
        // Latest Booking History Tablosu'nun görünür olduğu doğrulanmalı.
        // "Details" Butonu tıklandığında, Booked History sayfasına ulaşılabildiği doğrulanmalı.

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys("admin12");
        ReusableMethods.wait(1);
        adminLoginPage.passwordBox.sendKeys("123123123");
        ReusableMethods.wait(1);
        adminLoginPage.loginButton.click(); // Admin Dashboard sayfasına ulaştık.

        AdminDashboardUS22 adminDashboardUS22 = new AdminDashboardUS22();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminDashboardUS22.latestBookingHistoryCard.isDisplayed());
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);
        adminDashboardUS22.latestBookingHistoryDetailButton.click();
        ReusableMethods.wait(2);

        String expectedURL = "https://qa.easybusticket.com/admin/ticket/booked";
        String actualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualURL, expectedURL);

        Driver.getDriver().navigate().back();

        // Last 30 Days Payment History Grafiğini görüntüleyebilmeliyim.
        adminDashboardUS22.last30DaysPaymentGrafik.isDisplayed();

        // Login By Browser Chart,
        // Login By OS Chart,
        // Login By Country Chart görünür olduklarının doğrulanması:
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        adminDashboardUS22.browserChart.isDisplayed();
        adminDashboardUS22.oSChart.isDisplayed();
        adminDashboardUS22.countryChart.isDisplayed();


        ReusableMethods.wait(2);
        softAssert.assertAll();
        Driver.closeDriver();

    }
}