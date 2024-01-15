package tests.zehra.US31;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC05 {
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
        ReusableMethods.wait(2);

       //"Seat Layouts" sayfasının "Action" başlığının altındaki kalem simgesini görür
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.ikonKalemManage.isDisplayed(),"kalem ikonu görünmedi");

       //Kalem simgesine tıklar
        adminDashBoard_manageFleetsPage.ikonKalemManage.click();

        ReusableMethods.wait(2);
       //Penceredeki "Layout" kısmına güncelemek için rakam girer
        adminDashBoard_manageFleetsPage.placeholderUpdate.click();
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.BACK_SPACE)
               .sendKeys(Keys.BACK_SPACE)
               .sendKeys("45").perform();

        // Pencerenin altındaki "Update" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonUpdate.click();

        //Bilgilerin güncellendiğini görür
        System.out.println(getCellData(1,2));
        softAssert.assertEquals(getCellData(1,2),"4 x 5","eşit değil" );



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
