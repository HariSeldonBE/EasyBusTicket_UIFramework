package tests.ilteris.US03;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC03 {

    @Test
    public void getTicketNowButtonAktiflikTesti() {
/*
        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();

        String expectedURl="https://easybusticket.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedURl);

        softAssert.assertTrue(easyBusTicketPage.homePageGetTicketNowButton.isDisplayed());

        easyBusTicketPage.homePageGetTicketNowButton.click();

        String EBTticketPageExpectedUrl = "https://easybusticket.com/tickets";
        String EBTTicketPageActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(EBTTicketPageActualUrl.contains(EBTticketPageExpectedUrl));

        softAssert.assertAll();

        Driver.closeDriver();











 */

    }
}
