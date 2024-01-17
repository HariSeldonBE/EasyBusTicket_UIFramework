package tests.ilteris.US07;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.BlogPage;
import pages.user.FAQsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void headerBlogLinkiGörüntülemeTesti(){

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        BlogPage blogPage = new BlogPage();
        easyBusTicketPage.cookiesButton.click();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);

        softAssert.assertTrue(easyBusTicketPage.headerBlogButton.isDisplayed());
        easyBusTicketPage.headerBlogButton.click();

        String EBTticketPageExpectedUrl = "https://qa.easybusticket.com/blog";
        String EBTTicketPageActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(EBTTicketPageActualUrl,EBTticketPageExpectedUrl);

        softAssert.assertTrue(blogPage.blogPost1.isDisplayed());
        softAssert.assertTrue(blogPage.blogPost2.isDisplayed());
        softAssert.assertTrue(blogPage.blogPost3.isDisplayed());
        softAssert.assertTrue(blogPage.blogPost4.isDisplayed());
        softAssert.assertTrue(blogPage.blogPost5.isDisplayed());
        softAssert.assertTrue(blogPage.blogPost6.isDisplayed());
        softAssert.assertTrue(blogPage.blogPost7.isDisplayed());
        softAssert.assertTrue(blogPage.recentBlogPostHeader.isDisplayed());
        softAssert.assertTrue(blogPage.recentBlogPost1.isDisplayed());
        softAssert.assertTrue(blogPage.recentBlogPost2.isDisplayed());
        softAssert.assertTrue(blogPage.recentBlogPost3.isDisplayed());




        softAssert.assertAll();

        Driver.closeDriver();

    }
}
