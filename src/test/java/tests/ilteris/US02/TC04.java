package tests.ilteris.US02;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC04 {

   /* @Test
    public void headerBuyTicketsButonDoğrulamaVeAktiflikTesti() {

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();

        //Buy Tickets buton'unun görünürlüğünü doğrulayın
        softAssert.assertTrue(easyBusTicketPage.buyTicketsButton.isDisplayed());

        //Buy Tickets buton'unun aktifliğini doğrulayın
        easyBusTicketPage.buyTicketsButton.click();
        String exceptedUrl = "https://easybusticket.com/tickets";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(exceptedUrl,actualUrl);

        softAssert.assertAll();



        Driver.closeDriver();




    }*/
}
