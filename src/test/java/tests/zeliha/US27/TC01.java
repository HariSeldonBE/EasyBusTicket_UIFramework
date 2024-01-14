package tests.zeliha.US27;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {


    @Test
    public void AllTicketLinki() {

        /*
        TC01 - Admin olarak giriş yapıldığında "Payment Gateways" menüsü görüntülenebilmeli.

        STEPLER

        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	Dashboard sayfasının solunda  "Payment Gateways" linkinin görünür olduğu doğrulanır.
        5 -	"Payment Gateways" linki tıklanır.
        6 -	"Payment Gateways" Linkine tıklandığında, "Automatic Gateways" linkinin görünür ve aktif olduğu doğrulanır.
        7 -	"Payment Gateways" Linkine tıklandığında, "Manual Gateways" linkinin görünür ve aktif olduğu doğrulanır.

         */

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        Actions actions = new Actions(Driver.getDriver());
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        softAssert.assertTrue(adminDashBoardPage.spanPaymentGateways.isDisplayed(),"Booking History linki Görüntülenemedi.");
        adminDashBoardPage.spanPaymentGateways.click();

        softAssert.assertTrue(adminDashBoardPage.spanAutomaticGateways.isDisplayed(),"Pending Ticket linki Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanAutomaticGateways.isEnabled(),"Pending Ticket linki Aktif Değil.");

        softAssert.assertTrue(adminDashBoardPage.spanManualGateways.isDisplayed(),"Booked Ticket linki Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanManualGateways.isEnabled(),"Booked Ticket linki Aktif Değil.");

        Driver.quitDriver();

}}
