package tests.mehmet.US17;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.user.ProfilePage;
import utilities.Driver;
import utilities.ReusableMethods;


public class TC01{
    @Test
    public void profileButonuDogrulamaTesti(){
        SoftAssert softAssert=new SoftAssert();
        ProfilePage profilePage=new ProfilePage();
    //Browser açılır, URL'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
    //"Profile" DDM görülür ve aktif olduğu kontrol edilir
        softAssert.assertTrue(profilePage.profileDDM.isDisplayed());
        softAssert.assertTrue(profilePage.profileDDM.isEnabled());
        profilePage.profileDDM.click();
    //Profile butonu görüntülenir ve aktif olduğu doğrulanır
        softAssert.assertTrue(profilePage.profileButton.isDisplayed());
        softAssert.assertTrue(profilePage.profileButton.isEnabled());
    //Profile butonu tıklanır
        profilePage.profileButton.click();
    //Profile Setting sayfasının açıldığı doğrulanır
        String expectedTitle="Profile Setting";
        String actualTitle=profilePage.profileSetting.getText();
        softAssert.assertEquals(actualTitle,expectedTitle,"Profile Setting sayfası açılmadı");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
