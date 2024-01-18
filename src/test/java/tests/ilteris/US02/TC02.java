package tests.ilteris.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02 extends TestBaseRapor {

    @Test
    public void headerSosyalMedyaIconlarıGörüntülemeVeDogrulamaTesti(){

        extentTest=extentReports.createTest("Ilteris Kagan Colak", "US_02  TC_02 HeaderSosyalMedyaIconlarDogrulamaTest ");
        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);

        //Sosyal Medya icon'larının görüntülendiğini doğrulayın
        softAssert.assertTrue(easyBusTicketPage.xIcon.isDisplayed(),"X Icon Görünüyor");
        softAssert.assertTrue(easyBusTicketPage.facebookIcon.isDisplayed(),"Facebook Icon Görünüyor");
        softAssert.assertTrue(easyBusTicketPage.youtubeIcon.isDisplayed(),"Youtube Icon Görünüyor");
        softAssert.assertTrue(easyBusTicketPage.instagramIcon.isDisplayed(),"Instagram Icon Görünüyor");

        //Sosyal Medya icon'larının aktifliğini doğrulayın
        easyBusTicketPage.xIcon.click();
        String xExceptedURL = "https://twitter.com/";
        String xActualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(xActualURL,xActualURL,"Gidilen URL 'X' ulaşıyor");
        Driver.getDriver().navigate().back();
        extentTest.pass("PASSED");
        easyBusTicketPage.facebookIcon.click();
        String facebookExceptedURL = "https://www.facebook.com/";
        String facebookActualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(facebookActualURL,facebookExceptedURL,"Gidilen URL 'Facebook'a ulaşıyor");
        Driver.getDriver().navigate().back();
        extentTest.pass("PASSED");
        easyBusTicketPage.youtubeIcon.click();
        String youtubeExceptedURL = "https://www.youtube.com/";
        String youtubeActualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(youtubeActualURL,youtubeExceptedURL,"Gidilen URL 'Youtube' a ulaşmıyor");
        Driver.getDriver().navigate().back();
        extentTest.pass("FAİLED");
        easyBusTicketPage.instagramIcon.click();
        String instagramExceptedURL = "https://www.instagram.com/";
        String instagramActualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(instagramActualURL,instagramExceptedURL,"Gidilen URL 'Instagram'a ulaşıyor");
        Driver.getDriver().navigate().back();
        extentTest.pass("PASSED");



        softAssert.assertAll();

        extentTest.info("Closed page");

        Driver.closeDriver();


    }
}
