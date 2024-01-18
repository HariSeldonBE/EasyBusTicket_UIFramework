package tests.ilteris.US07;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasyBusTicketPage;
import pages.user.BlogPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    @Test
    public void headerBlogPageAktiflikTesti(){

        //https://easybusticket.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));

        SoftAssert softAssert = new SoftAssert();
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        BlogPage blogPage = new BlogPage();
        easyBusTicketPage.cookiesButton.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //url'in https://easybusticket.com/ oldugunu test edin
        String exceptedUrl = "https://qa.easybusticket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,exceptedUrl);

        softAssert.assertTrue(easyBusTicketPage.headerBlogButton.isDisplayed());
        easyBusTicketPage.headerBlogButton.click();

        String EBTticketPageExpectedUrl = "https://qa.easybusticket.com/blog";
        String EBTTicketPageActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(EBTTicketPageActualUrl,EBTticketPageExpectedUrl);

        ReusableMethods.wait(1);

        js.executeScript("arguments[0].click();",BlogPage.blogPost1);
        String blogPost1ExpectedUrl = "https://qa.easybusticket.com/blog/103/travel-trends-the-best-times-to-explore-new-places";
        String blogPost1ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(blogPost1ActualUrl,blogPost1ExpectedUrl);
       // js.executeScript("arguments[0].scrollIntoView()",BlogPage.travelTrendsHeader);
        softAssert.assertTrue(BlogPage.travelTrendsHeader.isDisplayed());

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        js.executeScript("arguments[0].click();",BlogPage.blogPost2);
        String blogPost2ExpectedUrl = "https://qa.easybusticket.com/blog/87/traveling-with-technology-making-your-journey-easier-with-apps-and-devices";
        String blogPost2ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(blogPost2ActualUrl,blogPost2ExpectedUrl);

        softAssert.assertTrue(blogPage.travelingWithTechnologyHeader.isDisplayed());

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        js.executeScript("arguments[0].click();",BlogPage.blogPost3);
        String blogPost3ExpectedUrl = "https://qa.easybusticket.com/blog/86/safety-measures-what-to-pay-attention-to-during-travel";
        String blogPost3ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(blogPost3ActualUrl,blogPost3ExpectedUrl);

        softAssert.assertTrue(blogPage.safetyMeasuresHeader.isDisplayed());

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        js.executeScript("arguments[0].click();",BlogPage.blogPost4);
        String blogPost4ExpectedUrl = "https://qa.easybusticket.com/blog/62/culinary-odyssey-across-america-must-try-regional-delicacies";
        String blogPost4ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(blogPost4ActualUrl,blogPost4ExpectedUrl);

        softAssert.assertTrue(blogPage.culinaryOdysseyAcrossAmericaHeader.isDisplayed());

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        js.executeScript("arguments[0].click();",BlogPage.blogPost5);
        String blogPost5ExpectedUrl = "https://qa.easybusticket.com/blog/60/tips-for-comfort-during-travel";
        String blogPost5ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(blogPost5ActualUrl,blogPost5ExpectedUrl);

        softAssert.assertTrue(blogPage.tipsForComfortDuringTravelHeader.isDisplayed());

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        js.executeScript("arguments[0].click();",BlogPage.blogPost6);
        String blogPost6ExpectedUrl = "https://qa.easybusticket.com/blog/59/americas-must-see-iconic-cities";
        String blogPost6ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(blogPost6ActualUrl,blogPost6ExpectedUrl);

        softAssert.assertTrue(blogPage.americasMustSeeIconicCitiesHeader.isDisplayed());

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        js.executeScript("arguments[0].click();",BlogPage.blogPost7);
        String blogPost7ExpectedUrl = "https://qa.easybusticket.com/blog/58/nature-retreat-in-america-the-most-beautiful-national-parks";
        String blogPost7ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(blogPost7ActualUrl,blogPost7ExpectedUrl);

        softAssert.assertTrue(blogPage.natureRetreatInAmericaHeader.isDisplayed());

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        softAssert.assertTrue(blogPage.recentBlogPostHeader.isDisplayed());
        ReusableMethods.wait(1);

        //Recent Blog Post'ların görünürlüğünü ve aktifliğini test edin
        js.executeScript("arguments[0].click();",BlogPage.recentBlogPost1);
        String recentBlogPost1ExpectedUrl = "https://qa.easybusticket.com/blog/103/travel-trends-the-best-times-to-explore-new-places";
        String recentBlogPost1ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(recentBlogPost1ActualUrl,recentBlogPost1ExpectedUrl);

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        js.executeScript("arguments[0].click();",BlogPage.recentBlogPost2);
        String recentBlogPost2ExpectedUrl = "https://qa.easybusticket.com/blog/87/traveling-with-technology-making-your-journey-easier-with-apps-and-devices";
        String recentBlogPost2ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(recentBlogPost2ActualUrl,recentBlogPost2ExpectedUrl);

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();

        js.executeScript("arguments[0].click();",BlogPage.recentBlogPost3);
        String recentBlogPost3ExpectedUrl = "https://qa.easybusticket.com/blog/86/safety-measures-what-to-pay-attention-to-during-travel";
        String recentBlogPost3ActualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(recentBlogPost3ActualUrl,recentBlogPost3ExpectedUrl);

        ReusableMethods.wait(1);
        Driver.getDriver().navigate().back();




        softAssert.assertAll();

        Driver.closeDriver();

    }
}
