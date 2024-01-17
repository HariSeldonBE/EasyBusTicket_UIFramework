package tests.zehra.US31;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC11 {
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

      // "Action" başlığının altındaki kalem simgesini görür ve tıklar
         softAssert.assertTrue(adminDashBoard_manageFleetsPage.buttonUpdate_Fleet.isDisplayed(),"update görünmedi");
         adminDashBoard_manageFleetsPage.buttonUpdate_Fleet.click();

      // İstenen bilgileri düzenler ve "Update" butonuna tıklar
        adminDashBoard_manageFleetsPage.inputName2.click();
        actions.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys("a bus").perform();
        Select select2 = new Select(adminDashBoard_manageFleetsPage.selectSeat3);
        select2.selectByVisibleText("1 x 3");
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys("1")
                .sendKeys(Keys.TAB).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys("8")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .click()
                .perform();
        ReusableMethods.wait(2);

        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoard_manageFleetsPage.buttonUpdate2);

       // Bilgilerin güncellendiğini görür
        String expectedAlertMesaj = "Fleet type updated successfully";
        softAssert.assertEquals(adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText(),expectedAlertMesaj,"başarıyla kaydedilmesi gerekiyordu");

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();



    }
}
