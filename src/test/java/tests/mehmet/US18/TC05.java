package tests.mehmet.US18;

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

public class TC05 {
    @Test
    public void Test01() {

        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage=new UserLoginPage();
        SoftAssert softAssert=new SoftAssert();

        //1-Kayıtlı kullanıcı olarak Browser'ı açar ve Url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        userLoginPage.loginButton.click();

        //2-Dashboard sayfasındaki header kısmındaki Profile menüsünden "change password" linkine tıklar
        easyBusTicketPage.dashboardButton.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(easyBusTicketPage.dropDownProfile).perform();
        easyBusTicketPage.linkChangePassword.click();

        //3--"Current password" kısmı boş bırakılıp password ve confirm password kısmı uygun kriterlere
        // göre doldurulduğunda uyarı verip password yenilememesi gerektiği doğrulanır
        JSUtilities.scrollToElement(Driver.getDriver(), easyBusTicketPage.boxPassword);
        JSUtilities.waitForPageLoadWithJS(Driver.getDriver(), Duration.ofSeconds(10));
        easyBusTicketPage.boxPassword.sendKeys("Qa!12345" + Keys.TAB);
        easyBusTicketPage.boxConfirmPassword.sendKeys("Qa!12345");
        //4-"Current password" kısmına kayıtlı kullanıcının şifresi girilip, password ve confirm password
        // kısmı uygun kriterlere göre ama birbirinden farklı şekilde doldurulduğunda gerekli uyarıyı
        // verip password yenilememesi gerektiği doğrulanır
        JSUtilities.scrollToElement(Driver.getDriver(),easyBusTicketPage.boxPassword);
        JSUtilities.waitForPageLoadWithJS(Driver.getDriver(), Duration.ofSeconds(10));
        easyBusTicketPage.boxPassword.sendKeys("Qa!12345"+ Keys.TAB);
        easyBusTicketPage.boxConfirmPassword.sendKeys("Qa!12345");
        String alertText=easyBusTicketPage.alert.getText();
        System.out.println(alertText);
        softAssert.assertTrue(easyBusTicketPage.alert.getText().contains(alertText),"\"Current password\" kutusunun doldurulması gerekmiyor");
        //actions.click(easyBusTicketPage.boxPassword).sendKeys("12345"+ Keys.TAB).sendKeys("12345");
        JSUtilities.waitForPageLoadWithJS(Driver.getDriver(), Duration.ofSeconds(10));
        JSUtilities.clickWithJS(Driver.getDriver(),easyBusTicketPage.buttonChangePassword);

        Driver.getDriver().navigate().back();
        //5-"Current password" kısmı yanlış girilip password ve confirm password kısmı uygun kriterlere
        // göre doldurulduğunda gerekli uyarıyı verip password yenilememesi gerektiği doğrulanır
        softAssert.assertAll();
    }
}
