package tests.zeliha.US27;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {

    @Test
    public void yeniKanalEkleme (){
    /* TC - Admin Dashboard sayfasında "Payment Gateways" Linki altında,
    "Manual Gateways" Linki altında yeni kanal ekleyebilmeli, eklediklerimi düzenleyebilmeliyim.

    STEPLER
    1 - Browser açılır.
    2 -	URL'e gidilir.
    3 -	Admin olarak giriş yapılır.
    4 -	"Payment Gateways" linki tıklanır.
    5 -	"ManualGateways" linki tıklanır.
    6 -	"add new" butonu tıklanır.
    7 -	"New Manual Gateway"  başlığının görünür olduğu doğrulanır.
    8 -	"Go Back"  butonunun görünür ve aktif olduğu doğrulanır.
    9 -	resim ekleme elementinin görünür ve aktif olduğu doğrulanır.
    10 - "Gateway Name *" textbox başlığının görünür olduğu doğrulanır.
    11 - "Gateway Name *" textbox'ının görünür ve aktif olduğu doğrulanır.
    12 - "Currency*" textbox başlığının görünür olduğu doğrulanır.
    13 - "Currency*" textbox'ının görünür ve aktif olduğu doğrulanır.
    14 - "Rae*" textbox başlığının görünür olduğu doğrulanır.
    15 - "Rate*" textbox'ının görünür ve aktif olduğu doğrulanır.
    16 - "Range*" başlığının görünür olduğu doğrulanır.
    17 - "Charge*" başlığının görünür olduğu doğrulanır.
    18 - "Minimum Amount*" textbox başlığının görünür olduğu doğrulanır.
    19 - "Minimum Amount*" textbox'ının görünür ve aktif olduğu doğrulanır.
    20 - "Maximum Amount *" textbox başlığının görünür olduğu doğrulanır.
    21 - "Maximum Amount *" textbox'ının görünür ve aktif olduğu doğrulanır.
    22 - "Fixed Charge*" textbox başlığının görünür olduğu doğrulanır.
    23 - "Fixed Charge*" textbox'ının görünür ve aktif olduğu doğrulanır.
    24 - "Deposit Instruction*" başlığının görünür olduğu doğrulanır.
    25 - "Deposit Instruction*" textbox'ının görünür ve aktif olduğu doğrulanır.
    26 - "User Data*" başlığının görünür olduğu doğrulanır.
    27 - "+ Add New*" butonunun görünür ve aktif olduğu doğrulanır.
    28 - "Save Method" butonunun görünür ve aktif olduğu doğrulanır.
    29 - "Edit" butonu ile girilen bilgilerin düzenlenebildiği doğrulanır.
     */

        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();

        Actions actions = new Actions(Driver.getDriver());
        SoftAssert softAssert = new SoftAssert();
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        softAssert.assertTrue(adminDashBoardPage.spanPaymentGateways.isDisplayed(),"Pending Ticket linki Görüntülenemedi.");
        adminDashBoardPage.spanPaymentGateways.click();
        adminDashBoardPage.spanManualGateways.click();

        softAssert.assertTrue(adminDashBoardPage.thGateway2.isDisplayed(),"Gateways Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thStatus6.isDisplayed(),"Status Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.thAction.isDisplayed(),"Action Başlığı Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanDeneme.isDisplayed(),"Gateway Datası Görüntülenemedi.");
        softAssert.assertTrue(adminDashBoardPage.spanDisabled.isDisplayed(),"Status Datası Görüntülenemedi.");

        softAssert.assertTrue(adminDashBoardPage.inputSearchTable2.isDisplayed(),"Arama Kutusu Görüntülenemedi.");
        adminDashBoardPage.inputSearchTable2.click();
        adminDashBoardPage.inputSearchTable2.sendKeys("deneme");
        adminDashBoardPage.inputSearchTable2.sendKeys(Keys.ENTER);
        ReusableMethods.wait(1);

        adminDashBoardPage.iPlus.click();

        /* ================ RESİM EKLEME =====================
        adminDashBoardPage.resimEklemeButonu.click();

        WebElement fileInput = driver.findElement(By.id("file-upload"));
        String filePath = "C:\\Kullanıcılar\\zelihaselcuk\\NEW.jpg";
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput);
        fileInput.sendKeys(filePath);
        */

        adminDashBoardPage.GatewayNameTextbox.click();
        adminDashBoardPage.GatewayNameTextbox.sendKeys("Card X");
        ReusableMethods.wait(1);
        adminDashBoardPage.GatewayNameTextbox.sendKeys(Keys.TAB);
        adminDashBoardPage.CurrencyTextbox.click();
        adminDashBoardPage.CurrencyTextbox.sendKeys("USD");
        ReusableMethods.wait(1);
        adminDashBoardPage.CurrencyTextbox.sendKeys(Keys.TAB);
        adminDashBoardPage.rateTextbox.sendKeys("3");
        ReusableMethods.wait(1);
        adminDashBoardPage.rateTextbox.sendKeys(Keys.TAB);
        adminDashBoardPage.minAmountTextbox.sendKeys("1.000");
        ReusableMethods.wait(1);
        adminDashBoardPage.minAmountTextbox.sendKeys(Keys.TAB);
        adminDashBoardPage.maxAmountTextbox.sendKeys("5.000");
        adminDashBoardPage.fixedCharge.sendKeys("1.000");
        adminDashBoardPage.fixedCharge.sendKeys(Keys.TAB);
        adminDashBoardPage.percentCharge.sendKeys("1.000");
        adminDashBoardPage.percentCharge.sendKeys(Keys.TAB);
        adminDashBoardPage.aciklamaTextbox.sendKeys("Yeni Kayıt Talebi.");
        adminDashBoardPage.aciklamaTextbox.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        adminDashBoardPage.saveMethodButtonu.isEnabled();
        adminDashBoardPage.saveMethodButtonu.click();


        adminDashBoardPage.goBackButonu.click();
        adminDashBoardPage.iPencil.click();

        adminDashBoardPage.divNewManualGatewayBack.click();
        //adminDashBoardPage.GatewayNameTextbox.click();
        //adminDashBoardPage.GatewayNameTextbox.sendKeys("Card Z");
        //ReusableMethods.wait(1);
        //adminDashBoardPage.GatewayNameTextbox.sendKeys(Keys.TAB);
        adminDashBoardPage.CurrencyTextbox.click();
        adminDashBoardPage.CurrencyTextbox.sendKeys("USD");
        ReusableMethods.wait(1);
        adminDashBoardPage.CurrencyTextbox.sendKeys(Keys.TAB);
        adminDashBoardPage.rateTextbox.sendKeys("7");
        ReusableMethods.wait(1);
        adminDashBoardPage.rateTextbox.sendKeys(Keys.TAB);
        adminDashBoardPage.minAmountTextbox.sendKeys("1111");
        ReusableMethods.wait(1);
        adminDashBoardPage.minAmountTextbox.sendKeys(Keys.TAB);
        adminDashBoardPage.maxAmountTextbox.sendKeys("5555");
        adminDashBoardPage.fixedCharge.sendKeys("1111");
        adminDashBoardPage.fixedCharge.sendKeys(Keys.TAB);
        adminDashBoardPage.percentCharge.sendKeys("1111");
        adminDashBoardPage.percentCharge.sendKeys(Keys.TAB);
        adminDashBoardPage.aciklamaTextbox.sendKeys("Yeni Kayıt Talebi.");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        adminDashBoardPage.saveMethodButtonu.isEnabled();


        adminDashBoardPage.goBackButonu.click();

        Driver.quitDriver();







}
}
