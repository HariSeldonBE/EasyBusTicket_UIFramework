package tests.kevser.US20;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.AccountRecoveryPage;
import pages.user.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {
    // US20 / TC03
    // "Account Recovery" sayfasına ulaşılır
    // "Try to send again" linki tıklanarak,
    // "Reset Password" sayfasına geri dönüldüğü doğrulanır.
    @Test
    public void test01() {
        //Kayıtlı kullanıcı;
        //Browser'ı açar, Url'e gider, Cokies'i kabul eder, "Sign in"i tıklar, "Forgot Password?" linkini tıklar
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        easyBusTicketPage.forgotPasswordLink.click();
        // DDM'de Username seçeneği kullanılarak, reset password code alınır.
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        ReusableMethods.wait(2);
        resetPasswordPage.selectOneDDM.click();
        Select selectUsername = new Select(resetPasswordPage.selectOneDDM);
        selectUsername.selectByValue("username");
        ReusableMethods.wait(2);
        resetPasswordPage.usernameTextBox.click();
        resetPasswordPage.usernameTextBox.sendKeys("kevser90");
        resetPasswordPage.sendPasswordCodeButton.click();
        ReusableMethods.wait(2);
        //Code'un alındığı ve "Accoun Recovery" sayfasına ulaşıldığı doğrulanır.
        AccountRecoveryPage accountRecoveryPage = new AccountRecoveryPage();
        Assert.assertTrue(accountRecoveryPage.labelAccountRecovery.isDisplayed());
        ReusableMethods.wait(3);

        // "Try to send again" linki tıklanarak, "Reset Password" sayfasına geri dönülebildiği doğrulanır.
        accountRecoveryPage.tryToSendAgainLink.click();
        Assert.assertTrue(resetPasswordPage.resetPasswordYazisi.isDisplayed());
        ReusableMethods.wait(3);

        Driver.closeDriver();


    }

}
