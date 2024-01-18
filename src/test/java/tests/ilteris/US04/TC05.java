package tests.ilteris.US04;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC05 extends TestBaseRapor {

    @Test
    public void footerContactInfoGorunurlukVeAktiflikTesti() {

        extentTest=extentReports.createTest("Ilteris Kagan Colak", "US_05  TC_05 FooterContactInfoDogrulamaTest ");
        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        Actions actions = new Actions(Driver.getDriver());

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);

        ReusableMethods.wait(0);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView()",easyBusTicketPage.easyBusTicketFooterLogo);
        ReusableMethods.wait(0);


        softAssert.assertTrue(easyBusTicketPage.footerAdresText.isDisplayed());
        ReusableMethods.wait(1);

        // Phone Number in Footer Display Test
        softAssert.assertTrue(easyBusTicketPage.footerTelNumber.isDisplayed(), "Phone number in footer is not displayed");
        softAssert.assertTrue(easyBusTicketPage.footerTelNumber.isEnabled(), "Phone number in footer is not enabled");
        softAssert.assertTrue(easyBusTicketPage.footerTelNumber.getAttribute("href").contains("tel:"), "Phone number in footer does not look for an external phone app");
        extentTest.pass("PASSED");





        softAssert.assertTrue(easyBusTicketPage.footerAdresText.isDisplayed(), "Address Info in Home Page Footer is not displayed");
        extentTest.pass("FAİLED");

        // Address Info in Home Page Footer Enable Test - click to go Google Map
        softAssert.assertTrue(easyBusTicketPage.footerAdresText.isEnabled(), "Address Info in Home Page Footer is not enabled");
        extentTest.pass("FAİLED");

        // Address Info in Home Page Footer Google Map test
        String hrefAttribute = easyBusTicketPage.footerAdresText.getAttribute("href");
        if (hrefAttribute == null) {
            hrefAttribute = "no href";
        }
        else {

        }
        softAssert.assertFalse(hrefAttribute.contains("no href"), "Address Info in Footer is not a Google Map link");
        extentTest.pass("FAİLED");

        softAssert.assertAll();

        extentTest.info("Closed page");

        Driver.closeDriver();

    }


}
