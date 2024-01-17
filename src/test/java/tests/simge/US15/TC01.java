package tests.simge.US15;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void supportRequestButonuDogrulamaTesti(){
        SoftAssert softAssert=new SoftAssert();

        // 1-Browser açılır ve Url'e gidilir
        BookingHistoryPage bookingHistoryPage = new BookingHistoryPage();
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        ReusableMethods.userLoginButton();
        ReusableMethods.wait(1);
        //"Support Request" DDM görülür ve aktif olduğu doğrulanır
        softAssert.assertTrue(userDashBoardPage.supportRequest.isDisplayed(),"Support Request DDM görüntülenmedi");
        softAssert.assertTrue(userDashBoardPage.supportRequest.isEnabled(),"Support Request DDM aktif değil");
        //Support Request tıklanır ve alt menüde Create New görüntülenir ve aktif olduğu doğrulanır
        userDashBoardPage.supportRequest.click();
        ReusableMethods.wait(1);
        softAssert.assertTrue(userDashBoardPage.createNew.isDisplayed(),"Create New butonu görüntülenmedi");
        Assert.assertTrue(userDashBoardPage.createNew.isEnabled(),"Create New butonu aktif değil");
        //Create New tıklanır ve Support Tickets sayfası açıldığı doğrulanır
        SupportRequestPage supportRequestPage = new SupportRequestPage();
        userDashBoardPage.createNew.click();
        softAssert.assertTrue(supportRequestPage.supportTicketsTitle.isDisplayed(),"Support Tickets sayfası açılmadı");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
