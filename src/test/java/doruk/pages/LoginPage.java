package doruk.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import doruk.utilities.ConfigurationReader;
import doruk.utilities.Driver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="userNamePlaceHolder")
    public WebElement userNameBox;

    @FindBy(id="passwordPlaceHolder")
    public WebElement passwordBox;

    @FindBy(id="ddlModel")
    public WebElement language;

    @FindBy(id="loginLabel")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"kt_header\"]/kt-topbar/div/user-account-management/div/div[2]/div/h6/span[2]")
    public WebElement hiSelenium;

    /**
     * user logs in with valid cridentials and verify user land on the home page
     */
    public void login(){
        Select languageDropdown = new Select(language);
        userNameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        languageDropdown.selectByVisibleText("English");
        loginButton.click();
        Assert.assertTrue(hiSelenium.isEnabled());
    }



}
