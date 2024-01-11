package tests.ilteris.US01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {
    @Test
    public void test01(){
        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        //"Every Journey is an Adventure, Every Ticket is a Story" yazısının görünürlüğünü test edin
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();

        // Title'in "easy" icerdigini test edin
        String exceptedTitleIcerik = "easy";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(exceptedTitleIcerik));

        //url'in https://easybusticket.com/ oldugunu test edin

        String exceptedUrl = "https://easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(exceptedUrl,actualUrl);

        Assert.assertTrue(easyBusTicketPage.EveryJourneyisanAdventureEveryTicketisaStoryYazisi.isDisplayed());



        Driver.closeDriver();


    }
}
