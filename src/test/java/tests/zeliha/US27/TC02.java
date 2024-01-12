package tests.zeliha.US27;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    @Test
    public void AutomaticGatewaysLinki (){

        /*
        TC02 - Admin Dashboard sayfasında "Payment Gateways" Linki altında,
        "Automatic Gateways" Linki aktif olmalı ve içerdiği bilgiler görüntülenebilmeli.

        STEPLER

        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	"Payment Gateways" linki tıklanır.
        5 -	"Automatic Gateways" linki tıklanır.
        6 -	"Automatic Gateways" başlığının görünür olduğu doğrulanır.
        7 -	"Gateway" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        8 -	"Supported Currency"  başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        9 -	"Enabled Currency" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        10 - "Status" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        11 - Arama Çubuğu öğesinin görünür ve aktif olduğu doğrulanır.

         */

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        softAssert.assertTrue(adminDashBoardPage.bookingHistoryButton.isDisplayed(),"Booking History linki Görüntülenemedi.");
        adminDashBoardPage.bookingHistoryButton.click();

        softAssert.assertTrue(adminDashBoardPage.spanPaymentGateways.isDisplayed(),"Pending Ticket linki Görüntülenemedi.");
        adminDashBoardPage.spanPaymentGateways.click();
        adminDashBoardPage.spanAutomaticGateways.click();

        softAssert.assertTrue(adminDashBoardPage.thGateway.isDisplayed(),"Gateways Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thSupportedCurrency.isDisplayed(),"Supported Currency Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thEnabledCurrency.isDisplayed(),"Enabled Currancy  Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thStatus5.isDisplayed(),"Status Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanName.isDisplayed(),"Gateways Datası Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdSupportedCurrency.isDisplayed(),"Supported Currency Datası Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdEnabledCurrency.isDisplayed(),"Enabled Currency Datası Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdStatus3.isDisplayed(),"Status Datası Görüntülenemedi.");


        softAssert.assertTrue(adminDashBoardPage.inputSearchTable.isDisplayed(),"Arama Kutusu Görüntülenemedi.");
        adminDashBoardPage.inputSearchTable.click();
        ReusableMethods.wait(2);
        adminDashBoardPage.inputSearchTable.sendKeys("deneme");
        adminDashBoardPage.inputSearchTable.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();



        Driver.quitDriver();




    }
}
