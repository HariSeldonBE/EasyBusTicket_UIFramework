package tests.ilteris.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void headerIletisimBilgileriGörüntülemeVeDogrulamaTesti(){

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
        softAssert.assertTrue(easyBusTicketPage.headerMobileNumberLinki.getAttribute("href").contains("tel:"), "Telefon linkine tıklayınca telefon uygulaması açılmıyor");


        ReusableMethods.wait(1);

        //Iletisim bilgilerinin aktifliğini test edin
        easyBusTicketPage.headerMobileNumberLinki.click();
        softAssert.assertTrue(easyBusTicketPage.headerEmail.getAttribute("href").contains("mailto:"), "Mail linkine tıklayınca mail uygulaması açılmıyor");


        easyBusTicketPage.headerEmail.click();
        softAssert.assertTrue(easyBusTicketPage.headerMobileNumberLinki.isEnabled(),"Email'e erişilemiyor");


        softAssert.assertAll();



        Driver.closeDriver();


    }

}
