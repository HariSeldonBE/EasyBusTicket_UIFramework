package tests.simge.US15;

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

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TC04 {
    @Test
    public void requestsSayfasiDogrulamaTesti(){

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
        //Sayfanın açıldığı doğrulanır
        Assert.assertTrue(supportRequestPage.statusOpen.isDisplayed());
        //Destek talep tablosu görüntülenir
        Assert.assertFalse(supportRequestPage.requestTable.isEmpty());
        Assert.assertFalse(supportRequestPage.tablePriority.isEmpty());
        //Action butonunun görünür ve aktif olduğu doğrulanır
        for (WebElement action:supportRequestPage.actionButton) {
            Assert.assertTrue(action.isDisplayed());
            Assert.assertTrue(action.isEnabled());
        }
       //New Ticket butonunun görünür ve aktif olduğu doğrulanır
        Assert.assertTrue(supportRequestPage.newTicketButton.isDisplayed());
        Assert.assertTrue(supportRequestPage.newTicketButton.isEnabled());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        //Subject başlıkları görüntülenir ve aktif olduğu doğrulanır
        for (WebElement subject:supportRequestPage.subjectList) {
            Assert.assertTrue(subject.isDisplayed());
            Assert.assertTrue(subject.isEnabled());
        }
       //Status u open olarak görünen desteklere cevap yazmak için action tıklanır ve doğru talebin reply sayfasının açıldığı doğrulanır
         String satirdakiStatusXpath="";
         String satirdakiActionXpath="";
        for (int i = 1; i <=supportRequestPage.lastReplies.size()/2; i++) {
        satirdakiStatusXpath="(//tr/td[2])["+i+"]";
        satirdakiActionXpath="(//i[@class=\"fa fa-desktop\"])["+i+"]";
        if (Driver.getDriver().findElement(By.xpath(satirdakiStatusXpath)).getText().contains("Open")){
            String expected =supportRequestPage.subjectList.get(i-1).getText();
            Driver.getDriver().findElement(By.xpath(satirdakiActionXpath)).click();
            ReusableMethods.wait(2);
            String cardTitleKontrol = supportRequestPage.cardTitle.getText().replace("Open ","");
            Assert.assertEquals(cardTitleKontrol,expected);
            ReusableMethods.wait(1);
            Driver.getDriver().get("https://qa.easybusticket.com/ticket");
            js.executeScript("window.scrollBy(0,arguments[0])",500);
            ReusableMethods.wait(1);

        }


            ReusableMethods.wait(1);

        }
        js.executeScript("window.scrollBy(0,arguments[0])",500);
        ReusableMethods.wait(1);
        for (int i = supportRequestPage.lastReplies.size()/2; i <supportRequestPage.lastReplies.size()/2; i++) {
            satirdakiStatusXpath="(//tr/td[2])["+i+"]";
            satirdakiActionXpath="(//i[@class=\"fa fa-desktop\"])["+i+"]";
            if (Driver.getDriver().findElement(By.xpath(satirdakiStatusXpath)).getText().contains("Open")){
                String expected =supportRequestPage.subjectList.get(i-1).getText();
                Driver.getDriver().findElement(By.xpath(satirdakiActionXpath)).click();
                ReusableMethods.wait(2);
                String cardTitleKontrol = supportRequestPage.cardTitle.getText().replace("Open ","");
                Assert.assertEquals(cardTitleKontrol,expected);
                ReusableMethods.wait(1);
                Driver.getDriver().get("https://qa.easybusticket.com/ticket");
                js.executeScript("window.scrollBy(0,arguments[0])",500);
                ReusableMethods.wait(1);

            }


            ReusableMethods.wait(1);

        }
       Driver.closeDriver();
    }
}
