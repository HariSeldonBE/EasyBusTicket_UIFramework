package tests.zehra.US31;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC15 {
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

        //  Açılan "All Vehicles" sayfasında "+Add New" butonun yanındaki
        //  arama kutusunu görür ve tıklar
         softAssert.assertTrue(adminDashBoard_manageFleetsPage.inputSearch_Vehicles.isDisplayed());
         adminDashBoard_manageFleetsPage.inputSearch_Vehicles.click();

        //  Register Number'a göre arama yapar

        actions.sendKeys("1234").sendKeys(Keys.ENTER).perform();
        String expectedTitle = "Easy Bus Ticket - Vehicles - 1234";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        softAssert.assertEquals(actualTitle,expectedTitle,"başlık eşit değil");


        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();



    }
}
