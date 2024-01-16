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

public class TC17 {
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

        // "+Add New" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonAddNew_Vehicles.click();
        ReusableMethods.wait(2);

       //  "Nick Name 7 karakter, Reg. No 7 karakter, Engine No. 18 karakter, Chasis No. 18 karakter,
        //  Model No.  2024 ve altı, Fleet Type anlamlı kelime veya cümle" haricinde değerler girerek alanlarını doldurur
        ReusableMethods.wait(1);
        adminDashBoard_manageFleetsPage.inputNickName.click();
        actions.sendKeys("1111111111111")
                .sendKeys(Keys.TAB).perform();
        Select select = new Select(adminDashBoard_manageFleetsPage.selectFleetType_Vehicle);
        select.selectByVisibleText("w bus");
        actions.click(adminDashBoard_manageFleetsPage.inputRegister_Vehicle)
                .sendKeys("222222222222222").sendKeys(Keys.TAB)
                .sendKeys("33333333333333333333333333").sendKeys(Keys.TAB)
                .sendKeys("111111111111111111111111111111111").sendKeys(Keys.TAB)
                .sendKeys("111111111").perform();

        // "Save" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonSave_AddVehicle.click();
        ReusableMethods.wait(1);

        //  Hata mesajını görür
        String expectedAddNewMesajı = "Vehicle save successfully.";
        String actualAddNew = adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText();
        softAssert.assertNotEquals(actualAddNew,expectedAddNewMesajı,"başarılı mesajı göründü");








        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
