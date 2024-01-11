package tests.yusuf.US08;

import org.openqa.selenium.JavascriptExecutor;
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
    // 1- http://qa.easybusticket.com  anasayfasina gidilir
            Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2 - Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3- Ana sayfa dan "Contact" ButtonLink e tıklanır.
        easyBusTicketPage.contactButton.click();

        ContactPage contactPage=new ContactPage();
        ReusableMethods.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(2);

        //4 - "Let's get in touch" yazısı altında "Our Address" kutucuğu,
    // ikonu ve bilgisi görüntülendiği doğrulanır.


        SoftAssert softAssert = new SoftAssert();
      softAssert.assertTrue(contactPage.ourAdressText.isDisplayed(),"Our Adress butonu goruntulenemedi");




        // 5 - "Let's get in touch" yazısı altında "Call Us" kutucuğu, ikonu ve bilgisi görüntülendiği doğrulanır.
        softAssert.assertTrue(contactPage.callUsText.isDisplayed(),"Call Us yazisi goruntulenemedi ");

        // 6-"Call Us" kutucugundaki telefon numarası aktif olduğu doğrulanır.

        softAssert.assertTrue(contactPage.numberbutton.isEnabled(),"Telefon numarasi butonu aktif degil");

        //7-"Email Us" kutucugundaki Email adresi aktif olduğu doğrulanır.

        softAssert.assertTrue(contactPage.emailbutton.isEnabled(),"Email butonu aktif degil ");

        softAssert.assertAll();
        ReusableMethods.wait(2);

Driver.closeDriver();







    }
}
