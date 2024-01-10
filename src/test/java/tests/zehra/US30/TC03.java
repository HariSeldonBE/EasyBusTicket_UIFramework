package tests.zehra.US30;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {
    @Test
    public void test01(){
        // Browser'ı açar
        // URL'e gider

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin11"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        // "Counter" linkine tıklar
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        adminDashBoardPage.linkCounter.click();

        // Açılan sayfada "Add New" butonunu görüntüler

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminDashBoardPage.addNewButton.isDisplayed(),"Add New butonu görünmüyor");

        // "Add New" butonuna tıklar

        adminDashBoardPage.addNewButton.click();

        // İstenen bilgileri (Name, City, Location, Mobile) girer
        Faker faker = new Faker();

         adminDashBoardPage.inputName.sendKeys(faker.name().firstName());
         adminDashBoardPage.inputCity.sendKeys(faker.address().city());
         adminDashBoardPage.inputLocation.sendKeys(faker.address().cityName());
         adminDashBoardPage.inputMobile.sendKeys(faker.phoneNumber().phoneNumber());

        // Pencerenin altındaki "Save" butonunu görür ve tıklar
        softAssert.assertTrue(adminDashBoardPage.saveButton.isDisplayed());
        adminDashBoardPage.saveButton.click();

        // Sayfanın en altına iner ve yeni Counter açtığını görür, Counter bigilerini görüntüler





    }

}
