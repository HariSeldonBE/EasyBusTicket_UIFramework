package tests.yusuf.US08;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
            public void contactus(){
        // 1- http://qa.easybusticket.com homepage go
        // 2- Cookies  accepted
        // 3- Click on "Contact" ButtonLink from the home page.
        // 4- Verify that the "Our Address" box, icon and information are displayed under the "Let's get in touch" text
        // 5- Verify that the "Call Us" box, icon and information are displayed under the "Let's get in touch" text.
        // 6- Verify that the phone number in the "Call Us" box is active.
        // 7- It is verified that the Email address in the "Email Us" box is active.


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.contactButton.click();

        ContactPage contactPage=new ContactPage();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(1);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(contactPage.ourAdressText.isDisplayed(),"Our Adress butonu goruntulenemedi");


        softAssert.assertTrue(contactPage.callUsText.isDisplayed(),"Call Us yazisi goruntulenemedi ");



        softAssert.assertTrue(contactPage.numberbutton.isEnabled(),"Telefon numarasi butonu aktif degil");



        softAssert.assertTrue(contactPage.emailbutton.isEnabled(),"Email butonu aktif degil ");

        softAssert.assertAll();
        ReusableMethods.wait(2);

        Driver.closeDriver();







    }
}
