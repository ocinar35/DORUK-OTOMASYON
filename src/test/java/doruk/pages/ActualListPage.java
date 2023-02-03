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

    @FindBy(xpath = "//tr[@class=\"dx-row dx-data-row dx-column-lines\"]/td")
    public List<WebElement> actlist;

    @FindBy(xpath = "(//*[contains(text(),\"Start\")])[1]")
    public WebElement startButton;

    @FindBy(xpath = "//*[.=\"Success\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//button[@class=\"swal2-confirm swal2-styled\"]")
    public WebElement okButton;

    /**
     * This method adds the actual informations to the List of String from the List of Webelement.
     */

    public List<String> act = new ArrayList<>();
    public void addTheActualInfoToActualList(){
        act.add(actualMachine.getText());
        for (int i = 0; i < 4; i++) {
            new BrowserUtils().sleep(1);
            act.add(actlist.get(i).getText());
        }

    }

}
