package tests.ilteris.US01;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {


    @Test

    public void EasyBusTicketAnaSayfaErişebilmeTesti(){
        
        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        //"Every Journey is an Adventure, Every Ticket is a Story" yazısının görünürlüğünü test edin
        softAssert.assertTrue(easyBusTicketPage.EveryJourneyisanAdventureEveryTicketisaStoryYazisi.isDisplayed());


        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);

        softAssert.assertAll();


        Driver.closeDriver();





    }

}
