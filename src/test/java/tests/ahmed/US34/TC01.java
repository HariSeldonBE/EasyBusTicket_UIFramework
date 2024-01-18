package tests.ahmed.US34;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminDashBoard_ProfilePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC01 {

    //Admin olarak profil bilgilerimi görüntüleyebilmeliyim

    @Test
    public void test01(){

        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        AdminDashBoard_ProfilePage adminDashBoard_profilePage = new AdminDashBoard_ProfilePage();

        // Browser açılır
        // Verilen URL ile ilgili web sitesine girilir
        // Admin Username ve Password'u ilgili yerlere girilir
        // Login butonuna tıklanır
        ReusableMethods.adminLoginMethod("admin13","123123123");

        // Açılan Admin Dashboard sayfasının sağ üst kısmında profile photo'suna
        // veya admin isminin üzerine click yapılır
        ReusableMethods.wait(2);
        adminDashBoard_profilePage.linkProfile.click();

        // Açılan dropdown menu'de "Profile" seçeneğine click yapılır
        JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoard_profilePage.ddmProfile);
        ReusableMethods.wait(1);

        // Açılan Profile sayfasında Name, Email gibi admin bilgilerinin görüntülendiği kontrol edilir
        softAssert.assertTrue(adminDashBoard_profilePage.labelName.isDisplayed());
        String actualName = adminDashBoard_profilePage.labelName.getText();
        String expectedName = "Admin13";
        softAssert.assertEquals(actualName,expectedName);

        String actualEmail = adminDashBoard_profilePage.labelEmail.getText();
        String expectedEmail = "admin13@easybusticket.com";
        softAssert.assertEquals(actualEmail,expectedEmail);

        Driver.quitDriver();
        softAssert.assertAll();
    }
}
