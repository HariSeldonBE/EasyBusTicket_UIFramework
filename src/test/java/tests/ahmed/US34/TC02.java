package tests.ahmed.US34;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminDashBoard_ProfilePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    //Admin olarak profil bilgilerimi güncelleyebilmeliyim
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

        // Profile sayfasında bulunan "profile Information" box'unda
        // Name, Email ve Image bilgilerinin değiştirilebildiği kontrol edilir
        adminDashBoard_profilePage.linkProfile.click();
        adminDashBoard_profilePage.ddmProfile.click();



        // Gerekli değişiklikler yapıldıktan sonra Save Changes button'una basılır
       // Değişiklikler kaydedildikten sonra profil bilgilerinin güncellendiğini kontrol edilir






        ReusableMethods.wait(2);
        Driver.quitDriver();
    }
}
