package tests.zehra.US33;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC05 {
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage = new UserLoginPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("invalidUserName"));
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("invalidPass"));
        userLoginPage.loginButton.click();
        Assert.assertTrue(userLoginPage.slideInBox.isDisplayed());

        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
