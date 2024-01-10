package tests.zehra.US30;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {


    @Test
    public void CounterElementleri(){

        // Browser'ı açar
        // URL'e gider

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin11"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        // "Counter" linkine tıklar
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        adminDashBoardPage.linkCounter.click();

        // Açılan "All Counter" sayfasında "Name, Mobile Number,
        // City, Location, Status, Action" başlıklarını görüntüler

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminDashBoardPage.thName.isDisplayed(),"Name Görünmüyor");
        softAssert.assertTrue(adminDashBoardPage.thMobileNumber.isDisplayed(),"Mobile N Görünmüyor");
        softAssert.assertTrue(adminDashBoardPage.thCity.isDisplayed(),"City Görünmüyor");
        softAssert.assertTrue(adminDashBoardPage.thLocation.isDisplayed(),"Location Görünmüyor");
        softAssert.assertTrue(adminDashBoardPage.thStatus.isDisplayed(),"Status Görünmüyor");

        // Açılan "All Counter" sayfasında "Name, Mobile Number,
        // City, Location, Status, Action" başlıklarının içeriğini görüntüler

        softAssert.assertTrue(adminDashBoardPage.tdName.isDisplayed(),"Name Görünmüyor");
        softAssert.assertTrue(adminDashBoardPage.tdMobileNumber.isDisplayed(),"Mobile N Görünmüyor");
        softAssert.assertTrue(adminDashBoardPage.tdCity.isDisplayed(),"City Görünmüyor");
        softAssert.assertTrue(adminDashBoardPage.tdLocation.isDisplayed(),"Location Görünmüyor");
        softAssert.assertTrue(adminDashBoardPage.tdStatus.isDisplayed(),"Status Görünmüyor");


        softAssert.assertAll();
        Driver.quitDriver();



    }
}
