package tests.yusuf.US08;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02 extends TestBaseRapor {
    @Test
            public void contactus(){
        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "Contact" ButtonLink from the home page.
        // 4- Verify that the "Our Address" box, icon and information are displayed under the "Let's get in touch" text
        // 5- Verify that the "Call Us" box, icon and information are displayed under the "Let's get in touch" text.
        // 6- Verify that the phone number in the "Call Us" box is active.
        // 7- It is verified that the Email address in the "Email Us" box is active.

        extentTest=extentReports.createTest("Contact Us communication TEST", "User tests the communication ");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.contactButton.click();
        extentTest.info("User presses the contact button");



        ContactPage contactPage=new ContactPage();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(contactPage.ourAdressText.isDisplayed(),"Our Adress butonu not displayed");
         extentTest.pass("Our Adress displayed test passed");

        softAssert.assertTrue(contactPage.callUsText.isDisplayed(),"Call Us text not displayed ");
        extentTest.pass("Call Us Text displayed test passed");


        softAssert.assertTrue(contactPage.numberbutton.isEnabled(),"Telefon numarasi butonu aktif degil");
        extentTest.pass("Number Button Enabled   test passed");


        softAssert.assertTrue(contactPage.emailbutton.isEnabled(),"Email butonu aktif degil ");
        extentTest.pass("Email Button Enabled   test passed");
        softAssert.assertAll();
        ReusableMethods.wait(2);
        extentTest.info("2 seconds wait");

        Driver.closeDriver();
        extentTest.info("Closed page");








    }
}
