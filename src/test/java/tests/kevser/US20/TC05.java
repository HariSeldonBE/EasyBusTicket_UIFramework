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

public class TC05 {

    @Test
    public void test01() {
        //TC05 : Account Recovery Page'de, Verfication Code'un yazılması gereken textbox'da
        //yapılacak olan işleme uygun bir yazı bulunması gerekmektedir.
        // expectedYazi = "Enter Your Verification Code";
        // actualYazi = "Enter Your username";

        //Kayıtlı kullanıcı;
        //Browser'ı açar, Url'e gider, Cokies'i kabul eder, "Sign in"i tıklar, "Forgot Password?" linkini tıklar
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        //UserLoginPage loginPage = new UserLoginPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        easyBusTicketPage.forgotPasswordLink.click();
        // Username seçeneği kullanılarak, reset password code alınır.
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
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

        // TC05
        // Account Recovery Page'de, Verfication Code'un yazılması gereken textbox'da
        // yapılacak olan işleme uygun bir yazı bulunması gerekmektedir.


        String expectedYazi = "Enter Your Verification Code";

        String actualYazi = accountRecoveryPage.verificationCodePlaceholderYazisi.getText();

        Assert.assertNotEquals(actualYazi,expectedYazi);

        /*
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(actualYazi,expectedYazi,"Placeholder'da 'Enter Your Username' yazısı görülmektedir.");
         */
        Driver.closeDriver();

    }

}
