package tests.zehra.US30;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;

import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;

public class TC03 {
    @Test
    public void test01(){
        // Browser'ı açar
        // URL'e gider

        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        
        ReusableMethods.adminLoginMethod("admin11","123123123");

        // "Counter" linkine tıklar
        adminDashBoardPage.linkCounter.click();

        // Açılan sayfada "Add New" butonunu görüntüler
        softAssert.assertTrue(adminDashBoardPage.counterAddNewButton.isDisplayed(),"Add New butonu görünmüyor");

        // "Add New" butonuna tıklar
        adminDashBoardPage.counterAddNewButton.click();

        // İstenen bilgileri (Name, City, Location, Mobile) girer
        String fakerName = faker.name().firstName();
        String fakerAddress = faker.address().city();
        String fakerLocation = faker.address().cityName();
        int fakerPhone = faker.number().randomDigit();

        ReusableMethods.wait(2);
        actions.click( adminDashBoardPage.nameTextBox)
                .sendKeys(fakerName)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerLocation)
                .sendKeys(Keys.TAB)
                .sendKeys("0"+fakerPhone)
                .perform();


        // Pencerenin altındaki "Save" butonunu görür ve tıklar
        softAssert.assertTrue(adminDashBoardPage.counterSaveButton.isDisplayed());
        adminDashBoardPage.counterSaveButton.click();

        // Sayfanın en altına iner ve yeni Counter açtığını görür,

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement lastRow = adminDashBoardPage.tbodyCounterTablo.findElement(By.xpath(".//tr[last()]"));
        String rowData = lastRow.getText();
       // System.out.println("Last row data: " + rowData);
        String[] rowDataArray = rowData.split(" ");
        softAssert.assertEquals(rowDataArray[0],fakerName,"Girilen isim kayıtlı isim ile aynı değil");

        // Counter bigilerini görüntüler
        System.out.println(Arrays.toString(rowDataArray));
        //System.out.println(adminDashBoardPage.counterHata.getText());//Counter save successfully.
        softAssert.assertAll();
        Driver.quitDriver();

    }

}
