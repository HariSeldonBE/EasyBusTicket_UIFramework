package tests.yusuf.US09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02 extends TestBaseRapor {
    @Test
    public void signUpformDogrulama(){
        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "signUp" ButtonLink from the home page.
        // 4- In the registration window, it is verified that the Firstname, Last name, Email, Country, Mobile, Username, Email, Password, Confirm Password text boxes are active and visible.

        extentTest=extentReports.createTest("Contact Us Button TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();

        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.signUpButton.click();
        extentTest.info("User presses the signUp button");

        ReusableMethods.wait(1);

        SoftAssert softAssert=new SoftAssert();
        SignUpPage signUpPage=new SignUpPage();


        softAssert.assertTrue(signUpPage.firstnameTextBox.isDisplayed(),"Firstname textBox goruntulenmedi ");
        extentTest.pass("Firstname textBox displayed test passed");
        softAssert.assertTrue(signUpPage.firstnameTextBox.isEnabled(),"Firstname textBoxt aktif degil");
        extentTest.pass("Firstname textBOx enabled test passed");

        softAssert.assertTrue(signUpPage.lastnameTextBox.isDisplayed(),"Lastname textBox goruntulenmedi ");
        extentTest.pass("Lastname textBox displayed test passed");
        softAssert.assertTrue(signUpPage.lastnameTextBox.isEnabled(),"Lastname textBoxt aktif degil");
        extentTest.pass("Lastname textBox enabled test passed");

        softAssert.assertTrue(signUpPage.countryDDM.isDisplayed(),"Country DDM goruntulenmedi ");
        extentTest.pass("CountryDDM  displayed test passed");
        softAssert.assertTrue(signUpPage.countryDDM.isEnabled(),"Country DDM aktif degil");
        extentTest.pass("CountryDDM enabled test passed");

        softAssert.assertTrue(signUpPage.mobileTextBox.isDisplayed(),"Mobile textBox goruntulenmedi ");
        extentTest.pass("Mobile textBox displayed test passed");
        softAssert.assertTrue(signUpPage.mobileTextBox.isEnabled(),"Mobile textBox aktif degil");
        extentTest.pass("Mobile textBox enabled test passed");

        softAssert.assertTrue(signUpPage.usernameTextBox.isDisplayed(),"Username textBox goruntulenmedi ");
        extentTest.pass(" Username  displayed test passed");
        softAssert.assertTrue(signUpPage.usernameTextBox.isEnabled(),"Username textBox aktif degil");
        extentTest.pass("Username  enabled test passed");


        softAssert.assertTrue(signUpPage.emailTextBox.isDisplayed(),"Email textBox goruntulenmedi ");
        extentTest.pass("Email textBox displayed test passed");
        softAssert.assertTrue(signUpPage.emailTextBox.isEnabled(),"Email textBox aktif degil");
        extentTest.pass("Email textBox enabled test passed");

        softAssert.assertAll();
        Driver.closeDriver();
        extentTest.info("Page closed");



    }
}
