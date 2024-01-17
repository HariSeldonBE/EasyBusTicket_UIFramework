package tests.yusuf.US09;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC07 extends TestBaseRapor {
    @Test
    public void usernamesecurity() {
        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "signUp" ButtonLink from the home page.
        // 4- The page scrolls down
        // 5- Registration procedures: Name, Surname, Email, Country, Mobile Phone, Email, Password, Confirm Password text boxes are filled with the appropriate criteria and the register button is pressed.
        // 6- An existing username is entered into the Username textBox.
        // 7- Verify that "username already exists" appears under the Username textBox.
        // 9- Sign Up button is pressed.
        // 10- Verify that text "The username has already been taken."

        extentTest=extentReports.createTest("Contact Us Button TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.signUpButton.click();
        extentTest.info("User presses the SignUp button");
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);
        extentTest.info("1 seconds wait");



        Actions actions = new Actions(Driver.getDriver());
        Faker faker=new Faker();
        SoftAssert softAssert=new SoftAssert();
        String userName=ConfigReader.getProperty("userName");
        String email =faker.internet().emailAddress();
        String password=faker.internet().password();

        actions.click(signUpPage.firstnameTextBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().subscriberNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(userName)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        extentTest.info("An existing username is entered into the Username textbox, other textboxes are filled with appropriate criteria.");

        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");

        softAssert.assertTrue(signUpPage.usernameAlreadyExist.isDisplayed());
        extentTest.pass("Username Already Exist displayed test passed");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);
        signUpPage.acceptCheckButon.click();
        extentTest.info("Sign Up accept check box clicked");
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
        signUpPage.signUpbutton.click();
        extentTest.info("Sign Up button  clicked");
        softAssert.assertTrue(signUpPage.Theusernamehasalreadybeentaken.isDisplayed());
        extentTest.pass("Theusernamehasalreadybeentaken text displayed passed");
        softAssert.assertAll();

        Driver.closeDriver();
        extentTest.info("Page closed");













    }
}