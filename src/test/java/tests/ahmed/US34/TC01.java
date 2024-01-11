package tests.ahmed.US34;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01 {

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("eBTAdminUrl"));
    }
}
