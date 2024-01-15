package tests.beytullah.US25;

import org.testng.Assert;
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
        Assert.assertTrue(paymentHistoryDDM.boxTrxUsername.isDisplayed());
        Assert.assertTrue(paymentHistoryDDM.boxDate.isDisplayed());
        Assert.assertTrue(paymentHistoryDDM.buttonTrxUsername.isDisplayed());
        Assert.assertTrue(paymentHistoryDDM.buttonDate.isDisplayed());
        //Trx numarası/username veya tarih arama kutusuna tıklar
        paymentHistoryDDM.boxTrxUsername.click();

        //Herhangi bir kullanıcının trx numarası/username bilgileri veya tarih aralığı arama kutucuklarına girilir
        //Arama kutucuğunun yanındaki search butonuna tıklar
        //"Easy Bus Ticket - Payments History Search" sayfasına ulaşır
        //Eğer aranan kullanıcı işlem yapmışsa kullanıcının işlemlerini görüntüler
        //"Successful Payment" linkine tıklar
        //Herhangi bir kullanıcının trx numarası/username bilgileri veya tarih aralığı arama kutucuklarına girilir
        //Arama kutucuğunun yanındaki search butonuna tıklar
        //Eğer aranan kullanıcı işlem yapmışsa kullanıcının işlemlerini görüntüler
        //"Rejected Payment" linkine tıklar
        //Herhangi bir kullanıcının trx numarası/username bilgileri veya tarih aralığı arama kutucuklarına girilir
        //Arama kutucuğunun yanındaki search butonuna tıklar
        //Eğer aranan kullanıcı işlem yapmışsa kullanıcının işlemlerini görüntüler
        //"All Payment" linkine tıklanır
        //Herhangi bir kullanıcının trx numarası/username bilgileri veya tarih aralığı arama kutucuklarına girilir
        //Arama kutucuğunun yanındaki search butonuna tıklar
        //Eğer aranan kullanıcı işlem yapmışsa kullanıcının işlemlerini görüntüler
    }
}
