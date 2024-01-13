package tests.zehra.US30;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminDashBoard_CounterPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC05 {
    @Test
    public void test01(){
    //   Browser'ı açar
    //   URL'e gider

        AdminDashBoard_CounterPage adminDashBoard_counterPage = new AdminDashBoard_CounterPage();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        ReusableMethods.adminLoginMethod("admin11","123123123");

        // "Counter" linkine tıklar
        adminDashBoard_counterPage.linkCounter.click();

        //   Açılan sayfanın en altına iner
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        //  Yeni Counter'ın sağ tarafındaki kalem ikonunu görür ve tıklar
        softAssert.assertTrue(adminDashBoard_counterPage.kalemİkon.isDisplayed(),"kalem ikonu görünmüyor");
       ReusableMethods.wait(3);
        ReusableMethods.doubleClick(adminDashBoard_counterPage.kalemİkon);

        //   İstenen bilgileri (Name, City, Location, Mobile) günceller
        String fakerName = faker.name().firstName();
        String fakerAddress = faker.address().city();
        String fakerLocation = faker.address().cityName();
        int fakerPhone = faker.number().randomDigit();

        ReusableMethods.wait(2);
        actions.click( adminDashBoard_counterPage.counterUpdateNameTextBox)
                .sendKeys(fakerName)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerLocation)
                .sendKeys(Keys.TAB)
                .sendKeys("0"+fakerPhone)
                .perform();

        //   Pencerenin altındaki "Update" butonuna basar
        adminDashBoard_counterPage.counterUpdateButton.click();

        //   Değişikliklerin yapıldığını görür
        String actualUpdateMessage = adminDashBoard_counterPage.counterHata.getText();
        String expectedUpdateMessage = "Counter update successfully.";
        softAssert.assertEquals(actualUpdateMessage,expectedUpdateMessage,"Update edilmedi");

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
}
