package tests.beytullah.US23;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class TC03 {
    @Test
    public void test1() throws InterruptedException {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // Admin dashboard sayfasına ulaşır
        String expectedURl = "https://qa.easybusticket.com/admin/dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedURl, "Admin dashboard sayfasına ulaşılamadı");

        // "Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();

        // Belirtilen linklere tıklar
        manageUsersDDM.linkAllUsers.click();
        String ilkKullaniciStr=kullaniciAdiCikar(manageUsersDDM.linkIlkKullaniciAdi);
        String mailStr=emailCikar(manageUsersDDM.labelMail);
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfAllElements(manageUsersDDM.inputAramaKutusu,
                manageUsersDDM.linkActiveUsers));

        manageUsersDDM.inputAramaKutusu.sendKeys(ilkKullaniciStr + Keys.ENTER);
        //Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(mailStr + Keys.ENTER);
        Driver.getDriver().navigate().back();
       // Thread.sleep(2000);

        // Belirtilen linklere tıklar
        manageUsersDDM.linkActiveUsers.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar

        manageUsersDDM.inputAramaKutusu.sendKeys(ilkKullaniciStr + Keys.ENTER);

        manageUsersDDM.inputAramaKutusu.click();
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(mailStr + Keys.ENTER);
        Driver.getDriver().navigate().back();

        // Belirtilen linklere tıklar
        manageUsersDDM.linkBannedUsers.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar

        manageUsersDDM.inputAramaKutusu.sendKeys(ilkKullaniciStr + Keys.ENTER);

        manageUsersDDM.inputAramaKutusu.click();
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(mailStr + Keys.ENTER);
        Driver.getDriver().navigate().back();


        // Belirtilen linklere tıklar
        manageUsersDDM.linkEmailUnverified.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar

        manageUsersDDM.inputAramaKutusu.sendKeys(ilkKullaniciStr+ Keys.ENTER);

        manageUsersDDM.inputAramaKutusu.click();
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(mailStr + Keys.ENTER);
        Driver.getDriver().navigate().back();


        // Belirtilen linklere tıklar
        manageUsersDDM.linkSmsUnverified.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar

        manageUsersDDM.inputAramaKutusu.sendKeys(ilkKullaniciStr + Keys.ENTER);

        manageUsersDDM.inputAramaKutusu.click();
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(mailStr + Keys.ENTER);
        Driver.getDriver().navigate().back();

        Driver.closeDriver();


    }

     public String kullaniciAdiCikar(WebElement kullaniciAdi) {
        String [] metin=kullaniciAdi.getText().split("@");
        String sonhali=metin[1].substring(0);
        return sonhali;
    }

    public String emailCikar(WebElement email) {
        String [] mail=email.getText().split("@");
        String once=mail[0];
        String sonra=mail[1].replaceAll("\\d","");
        String sonHali=once+"@"+sonra;
        return sonHali;
    }
}
