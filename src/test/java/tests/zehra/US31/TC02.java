package tests.zehra.US31;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.admin.AdminDashBoard_ManageFleetsPage;

import utilities.*;

public class TC02  {
    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();

        // Browser'ı açar
       // URL'e gider
        ReusableMethods.adminLoginMethod("admin11","123123123");

        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();

       // Seat Layouts'a tıklar
        JSUtilities.clickWithJS(Driver.getDriver(), adminDashBoard_manageFleetsPage.linkSeatLayouts);
        ReusableMethods.wait(2);

        // Açılan "Seat Layouts" sayfasında "S.N., Layout, Action" başlıklarını, içeriğini görüntüler
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.labelSN.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.labelLayout.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.labelAction.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdSN.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdLayout.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdAction.isDisplayed());

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
