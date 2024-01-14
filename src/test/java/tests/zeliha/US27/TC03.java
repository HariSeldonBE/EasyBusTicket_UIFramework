package tests.zeliha.US27;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.driver;
import static utilities.Driver.getDriver;

public class TC03 {


    @Test
    public void ManualGateways (){

        /*
        TC02 - Admin Dashboard sayfasında "Payment Gateways" Linki altında,
        "Manual Gateways" Linki aktif olmalı ve içerdiği bilgiler görüntülenebilmeli

        STEPLER
        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	"Payment Gateways" linki tıklanır.
        5 -	"Manual Gateways" linki tıklanır.
        10 -"Gateway" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        11 -"Status" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        12 -"Action" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        13 -Arama Çubuğu öğesinin görünür ve aktif olduğu doğrulanır.
        13 -"add new" butonu görünür ve aktif olduğu doğrulanır.

         */

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        Actions actions = new Actions(Driver.getDriver());
        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        softAssert.assertTrue(adminDashBoardPage.spanPaymentGateways.isDisplayed(),"Pending Ticket linki Görüntülenemedi.");
        adminDashBoardPage.spanPaymentGateways.click();
        adminDashBoardPage.spanManualGateways.click();

        softAssert.assertTrue(adminDashBoardPage.thGateway2.isDisplayed(),"Gateways Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thStatus6.isDisplayed(),"Status Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thAction.isDisplayed(),"Action Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanDeneme.isDisplayed(),"Gateway Datası Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanDisabled.isDisplayed(),"Status Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.inputSearchTable2.isDisplayed(),"Arama Kutusu Görüntülenemedi.");
        adminDashBoardPage.inputSearchTable2.click();
        adminDashBoardPage.inputSearchTable2.sendKeys("deneme");
        adminDashBoardPage.inputSearchTable2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);


        Driver.quitDriver();
    }

}
