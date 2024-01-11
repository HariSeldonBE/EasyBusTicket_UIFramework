package tests.ilteris.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void headerIletisimBilgileriGörüntülemeVeDogrulamaTesti(){

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();

        //Iletisim bilgilerinin görünürlügünü test edin
        softAssert.assertTrue(easyBusTicketPage.headerMobileNumberLinki.isDisplayed(),"Mobile Number görünüyor");
        softAssert.assertTrue(easyBusTicketPage.headerEmail.isDisplayed(),"Email görünüyor");

        //Iletisim bilgilerinin aktifliğini test edin
        easyBusTicketPage.headerMobileNumberLinki.click();
        softAssert.assertTrue(easyBusTicketPage.headerMobileNumberLinki.isEnabled(),"Mobile Number'a erişilemiyor");

        easyBusTicketPage.headerEmail.click();
        softAssert.assertTrue(easyBusTicketPage.headerMobileNumberLinki.isEnabled(),"Email'e erişilemiyor");


        softAssert.assertAll();



        Driver.closeDriver();


    }
}
