package tests.ilteris.US03;


import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
/*
    @Test

    public void chooseYourTicketPanelAktiflikTesti() {

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);


        ReusableMethods.wait(3);
        Select pickUpPointSelect = new Select(easyBusTicketPage.homePagePickUpPointContainer);
        pickUpPointSelect.selectByIndex(1);

        Select droppingPointSelect = new Select(easyBusTicketPage.homePageDroppingPointContainer);
        droppingPointSelect.selectByIndex(2);

        easyBusTicketPage.homePageFindTicketButton.click();

        String EBTticketPageExpectedUrl = "https://easybusticket.com/tickets";
        String EBTTicketPageActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(EBTTicketPageActualUrl.contains(EBTticketPageExpectedUrl));

        softAssert.assertAll();

        Driver.closeDriver();















    }

     */
}