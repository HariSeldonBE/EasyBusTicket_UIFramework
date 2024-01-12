package tests.zehra.US33;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminDashBoard_HeaderPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void test01(){
        AdminDashBoard_HeaderPage adminDashBoard_headerPage = new AdminDashBoard_HeaderPage();
        SoftAssert softAssert = new SoftAssert();

      //  1-Browser açılır
      //  2-Url 'e  gidilir
        ReusableMethods.adminLoginMethod("admin11","123123123");

      //  3-Dashboard sayfasındaki header bölümündeki tam ekran butonu göründüğü doğrulanır
        softAssert.assertTrue(adminDashBoard_headerPage.ikonOpenFullscreen.isDisplayed());

      //  4-Tam ekran butonu tıklanabilir olduğu doğrulanır
        softAssert.assertTrue(adminDashBoard_headerPage.ikonOpenFullscreen.isEnabled());

      //  5-Tam ekran butonu tek tıklanır ve tam ekran açıldığı doğrulanır.
       adminDashBoard_headerPage.ikonOpenFullscreen.click();
       softAssert.assertTrue(adminDashBoard_headerPage.ikonCloseFullscreen.isDisplayed(),"tam ekran açılmadı");

      //  6-Tekrar tam ekran butonuna tek tıklandığında sayfa eski haline döndüğü doğrulanır.
        adminDashBoard_headerPage.ikonCloseFullscreen.click();
        softAssert.assertTrue(adminDashBoard_headerPage.ikonOpenFullscreen.isDisplayed(),"eski haline dönmedi");

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.quitDriver();




    }
}
