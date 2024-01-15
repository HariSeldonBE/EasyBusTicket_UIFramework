package tests.ilteris.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC02 {

    @Test
    public void headerSosyalMedyaIconlarıGörüntülemeVeDogrulamaTesti(){

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
        softAssert.assertTrue(easyBusTicketPage.xIcon.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.facebookIcon.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.youtubeIcon.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.instagramIcon.isDisplayed());

        //Sosyal Medya icon'larının aktifliğini doğrulayın
        easyBusTicketPage.xIcon.click();
        String xExceptedTitle = "Hemen katıl.";
        String xActualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(xActualTitle.contains(xExceptedTitle));
        Driver.getDriver().navigate().back();

        easyBusTicketPage.facebookIcon.click();
        String facebookExceptedTitle = "Facebook tanıdıklarınla iletişim kurmanı ve hayatında olup bitenleri paylaşmanı sağlar.";
        String facebookActualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(facebookActualTitle.contains(facebookExceptedTitle));
        Driver.getDriver().navigate().back();

        easyBusTicketPage.youtubeIcon.click();
        String youtubeExceptedTitle = "Videoları beğenmek, yorum yapmak ve abone olmak için oturum açın.";
        String youtubeActualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(youtubeActualTitle.contains(youtubeExceptedTitle));
        Driver.getDriver().navigate().back();

        easyBusTicketPage.instagramIcon.click();
        String instagramExceptedTitle = "Hesabın yok mu?";
        String instagramActualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(instagramActualTitle.contains(instagramExceptedTitle));
        Driver.getDriver().navigate().back();




        softAssert.assertAll();



        Driver.closeDriver();


    }
}
