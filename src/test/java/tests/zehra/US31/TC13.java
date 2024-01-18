package tests.zehra.US31;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC13 extends TestBaseRapor {
    @Test
    public void deleteButonu(){


        extentTest=extentReports.createTest("ZEHRA_Delete Butonu TEST", "US_31  TC_13  Delete butonu görünmüyor. ");

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

       // Sayfada ""Action"" başlığının altındaki çöp kutusu butonuna tıklar"
        softAssert.assertFalse(adminDashBoard_manageFleetsPage.tdAction3.isDisplayed(),"delete butonu yok");
        extentTest.info("Delete butonu görünmüyor.");

       // Pencerede "Are you sure, you want to delete this?" yazısını görüntüler
       // "Delete" butonuna tıklar
       // Eklenen Fleet Type'ı sildiğini görür
        extentTest.info("Closed page");
        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
