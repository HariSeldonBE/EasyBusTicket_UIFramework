package tests.ilteris.US04;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void footerGörüntülemeTesti() {

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);

        //Easy Bus Ticket home page footer kısmı görününürlüğünü test edin
        softAssert.assertTrue(easyBusTicketPage.sosyalMedyaIcons.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.usefulLinksTitle.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.policiesTitle.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.contactInfoTitle.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.easyBusTicketFooterLogo.isDisplayed());


        softAssert.assertAll();

        Driver.closeDriver();

    }
}
