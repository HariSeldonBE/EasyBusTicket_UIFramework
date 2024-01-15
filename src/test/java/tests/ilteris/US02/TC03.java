package tests.ilteris.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {

    @Test
    public void headerSignInVeSignUpButonTestleri() {

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        SoftAssert softAssert = new SoftAssert();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);


        softAssert.assertTrue(easyBusTicketPage.signInButton.isDisplayed());
        easyBusTicketPage.signInButton.click();
        ReusableMethods.wait(1);
        String signInExceptedUrl = "https://qa.easybusticket.com/login";
        String signInActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(signInActualUrl,signInExceptedUrl);
        Driver.getDriver().navigate().back();

        ReusableMethods.wait(6);

        softAssert.assertTrue(easyBusTicketPage.signUpButton.isDisplayed());
        easyBusTicketPage.signUpButton.click();
        ReusableMethods.wait(1);
        String signUpExceptedUrl = "https://qa.easybusticket.com/register";
        String signUpActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(signUpActualUrl,signUpExceptedUrl);
        Driver.getDriver().navigate().back();


        softAssert.assertAll();



        Driver.closeDriver();


    }
}
