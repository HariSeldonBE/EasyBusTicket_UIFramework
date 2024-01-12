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

public class TC03 {
    @Test
    public void signUpformBosDogrulama() {

        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on the "Register" ButtonLink from the home page.
        // 4- Registration procedures: Name, Surname, Email, Country, Mobile Phone, Username, Email, Password, Confirm Password text boxes are left blank and the register button is pressed.
        // 5- It is verified that the form has not been sent


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.signUpButton2.click();
        SignUpPage signUpPage = new SignUpPage();
        ReusableMethods.wait(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        signUpPage.acceptCheckButon.click();

        signUpPage.signUpbutton.click();


        ReusableMethods.wait(1);
        Assert.assertTrue(signUpPage.firstnameTextBox.isDisplayed());
        ReusableMethods.wait(4);
        Driver.closeDriver();


    }

}