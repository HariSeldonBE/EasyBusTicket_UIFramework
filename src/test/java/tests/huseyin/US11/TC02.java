package tests.huseyin.US11;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC02 {
    // Login Test with Valid Username and Valid Password
    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage = new UserLoginPage();
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        SoftAssert softAssert = new SoftAssert();


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));


        Driver.closeDriver();
    }
}
