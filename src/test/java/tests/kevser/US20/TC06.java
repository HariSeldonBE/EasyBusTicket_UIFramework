package tests.kevser.US20;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC06 {
    // Negatif Test:
    // geçersiz username ile reset password kod gönderilemez
    @Test
    public void negatifUsernameTesti() {

        //Kayıtlı kullanıcı;
        //Browser'ı açar, Url'e gider, Cokies'i kabul eder, "Sign in"i tıklar, "Forgot Password?" linkini tıklar
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        ReusableMethods.wait(5);
        easyBusTicketPage.signInButton.click();
        easyBusTicketPage.forgotPasswordLink.click();
        ReusableMethods.wait(3);

        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.selectOneDDM.click();
        Select selectUsername = new Select(resetPasswordPage.selectOneDDM);
        selectUsername.selectByValue("username");
        ReusableMethods.wait(3);

        //DDM altındaki username textbox tıklanır, GEÇERSİZ kullanıcı bilgisi girilir.
        resetPasswordPage.usernameTextBox.click();
        ReusableMethods.wait(2);
        resetPasswordPage.usernameTextBox.sendKeys(ConfigReader.getProperty("invalidUserName"));
        // "Send Password Code" butonu tıklanır.
        resetPasswordPage.sendPasswordCodeButton.click();
        ReusableMethods.wait(2);

        //Geçersiz Username ile "Accoun Recovery" sayfasına ulaşılamadığı doğrulanır.
        String expectedUrl = "https://qa.easybusticket.com/password/reset";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        ReusableMethods.wait(3);
        Driver.closeDriver();
    }
}
