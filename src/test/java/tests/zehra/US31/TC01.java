package tests.zehra.US31;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.admin.AdminDashBoard_ManageFleetsPage;

import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;



public class TC01 {
    @Test
    public void test01(){
        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();

        // Browser'ı açar
       // URL'e gider
        ReusableMethods.adminLoginMethod("admin11","123123123");

       // Trasport Manager başlığını görür
         softAssert.assertTrue(adminDashBoard_manageFleetsPage.labelTransportManager.isDisplayed());

       // Manage Fleets DDM'i görür
        JSUtilities.scrollToElement(Driver.getDriver(),adminDashBoard_manageFleetsPage.linkManageFleets);
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.linkManageFleets.isDisplayed());

        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();
        JSUtilities.scrollToElement(Driver.getDriver(),adminDashBoard_manageFleetsPage.linkManageFleets);
        ReusableMethods.wait(2);

       // DDM açılır ve "Seat Layouts, Fleet Type, Vehicles" linklerini görür
         softAssert.assertTrue(adminDashBoard_manageFleetsPage.linkSeatLayouts.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.linkFleetType.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.linkVehicles.isDisplayed());

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
