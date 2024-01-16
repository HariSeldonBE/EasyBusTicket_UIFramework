package tests.ilteris.US05;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.AboutPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void headerAboutLinkiDogrulamaTesti(){

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        AboutPage aboutPage = new AboutPage();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);

        softAssert.assertTrue(easyBusTicketPage.headerAboutButton.isDisplayed());
        easyBusTicketPage.headerAboutButton.click();

        String EBTticketPageExpectedUrl = "https://qa.easybusticket.com/about-us";
        String EBTTicketPageActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(EBTTicketPageActualUrl,EBTticketPageExpectedUrl);

        softAssert.assertTrue(aboutPage.aboutPageHeader.isDisplayed());
        softAssert.assertTrue(aboutPage.fastAndSecureTicketSalesText.isDisplayed());
        softAssert.assertTrue(aboutPage.relaxedTravelPlanningText.isDisplayed());
        softAssert.assertTrue(aboutPage.customerSatisfactionFocusedServiceText.isDisplayed());
        softAssert.assertTrue(aboutPage.ourAdvantagesText.isDisplayed());

        Driver.getDriver().navigate().back();

        softAssert.assertAll();

        Driver.closeDriver();

    }
}
