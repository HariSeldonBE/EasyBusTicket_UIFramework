package tests.beytullah.US24;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void test1(){
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();
        manageUsersDDM.linkAllUsers.click();
        // Herhangi bir kullanıcıya tıklar
        /*
        List<String> kullaniciAdlari = new ArrayList<>();
        for (WebElement element : manageUsersDDM.linkKullaniciAdi1) {
            String kullaniciAdi = kullaniciAdiCikar(element.getText());
            kullaniciAdlari.add(kullaniciAdi);
        }
*/
        manageUsersDDM.linkFakeKullanici.click();
        // "User Detail" sayfasına ulaşır
        softAssert.assertTrue(manageUsersDDM.labelTitleBaslik.isDisplayed());
        // "Information" panelindeki her kutucuğu görür, tıklar ve  bilgileri değiştirir
        softAssert.assertTrue(manageUsersDDM.inputFirstName.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.inputLastName.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.inputEmail.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.inputMobileNumber.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.inputAddress.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.inputState.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.inputZipPostal.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.dropDownCountry.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.buttonStatus.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.buttonEmailVerification.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.buttonSMSVerification.isDisplayed());

        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(manageUsersDDM.inputFirstName)
                        .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                        .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                        .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                        .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                        .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                        .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                        .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                        .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).perform();
        Select selectUlke = new Select(manageUsersDDM.dropDownCountry);
        selectUlke.selectByIndex(5);
        //JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();
       // javascriptExecutor.executeScript("arguments[0].scrollIntoView();",manageUsersDDM.buttonStatus);

        actions.sendKeys(Keys.PAGE_DOWN);
        if (manageUsersDDM.buttonStatusActive.getText().equals("Active")){
            manageUsersDDM.buttonStatusBanned.click();
        }else {
            manageUsersDDM.buttonStatusActive.click();
        }
        if (manageUsersDDM.buttonEmailVerification.getText().equals("Verified")){
            manageUsersDDM.buttonUnVerified.click();
        }else {
            manageUsersDDM.buttonVerified.click();
        }
        if (manageUsersDDM.buttonEmailVerification.getText().equals("Verified")){
            manageUsersDDM.buttonUnVerified.click();
        }else {
            manageUsersDDM.buttonVerified.click();
        }

        manageUsersDDM.buttonEmailVerification.click();
        manageUsersDDM.buttonSMSVerification.click();
        //manageUsersDDM.buttonSaveChanges.click();
        /*
        manageUsersDDM.inputLastName.click();
        manageUsersDDM.inputEmail.click();
        manageUsersDDM.inputMobileNumber.click();
        manageUsersDDM.inputAddress.click();
        manageUsersDDM.inputState.click();
        manageUsersDDM.inputZipPostal.click();
        manageUsersDDM.dropDownCountry.click();
        manageUsersDDM.buttonStatus.click();
        manageUsersDDM.buttonEmailVerification.click();
        manageUsersDDM.buttonSMSVerification.click();
*/

        // "Information" panelindeki değişiklikleri kaydeder
        // "Active Users" sekmesine tıklanır ve görüntülenir
        // Herhangi bir kullanıcıya tıklar
        // "Information" panelindeki her kutucuğa tıklar ve  bilgileri değiştirir
        // "Information" panelindeki değişiklikleri kaydeder
        // "Banned Users" sekmesine tıklanır ve görüntülenir
        // Herhangi bir kullanıcıya tıklar
        // "Information" panelindeki her kutucuğa tıklar ve  bilgileri değiştirir
        // "Information" panelindeki değişiklikleri kaydeder

    }
    private String kullaniciAdiCikar(String metin) {
        int atIndex = metin.indexOf('@');
        if (atIndex != -1 && atIndex < metin.length() - 1) {
            return metin.substring(atIndex + 1).trim();
        }
        return "";
    }
}
