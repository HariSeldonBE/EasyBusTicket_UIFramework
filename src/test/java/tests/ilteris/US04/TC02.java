package tests.ilteris.US04;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    @Test
    public void footerSosyalMedyaButonlarıAktiflikTesti() {

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

        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(0);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView()",easyBusTicketPage.footerXIcon);
        ReusableMethods.wait(0);
        // X için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerXIcon.isDisplayed());
        ReusableMethods.wait(1);
        easyBusTicketPage.footerXIcon.click();
        String exceptedXURL = "https://twitter.com/";
        String actualXURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualXURL,exceptedXURL);

        js.executeScript("window.history.go(-1);");
        //Driver.getDriver().navigate().back();

        // Facebook için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerFacebookIcon.isDisplayed());
        easyBusTicketPage.footerFacebookIcon.click();
        String exceptedFacebookURL = "https://www.facebook.com/";
        String actualFacebookURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualFacebookURL,exceptedFacebookURL);

        Driver.getDriver().navigate().back();

        //Youtube için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerYoutubeIcon.isDisplayed());
        easyBusTicketPage.footerYoutubeIcon.click();
        String exceptedYoutubeURL = "https://www.youtube.com/";
        String actualYoutubeURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualYoutubeURL,exceptedYoutubeURL);

        Driver.getDriver().navigate().back();


        // Instagram için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerInstagramIcon.isDisplayed());
        easyBusTicketPage.footerInstagramIcon.click();
        String exceptedInstagramURL = "https://www.instagram.com/";
        String actualInstagramURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualInstagramURL,exceptedInstagramURL);

        Driver.getDriver().navigate().back();




        softAssert.assertAll();

        Driver.closeDriver();

    }
}
