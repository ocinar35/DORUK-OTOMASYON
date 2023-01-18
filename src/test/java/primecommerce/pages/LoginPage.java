package primecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import primecommerce.utilities.ConfigurationReader;
import primecommerce.utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@data-label='Username or E-mail']")
    public WebElement userNameBox;

    @FindBy(id="user_pass-188")
    public WebElement passwordBox;

    @FindBy(className="userpro-button fullwidth-block")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement notRobotCheckBox;

    @FindBy(xpath = "//img[@src='/wp-content/plugins/userpro/img/default_avatar_male.jpg']")
    public WebElement userImage;

    public void login(String userName,String password) throws InterruptedException {
        userNameBox.click();
        userNameBox.sendKeys(ConfigurationReader.get(userName));
        passwordBox.click();
        passwordBox.sendKeys(ConfigurationReader.get(password));
        notRobotCheckBox.click();
        Thread.sleep(2000);
        loginButton.click();
    }

}
