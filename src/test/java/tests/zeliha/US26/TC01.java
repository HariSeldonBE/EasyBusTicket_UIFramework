package tests.zeliha.US26;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void BookingHistoryLinki(){
         /*

       Browser açılır
       URL'e gidilir.
       Admin olarak giriş yapılır.
       Dashboard sayfasının solunda "Booking History" linkinin görünür olduğu doğrulanır.
       "Booking History" linki tıklanır.
       "Booking History" Linkine tıklandığında, "Pending Ticket" linkinin görünür ve aktif olduğu doğrulanır.
       "Booking History" Linkine tıklandığında, "Booked Ticket" linkinin görünür ve aktif olduğu doğrulanır.
       "Booking History" Linkine tıklandığında, "Rejected Ticket" linkinin görünür ve aktif olduğu doğrulanır.
       "Booking History" Linkine tıklandığında, "All Ticket" linkinin görünür ve aktif olduğu doğrulanır.

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

        softAssert.assertTrue(adminDashBoardPage.pendingTicketButton.isDisplayed(),"Pending Ticket linki Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.pendingTicketButton.isEnabled(),"Pending Ticket linki Aktif Değil.");

        softAssert.assertTrue(adminDashBoardPage.bookedTicketButton.isDisplayed(),"Booked Ticket linki Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.bookedTicketButton.isEnabled(),"Booked Ticket linki Aktif Değil.");

        softAssert.assertTrue(adminDashBoardPage.rejectedTicketButton.isDisplayed(),"Rejected Ticket linki Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.rejectedTicketButton.isEnabled(),"Rejected Ticket linki Aktif Değil.");

        softAssert.assertTrue(adminDashBoardPage.allTicketButton.isDisplayed(),"All Ticket linki Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.allTicketButton.isEnabled(),"All Ticket linki Aktif Değil.");

        softAssert.assertAll();
        Driver.quitDriver();



    }

}
