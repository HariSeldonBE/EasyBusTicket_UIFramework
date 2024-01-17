 package tests.yusuf.US08;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

 public class TC03 extends TestBaseRapor {
    @Test
    public void contactus(){
        // 1 - http://qa.easybusticket.com homepage go
        // 2 - Cookies  accepted
        // 3 - Click on "Contact" ButtonLink from the home page.
        // 4 - It must be verified that the map providing location information is visible.
        // 5 - It must be verified that the map providing location information is active.

        extentTest=extentReports.createTest("Contact Us MAP TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");


        easyBusTicketPage.contactButton.click();
        extentTest.info("User presses the contact button");

        ContactPage contactPage=new ContactPage();
        ReusableMethods.wait(1);
        SoftAssert softAssert=new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");

       softAssert.assertTrue(contactPage.map.isDisplayed(),"Map is not displayed");
        extentTest.pass("Map  displayed test passed");
       softAssert.assertTrue(contactPage.map.isEnabled(),"Map is not displayed");
        extentTest.pass("Map enabled test passed");

       softAssert.assertAll();

        Driver.closeDriver();
        extentTest.info("Closed page");





    }
}
