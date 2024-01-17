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

public class TC18 {
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
        ReusableMethods.wait(2);

        // Açılan "All Vehicles" sayfasında "Action" başlığının altında kalem simgesi görür ve tıklar
        softAssert.assertTrue(adminDashBoard_manageFleetsPage.buttonKalem_Vehicle.isDisplayed());
        adminDashBoard_manageFleetsPage.buttonKalem_Vehicle.click();

        // "Nick Name, Reg. No., Engine No., Chasis No., Model No., Fleet Type" alanlarını günceller
        ReusableMethods.wait(2);
        actions.moveToElement(adminDashBoard_manageFleetsPage.textboxNickName_Update).click().build().perform();
        adminDashBoard_manageFleetsPage.textboxNickName_Update.clear();
        ReusableMethods.wait(2);
        adminDashBoard_manageFleetsPage.textboxNickName_Update.sendKeys(faker.name().username());
        Select select = new Select(adminDashBoard_manageFleetsPage.selectFleetTypeUpdate_Vehicle);
        select.selectByVisibleText("q bus");
        actions.moveToElement(adminDashBoard_manageFleetsPage.textboxRegister_VehicleUPdate).click().build().perform();
        ReusableMethods.wait(2);
        adminDashBoard_manageFleetsPage.textboxRegister_VehicleUPdate.clear();
        adminDashBoard_manageFleetsPage.textboxRegister_VehicleUPdate.sendKeys(faker.number().digits(10));
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.CLEAR).sendKeys(faker.number().digits(11)).sendKeys(Keys.TAB)
                .sendKeys(Keys.CLEAR).sendKeys(faker.number().digits(14)).sendKeys(Keys.TAB)
                .sendKeys(Keys.CLEAR).sendKeys(faker.number().digits(15)).perform();

        // "Update" butonuna tıklar
         adminDashBoard_manageFleetsPage.buttonUpdate_Vehicle.click();


        // Güncelleme işleminin yapıldığını görür
        String expectedAddNewMesajı = "Vehicle update successfully.";
        String actualAddNew = adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText();
        softAssert.assertEquals(actualAddNew,expectedAddNewMesajı,"başarılı mesajı görünmredü");





        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
