package doruk.pages;

import doruk.utilities.BrowserUtils;
import doruk.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage{

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "IPC")
    public WebElement ipcPanel;

    @FindBy(xpath = "(//input[@class=\"dx-texteditor-input\"])[3]")
    public WebElement nameSearchBox;

    @FindBy(xpath = "(//*[@id=\"actionMenuClickEvent\"]/div)[1]/i")
    public WebElement firstAction;

    @FindBy(xpath = "//*[@id=\"epcJobFinishPopupAndSelectionButton\"]/div/a")
    public WebElement job;

    @FindBy(xpath = "(//*[@id=\"askLeaveHalfButton\"]/dx-button/div)[1]")
    public WebElement selectJob;

    @FindBy(xpath = "//*[@id=\"save\"]/dx-button/div")
    public WebElement selectFromList;

    @FindBy(xpath = "(//input[@class=\"dx-texteditor-input\"])[2]")
    public WebElement ordRefNoBox;

    @FindBy(xpath = "//div[@class=\"dx-radio-value-container\"]")
    public List<WebElement> orderReferenceNo;

    @FindBy(xpath = "(//div[@class=\"dx-template-wrapper dx-button-content\"])[3]")
    public WebElement continueButton;

    @FindBy(xpath = "(//div[@class=\"dx-template-wrapper dx-button-content\"])[3]")
    public WebElement finishButton;

    @FindBy(xpath = "//button[@class=\"swal2-confirm swal2-styled\"]")
    public WebElement confirmFinish;

    @FindBy(xpath = "//*[contains(text(),'Automation')]")
    public WebElement waitUntilFilter;

    /**
     * This method for choosing random one of Order Reference Numbers
     */
    public void setListRandomly(){
        int random = (int)(Math.random()*orderReferenceNo.size());
        orderReferenceNo.get(random).click();
    }

    /**
     * This method finishes the job.
     * Used refresh() method for enable the JOB panel
     */
    public void finishTheJob(){
        new BrowserUtils().refreshPage();
        job.click();
        finishButton.click();
        confirmFinish.click();
    }



}
