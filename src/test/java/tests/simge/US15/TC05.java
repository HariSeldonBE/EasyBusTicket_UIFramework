package tests.simge.US15;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.SupportRequestPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC05 {
    @Test
    public void replySayfasiDogrulamaTesti(){

        // 1-Browser açılır ve Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("eBTUrl"));
        // 2-Cookies kabul edilir
        EasyBusTicketPage easyBusTicketPage = new EasyBusTicketPage();
        easyBusTicketPage.cookiesButton.click();
        // 3-SignIn butonuna tıklanır
        easyBusTicketPage.signInButton.click();
        ReusableMethods.wait(2);
        UserDashBoardPage userDashBoardPage = new UserDashBoardPage();
        // 4-Geçerli Username girilir
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("userName"));
        // 5-Geçerli Password girilir
        userLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("userPass"));
        // 6-Log In butonuna tıklanır
        userLoginPage.loginButton.click();
        ReusableMethods.wait(1);

        //Support Request tıklanır
        userDashBoardPage.supportRequest.click();

        //Requests tıklanır
        SupportRequestPage supportRequestPage = new SupportRequestPage();
        userDashBoardPage.requests.click();
        ReusableMethods.wait(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);

        //Status u open olarak görünen desteklere cevap yazmak için action tıklanır
        String satirdakiStatusXpath="";
        String satirdakiActionXpath="";
        for (int i = 1; i <=supportRequestPage.lastReplies.size(); i++) {
            satirdakiStatusXpath="(//tr/td[2])["+i+"]";
            satirdakiActionXpath="(//i[@class=\"fa fa-desktop\"])["+i+"]";
            if (Driver.getDriver().findElement(By.xpath(satirdakiStatusXpath)).getText().contains("Open")){

                Driver.getDriver().findElement(By.xpath(satirdakiActionXpath)).click();
                js.executeScript("window.scrollBy(0,arguments[0])",300);
                ReusableMethods.wait(1);
                //Sayfadaki öğeler doğrulanır
                Assert.assertTrue(supportRequestPage.closeButton.isDisplayed());
                Assert.assertTrue(supportRequestPage.closeButton.isEnabled());
                Assert.assertTrue(supportRequestPage.replyButton.isDisplayed());
                Assert.assertTrue(supportRequestPage.replyButton.isEnabled());
                Assert.assertTrue(supportRequestPage.plusButton.isDisplayed());
                Assert.assertTrue(supportRequestPage.plusButton.isEnabled());
                Assert.assertTrue(supportRequestPage.attachments.isDisplayed());
                Assert.assertTrue(supportRequestPage.attachments.isEnabled());
                Assert.assertTrue(supportRequestPage.requestText.isDisplayed());
                Assert.assertTrue(supportRequestPage.requestText.isEnabled());
                //Cevap yazılır
                supportRequestPage.text.sendKeys("Merhaba, bu "+i+". talebe yanıt mesajıdır");
                //Reply button tıklanır
                supportRequestPage.replyButton.click();
                ReusableMethods.wait(1);
                Assert.assertTrue(supportRequestPage.successfullRepliedMessage.isDisplayed());
                Assert.assertEquals(supportRequestPage.replied.getText(),"Replied");
                js.executeScript("window.scrollBy(0,arguments[0])",300);
                ReusableMethods.wait(1);
                Assert.assertTrue(supportRequestPage.repliedMessage.isDisplayed());
                Driver.getDriver().get("https://qa.easybusticket.com/ticket");
                js.executeScript("window.scrollBy(0,arguments[0])",300);
                ReusableMethods.wait(1);
                for (WebElement customerReply:supportRequestPage.customerReplies) {
                    Assert.assertTrue(customerReply.isDisplayed());
                }

            }

        }
       // Driver.closeDriver();
    }
}
