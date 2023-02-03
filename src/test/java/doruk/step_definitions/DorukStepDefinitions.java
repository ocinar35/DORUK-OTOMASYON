package doruk.step_definitions;

import doruk.pages.*;
import doruk.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import doruk.utilities.ConfigurationReader;
import doruk.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class DorukStepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ActualListPage actualListPage = new ActualListPage();
    ExpectedListPage expectedListPage = new ExpectedListPage();
    BrowserUtils browserUtils = new BrowserUtils();

    @Given("User should be lands on login page with")
    public void userShouldBeLandsOnLoginPageWith() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
    }

    @When("user logs in and verify user lands on the home page")
    public void userLogsInAndVerifyUserLandsOnTheHomePage() throws InterruptedException {
        loginPage.login();
    }

    @And("user clicks the IPC menu, searches keyword on the name box and clicks first action button")
    public void userClicksTheIPCMenuSearchesKeywordOnTheNameBoxAndClicksFirstActionButton() {
        browserUtils.waitForClickablility(homePage.ipcPanel, 3);
        homePage.ipcPanel.click();
        new BrowserUtils().waitForClickablility(homePage.nameSearchBox, 3);
        homePage.nameSearchBox.sendKeys(ConfigurationReader.get("searchKey"));
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();",homePage.firstAction);
    }

    @And("user clicks the JOB and  clicks the Select from work order")
    public void userClicksTheJOBAndClicksTheSelectFromWorkOrder() {
        browserUtils.waitForClickablility(homePage.job, 3);
        homePage.job.click();
        browserUtils.waitForClickablility(homePage.selectJob, 3);
        homePage.selectJob.click();
    }

    @And("user clicks the Select From List button")
    public void userClicksTheSelectFromListButton() {
        homePage.selectFromList.click();
    }

    @And("user searches keyword on the order reference no box and chooses random row")
    public void userSearchesKeywordOnTheOrderReferenceNoBoxAndChoosesRandomRow() {
        new BrowserUtils().waitForClickablility(homePage.ordRefNoBox, 3);
        homePage.ordRefNoBox.sendKeys(ConfigurationReader.get("searchKey"));
        new BrowserUtils().waitForVisibility(homePage.waitUntilFilter);
        homePage.setListRandomly();
    }

    @And("user clicks the continue button")
    public void userClicksTheContinueButton() {
        browserUtils.waitForClickablility(homePage.continueButton,3);
        homePage.continueButton.click();
    }

    @And("user saves the informations on the list, clicks tha start button and verify Success message")
    public void userSavesTheInformationsOnTheListClicksThaStartButtonAndVerifySuccessMessage() {
        actualListPage.addTheActualInfoToActualList();
        browserUtils.waitForClickablility(actualListPage.startButton,3);
        actualListPage.startButton.click();
        Assert.assertTrue(actualListPage.successMessage.isEnabled());
        actualListPage.okButton.click();
    }

    @And("user clicks the active job information and saves the expected informations")
    public void userClicksTheActiveJobInformationAndSavesTheExpectedInformations() {
        browserUtils.waitForClickablility(expectedListPage.activeJobInfo,3);
        expectedListPage.activeJobInfo.click();
        expectedListPage.addTheExpectedInfoToExpectedList();
    }

    @And("user verifies actual and expected informations are equal")
    public void userVerifiesActualAndExpectedInformationsAreEqual() {
        int i = 0;
        for (String each : actualListPage.act) {
            Assert.assertTrue(each.contains(expectedListPage.exp.get(i++).substring(0,each.length())));
        }
        System.out.println(actualListPage.act);
        System.out.println(expectedListPage.exp);
    }

    @And("user clicks the X button")
    public void userClicksTheXButton() {
        expectedListPage.crossSign.click();
    }

    @And("user clicks job,clicks Finish the Job and confirm")
    public void userClicksJobClicksFinishTheJobAndConfirm() {
        homePage.finishTheJob();
    }

    @Then("user verifies Active Job Information is unable")
    public void userVerifiesActiveJobInformationIsUnable() {
        Assert.assertTrue(homePage.job.isEnabled());
    }



}
