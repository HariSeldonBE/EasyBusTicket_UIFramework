package tests.ilteris.US01;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    /*@Test
    public void EasyBusTicketAnaSayfaErişebilmeTesti(){
        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();

        //"Every Journey is an Adventure, Every Ticket is a Story" yazısının görünürlüğünü test edin
        softAssert.assertTrue(easyBusTicketPage.EveryJourneyisanAdventureEveryTicketisaStoryYazisi.isDisplayed());

        // Title'in "easy" icerdigini test edin
        String exceptedTitleIcerik = "easy";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(exceptedTitleIcerik));

        //url'in https://easybusticket.com/ oldugunu test edin

        String exceptedUrl = "https://easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(exceptedUrl,actualUrl);



        Driver.closeDriver();



    }*/
}
