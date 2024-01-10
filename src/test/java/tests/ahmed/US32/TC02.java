package tests.ahmed.US32;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.LinkedList;
import java.util.List;

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

        ReusableMethods.wait(2);
        adminDashBoardPage.addNewButton.sendKeys(Keys.ENTER);
        adminDashBoardPage.nameOfTheNewRouteBox.click();
        adminDashBoardPage.nameOfTheNewRouteBox.sendKeys("Alex Rider");
        ReusableMethods.wait(2);
        adminDashBoardPage.startFromBox.click();
        Select select1 = new Select(adminDashBoardPage.startFromBox);
        select1.selectByVisibleText("Houston");
        adminDashBoardPage.endToBox.click();
        Select select2 = new Select(adminDashBoardPage.endToBox);
        select2.selectByVisibleText("Austin");
        adminDashBoardPage.timeOfTheNewRoute.click();
        adminDashBoardPage.timeOfTheNewRoute.sendKeys("3 Hours");
        adminDashBoardPage.distanceOfTheNewRoute.click();
        adminDashBoardPage.distanceOfTheNewRoute.sendKeys("165 Miles");
        adminDashBoardPage.saveButton.click();



        ReusableMethods.wait(2);
        Driver.quitDriver();


    }
}
