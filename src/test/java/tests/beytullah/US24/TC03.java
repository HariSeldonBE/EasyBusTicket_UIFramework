package tests.beytullah.US24;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.Random;

import static utilities.JSUtilities.scrollToBottom;

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

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        boolean fakeKullaniciFound = false;

        while (!fakeKullaniciFound) {
            try {
                // Elementin sayfa üzerinde görünür olmasını bekler
                WebElement fakeKullanici = wait.until(ExpectedConditions.visibilityOf(manageUsersDDM.linkFakeKullanici));

                // fakeKullanici bulunuyorsa
                JSUtilities.clickWithJS(Driver.getDriver(),fakeKullanici);

                fakeKullaniciFound = true; // Döngüyü sonlandır
            } catch (TimeoutException e) {
                try {
                    // Element belirli bir süre içinde görünmezse, bir sonraki sayfaya geçiş yapılabilir
                    scrollToBottom(Driver.getDriver());
                    WebElement buttonRight = wait.until(ExpectedConditions.elementToBeClickable(manageUsersDDM.buttonRight));
                    JSUtilities.clickWithJS(Driver.getDriver(),manageUsersDDM.buttonRight);
                } catch (TimeoutException innerException) {
                    // buttonRight belirli bir süre içinde tıklanabilir hale gelmezse, hata alındı olarak işaretleyebilirsiniz.
                    System.out.println("Hata: Sayfa yüklenemedi veya buttonRight tıklanabilir hale gelmedi.");
                    break; // Döngüyü sonlandır
                }
            }
        }


        // Döngü bittiğinde, linkFakeKullanici'ye tıkla

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
        softAssert.assertTrue(manageUsersDDM.alert.getText().contains("warning"));

        softAssert.assertAll();
       // Driver.closeDriver();
    }
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
