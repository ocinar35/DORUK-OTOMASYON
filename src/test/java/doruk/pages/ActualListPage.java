package doruk.pages;

import doruk.utilities.BrowserUtils;
import doruk.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ActualListPage{
    BrowserUtils browserUtils = new BrowserUtils();

    public ActualListPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[@class=\"kt-margin-b-0 kt-valign-middle kt-block-inline\"]")
    public WebElement actualMachine;

    @FindBy(xpath = "(//tr[@class=\"dx-row dx-data-row dx-column-lines\"]/td)[1]")
    public WebElement actualordRefNo;

    @FindBy(xpath = "(//tr[@class=\"dx-row dx-data-row dx-column-lines\"]/td)[2]")
    public WebElement actualordOpId;

    @FindBy(xpath = "//tr[@class=\"dx-row dx-data-row dx-column-lines\"]/td[3]")
    public WebElement amount;

    @FindBy(xpath = "//tr[@class=\"dx-row dx-data-row dx-column-lines\"]/td[4]")
    public WebElement netCycle;

    @FindBy(xpath = "(//*[contains(text(),\"Start\")])[1]")
    public WebElement startButton;

    @FindBy(xpath = "//*[.=\"Success\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//button[@class=\"swal2-confirm swal2-styled\"]")
    public WebElement okButton;

    public List<String> act = new ArrayList<>();
    public void addTheActualInfoToActualList(){
        //browserUtils.waitForVisibility(actualMachine);
        act.add(actualMachine.getText());
        browserUtils.sleep(1);
        //browserUtils.waitForVisibility(actualordRefNo);
        act.add(actualordRefNo.getText());
        browserUtils.sleep(1);
        //browserUtils.waitForVisibility(actualordOpId);
        act.add(actualordOpId.getText());
        browserUtils.sleep(1);
        //browserUtils.waitForVisibility(amount);
        act.add(amount.getText());
        browserUtils.sleep(1);
       // browserUtils.waitForVisibility(netCycle);
        act.add(netCycle.getText());
    }

}
