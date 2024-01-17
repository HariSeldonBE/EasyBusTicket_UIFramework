package tests.mehmet.US16;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
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

        //DDM de alt alta "Create New" ve "Requests" bağlantılarının görülür ve aktif olduğu doğrulanır
        Assert.assertTrue(easyBusTicketPage.linkCreateNew.isDisplayed());
        Assert.assertTrue(easyBusTicketPage.linkRequests.isDisplayed());
        easyBusTicketPage.linkCreateNew.click();
        String expectedTitle1="Support Tickets";
        String actualTitle1=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle1.contains(expectedTitle1),"Support Tickets sayfasına ulaşılamadı");
        Driver.getDriver().switchTo().window(dashboardWHD);

        easyBusTicketPage.dropDownSupportRequest.click();
        easyBusTicketPage.linkRequests.click();
        String expectedTitle2="Support Tickets";
        String actualTitle2=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle2.contains(expectedTitle2),"Support Tickets sayfasına ulaşılamadı");

        ReusableMethods.wait(2);
        Driver.closeDriver();


    }
}
