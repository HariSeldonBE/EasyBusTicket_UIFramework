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

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // Admin dashboard sayfasına ulaşır
        String expectedURl = "https://qa.easybusticket.com/admin/dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedURl, "Admin dashboard sayfasına ulaşılamadı");

        // "Manage Users" DDM'yi görür ve tıklar
        WebElement dropDownManageUsers = manageUsersDDM.dropDownManageUsers;
        softAssert.assertTrue(dropDownManageUsers.isDisplayed(), "Manage Users DDM görüntülenemedi");
        dropDownManageUsers.click();

        // Açılan DDM'de belirli linkleri görür
        List<WebElement> linkElements = List.of(
                manageUsersDDM.linkAllUsers,
                manageUsersDDM.linkActiveUsers,
                manageUsersDDM.linkBannedUsers,
                manageUsersDDM.linkEmailUnverified,
                manageUsersDDM.linkSmsUnverified,
                manageUsersDDM.linkEmailToAll
        );

        for (WebElement linkElement : linkElements) {
            softAssert.assertTrue(linkElement.isDisplayed(), "Link görüntülenemedi: " + linkElement.getText());
        }

        // Linklerin sayılarını kontrol et
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
        }

        // Sayıları kontrol et
        softAssert.assertFalse(numbers.isEmpty(), "Sayı listesi boş");

        System.out.println("Numbers: " + numbers);

        // Tüm assertleri kontrol et
        softAssert.assertAll();



        Driver.closeDriver();
    }
}
