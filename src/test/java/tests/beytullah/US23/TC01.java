package tests.beytullah.US23;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.ManageUsersDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class TC01 {

    @Test
    public void test1() {
        ManageUsersDDM manageUsersDDM = new ManageUsersDDM();
        SoftAssert softAssert = new SoftAssert();

        //URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        //Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        //Admin dashboard sayfasına ulaşır
        String expectedURl = "https://qa.easybusticket.com/admin/dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedURl, "Admin dashboard sayfasına ulaşılamadı");

        //"Manage Users" DDM'yi görür
        manageUsersDDM.dropDownManageUsers.isDisplayed();
        //"Manage Users" DDM'ye tıklar
        manageUsersDDM.dropDownManageUsers.click();
        //Açılan DDM'de "all users, active users,banned users, Email unverified, sms unverified, email to al" linklerini görür
        softAssert.assertTrue(manageUsersDDM.linkAllUsers.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.linkActiveUsers.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.linkBannedUsers.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.linkEmailUnverified.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.linkSmsUnverified.isDisplayed());
        softAssert.assertTrue(manageUsersDDM.linkEmailToAll.isDisplayed());
        // Linklerin sayılarını görüntüler

        List<Integer> numbers = new ArrayList<>();

        for (WebElement element : manageUsersDDM.listSayiManageUsers) {
            String text = element.getText().trim();

            if (!text.isEmpty()) {
                try {
                    int number = Integer.parseInt(text);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.err.println("Sayıya dönüştürme hatası: " + text);
                }
            }

            softAssert.assertTrue(!numbers.isEmpty());
        }

        System.out.println("Numbers: " + numbers);
        Driver.closeDriver();
    }
}
