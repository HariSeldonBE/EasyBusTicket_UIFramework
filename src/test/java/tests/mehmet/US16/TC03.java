package tests.mehmet.US16;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.EasyBusTicketPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC03 {
    @Test
    public void test01() {
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
        // Destek geçmişi sayfasında oluşturulan talep ve talep bilgilerinin tablo şeklinde görülür olmalı
        softAssert.assertTrue(easyBusTicketPage.labelTable.isDisplayed(),"Tablo görülemedi");

        // Tablo sütünlarında "Subject", "Status", "Priority", "Last Reply", "Action" bilgilerinin yer aldığı,
        // "Action" alanında PC logolu bir butonun görülür ve aktif olduğu doğrulanır
        softAssert.assertTrue(easyBusTicketPage.buttonAction.isDisplayed(),"PC logolu bir buton görülemedi");
        softAssert.assertTrue(easyBusTicketPage.buttonAction.isEnabled(),"PC butonu aktif olduğu doğrulanmadı");
        // Tablonun sağ üstüde "New Ticket" butonu görülür olmalı
        softAssert.assertTrue(easyBusTicketPage.buttonNewTicket.isDisplayed(),"New Ticket butonu görünür değil");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
