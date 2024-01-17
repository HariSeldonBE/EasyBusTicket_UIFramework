package tests.zeliha.US28;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class TC01 {



    @Test
    public void SupportRequestTesti(){

    /*

    TC28 - Admin olarak giriş yapıldığında "Support Request" menüsü görüntülenebilmeli.

    STEPLER
    1 - Browser açılır.
    2 -	URL'e gidilir.
    3 -	Admin olarak giriş yapılır.
    4 -	Dashboard sayfasının solunda  "Support Request" linkinin görünür olduğu doğrulanır.
    5 -	"Support Request"  linki tıklanır.
    6 -	"Support Request"  Linkine tıklandığında, "All Requests" linkinin görünür ve aktif olduğu doğrulanır.
    7 -	"Support Request"  Linkine tıklandığında, "Pending Requests" linkinin görünür ve aktif olduğu doğrulanır.
    8 -	"Support Request"  Linkine tıklandığında, "Closed Requests" linkinin görünür ve aktif olduğu doğrulanır.
    9 -	"Support Request"  Linkine tıklandığında, "Answered Requests" linkinin görünür ve aktif olduğu doğrulanır.

   */

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        Actions actions = new Actions(Driver.getDriver());
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        softAssert.assertTrue(adminDashBoardPage.supportRequestButton.isDisplayed(),"Booking History linki Görüntülenemedi.");
        adminDashBoardPage.supportRequestButton.click();

        Driver.quitDriver();
    }




}
