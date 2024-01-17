package tests.ilteris.US04;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {

    @Test
    public void footerUsefulLinksGörünürlükVeAktiflikTesti() {

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

        // "About" için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerAboutButton.isDisplayed());
        ReusableMethods.wait(1);
        easyBusTicketPage.footerAboutButton.click();
        String exceptedAboutPageURL = "https://qa.easybusticket.com/about-us";
        String actualAboutPageURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualAboutPageURL,exceptedAboutPageURL);

        js.executeScript("window.history.go(-1);");
        //Driver.getDriver().navigate().back();

        // "FAQs" için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerFAQsButton.isDisplayed());
        easyBusTicketPage.footerFAQsButton.click();
        String exceptedFAQsPageURL = "https://qa.easybusticket.com/faq";
        String actualFAQsPageURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualFAQsPageURL,exceptedFAQsPageURL);

        Driver.getDriver().navigate().back();

        //"Blog" için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerBlogButton.isDisplayed());
        easyBusTicketPage.footerBlogButton.click();
        String exceptedBlogPageURL = "https://qa.easybusticket.com/blog";
        String actualBlogPageURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualBlogPageURL,exceptedBlogPageURL);

        Driver.getDriver().navigate().back();


        // "Contact" için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerContactButton.isDisplayed());
        easyBusTicketPage.footerContactButton.click();
        String exceptedContactPageURL = "https://qa.easybusticket.com/contact";
        String actualContactPageURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualContactPageURL,exceptedContactPageURL);

        Driver.getDriver().navigate().back();




        softAssert.assertAll();

        Driver.closeDriver();

    }
}
