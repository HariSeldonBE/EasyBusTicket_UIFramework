package tests.ahmed.US32;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class TC03 {

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
    }
}
