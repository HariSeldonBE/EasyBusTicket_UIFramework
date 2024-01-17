package tests.yusuf.US09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03 extends TestBaseRapor {
    @Test
    public void signUpformBosDogrulama() {

        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on the "Register" ButtonLink from the home page.
        // 4- Registration procedures: Name, Surname, Email, Country, Mobile Phone, Username, Email, Password, Confirm Password text boxes are left blank and the register button is pressed.
        // 5- It is verified that the form has not been sent

        extentTest=extentReports.createTest("SignUp Page  TEST", "User tests the signUp Page ");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.signUpButton.click();
        extentTest.info("User presses the signUp button");
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);
        extentTest.info("1 seconds wait");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        signUpPage.acceptCheckButon.click();
        extentTest.info("Accept check button Click");

        signUpPage.signUpbutton.click();
        extentTest.info("Sign Up button clicked");


        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");

        Assert.assertTrue(signUpPage.firstnameTextBox.isDisplayed());
        extentTest.pass("Firstname textBox is displayed test passed");
        ReusableMethods.wait(4);
        extentTest.info("4 seconds passed ");
        Driver.closeDriver();
        extentTest.info("Page closed");


    }

}