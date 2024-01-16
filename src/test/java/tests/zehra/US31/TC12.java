package tests.zehra.US31;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC12 {
    @Test
    public void test01(){

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
        Actions actions = new Actions(Driver.getDriver());


        // Browser'ı açar
        // URL'e gider
        ReusableMethods.adminLoginMethod("admin11", "123123123");
        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();

        // "Fleet Type" linkine tıklar
        JSUtilities.clickWithJS(Driver.getDriver(), adminDashBoard_manageFleetsPage.linkFleetTyp);
        ReusableMethods.wait(2);

      // "Fleet Type" sayfasının "Action" başlığının altındaki göz simgesini görür ve tıklar
         softAssert.assertTrue(adminDashBoard_manageFleetsPage.buttonActiveDissable_Fleet.isDisplayed(),"Active/Disable görünmüyor");
         adminDashBoard_manageFleetsPage.buttonActiveDissable_Fleet.click();

      // Active / Disable yapabilmek için "Active Fleet Type" penceresinde "Active" butonuna tıklayarak Active yapar
          adminDashBoard_manageFleetsPage.buttonDisable_FleetPopup.click();




        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();


    }
}
