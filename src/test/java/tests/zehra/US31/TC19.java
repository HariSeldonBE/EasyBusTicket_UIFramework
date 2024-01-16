package tests.zehra.US31;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC19 {
@Test
    public void test() {

    SoftAssert softAssert = new SoftAssert();
    AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    // Browser'ı açar
    // URL'e gider
    ReusableMethods.adminLoginMethod("admin11", "123123123");

    // Manage Fleets'e tıklar
    adminDashBoard_manageFleetsPage.linkManageFleets.click();

    // "Vehicles" linkine tıklar
    JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoard_manageFleetsPage.linkVehicles1);
    ReusableMethods.wait(2);

    // Açılan "All Vehicles" sayfasında "Action" başlığının altında göz simgesi görür ve tıklar
    softAssert.assertTrue(adminDashBoard_manageFleetsPage.ikonActiveDissable_Vehicle.isDisplayed());
    adminDashBoard_manageFleetsPage.ikonActiveDissable_Vehicle.click();

    // Active yapabilmek için "Active Vehicle" penceresinde "Active" butonuna tıklayarak Active yapar
    // Disable yapabilmek için "Disable Vehicle" penceresinde "Disable" butonuna tıklayarak Disable yapar
    adminDashBoard_manageFleetsPage.buttonActiveDisable_Vehicle.click();




    softAssert.assertAll();
    ReusableMethods.wait(2);
    Driver.closeDriver();
}
}
