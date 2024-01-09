package pages.admin;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashBoardPage {
    public AdminDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
