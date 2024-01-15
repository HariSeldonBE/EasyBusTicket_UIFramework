package tests.huseyin.US11;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {
    // Access to Login Page Test
    @Test
    public void test01(){

        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage = new UserLoginPage();
        SoftAssert softAssert = new SoftAssert();


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        Driver.getDriver().navigate().back();


        Driver.closeDriver();
    }
}
