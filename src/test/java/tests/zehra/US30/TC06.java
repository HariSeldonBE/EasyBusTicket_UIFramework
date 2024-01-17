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
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class TC06 {
    @Test
    public void test01(){
        //    Browser'ı açar
        //    URL'e gider

        AdminDashBoard_CounterPage adminDashBoard_counterPage = new AdminDashBoard_CounterPage();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        ReusableMethods.adminLoginMethod("admin11","123123123");

        // "Counter" linkine tıklar
        adminDashBoard_counterPage.linkCounter.click();

        // Açılan sayfanın en altına iner
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        // Eklenen Counter'ın sağ tarafındaki Active/Disable ikonu görür
           softAssert.assertTrue(adminDashBoard_counterPage.ikonCounterActiveDisable.isDisplayed());


        //  Eklenen Counter 'ın statusu Active  olduğunu doğrula
        WebElement lastRow = adminDashBoard_counterPage.tbodyCounterTablo.findElement(By.xpath(".//tr[last()]"));
        String rowData = lastRow.getText();

        String[] rowDataArray = rowData.split(" ");
        System.out.println(rowData);

        if (rowDataArray[rowDataArray.length-1].equals("Active")) {

            // Active ikonuna tıklar ve açılan pencereden Disable butonuna tıklar
            JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoard_counterPage.ikonCounterActiveDisable);
            adminDashBoard_counterPage.buttonDisable.click();
            ReusableMethods.wait(2);

            //Artık statu'nun Disable olarak değiştiğini doğrular,
            actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
            WebElement lastRow1 = adminDashBoard_counterPage.tbodyCounterTablo.findElement(By.xpath(".//tr[last()]"));
            String rowData1 = lastRow1.getText();
            String[] rowDataArray1 = rowData1.split(" ");
            System.out.println(rowData1);
            softAssert.assertEquals(rowDataArray1[rowDataArray1.length-1],"Disabled","Active");

        }else {
            JSUtilities.clickWithJS(Driver.getDriver(),adminDashBoard_counterPage.ikonCounterActiveDisable);
            adminDashBoard_counterPage.buttonActive.click();
            ReusableMethods.wait(2);

            //Artık statu'nun Actice olarak değiştiğini doğrular,
            actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
            WebElement lastRow1 = adminDashBoard_counterPage.tbodyCounterTablo.findElement(By.xpath(".//tr[last()]"));
            String rowData1 = lastRow1.getText();
            String[] rowDataArray1 = rowData1.split(" ");
            System.out.println(rowData1);
            softAssert.assertEquals(rowDataArray1[6],"Active","Disabled");
        }


        ReusableMethods.wait(2);

        softAssert.assertAll();

        Driver.closeDriver();

    }
}