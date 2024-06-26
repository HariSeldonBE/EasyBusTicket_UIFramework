package tests.zehra.US30;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;

import pages.admin.AdminDashBoard_CounterPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Arrays;

public class TC03 extends TestBaseRapor {
    @Test
    public void addNewTEST(){
        // Browser'ı açar
        // URL'e gider

        extentTest=extentReports.createTest("ZEHRA_add New Counter TEST", "US_30  TC_03 Add New Counter Test");

        AdminDashBoard_CounterPage adminDashBoard_counterPage = new AdminDashBoard_CounterPage();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        
        ReusableMethods.adminLoginMethod("admin11","123123123");
        extentTest.info("Admin goes to \"Easy Bus Ticket Admin\" Dashboard");

        // "Counter" linkine tıklar
        adminDashBoard_counterPage.linkCounter.click();

        // Açılan sayfada "Add New" butonunu görüntüler
        softAssert.assertTrue(adminDashBoard_counterPage.counterAddNewButton.isDisplayed(),"Add New butonu görünmüyor");

        // "Add New" butonuna tıklar
        adminDashBoard_counterPage.counterAddNewButton.click();

        // İstenen bilgileri (Name, City, Location, Mobile) girer
        String fakerName = faker.name().firstName();
        String fakerAddress = faker.address().city();
        String fakerLocation = faker.address().cityName();
        int fakerPhone = faker.number().randomDigit();

        ReusableMethods.wait(2);
        actions.click( adminDashBoard_counterPage.nameTextBox)
                .sendKeys(fakerName)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerLocation)
                .sendKeys(Keys.TAB)
                .sendKeys(""+fakerPhone)
                .perform();


        // Pencerenin altındaki "Save" butonunu görür ve tıklar
        softAssert.assertTrue(adminDashBoard_counterPage.counterSaveButton.isDisplayed());
        adminDashBoard_counterPage.counterSaveButton.click();

        // Sayfanın en altına iner ve yeni Counter açtığını görür,

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement lastRow = adminDashBoard_counterPage.tbodyCounterTablo.findElement(By.xpath(".//tr[last()]"));
        String rowData = lastRow.getText();
       // System.out.println("Last row data: " + rowData);
        String[] rowDataArray = rowData.split(" ");
        softAssert.assertEquals(rowDataArray[0],fakerName,"Girilen isim kayıtlı isim ile aynı değil");
        extentTest.pass("Tests the visibility of the 'new Counter' text");

        // Counter bigilerini görüntüler
        System.out.println(Arrays.toString(rowDataArray));

        softAssert.assertAll();
        extentTest.info("Closed page");
        Driver.quitDriver();

    }

}
