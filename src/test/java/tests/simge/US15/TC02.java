package tests.simge.US15;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.ProfilePage;
import pages.user.SupportRequestPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void createNewSayfasiDogrulamaTesti(){

        // 1-Browser açılır ve Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2-Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3-SignIn butonuna tıklanır
        easyBusTicketPage.signInButton.click();
        ReusableMethods.wait(2);
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        // 4-Geçerli Username girilir
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        // 5-Geçerli Password girilir
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        // 6-Log In butonuna tıklanır
        userLoginPage.loginButton.click();
        ReusableMethods.wait(1);
        //Support Request tıklanır
        userDashBoardPage.supportRequest.click();
        //Create New tıklanır
        SupportRequestPage supportRequestPage = new SupportRequestPage();
        userDashBoardPage.createNew.click();
        //Destek talep formunda "Name" ve "Email address" textbox'larının kullanıcıya ait bilgilerle ve inaktif olarak görüldüğü kontrol edilir
        ProfilePage profilePage =new ProfilePage();
        Assert.assertTrue(supportRequestPage.mySupportTicket.isDisplayed());
        Assert.assertFalse(supportRequestPage.mySupportTicket.isEnabled());
        Assert.assertTrue(supportRequestPage.name.isDisplayed());
        Assert.assertFalse(supportRequestPage.name.isEnabled());
        Assert.assertTrue(supportRequestPage.mail.isDisplayed());
        Assert.assertFalse(supportRequestPage.mail.isEnabled());
        String isimSoyisim=profilePage.profileName.getText()+" "+profilePage.profileLastName;
        Assert.assertEquals(supportRequestPage.name.getText(),isimSoyisim);
        Assert.assertEquals(supportRequestPage.mail.getText(),profilePage.profilEmail.getText());
        //Destek talep formunda "Subject" ve "Message" textbox'larının görülür ve aktif olduğu kontrol edilir
        Assert.assertTrue(supportRequestPage.subject.isDisplayed());
        Assert.assertTrue(supportRequestPage.subject.isEnabled());
        Assert.assertTrue(supportRequestPage.message.isDisplayed());
        Assert.assertTrue(supportRequestPage.message.isEnabled());
        //Destek talep formunda "Priority" combobox'ın görülür ve aktif olduğu kontrol edilir
        Assert.assertTrue(supportRequestPage.priority.isDisplayed());
        Assert.assertTrue(supportRequestPage.priority.isEnabled());
        //"Message" textbox altında dosya seçme alanının ve dosya seçme ekleme alanının görülür ve aktif olduğu kontrol edilir
        Assert.assertTrue(supportRequestPage.dosyaSec.isDisplayed());
        Assert.assertTrue(supportRequestPage.dosyaSec.isEnabled());
        Assert.assertTrue(supportRequestPage.dosyaSecEkleme.isDisplayed());
        Assert.assertTrue(supportRequestPage.dosyaSecEkleme.isEnabled());
        //Destek talep formunun en altında "Submit" butonunun görülür ve aktif olduğu kontrol edilir
        Assert.assertTrue(supportRequestPage.submit.isDisplayed());
        Assert.assertTrue(supportRequestPage.submit.isEnabled());
        Driver.closeDriver();


    }
}
