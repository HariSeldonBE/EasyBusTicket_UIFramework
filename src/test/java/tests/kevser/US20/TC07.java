package tests.kevser.US20;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.AccountRecoveryPage;
import pages.user.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC07 extends TestBaseRapor {

    @Test
    public void tamamlanmamisMesajTesti() {
        //TC07 : Account Recovery Page'de, Verfy Code Button altında yeralan mesaj,
        // Kullanıcıyı doğru yönlendirecek şekilde tamamlanmalı.
        // Expected Message :
        // "Please check including your Junk/Spam Folder. if not found, you can mail to 'info@easybusticket.com'"


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

        extentTest.info("Verify Code Button altında yeralan mesaj, kullanıcıyı doğru yönlendirecek şekilde tamamlanmalı.");
        String expectedYazi = "Please check including your Junk/Spam Folder. if not found, you can mail to 'info@easybusticket.com'";
        String actualYazi = accountRecoveryPage.resetPasswordMessage.getText();
        softAssert.assertEquals(actualYazi,expectedYazi,"Verify Code butonu altında bulunan mesaj yarım bırakılmış.");

        softAssert.assertAll();
        extentTest.info("Sayfa kapanır.");
        Driver.closeDriver();

    }

}
