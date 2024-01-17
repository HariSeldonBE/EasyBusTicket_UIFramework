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
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {
    @Test
    public void Contact(){

        // 1 - http://qa.easybusticket.com homepage go
        // 2 - Cookies  accepted
        // 3 - Click on "Contact" ButtonLink from the home page.
        // 4 - It is verified that the "Contact Us" cover text is displayed on the Contact page.


        extentTest=extentReports.createTest("Contact Us Button TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        ContactPage contactPage=new ContactPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.contactButton.click();
        extentTest.info("User presses the contact button");
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
        Assert.assertTrue(contactPage.contactUsText.isDisplayed());
        extentTest.pass("Tests the visibility of the 'Contact Us' text passed");

        Driver.closeDriver();
        extentTest.info("Closed page");







    }
}

