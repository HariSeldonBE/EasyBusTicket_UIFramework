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

public class TC08 extends TestBaseRapor {
    @Test
    public void AlreadyhaveanAccount(){

        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "signUp" ButtonLink from the home page.
        // 4- The page scrolls down
        // 5- The text "Already have an Account?" is displayed
        // 6- Press the "Sign In" button
        // 7- "SignInYourAccount" is displayed

        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signUpButton.click();
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);

        Actions actions=new Actions(Driver.getDriver());


        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);

        actions.sendKeys(Keys.PAGE_DOWN).perform();



        signUpPage.signInButton.click();
        ReusableMethods.wait(1);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(signUpPage.SignInYourAccountText.isDisplayed());
        softAssert.assertAll();
        Driver.closeDriver();










    }
}
