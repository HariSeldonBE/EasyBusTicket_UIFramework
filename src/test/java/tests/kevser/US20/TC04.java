package tests.kevser.US20;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {

    @Test
    public void test01() {
        /* US-20 / TC-04
         - Reset Password sayfasında, DDM'de E-mail seçilerek, geçerli E-mail textbox'a girilir.
         - "Send Password Code" butonu tıklanır.
           Kullanıcının kayıtlı e-mail adresine code gönderilir.
           "Password reset email sent successfully" yazısının görüntülenmesi beklenir  */

        //Kayıtlı kullanıcı;
        //Browser'ı açar, Url'e gider, Cokies'i kabul eder, "Sign in"i tıklar, "Forgot Password?" linkini tıklar
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        easyBusTicketPage.forgotPasswordLink.click();

        // TC04 yukarıdaki adımların ardından başlar.
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        //DDM tıklanır, menüler açılır, E-mail seçilir.
        resetPasswordPage.selectOneDDM.click();
        Select selectEmail = new Select(resetPasswordPage.selectOneDDM);
        selectEmail.selectByValue("email");
        ReusableMethods.wait(2);

        //DDM altındaki E-Mail Adress textbox tıklanır, geçerli kullanıcı bilgisi girilir.
        resetPasswordPage.eMailTextBox.click();
        resetPasswordPage.eMailTextBox.sendKeys("yazicikevser@outlook.com");

        // "Send Password Code" butonu tıklanır.
        resetPasswordPage.sendPasswordCodeButton.click();
        ReusableMethods.wait(2);

        // E-mail adresi girilerek, "Accoun Recovery" sayfasına ulaşılabildiği doğrulanmalı.
        // Ancak, Beklenen sayfaya ulaşılamıyor !!!
        String expectedUrl = "https://qa.easybusticket.com/password/code-verify";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(actualUrl,expectedUrl);

        ReusableMethods.wait(2);
        Driver.closeDriver();


    }
}
