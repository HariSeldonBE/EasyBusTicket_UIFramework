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
    public void test01() throws InterruptedException {

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
        adminDashBoardPage.scheduleAddNewStartFromBox.click();
        ReusableMethods.wait(2);
        adminDashBoardPage.scheduleAddNewStartFromBox.sendKeys("11:11"+Keys.TAB);
        adminDashBoardPage.scheduleAddNewEndAtBox.sendKeys(ikinciSaat+":"+ikinciDakika);
        actions.sendKeys(Keys.ENTER).perform();
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowStartFromElement.getText().contains("11:11"),"Start from saati dogru eklenmis mi listeye");
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowEndAtElement.getText().contains((ikinciSaat-12)+":"+ikinciDakika),"End At saati dogru eklenmis mi listeye");

        ReusableMethods.wait(2);
        Faker faker2 = new Faker();
        int ikinciSaat2 = faker2.number().numberBetween(12,23);
        int ikinciDakika2 = faker2.number().numberBetween(10,59);
        adminDashBoardPage.scheduleFirstRowPenButton.click();
        adminDashBoardPage.scheduleupdatePopUpStartFromBox.click();
        adminDashBoardPage.scheduleupdatePopUpStartFromBox.sendKeys(Keys.BACK_SPACE);
        adminDashBoardPage.scheduleupdatePopUpStartFromBox.sendKeys(Keys.BACK_SPACE);
        adminDashBoardPage.scheduleupdatePopUpStartFromBox.sendKeys(Keys.BACK_SPACE);
        adminDashBoardPage.scheduleupdatePopUpStartFromBox.sendKeys(Keys.BACK_SPACE);
        adminDashBoardPage.scheduleupdatePopUpStartFromBox.sendKeys(Keys.BACK_SPACE);
        adminDashBoardPage.scheduleupdatePopUpStartFromBox.sendKeys("10:59"+Keys.TAB);
        adminDashBoardPage.scheduleupdatePopUpEndAtBox.sendKeys(ikinciSaat2+":"+ikinciDakika2+Keys.ENTER);
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowStartFromElement.getText().contains("10:59"),"Start from saati dogru guncellenmis mi listeye");
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowEndAtElement.getText().contains((ikinciSaat2-12)+":"+ikinciDakika2),"End At saati dogru guncellenmis mi listeye");
        ReusableMethods.wait(1);
        softAssert.assertTrue(adminDashBoardPage.scheduleUpdatePopUpUpdateButton.isEnabled(),"Update pop-up update butonu aktif degil");

        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowActiveElement.isDisplayed());
        adminDashBoardPage.scheduleFirstRowDisableButton.click();
        adminDashBoardPage.scheduleDisablePopUpDisableButton.click();
        softAssert.assertTrue(adminDashBoardPage.scheduleFirstRowDisabledElement.isDisplayed());
        softAssert.assertAll();

        ReusableMethods.wait(2);
        Driver.quitDriver();

    }
}
