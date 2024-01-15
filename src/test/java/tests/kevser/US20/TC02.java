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

public class TC02 {

    /* US-20 / TC-02
       - "Reset Password" sayfasında, DDM'de Username seçilerek, geçerli Username textbox'a girilir.
       - "Send Password Code" butonu tıklanır.
         Kullanıcının kayıtlı e-mail adresine code gönderilir.
         "Password reset email sent successfully" mesajı görüntülenerek, codun başarılı bir şekilde gönderildiği doğrulanır.
       - Ardından "Account Recovery" sayfası açılır.

       - "Account Recovery" sayfasına ulaşıldığı doğrulanır:
           1. "Password reset email sent successfully" mesajı görüntülenir.
           2. Açılan sayfada "Account Recovery" yazısı görünür olur.
           3. "https://qa.easybusticket.com/password/code-verify" URL ile doğrulanır.     */

    //Kayıtlı kullanıcı;
    //Browser'ı açar, Url'e gider, Cokies'i kabul eder, "Sign in"i tıklar, "Forgot Password?" linkini tıklar
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        Assert.assertTrue(easyBusTicketPage.forgotPasswordLink.isDisplayed());
        easyBusTicketPage.forgotPasswordLink.click();

        // TC02 yukarıdaki adımlardan sonra başlıyor.
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        //DDM tıklanır, menüler açılır, username seçilir.
        resetPasswordPage.selectOneDDM.click();
        Select selectUsername = new Select(resetPasswordPage.selectOneDDM);
        selectUsername.selectByValue("username");
        ReusableMethods.wait(2);
        //DDM altındaki username textbox tıklanır, geçerli kullanıcı bilgisi girilir.
        resetPasswordPage.usernameTextBox.click();
        resetPasswordPage.usernameTextBox.sendKeys("kevser90");
        // "Send Password Code" butonu tıklanır.
        resetPasswordPage.sendPasswordCodeButton.click();
        ReusableMethods.wait(2);

        //"Accoun Recovery" sayfasına ulaşıldığı doğrulanır.
        AccountRecoveryPage accountRecoveryPage = new AccountRecoveryPage();
        Assert.assertTrue(accountRecoveryPage.labelAccountRecovery.isDisplayed());
        ReusableMethods.wait(3);

        Driver.closeDriver();


    }
}
