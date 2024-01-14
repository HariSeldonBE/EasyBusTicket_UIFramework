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

public class TC06 extends TestBaseRapor {
    @Test
    public void emailsecurity(){
        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "signUp" ButtonLink from the home page.
        // 4- The page scrolls down
        // 5- In the registration window, it is verified that the Firstname, Last name,  Country, Mobile, Username text boxes are active and visible.
        // 6- An invalid email is entered in the email.
        // 7- Sign Up button is pressed.
        // 9- Verify that the firstname textBox appears on the same page


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signUpButton.click();
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);

        Actions actions = new Actions(Driver.getDriver());
        Faker faker=new Faker();
        String email =ConfigReader.getProperty("gecersizemail");
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


        ReusableMethods.wait(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);


        signUpPage.acceptCheckButon.click();


        signUpPage.signUpbutton.click();

        ReusableMethods.wait(1);

        Assert.assertTrue(signUpPage.firstnameTextBox.isDisplayed());


        Driver.closeDriver();









    }



}
