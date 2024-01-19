package tests.kevser.US20;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC04 extends TestBaseRapor {

    @Test
    public void eMailileResetPasswordTest() {
        /* US-20 / TC-04
         - Reset Password sayfasında, DDM'de E-mail seçilerek, geçerli E-mail textbox'a girilir.
         - "Send Password Code" butonu tıklanır.
           Kullanıcının kayıtlı e-mail adresine code gönderilir.
           "Password reset email sent successfully" yazısının görüntülenmesi beklenir  */

        //Kayıtlı kullanıcı;
        //Browser'ı açar, Url'e gider, Cokies'i kabul eder, "Sign in"i tıklar, "Forgot Password?" linkini tıklar
        extentTest=extentReports.createTest("eMailileResetPasswordTest", "Email ile Şifre Sıfırlama Testi");
        extentReports.setSystemInfo("Automation Engineer", "Kevser");

        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        easyBusTicketPage.forgotPasswordLink.click();
        extentTest.info("Forgot Password? Linki tıklanır");

        // TC04 yukarıdaki adımların ardından başlar.
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        //DDM tıklanır, menüler açılır, E-mail seçilir.
        resetPasswordPage.selectOneDDM.click();
        Select selectEmail = new Select(resetPasswordPage.selectOneDDM);
        selectEmail.selectByValue("email");
        ReusableMethods.wait(2);

        //DDM altındaki E-Mail Adress textbox tıklanır, geçerli kullanıcı bilgisi girilir.
        resetPasswordPage.eMailTextBox.click();
        extentTest.info("DDM'de Email Address seçilir");
        resetPasswordPage.eMailTextBox.sendKeys("yazicikevser@outlook.com");
        extentTest.info("Kayıtlı Email girilir");

        // "Send Password Code" butonu tıklanır.
        resetPasswordPage.sendPasswordCodeButton.click();
        extentTest.info("User not found hata mesajı görülür");
        ReusableMethods.wait(2);

        // E-mail adresi girilerek, "Accoun Recovery" sayfasına ulaşılabildiği doğrulanmalı.
        // Ancak, Beklenen sayfaya ulaşılamıyor !!!
        String expectedUrl = "https://qa.easybusticket.com/password/code-verify";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl, "DDM'de Email seçilerek şifre sıfırlama işlemi yapılamıyor.");

        ReusableMethods.wait(2);
        softAssert.assertAll();
        extentTest.info("Sayfa kapanır.");
        Driver.closeDriver();


    }
}
