package tests.ilteris.US07;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.FAQsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void headerBlogLinkiDogrulamaTesti(){

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        FAQsPage faqsPage = new FAQsPage();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);

        softAssert.assertTrue(easyBusTicketPage.headerBlogButton.isDisplayed());
        easyBusTicketPage.headerBlogButton.click();

        String EBTticketPageExpectedUrl = "https://qa.easybusticket.com/blog";
        String EBTTicketPageActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(EBTTicketPageActualUrl,EBTticketPageExpectedUrl);




        softAssert.assertAll();

        Driver.closeDriver();

    }
}
