package tests.zehra.US31;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC07 {
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


       // "Name, Seat Layout, No of Deck, Total Seat, Facilities, Status, Action" başlıklarını ve içeriğini görür
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thName.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thSeat.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thDeck.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thTotalSeat.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thFacilities.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thStatus.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.thAction.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdName.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdSeat.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdDeck.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdTotalSeat.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdFacilities.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdStatus.isDisplayed());
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tdAction.isDisplayed());

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();














    }
}
