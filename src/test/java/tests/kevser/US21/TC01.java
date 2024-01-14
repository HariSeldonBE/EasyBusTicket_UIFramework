package tests.kevser.US21;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void test01(){

        //1-https://www.easybusticket.com/admin linki ile admin Login sayfasına ulaşabilmeliyim
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));

        //2-Admin Login sayfasındaki forma doğru bilgileri girerek, Admin Dahsboard sayfasına ulaşabilmeliyim
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys("admin12");
        ReusableMethods.wait(2);
        adminLoginPage.passwordBox.sendKeys("123123123");
        ReusableMethods.wait(2);
        adminLoginPage.loginButton.click();
        ReusableMethods.wait(2);

        // Admin'in başarılı bir şekilde login olabildiğini ve doğru sayfaya ulaştığını doğrulamalıyım.
        // 1.YOL: Navbar'da "admin12"nin giriş yaptığı görünür olmalı
        Assert.assertTrue(adminLoginPage.admin12Navbar.isDisplayed());

        // 2.YOL: Beklenen sayfanın açıldığı doğrulanmalı (Assert.assertEqual)
        String expectedUrl = "https://qa.easybusticket.com/admin/dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.closeDriver();

    }
}
