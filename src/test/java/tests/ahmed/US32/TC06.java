package tests.ahmed.US32;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.admin.AdminDashBoardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC06 {

    //Assigned Vehicles menüsünden tüm atanmış araçları görüntüleyebilmeli, yeni ekleyebilmeli, eklediğimi düzenleyebilmeliyim
    @Test
    public void test01(){
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

        ReusableMethods.adminLoginMethod("admin13","123123123");

        ReusableMethods.wait(2);
        Driver.quitDriver();
    }
}
