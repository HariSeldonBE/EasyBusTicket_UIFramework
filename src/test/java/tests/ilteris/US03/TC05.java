package tests.ilteris.US03;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC05 {

    @Test
    public void ourTestimonialsTesti() {

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView()",easyBusTicketPage.ourTestimonialsTitle);


        ReusableMethods.wait(2);

        softAssert.assertTrue(easyBusTicketPage.ourTestimonialsButton.isDisplayed());
        easyBusTicketPage.ourTestimonialsButton.click();
        ReusableMethods.wait(1);
        softAssert.assertTrue(easyBusTicketPage.ourTestimonialsButton2.isDisplayed());
        easyBusTicketPage.ourTestimonialsButton2.click();
        ReusableMethods.wait(1);
        softAssert.assertTrue(easyBusTicketPage.ourTestimonialsButton3.isDisplayed());
        easyBusTicketPage.ourTestimonialsButton3.click();



        softAssert.assertAll();

        Driver.closeDriver();













    }
}
