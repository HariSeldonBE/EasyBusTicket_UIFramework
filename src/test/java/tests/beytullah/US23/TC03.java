package tests.beytullah.US23;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class TC03 {
    @Test
    public void test1() throws InterruptedException {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();

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
        List<String> kullaniciAdlari = new ArrayList<>();
        for (WebElement element : manageUsersDDM.columnKullaniciAdi) {
            String kullaniciAdi = kullaniciAdiCikar(element.getText());
            kullaniciAdlari.add(kullaniciAdi);
        }
        List<String> emailller = new ArrayList<>();

        for (WebElement element1 : manageUsersDDM.listEmail) {
            String email = emailCikar(element1.getText());
            emailller.add(email);
        }

        System.out.println("kullaniciAdlari = " + kullaniciAdlari);
        System.out.println("emailller = " + emailller);

        // Belirtilen linklere tıklar
        manageUsersDDM.linkAllUsers.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.sendKeys(kullaniciAdlari.get(0) + Keys.ENTER);
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(emailller.get(0) + Keys.ENTER);
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);

        // Belirtilen linklere tıklar
        manageUsersDDM.linkActiveUsers.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.sendKeys(kullaniciAdlari.get(1) + Keys.ENTER);
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.click();
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(emailller.get(1) + Keys.ENTER);
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);

        // Belirtilen linklere tıklar
        manageUsersDDM.linkBannedUsers.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.sendKeys(kullaniciAdlari.get(2) + Keys.ENTER);
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.click();
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(emailller.get(2) + Keys.ENTER);
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);

        // Belirtilen linklere tıklar
        manageUsersDDM.linkEmailUnverified.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.sendKeys(kullaniciAdlari.get(3) + Keys.ENTER);
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.click();
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(emailller.get(3) + Keys.ENTER);
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);

        // Belirtilen linklere tıklar
        manageUsersDDM.linkSmsUnverified.click();
        // Belirtilen linklerin sayfalarında arama kutusunu görür
        manageUsersDDM.inputAramaKutusu.isDisplayed();
        // Arama kutularına tıklar
        manageUsersDDM.inputAramaKutusu.click();
        // Sırasıyla kayıtlı bir email adresi ve kayıtlı bir kullanıcı adı ile arama yapar
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.sendKeys(kullaniciAdlari.get(4) + Keys.ENTER);
        Thread.sleep(2000);
        manageUsersDDM.inputAramaKutusu.click();
        manageUsersDDM.inputAramaKutusu.clear();
        manageUsersDDM.inputAramaKutusu.sendKeys(emailller.get(4) + Keys.ENTER);
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    private String kullaniciAdiCikar(String metin) {
        int atIndex = metin.indexOf('@');
        if (atIndex != -1 && atIndex < metin.length() - 1) {
            return metin.substring(atIndex + 1).trim();
        }
        return "";
    }

    private String emailCikar(String metin) {
        String[] kelimeler = metin.split("\\s+");
        for (String kelime : kelimeler) {
            // Eğer kelime bir e-posta gibi görünüyorsa
            if (kelime.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                return kelime;
            }
        }
        return "";
    }
}
