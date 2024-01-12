package tests.ahmed.US34;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {

    //Admin olarak çıkış yapıp admin giriş sayfasına ulaşabilmeliyim
    @Test
    public void test01(){
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

        ReusableMethods.adminLoginMethod("admin13","123123123");

        adminDashBoardPage.adminDashboardProfileButton.click();
        Select select = new Select(adminDashBoardPage.adminDashboardProfileButton);
        select.selectByVisibleText("Logout");
        String expectedUrl = "https://qa.easybusticket.com/admin";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Admin giriş sayfası url kontrolü");
        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.quitDriver();
    }
}
