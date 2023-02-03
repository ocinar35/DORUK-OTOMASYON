package doruk.pages;

import doruk.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ExpectedListPage{

    public ExpectedListPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[contains(text(),\"SiemensMakine\")])[2]")
    public WebElement expectedMachine;

    @FindBy(xpath = "(//div[@class=\"col\"])[6]")
    public WebElement expectedordRefNo;

    @FindBy(xpath = "(//div[@class=\"col\"])[8]")
    public WebElement expectedordOpId;

    @FindBy(xpath = "(//div[@class=\"col\"])[22]")
    public WebElement planQuantity;

    @FindBy(xpath = "(//div[@class=\"col\"])[26]")
    public WebElement speed;

    @FindBy(xpath = "(//i[@class=\"dx-icon dx-icon-close\"])[2]")
    public WebElement crossSign;

    @FindBy(xpath = "//a[@style=\"background: url(assets/media/epcMain/aktif-is-bilgisi.svg) no-repeat center center; background-size: contain;\"]")
    public WebElement activeJobInfo;

    public List<String> exp = new ArrayList<>();
    public void addTheExpectedInfoToExpectedList(){
        exp.add(expectedMachine.getText());
        exp.add(expectedordRefNo.getText());
        exp.add(expectedordOpId.getText());
        exp.add(planQuantity.getText());
        exp.add(speed.getText());
    }
}
