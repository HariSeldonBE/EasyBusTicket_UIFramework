package tests.ahmed.US32;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {

    //Admin dashboard sayfasının solunda bulunan sidebar'daki
    // Manage trips link'ine basıldığında
    // Route, Schedule, Ticket Price, Trip ve Assigned Vehicle
    // linklerini içeren bir dropdown menüsü görüntülenmeli
    @Test
    public void test01(){

        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        adminLoginPage.usernameBox.click();
        adminLoginPage.usernameBox.sendKeys("admin13" + Keys.TAB);
        adminLoginPage.passwordBox.sendKeys("123123123");
        adminLoginPage.loginButton.click();

        adminDashBoardPage.manageTripsLink.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        softAssert.assertTrue(adminDashBoardPage.routeElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.scheduleElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.ticketPriceElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.tripElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.assignedVehicleElement.isDisplayed());
        softAssert.assertAll();

        ReusableMethods.wait(2);
        Driver.quitDriver();
    }
}
