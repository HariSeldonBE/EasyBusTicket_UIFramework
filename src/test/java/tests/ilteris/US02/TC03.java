package tests.ilteris.US02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC03 {

    @Test
    public void headerSignInVeSignUpButonTestleri() {
/*
        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();

        String exceptedUrl = "https://easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(exceptedUrl,actualUrl);

        //Sosyal Medya icon'larının görüntülendigini ve aktifligini doğrulayın
        softAssert.assertTrue(easyBusTicketPage.signInButton.isDisplayed());
        easyBusTicketPage.signInButton.click();
        String signInExceptedTitle = "Sign In your Account";
        String signInActualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(signInActualTitle.contains(signInExceptedTitle));
        Driver.getDriver().navigate().back();

        softAssert.assertTrue(easyBusTicketPage.signUpButton.isDisplayed());
        easyBusTicketPage.signInButton.click();
        String signUpExceptedTitle = "Sign Up your Account";
        String signUpActualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(signUpActualTitle.contains(signUpExceptedTitle));
        Driver.getDriver().navigate().back();


        softAssert.assertAll();



        Driver.closeDriver();


 */
    }
}
