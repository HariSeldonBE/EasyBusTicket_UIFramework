package tests.beytullah.US24;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Random;

public class TC03 {
    @Test
    public void test01(){
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();
        // "All Users" linkine tıklar
        manageUsersDDM.linkAllUsers.click();
        // Herhangi bir kullanıcıya tıklar
        manageUsersDDM.linkFakeKullanici.click();
        // "Information" panelindeki her kutucuğa tıklayıp "First Name",
        // "Last Name","City", "State", kısmına rakam ve simge,
        // "Email" kısmna @'den sonra rakam veya hiçlik ,
        // "Mobile Number" ve "Zip/Postal" kısmına harf ve simge girer
        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());

        Random random = new Random();
        int randomNumber = random.nextInt(1000000);

        String semboller = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
        int sembollerUzunluk = semboller.length();

        StringBuilder randomSymbol = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            randomSymbol.append(semboller.charAt(random.nextInt(sembollerUzunluk)));
        }
        manageUsersDDM.inputFirstName.clear();
        actions.click(manageUsersDDM.inputFirstName)
                .sendKeys(""+randomNumber+randomSymbol).sendKeys(Keys.TAB)
                .sendKeys(""+randomNumber+randomSymbol).sendKeys(Keys.TAB)
                .sendKeys("a@"+faker.name().firstName()+randomNumber).sendKeys(Keys.TAB)
                .sendKeys(faker.artist().name()+randomSymbol).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(""+randomNumber+randomSymbol).sendKeys(Keys.TAB)
                .sendKeys(""+randomNumber+randomSymbol).sendKeys(Keys.TAB)
                .sendKeys(faker.artist().name()+randomSymbol).sendKeys(Keys.TAB).perform();

        // "Save Changes" butonuna tıklar
       scrollToElement(Driver.getDriver(),manageUsersDDM.buttonSaveChanges);
       ReusableMethods.wait(2);
        manageUsersDDM.buttonSaveChanges.click();
        // "Information" panelindeki değişiklikleri kaydedemez

        Driver.closeDriver();
    }
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
