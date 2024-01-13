package tests.yusuf.US09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {

    @Test
    public void SignUpButton(){
        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "signUp" ButtonLink from the home page.
        // 4- Verify that the "Welcome to Easy Bus Ticket" cover text is displayed on the signUp page.
        // 5- It is confirmed that the text "Sign Up your Account" is displayed




        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signUpButton.click();
        ReusableMethods.wait(1);
        SoftAssert softAssert=new SoftAssert();
        SignUpPage signUpPage=new SignUpPage();

        softAssert.assertTrue(signUpPage.welcometoeasyBusTicketText.isDisplayed(),"Welcome to Easy Bus Ticket\" yazisi gozukmedi ");
        softAssert.assertTrue(signUpPage.signUpYourAccountText.isDisplayed(),"signUpYourAccountText yazisi gozukmedi");

        softAssert.assertAll();
        Driver.closeDriver();

}
}