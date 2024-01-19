package tests.kevser.US20;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.AccountRecoveryPage;
import pages.user.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC05 extends TestBaseRapor {

    @Test
    public void placeholderYaziTesti() {
        //TC05 : Account Recovery Page'de, Verfication Code'un yazılması gereken textbox'da
        //yapılacak olan işleme uygun bir yazı bulunması gerekmektedir.
        // expectedYazi = "Enter Your Verification Code";
        // actualYazi = "Enter Your username";

        //Kayıtlı kullanıcı;
        //Browser'ı açar, Url'e gider, Cokies'i kabul eder, "Sign in"i tıklar, "Forgot Password?" linkini tıklar
        extentTest=extentReports.createTest("eMailileResetPasswordTest", "Email ile Şifre Sıfırlama Testi");
        extentReports.setSystemInfo("Automation Engineer", "Kevser");

        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        //UserLoginPage loginPage = new UserLoginPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        easyBusTicketPage.forgotPasswordLink.click();
        extentTest.info("Forgot Password? Linki tıklanır.");
        // Username seçeneği kullanılarak, reset password code alınır.
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.selectOneDDM.click();
        Select selectUsername = new Select(resetPasswordPage.selectOneDDM);
        selectUsername.selectByValue("username");
        extentTest.info("DDM'de Username seçilir.");
        ReusableMethods.wait(2);
        resetPasswordPage.usernameTextBox.click();
        resetPasswordPage.usernameTextBox.sendKeys("kevser90");
        resetPasswordPage.sendPasswordCodeButton.click();
        extentTest.info("Kayıtlı Username girilir.");
        ReusableMethods.wait(2);
        //Code'un alındığı ve "Accoun Recovery" sayfasına ulaşıldığı doğrulanır.
        AccountRecoveryPage accountRecoveryPage = new AccountRecoveryPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(accountRecoveryPage.labelAccountRecovery.isDisplayed());
        extentTest.info("Account Recovery sayfasına yönlendirilir.");
        ReusableMethods.wait(3);

        // TC05
        // Account Recovery Page'de, Verfication Code'un yazılması gereken textbox'da
        // yapılacak olan işleme uygun bir yazı bulunması gerekmektedir.

        extentTest.info("Verification Code yazılması gereken textbox'da 'Enter Your Username' yazısı görülür.");
        String expectedYazi = "Enter Your Verification Code";
        String actualYazi = accountRecoveryPage.verificationCodePlaceholderYazisi.getText();
        softAssert.assertEquals(actualYazi,expectedYazi,"Placeholder'da yanlış mesaj görülmekte ('Enter Your Username')");

        softAssert.assertAll();
        extentTest.info("Sayfa kapanır.");
        Driver.closeDriver();

    }

}
