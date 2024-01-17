package tests.zehra.US30;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminDashBoard_CounterPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Arrays;

public class TC04 extends TestBaseRapor {
    @Test
    public void negatifTest(){

      // Browser'ı açar
      // URL'e gider

        extentTest=extentReports.createTest("New Counter Negatif TEST", "Yanlış bilgilerle girilmemesi gerekiyor ");

        AdminDashBoard_CounterPage adminDashBoard_counterPage = new AdminDashBoard_CounterPage();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        ReusableMethods.adminLoginMethod("admin11","123123123");

      // "Counter" linkine tıklar
        adminDashBoard_counterPage.linkCounter.click();
        extentTest.info("User goes to \"Easy Bus Ticket Admin\" Dashboard \" Counter");

      // "Add New" butonuna tıklar
        adminDashBoard_counterPage.counterAddNewButton.click();

      // İstenen bilgileri  "Name'e, City'e Location'a rakam, özel karakter; Mobile Number'a eksi işareti girer
        int fakerName = faker.number().randomDigit();
        String fakerAddress = faker.number().digit();
        String fakerLocation = faker.number().digit();
        int fakerPhone = faker.number().randomDigit();

        ReusableMethods.wait(2);
        actions.click( adminDashBoard_counterPage.nameTextBox)
                .sendKeys(""+fakerName)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerLocation)
                .sendKeys(Keys.TAB)
                .sendKeys("-"+fakerPhone)
                .perform();

        // Pencerenin altındaki "Save"butonuna tıklar
        adminDashBoard_counterPage.counterSaveButton.click();
        extentTest.info("New Counter kaydı");

        // Hata mesajı görür
    ;
       System.out.println(adminDashBoard_counterPage.counterHata.getText());
       softAssert.assertNotEquals( "Counter save successfully.",adminDashBoard_counterPage.counterHata.getText(),"hatalı bilgiler kaydedilmiş");

      // Sayfanın en altına iner ve yeni Counter açmadığını görür
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement lastRow = adminDashBoard_counterPage.tbodyCounterTablo.findElement(By.xpath(".//tr[last()]"));
        String rowData = lastRow.getText();
        // System.out.println("Last row data: " + rowData);
        String[] rowDataArray = rowData.split(" ");
        System.out.println(rowData);
        softAssert.assertNotEquals(rowDataArray[0],fakerName,"Girilen isim kaydedilmiş");
        extentTest.pass("Tests the visibility of the 'new Counter' text");

        extentTest.info("Closed page");
        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }

}
