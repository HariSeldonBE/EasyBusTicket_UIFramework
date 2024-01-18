package tests.ahmed.US34;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {

    //Admin olarak şifremi değiştirebilmeliyim
    @Test
    public void test01(){
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        String password = "123123123";
        String newPassword = "123123";
        ReusableMethods.adminLoginMethod("admin13",password);

        adminDashBoardPage.adminDashboardProfileButton.click();
        adminDashBoardPage.adminProfilePasswordButton.click();
        adminDashBoardPage.adminProfilePasswordSettingButton.click();

        adminDashBoardPage.adminPasswordPasswordBox.sendKeys(password);
        adminDashBoardPage.adminPasswordNewPasswordBox.sendKeys(newPassword);
        adminDashBoardPage.adminPasswordConfirmPasswordBox.sendKeys(newPassword);
        adminDashBoardPage.adminPasswordSaveChangesButton.click();

        adminDashBoardPage.adminDashboardProfileButton.click();
        adminDashBoardPage.adminProfileLogoutButton.click();
        String expectedUrl = "https://qa.easybusticket.com/admin";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);
        adminLoginPage.usernameBox.sendKeys("admin13");
        adminLoginPage.passwordBox.sendKeys(newPassword); // doldur
        adminLoginPage.loginButton.click();
        String expectedUrl2 = "https://qa.easybusticket.com/admin/dashboard";
        String actualUrl2 = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl2,expectedUrl2);

        adminDashBoardPage.adminDashboardProfileButton.click();
        adminDashBoardPage.adminProfilePasswordButton.click();
        adminDashBoardPage.adminProfilePasswordSettingButton.click();

        adminDashBoardPage.adminPasswordPasswordBox.sendKeys(newPassword);
        adminDashBoardPage.adminPasswordNewPasswordBox.sendKeys(password);
        adminDashBoardPage.adminPasswordConfirmPasswordBox.sendKeys(password);
        adminDashBoardPage.adminPasswordSaveChangesButton.click();

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.quitDriver();
    }
}
