package tests.zehra.US30;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.admin.AdminDashBoardPage;
import pages.admin.AdminDashBoard_CounterPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
     public void CounterLinki(){
        // Browser'ı açar
        // URL'e gider
        // Admin kullanıcı adını ve şifresini girer
        // Login butonuna tıklar
        // Trasport Manager menüsündeki Counter linkini görüntüler


        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin11"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
       AdminDashBoard_CounterPage adminDashBoard_counterPage = new AdminDashBoard_CounterPage();
        softAssert.assertTrue(adminDashBoard_counterPage.linkCounter.isDisplayed(),"Counter linki Görünmüyor");
        softAssert.assertAll();
        Driver.quitDriver();
        


}

}