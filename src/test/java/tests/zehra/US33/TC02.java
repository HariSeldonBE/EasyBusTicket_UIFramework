package tests.zehra.US33;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage = new UserLoginPage();
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        userLoginPage.loginButton.click();
        Assert.assertTrue(userDashBoardPage.labelDashBoard.isDisplayed());

        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
