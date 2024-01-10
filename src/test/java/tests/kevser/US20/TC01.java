package tests.kevser.US20;

import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {

    @Test
    public void test01(){
    Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
    EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
    easyBusTicketPage.cookiesButton.click();
    easyBusTicketPage.signInButton.click();
    ReusableMethods.wait(2);
    Driver.closeDriver();

}
}
