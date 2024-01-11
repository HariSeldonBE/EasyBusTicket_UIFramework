package tests.ahmed.US32;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {



    // Route sayfasındaki tüm rotaları görüntüleyebilmeli,
    // yeni rotalar ekleyip, eklediğim rotanın bilgilerini görüntüleyebilmeli,
    // eklediğim rotanın durumunu Active/Disable olarak değiştirebilmeliyim.
    @Test
    public void test01(){

        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

        ReusableMethods.adminLoginMethod("admin13","123123123");

        //Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        //adminLoginPage.usernameBox.click();
        //adminLoginPage.usernameBox.sendKeys("admin13" + Keys.TAB);
        //adminLoginPage.passwordBox.sendKeys("123123123");
        //adminLoginPage.loginButton.click();

        adminDashBoardPage.manageTripsLink.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        softAssert.assertTrue(adminDashBoardPage.routeElement.isDisplayed());
        adminDashBoardPage.routeElement.click();
        ReusableMethods.wait(1);

        softAssert.assertTrue(adminDashBoardPage.firstRouteName.isDisplayed());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        softAssert.assertTrue(adminDashBoardPage.lastRouteName.isDisplayed());
        actions.sendKeys(Keys.PAGE_UP).perform();

        Faker faker = new Faker();
        String routeName = faker.gameOfThrones().house();
        ReusableMethods.wait(2);
        adminDashBoardPage.routeAddNewButton.sendKeys(Keys.ENTER);
        adminDashBoardPage.nameOfTheNewRouteBox.click();
        adminDashBoardPage.nameOfTheNewRouteBox.sendKeys(routeName);
        ReusableMethods.wait(2);
        adminDashBoardPage.startFromBox.sendKeys(Keys.ENTER);
        Select select1 = new Select(adminDashBoardPage.selectStartFromBox);
        select1.selectByVisibleText("Houston");
        ReusableMethods.wait(2);
        adminDashBoardPage.endToBox.sendKeys(Keys.ENTER);
        Select select2 = new Select(adminDashBoardPage.selectEndToBox);
        select2.selectByVisibleText("Austin");
        adminDashBoardPage.timeOfTheNewRoute.click();
        adminDashBoardPage.timeOfTheNewRoute.sendKeys("a few hours:)");
        adminDashBoardPage.distanceOfTheNewRoute.click();
        adminDashBoardPage.distanceOfTheNewRoute.sendKeys("a few miles");
        adminDashBoardPage.routeSaveButton.click();
        adminDashBoardPage.routeAddNewGoBackButton.click();

        adminDashBoardPage.routeIlkRotaKalemButton.click();
        softAssert.assertTrue(adminDashBoardPage.routeInfoNameBox.getText().equals(routeName));
        softAssert.assertTrue(adminDashBoardPage.routeInfoTimeBox.getText().equals("a few hours:)"));
        softAssert.assertTrue(adminDashBoardPage.routeInfoDistanceBox.getText().equals("a few miles"));
        adminDashBoardPage.routeUpdateGoBackButton.click();

        softAssert.assertTrue(adminDashBoardPage.routeActiveStatusElement.isDisplayed());
        adminDashBoardPage.routeFirstRowDisableButton.click();
        adminDashBoardPage.routedisablePopUpButton.click();
        softAssert.assertTrue(adminDashBoardPage.routeDisableStatusElement.isDisplayed());


        ReusableMethods.wait(2);
        Driver.quitDriver();


    }
}
