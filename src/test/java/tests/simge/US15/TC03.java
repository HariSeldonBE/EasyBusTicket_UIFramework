package tests.simge.US15;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.SupportRequestPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {
    @Test
    public void createNewPozitifTesti(){

        // 1-Browser açılır ve Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2-Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3-SignIn butonuna tıklanır
        easyBusTicketPage.signInButton.click();
        ReusableMethods.wait(2);
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        // 4-Geçerli Username girilir
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        // 5-Geçerli Password girilir
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        // 6-Log In butonuna tıklanır
        userLoginPage.loginButton.click();
        ReusableMethods.wait(1);

        //Support Request tıklanır
        userDashBoardPage.supportRequest.click();

        //Create New tıklanır
        SupportRequestPage supportRequestPage = new SupportRequestPage();
        userDashBoardPage.createNew.click();
        //Subject yazılır
        supportRequestPage.subject.sendKeys("Koltuk seçme problemi7");
        //Priority seçilir
        supportRequestPage.priority.click();
        supportRequestPage.high.click();
        ReusableMethods.wait(1);
        //Mesaj yazılır
        supportRequestPage.message.sendKeys("Merhaba, deneme amaçlıdır.");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView()",supportRequestPage.submit);
        ReusableMethods.wait(1);
        //Submit tıklanır
        supportRequestPage.submit.click();
        ReusableMethods.wait(1);
        Assert.assertTrue(supportRequestPage.requestSuccessful.isDisplayed());
        Assert.assertTrue(supportRequestPage.statusOpen.isDisplayed());
        Driver.closeDriver();


    }
}
