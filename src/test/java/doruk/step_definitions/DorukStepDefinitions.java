package doruk.step_definitions;

import doruk.pages.*;
import doruk.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import doruk.utilities.ConfigurationReader;
import doruk.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;

public class DorukStepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ActualListPage actualListPage = new ActualListPage();
    ExpectedListPage expectedListPage = new ExpectedListPage();

    @Given("User should be on login page with")
    public void userShouldBeOnLoginPageWith() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
    }

    @When("user logs in and verify user lands on the home page")
    public void userLogsInAndVerifyUserLandsOnTheHomePage() throws InterruptedException {
        loginPage.login();
    }

    @And("user clicks the IPC menu, searches keyword on the name box and clicks first action button")
    public void userClicksTheIPCMenuSearchesKeywordOnTheNameBoxAndClicksFirstActionButton() {
        homePage.ipcPanel.click();
        homePage.nameSearchBox.sendKeys(ConfigurationReader.get("searchKey"));
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();",homePage.firstAction);
    }

    @And("user clicks the JOB and  clicks the Select from work order")
    public void userClicksTheJOBAndClicksTheSelectFromWorkOrder() {
        homePage.job.click();
        homePage.selectJob.click();
    }

    @And("user clicks the Select From List button")
    public void userClicksTheSelectFromListButton() {
        homePage.selectFromList.click();
    }

    @And("user searches keyword on the ORder Reference No box and choses random row")
    public void userSearchesKeywordOnTheORderReferenceNoBoxAndChosesRandomRow(){
        homePage.ordRefNoBox.sendKeys(ConfigurationReader.get("searchKey"));
        new BrowserUtils().waitForVisibility(homePage.waitUntilFilter);
        homePage.setListRandomly();
    }

    @And("user clicks the continue buton")
    public void userClicksTheContinueButon() {
        //homePage.waitForVisibility(homePage.continueButton);
        homePage.continueButton.click();
    }

    @And("user saves the informations on the list, clicks tha start button and verify Success message")
    public void userSavesTheInformationsOnTheListClicksThaStartButtonAndVerifySuccessMessage() {
        //homePage.waitForVisibility(actualListPage.amount);
        actualListPage.addTheActualInfoToActualList();
        //homePage.waitForVisibility(actualListPage.startButton);
        actualListPage.startButton.click();
        Assert.assertTrue(actualListPage.successMessage.isEnabled());
        actualListPage.okButton.click();
    }

    @And("user clicks the Active Job Information and saves the expected informations")
    public void userClicksTheActiveJobInformationAndSavesTheExpectedInformations() {
        //homePage.waitForVisibility(expectedListPage.activeJobInfo);
        expectedListPage.activeJobInfo.click();
        //homePage.waitForVisibility(expectedListPage.expectedordOpId);
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

    @And("user clicks job,cliks Finish the Job and confirm")
    public void userClicksJobCliksFinishTheJobAndConfirm() {
        homePage.finishTheJob();
    }

    @Then("user verifies Active Job Information is unable")
    public void userVerifiesActiveJobInformationIsUnable() {
        Assert.assertTrue(homePage.job.isEnabled());
    }


}
