package tests.beytullah.US24;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import pages.admin.PaymentHistoryDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.JSUtilities.scrollToBottom;

public class TC02 {
    @Test
    public void test1() {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        PaymentHistoryDDM paymentHistoryDDM = new PaymentHistoryDDM();
        SoftAssert softAssert = new SoftAssert();

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();
        manageUsersDDM.linkAllUsers.click();
        // Herhangi bir kullanıcıya tıklar
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        boolean fakeKullaniciFound = false;

        while (!fakeKullaniciFound) {
            try {
                // Elementin sayfa üzerinde görünür olmasını bekler
                WebElement fakeKullanici = wait.until(ExpectedConditions.visibilityOf(manageUsersDDM.linkFakeKullanici));
                JSUtilities.clickWithJS(Driver.getDriver(), fakeKullanici);

                fakeKullaniciFound = true; // Döngüyü sonlandır
            } catch (TimeoutException e) {
                try {
                    // Element belirli bir süre içinde görünmezse, bir sonraki sayfaya geçiş yapılabilir
                    scrollToBottom(Driver.getDriver());
                    WebElement buttonRight = wait.until(ExpectedConditions.elementToBeClickable(manageUsersDDM.buttonRight));
                    JSUtilities.clickWithJS(Driver.getDriver(), manageUsersDDM.buttonRight);
                } catch (TimeoutException innerException) {
                    // buttonRight belirli bir süre içinde tıklanabilir hale gelmezse, hata alındı olarak işaretleyebilirsiniz.
                    System.out.println("Hata: Sayfa yüklenemedi veya buttonRight tıklanabilir hale gelmedi.");
                    break; // Döngüyü sonlandır
                }
            }
        }
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

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        manageUsersDDM.inputFirstName.clear();
        actions.click(manageUsersDDM.inputFirstName)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).perform();
        Select selectUlke = new Select(manageUsersDDM.dropDownCountry);
        selectUlke.selectByIndex(5);

        scrollToElement(Driver.getDriver(), manageUsersDDM.buttonSaveChanges);
        ReusableMethods.wait(2);
       /* if (manageUsersDDM.buttonStatusActive.getText().equals("Active")){
            manageUsersDDM.buttonStatusBanned.click();
        }
        */
        if (manageUsersDDM.buttonEmailVerified.getText().equals("Verified")) {
            manageUsersDDM.buttonEmailUnVerified.click();
        } else {
            manageUsersDDM.buttonEmailVerified.click();
        }
        if (manageUsersDDM.buttonSmsVerified.getText().equals("Verified")) {
            manageUsersDDM.buttonSmsUnVerified.click();
        } else {
            manageUsersDDM.buttonSmsVerified.click();
        }
        //"Save Changes" butonuna tıklar


        manageUsersDDM.buttonSaveChanges.click();

        //--------------------------------------------------------------------------------

        // "Active Users" linkine tıklar
        manageUsersDDM.linkActiveUsers.click();
        // Herhangi bir kullanıcıya tıklar
        ReusableMethods.wait(2);
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        fakeKullaniciFound = false;

        while (!fakeKullaniciFound) {
            try {
                // Elementin sayfa üzerinde görünür olmasını bekler
                WebElement fakeKullanici = wait.until(ExpectedConditions.visibilityOf(manageUsersDDM.linkFakeKullanici));
                JSUtilities.clickWithJS(Driver.getDriver(), fakeKullanici);

                fakeKullaniciFound = true; // Döngüyü sonlandır
            } catch (TimeoutException e) {
                try {
                    // Element belirli bir süre içinde görünmezse, bir sonraki sayfaya geçiş yapılabilir
                    scrollToBottom(Driver.getDriver());
                    WebElement buttonRight = wait.until(ExpectedConditions.elementToBeClickable(manageUsersDDM.buttonRight));
                    JSUtilities.clickWithJS(Driver.getDriver(), manageUsersDDM.buttonRight);
                } catch (TimeoutException innerException) {
                    // buttonRight belirli bir süre içinde tıklanabilir hale gelmezse, hata alındı olarak işaretleyebilirsiniz.
                    System.out.println("Hata: Sayfa yüklenemedi veya buttonRight tıklanabilir hale gelmedi.");
                    break; // Döngüyü sonlandır
                }
            }
        }
        // "Information" panelindeki her kutucuğa tıklar ve  bilgileri değiştirir
        manageUsersDDM.inputFirstName.clear();
        actions.click(manageUsersDDM.inputFirstName)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).perform();

        selectUlke.selectByIndex(5);
        scrollToElement(Driver.getDriver(), manageUsersDDM.buttonSaveChanges);
        ReusableMethods.wait(2);

        if (manageUsersDDM.buttonStatusActive.getText().equals("Active")) {
            manageUsersDDM.buttonStatusBanned.click();
        } else {
            manageUsersDDM.buttonStatusActive.click();
        }

        if (manageUsersDDM.buttonEmailVerified.getText().equals("Verified")) {
            manageUsersDDM.buttonEmailUnVerified.click();
        } else {
            manageUsersDDM.buttonEmailVerified.click();
        }
        if (manageUsersDDM.buttonSmsVerified.getText().equals("Verified")) {
            manageUsersDDM.buttonSmsUnVerified.click();
        } else {
            manageUsersDDM.buttonSmsVerified.click();
        }
        // "Save Changes" butonuna tıklar

        ReusableMethods.wait(2);
        manageUsersDDM.buttonSaveChanges.click();

        //--------------------------------------------------------------------------------

        // "Banned Users"  linkine tıklar
        manageUsersDDM.linkBannedUsers.click();
        // Herhangi bir kullanıcıya tıklar

        ReusableMethods.wait(2);
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        fakeKullaniciFound = false;

        while (!fakeKullaniciFound) {
            try {
                // Elementin sayfa üzerinde görünür olmasını bekler
                WebElement fakeKullanici = wait.until(ExpectedConditions.visibilityOf(manageUsersDDM.linkFakeKullanici));
                JSUtilities.clickWithJS(Driver.getDriver(), fakeKullanici);

                fakeKullaniciFound = true; // Döngüyü sonlandır
            } catch (TimeoutException e) {
                try {
                    // Element belirli bir süre içinde görünmezse, bir sonraki sayfaya geçiş yapılabilir
                    scrollToBottom(Driver.getDriver());
                    WebElement buttonRight = wait.until(ExpectedConditions.elementToBeClickable(manageUsersDDM.buttonRight));
                    JSUtilities.clickWithJS(Driver.getDriver(), manageUsersDDM.buttonRight);
                } catch (TimeoutException innerException) {
                    // buttonRight belirli bir süre içinde tıklanabilir hale gelmezse, hata alındı olarak işaretleyebilirsiniz.
                    System.out.println("Hata: Sayfa yüklenemedi veya buttonRight tıklanabilir hale gelmedi.");
                    break; // Döngüyü sonlandır
                }
            }
        }
        // "Information" panelindeki her kutucuğa tıklar ve  bilgileri değiştirir
        manageUsersDDM.inputFirstName.clear();
        actions.click(manageUsersDDM.inputFirstName)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).perform();

        selectUlke.selectByIndex(5);
        scrollToElement(Driver.getDriver(), manageUsersDDM.buttonSaveChanges);
        ReusableMethods.wait(2);
        if (manageUsersDDM.buttonStatusActive.getText().equals("Active")) {
            manageUsersDDM.buttonStatusBanned.click();
        } else {
            manageUsersDDM.buttonStatusActive.click();
        }
        if (manageUsersDDM.buttonEmailVerified.getText().equals("Verified")) {
            manageUsersDDM.buttonEmailUnVerified.click();
        } else {
            manageUsersDDM.buttonEmailVerified.click();
        }
        if (manageUsersDDM.buttonSmsVerified.getText().equals("Verified")) {
            manageUsersDDM.buttonSmsUnVerified.click();
        } else {
            manageUsersDDM.buttonSmsVerified.click();
        }
        // "Save Changes" butonuna tıklar

        ReusableMethods.wait(2);
        manageUsersDDM.buttonSaveChanges.click();
        Driver.closeDriver();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
