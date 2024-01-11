package tests.ahmed.US32;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC03 {

    //Schedule sayfasındaki tüm hareket saatlerini görüntüleyebilmeli,
    // yeni ekleyebilmeli, eklediğimi düzenleyebilmeli ve active/disable yapabilmeliyim
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
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).perform();
        softAssert.assertTrue(adminDashBoardPage.scheduleElement.isDisplayed());
        adminDashBoardPage.scheduleElement.click();
        ReusableMethods.wait(1);

        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowStartFromElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowEndAtElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowDurationElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowStatusElement.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowActionElement.isDisplayed());

        adminDashBoardPage.scheduleAddNewButton.click();
        Faker faker = new Faker();
        int ilkSaat = faker.number().numberBetween(1,11);
        int ilkDakika = faker.number().numberBetween(10,59);
        int ikinciSaat = faker.number().numberBetween(12,23);
        int ikinciDakika = faker.number().numberBetween(10,59);
        adminDashBoardPage.scheduleAddNewStartFromBox.sendKeys(ilkSaat+":"+ilkDakika);
        adminDashBoardPage.scheduleAddNewEndAtBox.sendKeys(ikinciSaat+":"+ikinciDakika+Keys.ENTER);
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowStartFromElement.getText().contains("09:55"));
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowStartFromElement.getText().contains("12:55"));

        adminDashBoardPage.scheduleFirstRowPenButton.click();
        adminDashBoardPage.scheduleupdatePopUpStartFromBox.click();
        adminDashBoardPage.scheduleUpdatePopUpStartFromClockPickerElement.click();
        adminDashBoardPage.scheduleUpdatePopUpStartFromSecondClockPickerElement.click();
        adminDashBoardPage.scheduleupdatePopUpEndAtBox.click();
        adminDashBoardPage.scheduleUpdatePopUpEndAtClockPickerElement.click();
        adminDashBoardPage.scheduleUpdatePopUpEndAtSecondClockPickerElement.click();
        adminDashBoardPage.scheduleUpdatePopUpUpdateButton.click();

        ReusableMethods.wait(2);
        Driver.quitDriver();

    }
}
