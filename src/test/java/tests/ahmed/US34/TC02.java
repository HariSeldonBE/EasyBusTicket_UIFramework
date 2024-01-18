package tests.ahmed.US34;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminDashBoard_ProfilePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
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
        adminDashBoard_profilePage.linkProfile.click();
        adminDashBoard_profilePage.ddmProfile.click();

        // Name, Email ve Image bilgilerinin değiştirilebildiği kontrol edilir
        String username = "admin13";
        String newUsername = "ahmed13";
        String email = "admin13@easybusticket.com";
        String newEmail = "ahmed13@easybusticket.com";
        adminDashBoard_profilePage.textboxName.clear();
        adminDashBoard_profilePage.textboxName.sendKeys(newUsername);
        adminDashBoard_profilePage.textboxEmail.clear();
        adminDashBoard_profilePage.textboxEmail.sendKeys(newEmail);

        // Gerekli değişiklikler yapıldıktan sonra Save Changes button'una basılır
        JSUtilities.clickWithJS(Driver.getDriver(), adminDashBoard_profilePage.SaveChangesButton);

        // Değişiklikler kaydedildikten sonra profil bilgilerinin güncellendiğini kontrol edilir
        softAssert.assertEquals(adminDashBoard_profilePage.labelName.getText(),newUsername,"Username guncellenmis mi?");
        softAssert.assertEquals(adminDashBoard_profilePage.labelEmail.getText(),newEmail,"Email guncellenmis mi?");

        adminDashBoard_profilePage.textboxName.clear();
        adminDashBoard_profilePage.textboxName.sendKeys(username);
        adminDashBoard_profilePage.textboxEmail.clear();
        adminDashBoard_profilePage.textboxEmail.sendKeys(email);
        JSUtilities.clickWithJS(Driver.getDriver(), adminDashBoard_profilePage.SaveChangesButton);
        softAssert.assertEquals(adminDashBoard_profilePage.labelName.getText(),username,"Username eski haline donmus mu?");
        softAssert.assertEquals(adminDashBoard_profilePage.labelEmail.getText(),email,"Email eski haline donmus mu?");












        ReusableMethods.wait(2);
        Driver.quitDriver();
    }
}
