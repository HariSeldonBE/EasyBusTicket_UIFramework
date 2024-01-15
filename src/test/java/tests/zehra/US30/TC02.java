package tests.zehra.US30;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.admin.AdminDashBoard_CounterPage;
import pages.admin.AdminLoginPage;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class TC02 extends TestBaseRapor {


    @Test
    public void CounterElementleri(){

        // Browser'ı açar
        // URL'e gider

        extentTest=extentReports.createTest("CounterElementleri TEST", " admin tests counterlinki ");

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin11"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        // "Counter" linkine tıklar
        AdminDashBoard_CounterPage adminDashBoard_counterPage = new AdminDashBoard_CounterPage();
        adminDashBoard_counterPage.linkCounter.click();

        // Açılan "All Counter" sayfasında "Name, Mobile Number,
        // City, Location, Status, Action" başlıklarını görüntüler

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminDashBoard_counterPage.thName.isDisplayed(),"Name Görünmüyor");
        softAssert.assertTrue(adminDashBoard_counterPage.thMobileNumber.isDisplayed(),"Mobile N Görünmüyor");
        softAssert.assertTrue(adminDashBoard_counterPage.thCity.isDisplayed(),"City Görünmüyor");
        softAssert.assertTrue(adminDashBoard_counterPage.thLocation.isDisplayed(),"Location Görünmüyor");
        softAssert.assertTrue(adminDashBoard_counterPage.thStatus.isDisplayed(),"Status Görünmüyor");

        // Açılan "All Counter" sayfasında "Name, Mobile Number,
        // City, Location, Status, Action" başlıklarının içeriğini görüntüler

        softAssert.assertTrue(adminDashBoard_counterPage.tdName.isDisplayed(),"Name Görünmüyor");
        softAssert.assertTrue(adminDashBoard_counterPage.tdMobileNumber.isDisplayed(),"Mobile N Görünmüyor");
        softAssert.assertTrue(adminDashBoard_counterPage.tdCity.isDisplayed(),"City Görünmüyor");
        softAssert.assertTrue(adminDashBoard_counterPage.tdLocation.isDisplayed(),"Location Görünmüyor");
        softAssert.assertTrue(adminDashBoard_counterPage.tdStatus.isDisplayed(),"Status Görünmüyor");


        softAssert.assertAll();
        Driver.quitDriver();



    }
}
