package tests.yusuf.US09;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC04 extends TestBaseRapor {
    @Test
    public void signUPbasariligiris(){
        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "signUp" ButtonLink from the home page.
        // 4- The page scrolls down
        // 5- Registration procedures: Name, Surname, Email, Country, Mobile Phone, User Name, Email, Password, Confirm Password text boxes are filled with the appropriate criteria and the register button is pressed.

        extentTest=extentReports.createTest("Contact Us Button TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.signUpButton.click();
        extentTest.info("User presses the signUp button");

        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);
        extentTest.info("2 seconds wait");

        Actions actions = new Actions(Driver.getDriver());
        Faker faker=new Faker();
        String email =faker.internet().emailAddress();
        String password=faker.internet().password();
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
        extentTest.info("Information is filled with appropriate criteria");

        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Page down");
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");


        signUpPage.acceptCheckButon.click();
       extentTest.info("Sign Up accept check box clicked");

        signUpPage.signUpbutton.click();
        extentTest.info("Sign Up button  clicked");
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
        Driver.closeDriver();
        extentTest.info("Page closed");










    }
}
