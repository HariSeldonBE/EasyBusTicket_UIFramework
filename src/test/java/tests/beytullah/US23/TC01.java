package tests.beytullah.US23;

import pages.admin.AdminDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01 {

    @Test
    public void test1(){
        AdminDashBoardPage adminDashBoardPage=new AdminDashBoardPage();
        SoftAssert softAssert=new SoftAssert();

        //URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        //Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14","123123123");
        //Admin dashboard sayfasına ulaşır
        String expectedURl="https://qa.easybusticket.com/admin/dashboard";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedURl,"Admin dashboard sayfasına ulaşılamadı");

        //"Manage Users" DDM'yi görür
        adminDashBoardPage.dropDownManageUsers.isDisplayed();
        //"Manage Users" DDM'ye tıklar
        adminDashBoardPage.dropDownManageUsers.click();
        //Açılan DDM'de "all users, active users,banned users, Email unverified, sms unverified, email to al" linklerini görür
        softAssert.assertTrue(adminDashBoardPage.linkAllUsers.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkActiveUsers.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkBannedUsers.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkEmailUnverified.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkSmsUnverified.isDisplayed());
        softAssert.assertTrue(adminDashBoardPage.linkEmailToAll.isDisplayed());
        // Linklerin sayılarını görüntüler
        int expectedSayi = 0;
        int actualSayi = adminDashBoardPage.listSayiManageUsers.indexOf(1);
        softAssert.assertTrue(actualSayi >= expectedSayi, "Link sayısı beklenenden büyük eşit değil. Beklenen: " + expectedSayi + ", Gerçek: " + actualSayi);
        /*List<Integer> sayiList = new ArrayList<>();
        for (WebElement element : adminDashBoardPage.listSayiManageUsers) {
            sayiList.add(Integer.parseInt(element.getText()));
        }

        System.out.println("sayiList = " + sayiList);

         */



    }
}
