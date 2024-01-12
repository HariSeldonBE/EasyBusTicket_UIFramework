/* package tests.yusuf.US08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC04 {
    @Test
    public void iletisimform(){


        // 1- http://qa.easybusticket.com  anasayfasina gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2 - Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3- Ana sayfa dan "Contact" ButtonLink e tıklanır.
        easyBusTicketPage.contactButton.click();

        ContactPage contactPage=new ContactPage();
        ReusableMethods.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();



    }
}

*/