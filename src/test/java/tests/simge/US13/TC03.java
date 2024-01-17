package tests.simge.US13;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.FindTicketsPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {
    @Test
    public void biletAramaNegatifTesti(){
        SoftAssert softAssert = new SoftAssert();
        // 1-Browser açılır ve Url'e gidilir ve Login olunur
        ReusableMethods.userLoginButton();
        // 7-Açılan user dashboard sayfasında navbar menüde "Booking" ddm menüsü tıklanır
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        userDashBoardPage.bookingDdm.click();
        ReusableMethods.wait(2);
        // 8-"Booking" açılır menüsü açıldığında "Buy Ticket" butonu tıklanır
        userDashBoardPage.buyTicket.click();
        FindTicketsPage findTicketsPage = new FindTicketsPage();
        // 9-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(2);
        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(2);
        // 10-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointNegatifSelection.click();
        // 11-"Date of Journey" dropbox undan sonraki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourneySelection.click();
        ReusableMethods.wait(2);
        // 12-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        ReusableMethods.wait(2);
        // 13-"Please select pickup point and destination point properly" hata yazısı çıktığı doğrulanır
        softAssert.assertTrue(findTicketsPage.properlyError.isDisplayed(), "Error görüntülenmedi");
        ReusableMethods.wait(2);
        // 14-"Pick Up Point" dropbox undan herhangi bir yer seçilir
        findTicketsPage.pickupPoint.click();
        ReusableMethods.wait(2);
        findTicketsPage.pickupPointSelection.click();
        ReusableMethods.wait(2);
        // 15-"Dropping Point" dropbox undan farklı yer seçilir
        findTicketsPage.droppingPoint.click();
        findTicketsPage.droppingPointSelection.click();
        // 16-"Date of Journey" dropbox undan önceki tarih seçilir
        findTicketsPage.dateOfJourney.click();
        findTicketsPage.dateOfJourneyNegatifSelection.click();
        ReusableMethods.wait(2);
        // 17-"Find Tickets" butonu tıklanır
        findTicketsPage.findTicketsButton.click();
        ReusableMethods.wait(2);
        // 18-"Date of journey can't be less than today." hata yazısı çıktığı doğrulanır
        softAssert.assertTrue(findTicketsPage.journeyDateError.isDisplayed(),"Journey Date Error görüntülenmedi");

        ReusableMethods.wait(2);
        softAssert.assertAll();
        Driver.closeDriver();





    }
}
