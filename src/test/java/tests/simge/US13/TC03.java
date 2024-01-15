package tests.simge.US13;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
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

        // 1-Browser açılır ve Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2-Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3-SignIn butonuna tıklanır
        easyBusTicketPage.signInButton.click();
        ReusableMethods.wait(2);
        // 4-Geçerli Username girilir
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        // 5-Geçerli Password girilir
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        // 6-Log In butonuna tıklanır
        userLoginPage.loginButton.click();
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
        Assert.assertTrue(findTicketsPage.properlyError.isDisplayed());
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
        Assert.assertTrue(findTicketsPage.journeyDateError.isDisplayed());

        ReusableMethods.wait(2);

        Driver.closeDriver();





    }
}
