package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminLoginPage {
    public AdminLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    // Admin login sayfasındaki Username Kutusu
    @FindBy(id = "username")
    public WebElement usernameBox;

    // Admin login sayfasındaki Password Kutusu
    @FindBy(id = "pass")
    public WebElement passwordBox;

    // Admin login sayfasındaki Login butonu
    @FindBy(xpath = "//button[@class='submit-btn mt-25 b-radius--capsule']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='admin12']")
    public WebElement admin12Navbar;

}
