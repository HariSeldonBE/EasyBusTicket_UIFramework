package tests.zehra.US31;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.admin.AdminDashBoard_ManageFleetsPage;
import pages.user.UserLoginPage;
import utilities.*;

public class TC04 extends TestBaseRapor {
    @Test
    public void negatifLayoutKayıtTest(){
        extentTest=extentReports.createTest("ZEHRA_New Layout Negatif TEST", "US_31 TC_04  Yanlış bilgilerle girilmemesi gerekiyor ");

        SoftAssert softAssert = new SoftAssert();
        AdminDashBoard_ManageFleetsPage adminDashBoard_manageFleetsPage = new AdminDashBoard_ManageFleetsPage();
        Actions actions = new Actions(Driver.getDriver());

        // Browser'ı açar
        // URL'e gider
        ReusableMethods.adminLoginMethod("admin11","123123123");

        // Manage Fleets'e tıklar
        adminDashBoard_manageFleetsPage.linkManageFleets.click();

        // Seat Layouts'a tıklar
        JSUtilities.clickWithJS(Driver.getDriver(), adminDashBoard_manageFleetsPage.linkSeatLayouts);
        ReusableMethods.wait(2);

        // "Add New" butonuna tıklar
        adminDashBoard_manageFleetsPage.buttonAddNew.click();

        // "Layout" kutucuğuna koltuk tipini "?x?, axa, 0x0 ve 3x3'ten buyük" değer girer
        adminDashBoard_manageFleetsPage.textboxLayout.click();
        actions.sendKeys("eg").perform();

        // Pencerenin altındaki "Save" butonunu tıklar
         adminDashBoard_manageFleetsPage.buttonSave.click();
        extentTest.info("New Layout kaydı");
        ReusableMethods.wait(2);

        // Hata mesajı görür
        String expectedHataMesaji = "Seat layout saved successfully.";
        softAssert.assertNotEquals(adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText(),expectedHataMesaji,"Hata mesajı vermedi");

        System.out.println(expectedHataMesaji);
        System.out.println(adminDashBoard_manageFleetsPage.alertAddNewMesagge.getText());
        softAssert.assertAll();
        ReusableMethods.wait(2);
        extentTest.info("Closed page");
        Driver.closeDriver();

    }
}
