package tests.zehra.US33;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.admin.AdminDashBoard_HeaderPage;

import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {
    @Test
    public void test01(){

        AdminDashBoard_HeaderPage adminDashBoard_headerPage = new AdminDashBoard_HeaderPage();
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());

        // 1-Browser açılır
        // 2-Url 'e  gidilir
        ReusableMethods.adminLoginMethod("admin11","123123123");

        // 3-Bildirim butonuna tıklanır.
        adminDashBoard_headerPage.ikonBildirim.click();

        // 4- Bildirim butonuna tıklandığında son bildirimden geriye doğru tüm okunmamış
        // bildirimlerin alt alta kutucuklar içinde gösterildiği pencere açıldığı doğrulanır
        ReusableMethods.wait(2);
        softAssert.assertTrue(adminDashBoard_headerPage.ddmBildirimPenceresi.isDisplayed(),"pencere görünmüyor");

         // 6-Pencerenin en altında "Tüm bildirimleri görüntüle" linkine tıklandığında
         // tüm bildirimlerin olduğu sayfaya götürdüğü doğrulanır
         adminDashBoard_headerPage.ddmViewAllNotification.click();
         String expectedUrl= "https://qa.easybusticket.com/admin/notifications";
         String actualUrl = Driver.getDriver().getCurrentUrl();
         softAssert.assertEquals(actualUrl,expectedUrl);

         // 7-Bildirim sayfasının sağ üst köşesinde bulunan "Tümünü okundu olarak işaretle " butonuna
         // tıklandığında "Bildirimler başarıyla okundu" alertinin görüldüğü doğrulanır.
         adminDashBoard_headerPage.buttonTümüOkundu.click();

         ReusableMethods.wait(2);
         softAssert.assertTrue(adminDashBoard_headerPage.alertTümBildirimlerOkundu.isDisplayed(),"alert okunamadı");

         softAssert.assertAll();
         ReusableMethods.wait(2);
         Driver.closeDriver();

    }
}
