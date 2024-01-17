package tests.beytullah.US24;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.*;

import java.time.Duration;
import java.util.Random;

import static utilities.JSUtilities.scrollToBottom;

public class TC03 extends TestBaseRapor {
    @Test
    public void test01(){
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();
        extentTest=extentReports.createTest("Hatalı karakter girişiyle kayıt yapma", "Kullnıcının biligilerini değiştirirken kabul edilmemesi gereken karakterler kabul ediliyor");

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        extentTest.info("URL'e gider");

        ReusableMethods.adminLoginMethod("admin14", "123123123");
        extentTest.info("Admin bilgilerini girer");

        manageUsersDDM.dropDownManageUsers.click();
        extentTest.info("\"Manage Users\" DDM'ye tıklar");

        manageUsersDDM.linkAllUsers.click();
        extentTest.info("\"All Users\" linkine tıklar");

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
        extentTest.info("Herhangi bir kullanıcıya tıklar");

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
        extentTest.info("\"Information\" panelindeki her kutucuğa tıklayıp \"First Name\",\n" +
                "\"Last Name\",\"City\", \"State\", kısmına rakam ve simge,\n" +
                "\"Email\" kısmna @'den sonra rakam veya hiçlik ,\n" +
                "\"Mobile Number\" ve \"Zip/Postal\" kısmına harf ve simge girer");

       scrollToElement(Driver.getDriver(),manageUsersDDM.buttonSaveChanges);
        extentTest.info("\"Save Changes\" butonuna tıklar");
       ReusableMethods.wait(2);
        manageUsersDDM.buttonSaveChanges.click();
        softAssert.assertTrue(manageUsersDDM.alert.getText().contains("warning"),"Yanlış girilen bilgiler kaydedildi");
        extentTest.info("\"Information\" panelindeki değişiklikleri kaydedemez");

        softAssert.assertAll();
       Driver.closeDriver();
    }
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
