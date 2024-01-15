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


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signUpButton.click();
        ReusableMethods.wait(1);
        SoftAssert softAssert=new SoftAssert();
        SignUpPage signUpPage=new SignUpPage();

        softAssert.assertTrue(signUpPage.firstnameTextBox.isDisplayed(),"Firstname textBox goruntulenmedi ");
        softAssert.assertTrue(signUpPage.firstnameTextBox.isEnabled(),"Firstname textBoxt aktif degil");

        softAssert.assertTrue(signUpPage.lastnameTextBox.isDisplayed(),"Lastname textBox goruntulenmedi ");
        softAssert.assertTrue(signUpPage.lastnameTextBox.isEnabled(),"Lastname textBoxt aktif degil");

        softAssert.assertTrue(signUpPage.countryDDM.isDisplayed(),"Country DDM goruntulenmedi ");
        softAssert.assertTrue(signUpPage.countryDDM.isEnabled(),"Country DDM aktif degil");

        softAssert.assertTrue(signUpPage.mobileTextBox.isDisplayed(),"Mobile textBox goruntulenmedi ");
        softAssert.assertTrue(signUpPage.mobileTextBox.isEnabled(),"Mobile textBox aktif degil");

        softAssert.assertTrue(signUpPage.usernameTextBox.isDisplayed(),"Username textBox goruntulenmedi ");
        softAssert.assertTrue(signUpPage.usernameTextBox.isEnabled(),"Username textBox aktif degil");

        softAssert.assertTrue(signUpPage.emailTextBox.isDisplayed(),"Email textBox goruntulenmedi ");
        softAssert.assertTrue(signUpPage.emailTextBox.isEnabled(),"Email textBox aktif degil");

        softAssert.assertAll();
        Driver.closeDriver();



    }
}
