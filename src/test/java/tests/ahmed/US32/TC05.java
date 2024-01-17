package tests.ahmed.US32;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC05 {

    //Trip sayfasında tüm seyahat tiplerini görüntüleyebilmeli, yeni ekleyebilmeli, eklediğimi düzenleyebilmeli ve Active/Disable olarak değiştirebilmeliyim
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
        softAssert.assertTrue(adminDashBoardPage.tripElement.isDisplayed());
        adminDashBoardPage.tripElement.click();
        ReusableMethods.wait(1);
        softAssert.assertTrue(adminDashBoardPage.tripFirstRowTitle.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.tripFirstRowDayOff.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.tripFirstRowAc.isDisplayed());

        adminDashBoardPage.tripAddNewButton.click();
        Faker faker1 = new Faker();
        String tripTitle = faker1.gameOfThrones().character();
        adminDashBoardPage.tripAddNewPopUpTitleBox.sendKeys(tripTitle);

        adminDashBoardPage.tripAddNewFleetTypeBox.click();
        Select select1 = new Select(adminDashBoardPage.tripAddNewFleetTypeSelect);
        select1.selectByVisibleText("Roberta");
        adminDashBoardPage.tripAddNewFleetTypeBox.click();

        adminDashBoardPage.tripAddNewRouteBox.click();
        Select select2 = new Select(adminDashBoardPage.tripAddNewRouteSelect);
        select2.selectByVisibleText("Locke of Oldcastle");
        adminDashBoardPage.tripAddNewRouteBox.click();

        adminDashBoardPage.tripAddNewScheduleBox.click();
        Select select3 = new Select(adminDashBoardPage.tripAddNewScheduleSelect);
        select3.selectByVisibleText("11:11 am - 07:18 pm");
        adminDashBoardPage.tripAddNewScheduleBox.click();

        adminDashBoardPage.tripAddNewStartFromBox.click();
        Select select4 = new Select(adminDashBoardPage.tripAddNewStartFromSelect);
        select4.selectByVisibleText("Houston");
        adminDashBoardPage.tripAddNewStartFromBox.click();

        adminDashBoardPage.tripAddNewEndToBox.click();
        Select select5 = new Select(adminDashBoardPage.tripAddNewEndToSelect);
        select5.selectByVisibleText("Austin");
        adminDashBoardPage.tripAddNewEndToBox.click();

        adminDashBoardPage.tripAddNewDayOffBox.sendKeys("Sunday"+Keys.ENTER);
        adminDashBoardPage.tripAddNewSaveButton.click();

        softAssert.assertTrue(adminDashBoardPage.tripFirstRowTitle.getText().contains("Roberta - Houston - Austin"),"Trip'in ismi dogru yazilmis mi listeye");
        softAssert.assertTrue(adminDashBoardPage.tripFirstRowDayOff.getText().contains("Sunday"),"Trip'in day off'lari listede dogru gorunuyor mu");

        adminDashBoardPage.tripFirstRowEditButton.click();
        adminDashBoardPage.tripUpdateScheduleBox.click();
        Select select6 = new Select(adminDashBoardPage.tripUpdateScheduleSelect);
        select6.selectByVisibleText("11:11 am - 06:36 pm");
        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoardPage.tripUpdateButton);
        ReusableMethods.wait(2);

        softAssert.assertTrue(adminDashBoardPage.tripFirstRowActiveElement.isDisplayed(),"Trip'in status'u active mi?");
        adminDashBoardPage.tripFirstRowDisableButton.click();
        adminDashBoardPage.tripDisablePopUpDisableButton.click();
        softAssert.assertTrue(adminDashBoardPage.tripFirstRowDisabledElement.isDisplayed(),"Trip'in status'i disabled mi?");

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.quitDriver();

        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //ReusableMethods.wait(2);
        //js.executeScript("arguments[0].scrollIntoView()",adminDashBoardPage.tripUpdateButton);
    }
}
