package tests.yusuf.US08;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import javax.swing.*;

public class TC05 extends TestBaseRapor {

    @Test
    public void supportMessage(){
        // 1- http://qa.easybusticket.com  anasayfasina gidilir
        // 2- Cookies kabul edilir
        // 3- Ana sayfa dan "Contact" ButtonLink e tıklanır.
        // 4- Sayfa asagi kaydirilir
        // 5- Name,email, subject ,Your Message  TextBoxlari doldurulur.
        // 6- Send Us Message Button tıklanilir
        // 7- " Your message has been sent. Thank you for contacting us. " goruntulendigi dogrulanir

        extentTest=extentReports.createTest("Contact Us Button TEST", "User tests the contact button");
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        extentTest.info("User goes to \"Easy Bus Ticket\" home page");
        EasyBusTicketPage easyBusTicketPage=new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        extentTest.info("User presses the accept cookies ");
        easyBusTicketPage.contactButton.click();
        extentTest.info("User presses the contact button");

        ContactPage contactPage=new ContactPage();
        ReusableMethods.wait(1);
        extentTest.info("1 seconds wait");

        Actions actions=new Actions(Driver.getDriver());
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();


        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",contactPage.nameTextBox);
        ReusableMethods.wait(1);
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
            extentTest.info("Fills boxes with appropriate criteria");
        contactPage.sendUsButton.click();
        extentTest.info("\"send us button\" Click");
        ReusableMethods.wait(3);
        extentTest.info("3 seconds wait");
        Assert.assertTrue(contactPage.yourmessagehasbeensentbutton.isDisplayed());
        extentTest.pass("' YourMessage Has Been Sent' displayed test passed ");

        Driver.closeDriver();
        extentTest.info("Page closed");











    }
}
