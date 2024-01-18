package tests.mehmet.US18;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;

import java.time.Duration;

public class TC04 {
    @Test
    public void Test01() throws InterruptedException {

        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage = new UserLoginPage();
        SoftAssert softAssert = new SoftAssert();

        //1-Kayıtlı kullanıcı olarak Browser'ı açar ve Url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        userLoginPage.loginButton.click();

        easyBusTicketPage.dashboardButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(easyBusTicketPage.dropDownProfile).perform();
        JSUtilities.clickWithJS(Driver.getDriver(), easyBusTicketPage.linkChangePassword);
        //3-Açılan sayfada ki formda "current password, password, confirm password" yazılarının
        // ve altlarında textbox'ların görünür ve aktif olduğunu doğrular.
        softAssert.assertTrue(easyBusTicketPage.labelCurrentPasswordText.isDisplayed(), "\"Current password\" yazısı görülemedi");
        softAssert.assertTrue(easyBusTicketPage.boxCurrentPassword.isDisplayed(), "\"Current password\" kutusu görülemedi");
        softAssert.assertTrue(easyBusTicketPage.boxCurrentPassword.isEnabled(), "\"Current password\" kutusu aktif değil");

        softAssert.assertTrue(easyBusTicketPage.labelPasswordText.isDisplayed(), "\"Password\" yazısı görülemedi");
        softAssert.assertTrue(easyBusTicketPage.boxPassword.isDisplayed(), "\"Password\" kutusu görülemedi");
        softAssert.assertTrue(easyBusTicketPage.boxPassword.isEnabled(), "\"Password\" kutusu aktif değil");

        softAssert.assertTrue(easyBusTicketPage.labelConfirmPassword.isDisplayed(), "\"Confirm password\" yazısı görülemedi");
        softAssert.assertTrue(easyBusTicketPage.boxConfirmPassword.isDisplayed(), "\"Confirm password\" kutusu görülemedi");
        softAssert.assertTrue(easyBusTicketPage.boxConfirmPassword.isEnabled(), "\"Confirm password\" kutusu aktif değil");
        //4-Textbox lardaki placeholder 'ların görünür ve aktif olduğunu doğrular.
        softAssert.assertTrue(!easyBusTicketPage.boxCurrentPassword.getAttribute("placeholder").isEmpty(), "\"CurrentPassword\" box'da Placeholder mevcut değil");
        softAssert.assertTrue(!easyBusTicketPage.boxPassword.getAttribute("placeholder").isEmpty(), "\"Password\" box'da Placeholder mevcut değil");
        softAssert.assertTrue(!easyBusTicketPage.boxCurrentPassword.getAttribute("placeholder").isEmpty(), "\"Password\" box'da Placeholder mevcut değil");

        //5- Textbox ların altında "change password" butonunun görünür ve aktif olduğu doğrulanır
        softAssert.assertTrue(easyBusTicketPage.buttonChangePassword.isDisplayed(), "\"change password\" butonu görünür değil");
        softAssert.assertTrue(easyBusTicketPage.buttonChangePassword.isEnabled(), "\"change password\" butonu aktif değil");

        //6-"Current password" textbox'ına kullanıcı şifresinin girilmesi gerektiği doğrulanır.
        /*JSUtilities.scrollToElement(Driver.getDriver(),easyBusTicketPage.boxPassword);
        JSUtilities.waitForPageLoadWithJS(Driver.getDriver(), Duration.ofSeconds(10));
        easyBusTicketPage.boxPassword.sendKeys("Qa!12345"+ Keys.TAB);
        easyBusTicketPage.boxConfirmPassword.sendKeys("Qa!12345");

        JSUtilities.waitForPageLoadWithJS(Driver.getDriver(), Duration.ofSeconds(10));
        JSUtilities.clickWithJS(Driver.getDriver(),easyBusTicketPage.buttonChangePassword);  */

        //7-"password" kısmına içinde kriterlerin olduğu siyah ekran çıktığı görüntülenir ve

        /*
        JSUtilities.waitForPageLoadWithJS(Driver.getDriver(), Duration.ofSeconds(10));
       JSUtilities.scrollToElement(Driver.getDriver(),easyBusTicketPage.boxPassword);

        actions.moveToElement(easyBusTicketPage.labelPasswordText).perform();

        softAssert.assertTrue(easyBusTicketPage.popUpSifre.isDisplayed(), "Sifre popUp'ı görünmedi");*/


        // bu kriterlere uygun şifre girildiği doğrulanır.


        //8- "confirm password" kısmına da girdiği password un aynısını girip "change password "
        // butonuna tıklandığı doğrulanır.
        //9- "şifre başarılı bir şekilde değişti" yazısının görüntülendiğini doğrular.
        softAssert.assertAll();
    }
}
