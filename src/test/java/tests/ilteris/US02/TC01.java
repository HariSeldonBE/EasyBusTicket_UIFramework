package tests.ilteris.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {
    @Test
    public void headerIletisimBilgileriGörüntülemeVeDogrulamaTesti(){


        extentTest=extentReports.createTest("Ilteris Kagan Colak", "US_02  TC_01 IletisimBilgileriDogrulamaTest ");
        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);



        //Iletisim bilgilerinin görünürlügünü test edin
        softAssert.assertTrue(easyBusTicketPage.headerMobileNumberLinki.isDisplayed(),"Mobile Number görünüyor");
        extentTest.pass("PASSED");
        softAssert.assertTrue(easyBusTicketPage.headerMobileNumberLinki.getAttribute("href").contains("tel:"), "Telefon linkine tıklayınca telefon uygulaması açılmıyor");
        extentTest.pass("FAİLED");

        ReusableMethods.wait(1);

        //Iletisim bilgilerinin aktifliğini test edin
        easyBusTicketPage.headerMobileNumberLinki.click();
        softAssert.assertTrue(easyBusTicketPage.headerEmail.getAttribute("href").contains("mailto:"), "Mail linkine tıklayınca mail uygulaması açılmıyor");
        extentTest.pass("FAİLED");


        easyBusTicketPage.headerEmail.click();
        softAssert.assertTrue(easyBusTicketPage.headerMobileNumberLinki.isEnabled(),"Email'e erişilemiyor");
        extentTest.pass("FAİLED");

        softAssert.assertAll();

        extentTest.info("Closed page");

        Driver.closeDriver();


    }

}
