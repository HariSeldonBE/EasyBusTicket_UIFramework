package tests.huseyin.US11;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC15 {
    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        UserLoginPage userLoginPage = new UserLoginPage();
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        SoftAssert softAssert = new SoftAssert();


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        String actualEBTUrl = Driver.getDriver().getCurrentUrl();
        String expectedEBTUrl = ConfigReader.getProperty("eBTUrl");

        // Easy Bus Ticket Home Page Url Test
        softAssert.assertEquals(actualEBTUrl,expectedEBTUrl, "Easy Bus Ticket Home Page is not displayed");

        // Home Page Cookies Button Display Test
        softAssert.assertTrue(easyBusTicketPage.cookiesButton.isDisplayed(),"Cookies Button Button is not displayed");
        // Home Page Sign-in Button Enable Test
        softAssert.assertTrue(easyBusTicketPage.cookiesButton.isEnabled(),"Cookies Button is not enabled");

        ReusableMethods.wait(1);
        easyBusTicketPage.cookiesButton.click();

        // Home Page Sign-in Button Display Test
        softAssert.assertTrue(easyBusTicketPage.signInButton.isDisplayed(),"Sign-In Button is not displayed");
        // Home Page Sign-in Button Enable Test
        softAssert.assertTrue(easyBusTicketPage.signInButton.isEnabled(),"Sign-In Button is not enabled");

        easyBusTicketPage.signInButton.click();

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("eBTUserUrl");


        // User Login Page Url Test
        softAssert.assertEquals(actualUrl,expectedUrl, "User Login Page is not displayed");
        // User Login Page Login Panel Test
        softAssert.assertTrue(userLoginPage.logInPanel.isDisplayed(), "Login Panel is not displayed");
        // User Login Page Username Box Display Test
        softAssert.assertTrue(userLoginPage.usernameBox.isDisplayed(), "Username Box is not displayed");
        // User Login Page Password Box Enable Test
        softAssert.assertTrue(userLoginPage.usernameBox.isEnabled(), "Username Box is not enabled");
        // User Login Page Password Box Display Test
        softAssert.assertTrue(userLoginPage.passwordBox.isDisplayed(), "Password Box is not displayed");
        // User Login Page Password Box Enable Test
        softAssert.assertTrue(userLoginPage.passwordBox.isEnabled(), "Password Box is not enabled");
        // User Login Page Login Button Display Test
        softAssert.assertTrue(userLoginPage.loginButton.isDisplayed(), "Login Button is not displayed");
        // User Login Page Password Box Enable Test
        softAssert.assertTrue(userLoginPage.loginButton.isEnabled(), "Login Button Box is not enabled");


        // Enter Username and Password then Click to the Login button
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        ReusableMethods.wait(1);
        userLoginPage.loginButton.click();

        String actualUserDBUrl = Driver.getDriver().getCurrentUrl();
        String expectedUserDBUrl = "https://qa.easybusticket.com/user/dashboard";

        // User Dashboard Page Url Test
        softAssert.assertEquals(actualUserDBUrl,expectedUserDBUrl, "User Dashboard Url is not confirmed");
        // User Dashboard Page Easy Bus Ticket Logo Display Test
        softAssert.assertTrue(userDashBoardPage.eBTLogo.isDisplayed(), "Login Button is not displayed");
        // User Dashboard Page Easy Bus Ticket Logo Enable Test
        softAssert.assertTrue(userDashBoardPage.eBTLogo.isEnabled(), "Login Button Box is not enabled");

        userDashBoardPage.eBTLogo.click();

        // Easy Bus Ticket Home Page Url Test
        softAssert.assertEquals(actualEBTUrl,expectedEBTUrl, "Easy Bus Ticket Home Page is not displayed");

        softAssert.assertTrue(easyBusTicketPage.testimonial1.isDisplayed(), "Testimonial is not displayed");
        softAssert.assertTrue(easyBusTicketPage.testimonial1.isEnabled(), "Testimonial is not enabled");
        softAssert.assertTrue(easyBusTicketPage.testimonial2.isDisplayed(), "Testimonial is not displayed");
        softAssert.assertTrue(easyBusTicketPage.testimonial2.isEnabled(), "Testimonial is not enabled");
        softAssert.assertTrue(easyBusTicketPage.testimonial3.isDisplayed(), "Testimonial is not displayed");
        softAssert.assertTrue(easyBusTicketPage.testimonial3.isEnabled(), "Testimonial is not enabled");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].click();",easyBusTicketPage.testimonial1);
        ReusableMethods.wait(2);
        js.executeScript("arguments[0].click();",easyBusTicketPage.testimonial2);
        ReusableMethods.wait(1);
        js.executeScript("arguments[0].click();",easyBusTicketPage.testimonial3);
        ReusableMethods.wait(1);


        softAssert.assertAll();
        Driver.closeDriver();
    }
}
