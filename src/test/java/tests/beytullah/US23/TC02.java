package tests.beytullah.US23;

import Pages.admin.AdminDashBoardPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC02 {
    @Test
    public void TC01() {
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        SoftAssert softAssert=new SoftAssert();
        AdminDashBoardPage adminDashBoardPage=new AdminDashBoardPage();
        ReusableMethods.adminLoginMethod("admin14","123123123");

        adminDashBoardPage.dropDownManageUsers.click();
        softAssert.assertTrue(adminDashBoardPage.linkAllUsers.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkActiveUsers.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkBannedUsers.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkEmailUnverified.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkSmsUnverified.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkEmailToAll.isDisplayed());

        ReusableMethods.wait(3);
        adminDashBoardPage.linkAllUsers.click();
        String expectedUrl1="https://qa.easybusticket.com/admin/users";
        String actualUrl1=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl1,actualUrl1);
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkActiveUsers.click();
        String expectedUrl2="https://qa.easybusticket.com/admin/users/active";
        String actualUrl2=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl2,actualUrl2);
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkBannedUsers.click();
        String expectedUrl3="https://qa.easybusticket.com/admin/users/banned";
        String actualUrl3=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl3,actualUrl3);
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkEmailUnverified.click();
        String expectedUrl4="https://qa.easybusticket.com/admin/users/email-unverified";
        String actualUrl4=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl4,actualUrl4);
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkSmsUnverified.click();
        String expectedUrl5="https://qa.easybusticket.com/admin/users/sms-unverified";
        String actualUrl5=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl5,actualUrl5);
        Driver.getDriver().navigate().back();

        adminDashBoardPage.linkEmailToAll.click();
        String expectedUrl6="https://qa.easybusticket.com/admin/users/send-email";
        String actualUrl6=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl6,actualUrl6);
        ReusableMethods.wait(3);
    }
}
