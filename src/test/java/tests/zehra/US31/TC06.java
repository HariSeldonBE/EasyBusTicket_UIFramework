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

public class TC06 {

    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
        Actions actions = new Actions(Driver.getDriver());

        // Browser'ı açar
        // URL'e gider
        ReusableMethods.adminLoginMethod("admin11", "123123123");
        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();

        // Seat Layouts'a tıklar
        JSUtilities.clickWithJS(Driver.getDriver(), adminDashBoard_manageFleetsPage.linkSeatLayouts);
        ReusableMethods.wait(2);

        //"Action" başlığının altındaki çöp kutusu simgesini gürür tıklar
        String expectedLayoutBilgisi = getCellData(1,2);

        softAssert.assertTrue(adminDashBoard_manageFleetsPage.ikonDeleteManage.isDisplayed(),"delete ikonu görünmedi");
        adminDashBoard_manageFleetsPage.ikonDeleteManage.click();

        ReusableMethods.wait(2);
        // "Delete Seat Layouts" penceresi açılır
         softAssert.assertTrue(adminDashBoard_manageFleetsPage.popapDeleteSeat.isDisplayed(),"pencereyi görmüyor");

       // Pencerede "Are you sure, you want to delete this?" yazısını görüntüler
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.strongAreYouSureWant.isDisplayed(),"penceredekiyazı görünmedi");

       // "Delete" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonDelete.click();

        ReusableMethods.wait(2);
        // Seat layout'u sildiğini görür
        softAssert.assertNotEquals(getCellData(1,2),expectedLayoutBilgisi,"silmemiş demektir");

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