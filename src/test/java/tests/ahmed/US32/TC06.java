package tests.ahmed.US32;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC06 {

    //Assigned Vehicles menüsünden tüm atanmış araçları görüntüleyebilmeli, yeni ekleyebilmeli, eklediğimi düzenleyebilmeliyim
    @Test
    public void test01(){
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

        ReusableMethods.adminLoginMethod("admin13","123123123");

        adminDashBoardPage.manageTripsLink.click();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        softAssert.assertTrue(adminDashBoardPage.assignedVehicleElement.isDisplayed());
        adminDashBoardPage.assignedVehicleElement.click();
        ReusableMethods.wait(1);

        softAssert.assertTrue(adminDashBoardPage.avTripTitleElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.avNicknameElement.isDisplayed());
        adminDashBoardPage.avAddNewButton.click();
        adminDashBoardPage.avAddNewTripTitleBox.click();
        Select select1 = new Select(adminDashBoardPage.avAddNewTripTitleSelect);
        select1.selectByValue("127");
        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoardPage.avAddNewVehicleNameBox);
        
        Select select2 = new Select(adminDashBoardPage.avAddNewVehicleNameSelect);
        select2.selectByVisibleText(" Lannister (8888) ");

        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoardPage.avAddNewSaveButton);
        softAssert.assertTrue(adminDashBoardPage.avTripTitleElement.getText().contains("Fletcher - Houston - Austin"));
        softAssert.assertTrue(adminDashBoardPage.avNicknameElement.getText().contains("Lannister"));

        adminDashBoardPage.avEditButton.click();
        adminDashBoardPage.avUpdateTripBox.click();
        Select select3 = new Select(adminDashBoardPage.avUpdateTripSelect);
        select3.selectByValue("128"); // gotta update
        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoardPage.avUpdateVehicleBox);
        Select select4 = new Select(adminDashBoardPage.avUpdateVehicleSelect);
        select4.selectByVisibleText(" Stark (987) ");
        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoardPage.avUpdatePopUpUpdateButton);
        softAssert.assertTrue(adminDashBoardPage.avTripTitleElement.getText().contains("Fletcher - Houston - Austin"));
        softAssert.assertTrue(adminDashBoardPage.avNicknameElement.getText().contains("Stark"));


        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.quitDriver();
    }
}
