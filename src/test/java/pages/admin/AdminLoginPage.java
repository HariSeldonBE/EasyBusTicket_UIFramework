package pages.admin;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminLoginPage {
    public AdminLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
