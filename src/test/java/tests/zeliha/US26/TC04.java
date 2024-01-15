package tests.zeliha.US26;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {

    @Test
    public void RejectedTicketLinki() {
        /*
        TC04 - Admin Dashboard sayfasında "Booking History" Linki altında,
        "Rejected Ticket" Linki aktif olmalı ve içerdiği bilgiler görüntülenebilmeli.

        STEPLER
        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	"Booking History" linki tıklanır.
        5 -	"Rejected Ticket" linki tıklanır.
        6 -	"Rejected Ticket" başlığının görünür olduğu doğrulanır.
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
        18 - Sayfa değiştirme öğelerinin görünür ve aktif olduğu doğrulanır.

         */

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        Actions actions = new Actions(Driver.getDriver());
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

        softAssert.assertTrue(adminDashBoardPage.bookingHistoryButton.isDisplayed(), "Booking History linki Görüntülenemedi.");
        adminDashBoardPage.bookingHistoryButton.click();

        softAssert.assertTrue(adminDashBoardPage.rejectedTicketButton.isDisplayed(),"Booking History linki Görüntülenemedi.");
        adminDashBoardPage.rejectedTicketButton.click();

        softAssert.assertTrue(adminDashBoardPage.thUser3.isDisplayed(), "User Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanSymbol.isDisplayed(), "User Datası Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanSymbol2.isDisplayed(), "");

        softAssert.assertTrue(adminDashBoardPage.thNumber2.isDisplayed(), "PNR Number Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdNumber.isDisplayed(), "PNR Number Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.thJourneyDate3.isDisplayed(), "JourneyDate Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdJourneyDate2.isDisplayed(), "JourneyDate Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.thTrip3.isDisplayed(), "Trip Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanLuxBus.isDisplayed(), "Trip Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.thPickupPoint3.isDisplayed(), "Pickup Point Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdPickupPoint2.isDisplayed(), "Pickup Point Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.thDroppingPoint3.isDisplayed(), "Dropping Point Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdDroppingPoint2.isDisplayed(), "Dropping Point Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.thStatus3.isDisplayed(), "Status Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanRejected.isDisplayed(), "Status Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.thTicketCount3.isDisplayed(), "Ticket Count Başlığı  Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdTicketCount2.isDisplayed(), "Ticket Count Datası  Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.thFare3.isDisplayed(), "Fare Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.tdFare2.isDisplayed(), "Fare Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.inputSearch.isDisplayed(), "Arama Kutusu Görüntülenemedi.");
        adminDashBoardPage.inputSearch.click();
        ReusableMethods.wait(1);
        adminDashBoardPage.inputSearch.sendKeys("deneme");
        adminDashBoardPage.iSearch.click();
        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        Driver.getDriver().navigate().refresh();

        /*
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);
        softAssert.assertTrue(adminDashBoardPage.sayfadegistirme2butonu.isDisplayed(), "Sayfa Değiştirme Butonu Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.sayfadegistirme2butonu.isEnabled(),"Buton Çalışmıyor");
        */

        Driver.quitDriver();





}
}
