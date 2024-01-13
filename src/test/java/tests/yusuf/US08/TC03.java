 package tests.yusuf.US08;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {
    @Test
    public void contactus(){
        // 1 - http://qa.easybusticket.com homepage go
        // 2 - Cookies  accepted
        // 3 - Click on "Contact" ButtonLink from the home page.
        // 4 - It must be verified that the map providing location information is visible.
        // 5 - It must be verified that the map providing location information is active.


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();

        easyBusTicketPage.contactButton.click();

        ContactPage contactPage=new ContactPage();
        ReusableMethods.wait(1);
        SoftAssert softAssert=new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);

       softAssert.assertTrue(contactPage.map.isDisplayed(),"Map gozukmuyor");
       softAssert.assertTrue(contactPage.map.isEnabled(),"Map aktif degil");

       softAssert.assertAll();

        Driver.closeDriver();





    }
}
