package tests.zehra.US31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.admin.AdminDashBoard_ManageFleetsPage;

import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC03 {


    @Test
    public void test01(){
        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
        Actions actions = new Actions(Driver.getDriver());

        // Browser'ı açar
        // URL'e gider
        ReusableMethods.adminLoginMethod("admin11","123123123");

        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();

       // Seat Layouts'a tıklar
        JSUtilities.clickWithJS(Driver.getDriver(), adminDashBoard_manageFleetsPage.linkSeatLayouts);

        // Açılan "Seat Layouts" sayfasında "Add New" butonunu görüntüler
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.buttonAddNew.isDisplayed(),"addnew görünmüyor");
        
       // "Add New" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonAddNew.click();
        
       // "Add Seat Layouts" penceresi açılır
        ReusableMethods.wait(2);
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.popapAddSeat.isDisplayed(),"pencere görünmüyor");
        
       // "Layout" kutucuğuna koltuk tipini rakam olarak girer
        adminDashBoard_manageFleetsPage.textboxLayout.click();
        actions.sendKeys("07").perform();

       // Pencerenin altındaki "Save" butonunu görür ve tıklar
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.buttonSave.isDisplayed(),"save butonu görünmedi");
        adminDashBoard_manageFleetsPage.buttonSave.click();

       // Yeni Seat layout'un eklendiğini görür
        System.out.println(getCellData(1,2));
        softAssert.assertEquals(getCellData(1,2),"0 x 7","eşit değil" );

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }

    private String getCellData(int SatirNO, int SutunNo) {
        String dinamikXpath = "//tbody/tr["+SatirNO+"]/td["+SutunNo+"]";
        WebElement istenenCellDataElementi = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        return istenenCellDataElementi.getText();
    }
}
