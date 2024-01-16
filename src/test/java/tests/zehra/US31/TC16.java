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

public class TC16 {
    @Test
    public void test(){

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        // Browser'ı açar
        // URL'e gider
        ReusableMethods.adminLoginMethod("admin11", "123123123");

        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();

        // "Vehicles" linkine tıklar
        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoard_manageFleetsPage.linkVehicles1);

        // "+Add New" butonunu görür
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.buttonAddNew_Vehicles.isDisplayed());

        // "+Add New" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonAddNew_Vehicles.click();
        ReusableMethods.wait(2);

        // "Add Vehicle" başlılklı bir pecere açılır
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.tableAddVehicle.isDisplayed(),"pencereyi görmüyor");

      // "Nick Name, Reg. No., Engine No., Chasis No., Model No., Fleet Type" alanlarını doldurur
       ReusableMethods.wait(1);
        adminDashBoard_manageFleetsPage.inputNickName.click();
                actions.sendKeys(faker.name().username())
                .sendKeys(Keys.TAB).perform();
        Select select = new Select(adminDashBoard_manageFleetsPage.selectFleetType_Vehicle);
        select.selectByVisibleText("w bus");
        actions.click(adminDashBoard_manageFleetsPage.inputRegister_Vehicle)
                .sendKeys(faker.number().digit()).sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit()).sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit()).sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit()).perform();


        // "Save" butonu görür
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.buttonSave_AddVehicle.isDisplayed(),"save butonu görmüyor");

      // "Save" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonSave_AddVehicle.click();
        ReusableMethods.wait(1);

      // Yeni araç ekleme işleminin yapıldığını görür
        String expectedAddNewMesajı = "Vehicle save successfully.";
        String actualAddNew = adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText();
        softAssert.assertEquals(actualAddNew,expectedAddNewMesajı,"başarılı mesajı görünmedi");










        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
