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
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;

public class TC04 {
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

      // "Add New" butonuna tıklar
        adminDashBoardPage.counterAddNewButton.click();

      // İstenen bilgileri  "Name'e, City'e Location'a rakam, özel karakter; Mobile Number'a eksi işareti girer
        int fakerName = faker.number().randomDigit();
        String fakerAddress = faker.number().digit();
        String fakerLocation = faker.number().digit();
        int fakerPhone = faker.number().randomDigit();

        ReusableMethods.wait(2);
        actions.click( adminDashBoardPage.nameTextBox)
                .sendKeys(""+fakerName)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerAddress)
                .sendKeys(Keys.TAB)
                .sendKeys(fakerLocation)
                .sendKeys(Keys.TAB)
                .sendKeys("-"+fakerPhone)
                .perform();

        // Pencerenin altındaki "Save"butonuna tıklar
        adminDashBoardPage.counterSaveButton.click();

      // Hata mesajı görür
    ;
       System.out.println(adminDashBoardPage.counterHata.getText());
       softAssert.assertNotEquals( "Counter save successfully.",adminDashBoardPage.counterHata.getText(),"hatalı bilgiler kaydedilmiş");

      // Sayfanın en altına iner ve yeni Counter açmadığını görür
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement lastRow = adminDashBoardPage.tbodyCounterTablo.findElement(By.xpath(".//tr[last()]"));
        String rowData = lastRow.getText();
        // System.out.println("Last row data: " + rowData);
        String[] rowDataArray = rowData.split(" ");
        System.out.println(rowData);
        softAssert.assertNotEquals(rowDataArray[0],fakerName,"Girilen isim kaydedilmiş");

        softAssert.assertAll();
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }

}
