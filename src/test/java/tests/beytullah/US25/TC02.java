package tests.beytullah.US25;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.PaymentHistoryDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {
    @Test
    public void test1(){


        PaymentHistoryDDM paymentHistoryDDM = new PaymentHistoryDDM();
        SoftAssert softAssert = new SoftAssert();

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Pyment History" DDM ye tıklar
        paymentHistoryDDM.dropDownPaymentHistory.click();
        //"Pending Payment" linkine tıklar
        ReusableMethods.wait(2);
        paymentHistoryDDM.linkPendingPayment.click();

        //Sağ üstte trx numarası/username  arama kutusunu,tarih arama kutusunu ve search butonunu görür
        softAssert.assertTrue(paymentHistoryDDM.boxTrxUsername.isDisplayed());
        softAssert.assertTrue(paymentHistoryDDM.boxDate.isDisplayed());
        softAssert.assertTrue(paymentHistoryDDM.buttonTrxUsername.isDisplayed());
        softAssert.assertTrue(paymentHistoryDDM.buttonDate.isDisplayed());
        //Trx numarası/username veya tarih arama kutusuna tıklar
        paymentHistoryDDM.boxTrxUsername.click();

        //Herhangi bir kullanıcının trx numarası/username bilgileri veya tarih aralığı arama kutucuklarına girilir
        String ilkKullaniciStr=paymentHistoryDDM.linkIlkKullanici.getText();
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(paymentHistoryDDM.boxTrxUsername).sendKeys(ilkKullaniciStr).perform();

        //Arama kutucuğunun yanındaki search butonuna tıklar
        paymentHistoryDDM.buttonTrxUsername.click();
        //"Easy Bus Ticket - Payments History Search" sayfasına ulaşır
        String expectedTitle1="Pending Payments Search";
        String actualTitle1=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle1.contains(expectedTitle1));


        //"Successful Payment" linkine tıklar
        paymentHistoryDDM.linkSuccessfulPayment.click();
        //Herhangi bir kullanıcının trx numarası/username bilgileri veya tarih aralığı arama kutucuklarına girilir
        actions.sendKeys(paymentHistoryDDM.boxTrxUsername).sendKeys(ilkKullaniciStr).perform();
        //Arama kutucuğunun yanındaki search butonuna tıklar
        paymentHistoryDDM.buttonTrxUsername.click();

        //"Successful Payments Search" sayfasına ulaşır
        String expectedTitle2="Successful Payments Search";
        String actualTitle2=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle2.contains(expectedTitle2),"Successful Payments Search sayfasına ulaşılamadı");

        //"Rejected Payment" linkine tıklar
        paymentHistoryDDM.linkRejectedPayment.click();
        //Herhangi bir kullanıcının trx numarası/username bilgileri veya tarih aralığı arama kutucuklarına girilir
        actions.sendKeys(paymentHistoryDDM.boxTrxUsername).sendKeys(ilkKullaniciStr).perform();
        //Arama kutucuğunun yanındaki search butonuna tıklar
        paymentHistoryDDM.buttonTrxUsername.click();

        //"Rejected Payments Search" sayfasına ulaşır
        String expectedTitle3="Rejected Payments Search";
        String actualTitle3=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle3.contains(expectedTitle3));

        //"All Payment" linkine tıklanır
        paymentHistoryDDM.linkAllPayment.click();
        //Herhangi bir kullanıcının trx numarası/username bilgileri veya tarih aralığı arama kutucuklarına girilir
        actions.sendKeys(paymentHistoryDDM.boxTrxUsername).sendKeys(ilkKullaniciStr).perform();
        //Arama kutucuğunun yanındaki search butonuna tıklar
        paymentHistoryDDM.buttonTrxUsername.click();

        //"Payments History Search" sayfasına ulaşır
        String expectedTitle4="Payments History Search";
        String actualTitle4=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle4.contains(expectedTitle4));
        //Eğer aranan kullanıcı işlem yapmışsa kullanıcının işlemlerini görüntüler

        softAssert.assertAll();
    }

}
