package tests.ilteris.US03;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class    TC01 {

/*
    @Test
    public void chooseYourTicketPanelGörüntülemeTesti() {


        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();

        String expectedURl="https://easybusticket.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedURl);


        //Choose Your Ticket Panelinin görünür olduğunu test edin
        softAssert.assertTrue(easyBusTicketPage.homePageChooseYourTicketPanelText.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.homePagePickUpPointContainer.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.homePageDroppingPointContainer.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.homePageDepartureDatePicker.isDisplayed());
        softAssert.assertTrue(easyBusTicketPage.homePageFindTicketButton.isDisplayed());

        softAssert.assertAll();

        Driver.closeDriver();










    }*/
}
