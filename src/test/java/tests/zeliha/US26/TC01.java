package tests.zeliha.US26;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {

    @Test
    public void BookingHistoryLinki(){
         /*
        TC01 - Admin olarak giriş yapıldığında
        "Booking History" menüsü görüntülenebilmeli.

        STEPLER
        1 - Browser açılır.
        2 -	URL'e gidilir.
        3 -	Admin olarak giriş yapılır.
        4 -	Dashboard sayfasının solunda "Booking History" linkinin görünür olduğu doğrulanır.
        5 -	"Booking History" linki tıklanır.
        6 -	"Booking History" Linkine tıklandığında, "Pending Ticket" linkinin görünür ve aktif olduğu doğrulanır.
        7 -	"Booking History" Linkine tıklandığında, "Booked Ticket" linkinin görünür ve aktif olduğu doğrulanır.
        8 -	"Booking History" Linkine tıklandığında, "Rejected Ticket" linkinin görünür ve aktif olduğu doğrulanır.
        9 -	"Booking History" Linkine tıklandığında, "All Ticket" linkinin görünür ve aktif olduğu doğrulanır.

       */
        extentTest=extentReports.createTest("Zeliha Selçuk / "+"Booking History Button TEST", "Is 'Booking History Button' is worked?");
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        extentTest.info("User goes to \"Easy Bus Ticket\" AdminDashboard Booking History page");
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        softAssert.assertTrue(adminDashBoardPage.bookingHistoryButton.isDisplayed(),"Booking History linki Görüntülenemedi.");
        adminDashBoardPage.bookingHistoryButton.click();

        softAssert.assertTrue(adminDashBoardPage.pendingTicketButton.isDisplayed(),"Pending Ticket linki Görüntülenemedi.");
        extentTest.pass("PASSED");
        softAssert.assertTrue(adminDashBoardPage.pendingTicketButton.isEnabled(),"Pending Ticket linki Aktif Değil.");


        softAssert.assertTrue(adminDashBoardPage.bookedTicketButton.isDisplayed(),"Booked Ticket linki Görüntülenemedi.");
        extentTest.pass("PASSED");
        softAssert.assertTrue(adminDashBoardPage.bookedTicketButton.isEnabled(),"Booked Ticket linki Aktif Değil.");

        softAssert.assertTrue(adminDashBoardPage.rejectedTicketButton.isDisplayed(),"Rejected Ticket linki Görüntülenemedi.");
        extentTest.pass("PASSED");
        softAssert.assertTrue(adminDashBoardPage.rejectedTicketButton.isEnabled(),"Rejected Ticket linki Aktif Değil.");

        softAssert.assertTrue(adminDashBoardPage.allTicketButton.isDisplayed(),"All Ticket linki Görüntülenemedi.");
        extentTest.pass("PASSED");
        softAssert.assertTrue(adminDashBoardPage.allTicketButton.isEnabled(),"All Ticket linki Aktif Değil.");

        Driver.quitDriver();
        extentTest.info("Closed page");



    }

}
