package tests.yusuf.US08;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void Contact(){

        // 1- http://qa.easybusticket.com  anasayfasina gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2 - Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3- Ana sayfa dan "Contact" ButtonLink e tıklanır.
        easyBusTicketPage.contactButton.click();
        ReusableMethods.wait(1);
        //4 - Contact sayfasında "Contact Us" kapak yazısının görüntülendiği doğrulanır.
        Assert.assertTrue(easyBusTicketPage.contactUsText.isDisplayed());

        Driver.closeDriver();







    }
}

