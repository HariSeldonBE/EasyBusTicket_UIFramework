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
import utilities.TestBaseRapor;

public class TC10 extends TestBaseRapor {
    @Test
    public void negatifTest(){

        extentTest=extentReports.createTest("add New Negatif TEST", "Yanlış bilgilerle girilmemesi gerekiyor ");


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

        // "+Add New" butonuna tıklar
        adminDashBoard_manageFleetsPage.ButtonAddNew_FleetType.click();
        ReusableMethods.wait(2);

        // "Add Fleet Type" penceresindeki "Seats of Deck" kısmına
        // 9'dan küçük 50'ten büyük bir sayı girer

        adminDashBoard_manageFleetsPage.inputName.click();
        actions.sendKeys("KL bus").perform();
        Select select1 = new Select(adminDashBoard_manageFleetsPage.selectSeat);
        select1.selectByVisibleText("2 x 2");
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.TAB).sendKeys("1")
                .sendKeys(Keys.TAB).sendKeys("105")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .perform();
        ReusableMethods.wait(1);
        adminDashBoard_manageFleetsPage.buttonACStatus.click();
        adminDashBoard_manageFleetsPage.buttonAddFleetSave2.click();

        // Hata mesajı görür
        String expectedAlertMesaj = "Fleet type saved successfully";
        softAssert.assertFalse(expectedAlertMesaj.contains(adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText()),"başarıyla kaydedilmemesi gerekiyordu");
        extentTest.info("Hata mesajı bekleniyor");

        extentTest.info("Closed page");
        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();















    }
}
