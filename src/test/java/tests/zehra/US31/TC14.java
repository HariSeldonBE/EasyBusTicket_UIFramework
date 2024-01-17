package tests.zehra.US31;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC14 {
    @Test
    public void test(){

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
        Actions actions = new Actions(Driver.getDriver());


        // Browser'ı açar
        // URL'e gider
        ReusableMethods.adminLoginMethod("admin11", "123123123");

        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();

      // "Vehicles" linkine tıklar
        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoard_manageFleetsPage.linkVehicles1);

      // "All Vehicles" sayfası açılır
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.labelAllVehicles.isDisplayed());

      // Açılan "All Vehicles" sayfasında
        // "Nick Name, Reg. No., Engine No., Chasis No.,
        // Model No., Fleet Type, Status, Action" başlıklarını ve içeriğini görür

      softAssert.assertTrue(adminDashBoard_manageFleetsPage.thNickName.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thReg.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thEngine.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thChasis.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thModel.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thFleetType.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thStatus2.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thAction2.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdNickName.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdReg.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdEngine.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdChasis.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdModel.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdFleetType.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdStatus.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdAction.isDisplayed());

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();
    }
}
