package tests.zehra.US33;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoard_HeaderPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void test01(){
        AdminDashBoard_HeaderPage adminDashBoard_headerPage = new AdminDashBoard_HeaderPage();
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());

       // 1-Browser açılır
       // 2-Url 'e  gidilir
        ReusableMethods.adminLoginMethod("admin11","123123123");

       // 3-Dashboard sayfasındaki header bölümündeki arama butonunun göründüğü doğrulanır
        softAssert.assertTrue(adminDashBoard_headerPage.buttonHeaderSearch.isDisplayed());

       // 4- Arama butonunun aktif olduğu doğrulanır
        softAssert.assertTrue(adminDashBoard_headerPage.buttonHeaderSearch.isEnabled());

       // 5-Arama butonuna tıklandığında search placeholder'ın açıldığı doğrulanır
        adminDashBoard_headerPage.buttonHeaderSearch.click();
        softAssert.assertTrue(adminDashBoard_headerPage.navbarSearchField.isDisplayed());

        // 6-Search placeholder'ına istenen sayfa yazılabildiği doğrulanır
        softAssert.assertTrue(adminDashBoard_headerPage.navbarSearchField.isEnabled());

       // 7-Search placeholder'ına yazılan sayfaya gittiği doğrulanır
        adminDashBoard_headerPage.navbarSearchField.click();
        actions.sendKeys("about").perform();
        actions.moveToElement(adminDashBoard_headerPage.labelSearchAbout)
                .doubleClick(adminDashBoard_headerPage.labelSearchAbout)
                .perform();
        softAssert.assertTrue(adminDashBoard_headerPage.labelSayfaBaşlıkları.getText().toLowerCase().contains("about"));

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.quitDriver();


    }
}
