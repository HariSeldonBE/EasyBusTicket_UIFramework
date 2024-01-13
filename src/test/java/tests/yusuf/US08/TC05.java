package tests.yusuf.US08;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class TC05 {

    @Test
    public void supportmessage(){
        // 1- http://qa.easybusticket.com  anasayfasina gidilir
        // 2- Cookies kabul edilir
        // 3- Ana sayfa dan "Contact" ButtonLink e tıklanır.
        // 4- Sayfa asagi kaydirilir
        // 5- Name,email, subject ,Your Message  TextBoxlari doldurulur.
        // 6- Send Us Message Button tıklanilir
        // 7- " Your message has been sent. Thank you for contacting us. " goruntulendigi dogrulanir


        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.contactButton.click();

        ContactPage contactPage=new ContactPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        Faker faker=new Faker();
        actions.click(contactPage.nameTextBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("fakesubject"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("fakemessage"))
                .perform();


        contactPage.sendUsButton.click();


        ReusableMethods.wait(3);


        Assert.assertTrue(contactPage.yourmessagehasbeensentbutton.isDisplayed());

        Driver.closeDriver();











    }
}
