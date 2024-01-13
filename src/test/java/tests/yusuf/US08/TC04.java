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

public class TC04 {
    @Test
    public void iletisimform(){


        // 1- http://qa.easybusticket.com  anasayfasina gidilir
        // 2- Cookies kabul edilir
        // 3- Ana sayfa dan "Contact" ButtonLink e tıklanır.
        // 4- İletişim formunun üstünde "Have any Questions?" yazısı görüntülendiği doğrulanmalı.
        // 5- "Name" kutucuğunun aktif olduğu ve isim yazılabildiği doğrulanmalı.
        // 6- "Email" kutucuğunun aktif olduğu ve email adresi yazılabildiği doğrulanmalı. @
        // 7- "Subject" kutucuğunun aktif olduğu ve konu yazılabildiği doğrulanmalı.
        // 8- "Your Message" kutucuğunun aktif olduğu ve mesaj yazılabildiği doğrulanmalı.
        // 9- "Send Us Message" butonunun görünür olduğu doğrulanmalı.
        // 10- "Send Us Message" butonu tıklandığında
        // "Your message has been sent, thank you for contact us" yazısının görünür olduğu doğrulanmalı.



        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        easyBusTicketPage.contactButton.click();
        ContactPage contactPage=new ContactPage();
        ReusableMethods.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(contactPage.haveAnyQuestionsText.isDisplayed());

        softAssert.assertTrue(contactPage.nameTextBox.isDisplayed(),"Name Textbox gozukmuyor");
        softAssert.assertTrue(contactPage.nameTextBox.isEnabled(),"Name Textbox aktif degil");

        softAssert.assertTrue(contactPage.emailTextBox.isDisplayed(),"Email Textbox gozukmuyor");
        softAssert.assertTrue(contactPage.emailTextBox.isEnabled(),"Email Textbox aktif degil");


        softAssert.assertTrue(contactPage.subjectTextBox.isDisplayed(),"Subject Textbox gozukmuyor");
        softAssert.assertTrue(contactPage.subjectTextBox.isEnabled(),"Subject Textbox aktif degil");


        softAssert.assertTrue(contactPage.messageTextBox.isDisplayed(),"Message Textbox gozukmuyor");
        softAssert.assertTrue(contactPage.messageTextBox.isEnabled(),"Message Textbox aktif degil");

        softAssert.assertTrue(contactPage.sendUsButton.isDisplayed(),"Send Us Button  gozukmuyor");
        softAssert.assertTrue(contactPage.sendUsButton.isEnabled(),"Send Us Button aktif degil");

       softAssert.assertAll();

       Driver.closeDriver();



    }
}

