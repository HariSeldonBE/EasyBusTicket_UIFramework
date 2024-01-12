package tests.zehra.US30;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC06 {
    @Test
    public void test01(){
//    Browser'ı açar
//    URL'e gider
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());

        ReusableMethods.adminLoginMethod("admin11","123123123");

        // "Counter" linkine tıklar
        adminDashBoardPage.linkCounter.click();

        // Açılan sayfanın en altına iner
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        // Eklenen Counter'ın sağ tarafındaki Active/Disable ikonu görür
           softAssert.assertTrue(adminDashBoardPage.ikonCounterActiveDisable.isDisplayed());

        //

}
}