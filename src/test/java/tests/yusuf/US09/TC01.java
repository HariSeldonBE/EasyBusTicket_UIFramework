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



        extentTest=extentReports.createTest("SignUp Button TEST", "User tests the signUp button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.signUpButton.click();
        extentTest.info("User click signUp Button ");

        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");
        SoftAssert softAssert=new SoftAssert();
        SignUpPage signUpPage=new SignUpPage();

        softAssert.assertTrue(signUpPage.welcometoeasyBusTicketText.isDisplayed(),"Welcome to Easy Bus Ticket\" text not displayed ");
        extentTest.pass("'Welcome to Easy BUs Ticket ' text test passed ");
        softAssert.assertTrue(signUpPage.signUpYourAccountText.isDisplayed(),"signUpYourAccountText is not displayed");
        extentTest.pass("'SignUp Your Account' text test passed ");


        softAssert.assertAll();
        Driver.closeDriver();
        extentTest.info("Page closed");

}
}