package tests.beytullah.US25;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.PaymentHistoryDDM;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {

    @Test
    public void test() {

        PaymentHistoryDDM paymentHistoryDDM = new PaymentHistoryDDM();
        SoftAssert softAssert = new SoftAssert();

        // URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
        // Admin bilgilerini girer
        ReusableMethods.adminLoginMethod("admin14", "123123123");
        // "Pyment History" DDM yi görür
        paymentHistoryDDM.dropDownPaymentHistory.isDisplayed();
        // "Pyment History" DDM ye tıklar
        paymentHistoryDDM.dropDownPaymentHistory.click();
        // Açılan memüden "Pending History, Successful History, Rejected Payment ve All payment" linklerini görür
        ReusableMethods.wait(2);
        softAssert.assertTrue(paymentHistoryDDM.linkPendingPayment.isDisplayed(),"Pending History linki görülemedi");
        softAssert.assertTrue(paymentHistoryDDM.linkSuccessfulPayment.isDisplayed(),"Successful History linki görülemedi");
        softAssert.assertTrue(paymentHistoryDDM.linkRejectedPayment.isDisplayed(),"Rejected Payment linki görülemedi");
        softAssert.assertTrue(paymentHistoryDDM.linkAllPayment.isDisplayed(),"All payment linki görülemedi");
        // Tüm linklere tıklar ilgili sayfalara ulaşır
        paymentHistoryDDM.linkPendingPayment.click();
        String expectedTitle1="Easy Bus Ticket - Pending Payment";
        String actualTitle1=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle1,expectedTitle1,"Pending Payment sayfasına ulaşılamadı");

        paymentHistoryDDM.linkSuccessfulPayment.click();
        String expectedTitle2="Easy Bus Ticket - Successful Payment";
        String actualTitle2=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle2,expectedTitle2,"Successful Payment sayfasına ulaşılamadı");

        paymentHistoryDDM.linkRejectedPayment.click();
        String expectedTitle3="Easy Bus Ticket - Rejected Payment";
        String actualTitle3=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle3,expectedTitle3,"Rejected Payment sayfasına ulaşılamadı");

        paymentHistoryDDM.linkAllPayment.click();
        String expectedTitle4="Easy Bus Ticket - All Payment";
        String actualTitle4=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle4,expectedTitle4,"All Payment Payment sayfasına ulaşılamadı");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
