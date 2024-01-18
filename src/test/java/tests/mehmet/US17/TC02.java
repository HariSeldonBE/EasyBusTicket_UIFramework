package tests.mehmet.US17;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.user.ProfilePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    @Test
    public void profileSttingPageDogrulamaTesti(){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        SoftAssert softAssert=new SoftAssert();
        ProfilePage profilePage=new ProfilePage();
        //Browser açılır, URL'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        profilePage.profileDDM.click();
        //Profile butonu tıklanır
        profilePage.profileButton.click();
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        //Profil ayarları sayfasında "First Name", "Last Name", "E-mail Address", "Mobile Number", "Address", "State", "Zip Code", "City", "Zip Code", "Country" textboxlarının görülür olduğu doğrulanır
        softAssert.assertTrue(profilePage.profileName.isDisplayed(),"Name");
        softAssert.assertTrue(profilePage.profileName.isEnabled(),"Name");
        softAssert.assertTrue(profilePage.profileLastName.isDisplayed(),"Last Name");
        softAssert.assertTrue(profilePage.profileLastName.isEnabled(),"Last Name");
        softAssert.assertTrue(profilePage.phone.isDisplayed(),"Phone");
        // softAssert.assertTrue(profilePage.phone.isEnabled(),"Phone");
        softAssert.assertTrue(profilePage.address.isDisplayed(),"Address");
        softAssert.assertTrue(profilePage.address.isEnabled(),"Address");
        softAssert.assertTrue(profilePage.profilEmail.isDisplayed(),"Email");
        //softAssert.assertTrue(profilePage.profilEmail.isEnabled(),"Email");
        softAssert.assertTrue(profilePage.city.isDisplayed(),"City");
        softAssert.assertTrue(profilePage.city.isEnabled(),"City");
        softAssert.assertTrue(profilePage.zipCode.isDisplayed(),"Zip");
        softAssert.assertTrue(profilePage.zipCode.isEnabled(),"Zip");
        softAssert.assertTrue(profilePage.countryProfile.isDisplayed(),"Country");
        softAssert.assertTrue(profilePage.state.isDisplayed(),"State");
        softAssert.assertTrue(profilePage.state.isEnabled(),"State");
        //Formun altında "Update Profile" butonunın görülür ve aktif olduğu doğrulanır
        softAssert.assertTrue(profilePage.updateProfileButton.isDisplayed(),"Buton");
        softAssert.assertTrue(profilePage.updateProfileButton.isEnabled(),"Buton");
        //Tüm bilgilerin tek başına veya toplu halde güncellenebildiği doğrulanır
        String name ="Wise";
        String lastName ="Quarter";
        String adres ="Balikesir";
        String state ="Anadolu";
        String zip="12345";
        String zip2="98745";
        String city="Giresun";
        String profileName=profilePage.profileName.getAttribute("value");
        String profileLastName=profilePage.profileLastName.getAttribute("value");
        String profileAddress=profilePage.address.getAttribute("value");
        String profileState=profilePage.state.getAttribute("value");
        String profileZipCode=profilePage.zipCode.getAttribute("value");
        String profileCity= profilePage.city.getAttribute("value");
        String profileIkinciZip=profilePage.ikinciZip.getAttribute("value");

        profilePage.profileName.clear();
        profilePage.profileName.sendKeys(name);
        profilePage.profileLastName.clear();
        profilePage.profileLastName.sendKeys(lastName);
        profilePage.address.clear();
        profilePage.address.sendKeys(adres);
        profilePage.state.clear();
        profilePage.state.sendKeys(state);
        profilePage.zipCode.clear();
        profilePage.zipCode.sendKeys(zip);
        profilePage.city.clear();
        profilePage.city.sendKeys(city);
        profilePage.ikinciZip.clear();
        profilePage.ikinciZip.sendKeys(zip2);
        ReusableMethods.wait(1);
        profilePage.updateProfileButton.click();

        //Bilgilerin başarılı bir şekilde update olduğu doğrulanır

        softAssert.assertNotEquals(name,profileName,"Name aynı");
        softAssert.assertNotEquals(lastName,profileLastName,"Lastname aynı");
        softAssert.assertNotEquals(state,profileState,"State aynı");
        softAssert.assertNotEquals(city,profileCity,"City aynı");
        softAssert.assertNotEquals(zip,profileZipCode,"Zip aynı");
        softAssert.assertNotEquals(zip2,profileIkinciZip,"Zip2 aynı");
        softAssert.assertNotEquals(adres,profileAddress,"Adres aynı");




        softAssert.assertTrue(profilePage.basariliGiris.isDisplayed());



        ReusableMethods.wait(2);



        softAssert.assertAll();
        Driver.closeDriver();

    }
}
