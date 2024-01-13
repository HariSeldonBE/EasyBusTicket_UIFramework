package tests.yusuf.US08;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import pages.user.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {
    @Test
    public void Contact(){

        // 1 - http://qa.easybusticket.com homepage go
        // 2 - Cookies  accepted
        // 3 - Click on "Contact" ButtonLink from the home page.
        // 4 - It is verified that the "Contact Us" cover text is displayed on the Contact page.

        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        ContactPage contactPage=new ContactPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.contactButton.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(contactPage.contactUsText.isDisplayed());

        Driver.closeDriver();







    }
}

