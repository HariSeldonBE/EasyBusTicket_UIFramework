package tests.zehra.US33;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoard_HeaderPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {
    @Test
    public void test01(){

        AdminDashBoard_HeaderPage adminDashBoard_headerPage = new AdminDashBoard_HeaderPage();
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());

       // 1-Browser açılır
       // 2-Url 'e  gidilir
        ReusableMethods.adminLoginMethod("admin11","123123123");

       // 3-Dashboard sayfasındaki header bölümündeki bildirim butonunun göründüğü doğrulanır
        softAssert.assertTrue(adminDashBoard_headerPage.ikonBildirim.isDisplayed(),"bildirim ikonu görünmüyor");

       // 4- Bildirim butonunun tıklanabilir olduğu doğrulanır
       softAssert.assertTrue(adminDashBoard_headerPage.ikonBildirim.isEnabled());

        // 5-Bildirim butonuna tek tıklandığında okunmamış bildirim sayısının olduğu doğrulanır
        adminDashBoard_headerPage.ikonBildirim.click();
        String okunmamisBildirimSayisiYazisi = adminDashBoard_headerPage.pUnreadNotification.getText();
        String okunmamisBildirimSayisistr= okunmamisBildirimSayisiYazisi.replaceAll("\\D","");
        int okunmamisBildirimSayisi = Integer.parseInt(okunmamisBildirimSayisistr);
        softAssert.assertTrue(okunmamisBildirimSayisi>0);

        // 6-Bildirim butonuna tıklandığında son bildirimden geriye doğru tüm okunmamış bildirimlerin
        // alt alta kutucuklar içinde gösterildiği doğrulanır
        softAssert.assertTrue(adminDashBoard_headerPage.ddmNewMemberRegisteredHours.isDisplayed());


        // 7-Kutucukların da aktif olup tıklandığında bildirimin olduğu sayfaya götürdüğü doğrulanır
        softAssert.assertTrue(adminDashBoard_headerPage.ddmNewMemberRegisteredHours.isEnabled());
        adminDashBoard_headerPage.ddmNewMemberRegisteredHours.click();
        String expectedBildirimYazisi = adminDashBoard_headerPage.ddmNewMemberRegisteredSeconds.getText();
        String expectedAcilanBildirimSayfasi = adminDashBoard_headerPage.bildirimTitle.getText();
        //softAssert.assertEquals("New member registered",expectedBildirimYazisi);
        softAssert.assertEquals("User Detail",expectedAcilanBildirimSayfasi,"ilk");
        softAssert.assertEquals("Booked Ticket",expectedAcilanBildirimSayfasi,"iki");
        softAssert.assertEquals("Reply Request",expectedAcilanBildirimSayfasi,"üç");



        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
