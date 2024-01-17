package tests.yusuf.US09;

import com.github.javafaker.Faker;
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

public class TC05 extends TestBaseRapor {

    @Test

    public void passwordsecurity(){
        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "signUp" ButtonLink from the home page.
        // 4- The page scrolls down
        // 5- Registration procedures: Name, Surname, Email, Country, Mobile Phone, User Name, Email,  Confirm , text boxes are filled with the appropriate criteria and the register button is pressed.
        // 6- Password textBox is written in lowercase letters that do not meet the criteria
        // 7- Confirm password textbox is written the same as what is written in the password textBox.
        // 8- Sign Up button is pressed
        // 9- Verify that the firstname textBox appears on the same page

        extentTest=extentReports.createTest("SignUp Page  TEST", "User tests the signUp Page ");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.signUpButton.click();
        extentTest.info("User presses the SignUp button");
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);
        extentTest.info("2 seconds wait");

        Actions actions = new Actions(Driver.getDriver());
        Faker faker=new Faker();
        String email =faker.internet().emailAddress();
        String password=ConfigReader.getProperty("gecersizparola");
        actions.click(signUpPage.firstnameTextBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().username())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        extentTest.info("Textboxes other than passwords are filled with appropriate criteria");



        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

         ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");

        signUpPage.acceptCheckButon.click();
        extentTest.info("Sign Up accept check box clicked");

        signUpPage.signUpbutton.click();
        extentTest.info("Sign up button clicked");
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
        Assert.assertTrue(signUpPage.firstnameTextBox.isDisplayed());
        extentTest.pass("Not logged in test passed");

        Driver.closeDriver();
        extentTest.info("Page closed");






    }
}
