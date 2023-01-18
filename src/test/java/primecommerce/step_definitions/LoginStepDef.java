package primecommerce.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import primecommerce.pages.LoginPage;
import primecommerce.utilities.ConfigurationReader;
import primecommerce.utilities.Driver;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("User should be on login page with {string}")
    public void user_should_be_on_login_page_with(String url) {
        Driver.get().get(ConfigurationReader.get(url));

    }

    @When("user enter {string} , {string} and click the submit button")
    public void user_enter_and_click_the_submit_button(String email, String password) throws InterruptedException {
        loginPage.login(email, password);
    }

    @Then("user shoul be on the home page")
    public void user_shoul_be_on_the_home_page() {
        Assert.assertTrue(loginPage.userImage.isEnabled());
    }

    @When("user add new player and guests from Willow Pass")
    public void user_add_new_player_and_guests_from_Willow_Pass() {

    }

    @When("user starts the game")
    public void user_starts_the_game() {

    }

    @When("user finishes the game")
    public void user_finishes_the_game() {

    }

    @When("user checks the waiting list is not empty")
    public void user_checks_the_waiting_list_is_not_empty() {

    }

    @When("user remove the all players from waiting list")
    public void user_remove_the_all_players_from_waiting_list() {

    }

    @Then("user checks the waiting list is empty")
    public void user_checks_the_waiting_list_is_empty() {

    }


}
