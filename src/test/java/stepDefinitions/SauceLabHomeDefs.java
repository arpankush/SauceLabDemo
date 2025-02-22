package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.SauceLabHomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SauceLabHomeDefs {

    SauceLabHomePage sauceLabHomePage = new SauceLabHomePage();

    public SauceLabHomeDefs() throws IOException {
    }

    @Given("I open the website")
    public void i_open_the_website() {
        sauceLabHomePage.i_open_the_website();
    }
    @When("I login with the UserID {string} and Password {string}")
    public void i_login_with_the_user_id_and_password(String string, String string2) {
        sauceLabHomePage.i_login_with_the_user_id_and_password(string, string2);
    }
    @Then("I validate the login is successful")
    public void i_validate_the_login_is_successful() {
        sauceLabHomePage.i_validate_the_login_is_successful();
    }
    @Then("I add {string} to the cart")
    public void i_add_to_the_cart(String string) throws InterruptedException {
        sauceLabHomePage.i_add_to_the_cart(string);
    }
    @Then("I go to the cart")
    public void i_go_to_the_cart() throws InterruptedException {
        sauceLabHomePage.i_go_to_the_cart();
    }
    @Then("I checkout with items in the cart")
    public void i_checkout_with_items_in_the_cart() throws InterruptedException {
        sauceLabHomePage.i_checkout_with_items_in_the_cart();
    }
    @Then("I verify {string} in the cart")
    public void i_verify_in_the_cart(String string) throws InterruptedException {
        sauceLabHomePage.i_verify_in_the_cart(string);
    }
    @Then("I remove a item in the cart")
    public void i_remove_a_item_in_the_cart() throws InterruptedException {
        sauceLabHomePage.i_remove_a_item_in_the_cart();
    }
    @Then("I go back continue shopping")
    public void i_go_back_continue_shopping() throws InterruptedException {
        sauceLabHomePage.i_go_back_continue_shopping();
    }
    @Then("I check the sort")
    public void i_check_the_sort() throws InterruptedException {
        sauceLabHomePage.i_check_the_sort();
    }
    @Then("I quit my browser")
    public void i_quit_my_browser() throws InterruptedException {
        sauceLabHomePage.i_quit_my_browser();
    }
}
