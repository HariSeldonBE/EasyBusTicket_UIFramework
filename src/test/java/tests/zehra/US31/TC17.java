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

public class TC17 extends TestBaseRapor {
    @Test
    public void addNew_Vehicles_NegatifTest(){

        extentTest=extentReports.createTest("ZEHRA_Add New Vehicles Negatif TEST", "US_31  TC_17  Yanlış bilgilerle girilmemesi gerekiyor ");

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
        actions.sendKeys(""+faker.number().numberBetween(11111111,1111111111))
                .sendKeys(Keys.TAB).perform();
        Select select = new Select(adminDashBoard_manageFleetsPage.selectFleetType_Vehicle);
        select.selectByVisibleText("w bus");
        actions.click(adminDashBoard_manageFleetsPage.inputRegister_Vehicle)
                .sendKeys(""+faker.number().numberBetween(1111111,1111111111)).sendKeys(Keys.TAB)
                .sendKeys("3333333333333333333833933").sendKeys(Keys.TAB)
                .sendKeys("111111111111111111111111711111").sendKeys(Keys.TAB)
                .sendKeys(""+faker.number().numberBetween(2024,100000)).perform();

        // "Save" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonSave_AddVehicle.click();
        ReusableMethods.wait(1);

        //  Hata mesajını görür
        String expectedAddNewMesajı = "Vehicle save successfully.";
        String actualAddNew = adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText();
        softAssert.assertNotEquals(actualAddNew,expectedAddNewMesajı,"başarılı mesajı göründü");
        extentTest.info("Hata mesajı bekleniyor");

        extentTest.info("Closed page");
        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
