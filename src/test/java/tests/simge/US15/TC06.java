package tests.simge.US15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.network.model.SubresourceWebBundleInnerResponseError;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EasyBusTicketPage;
import pages.user.SupportRequestPage;
import pages.user.UserDashBoardPage;
import pages.user.UserLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC06 {
    @Test
    public void replyBoslukHiclikNegatifTesti(){

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
                //Cevap yazılır
                supportRequestPage.text.sendKeys(" ");
                //Reply button tıklanır
                supportRequestPage.replyButton.click();
                ReusableMethods.wait(1);
                Assert.assertTrue(supportRequestPage.error.isDisplayed());
                ReusableMethods.wait(1);
                supportRequestPage.text.sendKeys("");
                supportRequestPage.replyButton.click();
                ReusableMethods.wait(1);
                Assert.assertTrue(supportRequestPage.error.isDisplayed());
                ReusableMethods.wait(1);
                Driver.closeDriver();
            }
            else Driver.closeDriver();

        }
    }
}
