package tests.zeliha.US26;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class TC02 {

    @Test
    public void PendingTicketLinki() {
    /*
    TC02 - Admin Dashboard sayfasında "Booking History" Linki altında,
    "Pending Ticket" Linki aktif olmalı ve içerdiği bilgiler görüntülenebilmeli

    STEPLER
        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	"Booking History" linki tıklanır.
        5 -	"Pending Ticket" linki tıklanır.
        6 -	"Pending Ticket" başlığının görünür olduğu doğrulanır.
        7 -	"User" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        8 -	"User" başlık öğesinin altındaki kullanıcı bilgisinin aktif olduğu doğrulanır.
        9 -	"PNR Number"  başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        10 - "Journey Date" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        11 - "Trip" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        12 - "Pickup Point" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        13 - "Dropping Point" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        14 - "Status" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        15 - "Ticket Count" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        16 - "Fare" başlık öğesinin ve altındaki ilgili bilet bilgisinin görünür olduğu doğrulanır.
        17 - Arama Çubuğu öğesinin görünür ve aktif olduğu doğrulanır.

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

        softAssert.assertTrue(adminDashBoardPage.headerPendingTicket.isDisplayed(),"Pending Ticket linki Görüntülenemedi.");
        adminDashBoardPage.pendingTicketButton.click();

        softAssert.assertTrue(adminDashBoardPage.thUser.isDisplayed(),"User Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thPNRNumber.isDisplayed(),"PNR Number Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thJourneyDate.isDisplayed(),"JourneyDate Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thTrip.isDisplayed(),"Trip Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thPickupPoint.isDisplayed(),"Pickup Point Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thDroppingPoint.isDisplayed(),"Dropping Point Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thStatus.isDisplayed(),"Status Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thTicketCount.isDisplayed(),"Ticket Count Başlığı  Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thFare.isDisplayed(),"Fare Başlığı Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.aramaKutusu.isDisplayed(),"Arama Kutusu Görüntülenemedi.");
        adminDashBoardPage.aramaKutusu.click();
        ReusableMethods.wait(2);

        adminDashBoardPage.aramaKutusu.sendKeys("deneme");
        adminDashBoardPage.aramaButtonu.click();
        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();



        Driver.quitDriver();




    }

}
