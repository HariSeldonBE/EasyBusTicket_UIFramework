package tests.beytullah.US23;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {
    @Test
    public void test1(){
        AdminDashBoardPage adminDashBoardPage=new AdminDashBoardPage();
        SoftAssert softAssert=new SoftAssert();

        //URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        //Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14","123123123");
        //Admin dashboard sayfasına ulaşır
        String expectedURl="https://qa.easybusticket.com/admin/dashboard";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedURl,"Admin dashboard sayfasına ulaşılamadı");

        //"Manage Users" DDM'ye tıklar
        adminDashBoardPage.dropDownManageUsers.click();
        // Belirtilen linklere tıklar
        //ReusableMethods.wait(3);
        adminDashBoardPage.linkAllUsers.click();
        // Belirtilen linlerin sayfalarında arama kutusunu görür
        adminDashBoardPage.inputAramaKutusu.isDisplayed();

        // Arama kutularına tıklar
        adminDashBoardPage.inputAramaKutusu.click();
        adminDashBoardPage.inputAramaKutusu.sendKeys("@pacal63"+ Keys.ENTER);
        // Sırasıyla kayıltlı bir email adresi ve kayıltlı bir kullanıcı adı  ile arama yapar
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkActiveUsers.click();
        // Belirtilen linlerin sayfalarında arama kutusunu görür

        // Arama kutularına tıklar
        // Sırasıyla kayıltlı bir email adresi ve kayıltlı bir kullanıcı adı  ile arama yapar
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkBannedUsers.click();
        // Belirtilen linlerin sayfalarında arama kutusunu görür

        // Arama kutularına tıklar
        // Sırasıyla kayıltlı bir email adresi ve kayıltlı bir kullanıcı adı  ile arama yapar
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkEmailUnverified.click();
        // Belirtilen linlerin sayfalarında arama kutusunu görür

        // Arama kutularına tıklar
        // Sırasıyla kayıltlı bir email adresi ve kayıltlı bir kullanıcı adı  ile arama yapar
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkSmsUnverified.click();
        // Belirtilen linlerin sayfalarında arama kutusunu görür

        // Arama kutularına tıklar
        // Sırasıyla kayıltlı bir email adresi ve kayıltlı bir kullanıcı adı  ile arama yapar
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkEmailToAll.click();
        // Belirtilen linlerin sayfalarında arama kutusunu görür

        // Arama kutularına tıklar
        // Sırasıyla kayıltlı bir email adresi ve kayıltlı bir kullanıcı adı  ile arama yapar




        // Aranan kullanıcıya ulaşır
    }
}
