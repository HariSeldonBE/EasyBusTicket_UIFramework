package tests.ahmed.US32;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC04 {

    //Ticket price sayfasında bilet fiyatlarını görüntüleyebilmeliyim,yeni ekleyebilmeli, eklediğimi düzenleyebilmeli ve silebilmeliyim
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
        softAssert.assertTrue(adminDashBoardPage.ticketPriceElement.isDisplayed());
        adminDashBoardPage.ticketPriceElement.click();
        ReusableMethods.wait(1);
        softAssert.assertTrue(adminDashBoardPage.tpFleetTypeElement.isDisplayed());
        adminDashBoardPage.tpAddNewButton.click();
        ReusableMethods.wait(1);
        adminDashBoardPage.tpAddNewFleetTypeBox.click();
        Select select1 = new Select(adminDashBoardPage.tpAddNewFleetTypeSelect);
        select1.selectByVisibleText("CLASSIC BUS");
        adminDashBoardPage.tpAddNewFleetTypeBox.click();
        ReusableMethods.wait(2);
        adminDashBoardPage.tpAddNewRouteBox.click();
        Select select2 = new Select(adminDashBoardPage.tpAddNewRouteSelect);
        select2.selectByVisibleText("Grey");
        adminDashBoardPage.tpAddNewRouteBox.click();
        Faker faker1 = new Faker();
        int price = faker1.number().numberBetween(1,10);
        adminDashBoardPage.tpAddNewPriceBox.sendKeys(price+"0");
        ReusableMethods.wait(1);
        adminDashBoardPage.tpAddNewSecondPriceBox.sendKeys(price+"0");
        ReusableMethods.wait(1);
        adminDashBoardPage.tpAddNewSaveButton.click();
        ReusableMethods.wait(1);
        adminDashBoardPage.tpAddNewGoBackButton.click();
        softAssert.assertTrue(adminDashBoardPage.tpFirstRowRouteElement.getText().contains("Grey"),"Eklenen tp'nin ismi dogru mu?");
        softAssert.assertTrue(adminDashBoardPage.tpFirstRowPriceElement.getText().contains(price+"0"),"Eklenen tp'nin fiyati dogru mu?");
        adminDashBoardPage.tpFirstRowEditButton.click();
        adminDashBoardPage.tpEditPagePriceInputBox.sendKeys(Keys.BACK_SPACE);
        adminDashBoardPage.tpEditPagePriceInputBox.sendKeys(Keys.BACK_SPACE);
        Faker faker2 = new Faker();
        int priceUpdated = faker2.number().numberBetween(1,10);
        adminDashBoardPage.tpEditPagePriceInputBox.sendKeys(priceUpdated+"0");
        adminDashBoardPage.tpEditPageUpdateButton.click();
        adminDashBoardPage.tpEditPageGoBackButton.click();
        softAssert.assertTrue(adminDashBoardPage.tpFirstRowPriceElement.getText().contains(priceUpdated+"0"),"Guncellenen tp'nin guncellenmis fiyati dogru mu?");
        adminDashBoardPage.tpFirstRowDeleteButton.click();
        adminDashBoardPage.tpDeletePopUpDeletButton.click();
        softAssert.assertFalse(adminDashBoardPage.tpFirstRowRouteElement.getText().contains("Grey"),"tp silinmis mi?");

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.quitDriver();
    }
}
