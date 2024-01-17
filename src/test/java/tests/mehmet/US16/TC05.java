/* package tests.mehmet.US16;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC05 {
    @Test
    public void test01() {
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage = new UserLoginPage();
        SoftAssert softAssert = new SoftAssert();
        //Browser açılır
        //URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        //Sign-in butonuna tıklanır
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signInButton.click();
        //Username ve Password alanları doldurulur
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));

        //Login butonuna tıklanarak user dashboard sayfasına gidilir
        userLoginPage.loginButton.click();
        //"Support Request" DDM üzerine mouse ile gelinirek DDM açılır
        String dashboardWHD = Driver.getDriver().getWindowHandle();
        easyBusTicketPage.dropDownSupportRequest.click();
        //DDM de "Requests" linki tıklanır
        easyBusTicketPage.linkRequests.click();
        // Destek geçmişi sayfasında""New Ticket" butonu tıklanır
        easyBusTicketPage.buttonNewTicket.click();
        // Yeni destek talebi oluşturma sayfasına erişildiği doğrulanır
        String expectedTitle="Support Tickets";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Yeni destek talebi oluşturma sayfasına erişildiği doğrulanamadı");
        softAssert.assertAll();

    }
}
*/