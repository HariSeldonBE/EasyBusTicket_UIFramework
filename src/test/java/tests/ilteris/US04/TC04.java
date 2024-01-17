package tests.ilteris.US04;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {

    @Test
    public void footerPoliciesGörünürlükVeAktiflikTesti() {

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

        // "Privacy Policy" için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerPrivacyPolicyButton.isDisplayed());
        ReusableMethods.wait(1);
        easyBusTicketPage.footerPrivacyPolicyButton.click();
        String exceptedPrivacyPolicyURL = "https://qa.easybusticket.com/policy/69/privacy-policy";
        String actualPrivacyPolicyURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualPrivacyPolicyURL,exceptedPrivacyPolicyURL);

        js.executeScript("window.history.go(-1);");
        //Driver.getDriver().navigate().back();

        // "Terms and Conditions" için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.footerPrivacyTermsConditionsButton.isDisplayed());
        easyBusTicketPage.footerPrivacyTermsConditionsButton.click();
        String exceptedTermsConditionsURL = "https://qa.easybusticket.com/policy/71/terms-and-conditions";
        String actualTermsConditionsURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualTermsConditionsURL,exceptedTermsConditionsURL);

        Driver.getDriver().navigate().back();

        //"Ticket Policies" için aktifliği test edin
        softAssert.assertTrue(easyBusTicketPage.EveryJourneyisanAdventureEveryTicketisaStoryYazisi.isDisplayed());
        easyBusTicketPage.footerTicketPoliciesButton.click();
        String exceptedBTicketPoliciesURL = "https://qa.easybusticket.com/policy/90/ticket-policies";
        String actualTicketPoliciesURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualTicketPoliciesURL,exceptedBTicketPoliciesURL);

        Driver.getDriver().navigate().back();




        softAssert.assertAll();

        Driver.closeDriver();

    }
}
