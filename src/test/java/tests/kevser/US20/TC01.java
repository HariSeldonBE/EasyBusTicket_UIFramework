package tests.kevser.US20;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    /* US-20 / TC-01
            1-Kayıtlı kullanıcı Browser'ı açar, Url'e gider
            2-Cookies'i kabul eder
            2-Ana sayfadaki "Sign in" linkine tıklar
            3-Login sayfasında "Forgot Password?" linkinin görünür olduğu doğrulanır ve linke tıklar
            *** Açılan yeni sayfada "Reset Password" yazısının görünür olduğu doğrulanarak,
                beklenen sayfaya ulaşıldığı onaylanır.
        */
    @Test
    public void resetPasswordPageTest() {
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        ReusableMethods.wait(2);
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(easyBusTicketPage.forgotPasswordLink.isDisplayed());
        easyBusTicketPage.forgotPasswordLink.click();

        // Beklenen sayfaya ulaşıldı. Açılan sayfada "Reset Password" yazısının görüldüğü doğrulandı.
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        softAssert.assertTrue(resetPasswordPage.resetPasswordYazisi.isDisplayed());

        String expectedUrl = "https://qa.easybusticket.com/password/reset";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);

        ReusableMethods.wait(2);

        softAssert.assertAll();
        Driver.closeDriver();


    }
}
