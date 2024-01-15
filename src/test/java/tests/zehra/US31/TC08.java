package tests.zehra.US31;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC08 {
    @Test
    public void test01(){
        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
        Actions actions = new Actions(Driver.getDriver());
        Select select1 = new Select(adminDashBoard_manageFleetsPage.selectSeat);

        // Browser'ı açar
        // URL'e gider
        ReusableMethods.adminLoginMethod("admin11", "123123123");
        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();

       // "Fleet Type" linkine tıklar
        JSUtilities.clickWithJS(Driver.getDriver(), adminDashBoard_manageFleetsPage.linkFleetTyp);
        ReusableMethods.wait(2);

       // Sayfada "+Add New" butonunu görür
         softAssert.assertTrue(adminDashBoard_manageFleetsPage.ButtonAddNew_FleetType.isDisplayed());

       // "+Add New" butonuna tıklar
        adminDashBoard_manageFleetsPage.ButtonAddNew_FleetType.click();

       // "Add Fleet Type" penceresi açılır
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.popapAddFleetType.isDisplayed());

       // İstenen bilgileri girer ve "save" butonuna tıklar
         adminDashBoard_manageFleetsPage.inputName.click();
         actions.sendKeys("VIP BUS").perform();

        select1.selectByVisibleText("Houston");
        ReusableMethods.wait(2);



        // Sayfada yeni Fleet Type eklendiğini görür









        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();
    }
}
