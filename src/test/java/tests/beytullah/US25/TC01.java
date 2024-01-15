package tests.beytullah.US25;

import org.testng.Assert;
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
        Assert.assertTrue(paymentHistoryDDM.linkPendingPayment.isDisplayed());
        Assert.assertTrue(paymentHistoryDDM.linkSuccessfulPayment.isDisplayed());
        Assert.assertTrue(paymentHistoryDDM.linkRejectedPayment.isDisplayed());
        Assert.assertTrue(paymentHistoryDDM.linkAllPayment.isDisplayed());
        // Tüm linklere tıklar ilgili sayfalara ulaşır
        paymentHistoryDDM.linkPendingPayment.click();
        String expectedTitle1="Easy Bus Ticket - Pending Payment";
        String actualTitle1=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle1,expectedTitle1);

        paymentHistoryDDM.linkSuccessfulPayment.click();
        String expectedTitle2="Easy Bus Ticket - Successful Payment";
        String actualTitle2=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle2,expectedTitle2);

        paymentHistoryDDM.linkRejectedPayment.click();
        String expectedTitle3="Easy Bus Ticket - Rejected Payment";
        String actualTitle3=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle3,expectedTitle3);

        paymentHistoryDDM.linkAllPayment.click();
        String expectedTitle4="Easy Bus Ticket - All Payment";
        String actualTitle4=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle4,expectedTitle4);

    }
}
