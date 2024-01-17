package tests.zehra.US31;

import com.github.javafaker.Faker;
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

public class TC09 extends TestBaseRapor {
    @Test
    public void negatifFleetTypeTest(){
        extentTest=extentReports.createTest("ZEHRA_Add New Fleet Type Negatif TEST", "US_31  TC_09  Yanlış bilgilerle yeni giriş yapılmaması gerekiyor");

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

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

       // "Add Fleet Type" penceresindeki "No of Deck" kısmına 3'ten büyük bir sayı girer
        adminDashBoard_manageFleetsPage.inputName.click();
        actions.sendKeys(faker.name().title()).perform();
        Select select1 = new Select(adminDashBoard_manageFleetsPage.selectSeat);
        select1.selectByVisibleText("2 x 1");
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.TAB).sendKeys("4")
                .sendKeys(Keys.TAB).sendKeys(""+faker.number().numberBetween(1,100))
                .sendKeys(Keys.TAB).sendKeys(""+faker.number().numberBetween(1,100))
                .sendKeys(Keys.TAB).sendKeys(""+faker.number().numberBetween(1,100))
                .sendKeys(Keys.TAB).sendKeys(""+faker.number().numberBetween(1,100))
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .perform();
        ReusableMethods.wait(1);
        adminDashBoard_manageFleetsPage.buttonACStatus.click();
        adminDashBoard_manageFleetsPage.buttonAddFleetSave2.click();

        extentTest.info("Hata mesajı görülmesi gerekiyor");
       // Hata mesajı görür
        String expectedAlertMesaj = "Fleet type saved successfully";
        softAssert.assertFalse(expectedAlertMesaj.contains(adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText()),"başarıyla kaydedilmemesi gerekiyordu");

        extentTest.info("Closed page");
        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
