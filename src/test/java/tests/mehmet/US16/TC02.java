package tests.mehmet.US16;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void test01(){

        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage=new UserLoginPage();
        SoftAssert softAssert=new SoftAssert();
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
        String dashboardWHD=Driver.getDriver().getWindowHandle();
        easyBusTicketPage.dropDownSupportRequest.click();
        //DDM de "Requests" linki tıklanır
        easyBusTicketPage.linkRequests.click();
        String expectedTitle2="Support Tickets";
        String actualTitle2=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle2.contains(expectedTitle2),"Support Tickets sayfasına ulaşılamadı");

        ReusableMethods.wait(2);
        Driver.closeDriver();






    }
}
