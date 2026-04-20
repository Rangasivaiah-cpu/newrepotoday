package shiva.automation_project_v2.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import shiva.automation_project_v2.pages.FoodOrderPage;

/**
 * Step definitions for food order website scenarios.
 */
public class FoodOrderStepDefinitions {

    private final FoodOrderPage foodOrderPage = new FoodOrderPage();

    @Given("I open the food order website")
    public void i_open_the_food_order_website() {
        foodOrderPage.openFoodOrderSite();
    }

    @Then("the food order page title should contain {string}")
    public void the_food_order_page_title_should_contain(String expected) {
        Assert.assertTrue(foodOrderPage.isTitleContaining(expected),
            "Expected page title to contain: " + expected);
    }

    @Then("the page should show products or search")
    public void the_page_should_show_products_or_search() {
        Assert.assertTrue(foodOrderPage.hasProductsOrSearch(),
            "Page should show products or search box");
    }

    @When("I search for {string}")
    public void i_search_for(String keyword) {
        foodOrderPage.searchProduct(keyword);
    }

    @Then("search results should show {string}")
    public void search_results_should_show(String productName) {
        Assert.assertTrue(foodOrderPage.searchResultsContain(productName),
            "Search results should contain: " + productName);
    }

    @When("I add the first product to cart")
    public void i_add_the_first_product_to_cart() {
        foodOrderPage.addFirstProductToCart();
    }

    @Then("the cart should show at least {int} item")
    public void the_cart_should_show_at_least_items(int minItems) {
        int count = foodOrderPage.getCartItemsCount();
        Assert.assertTrue(count >= minItems,
            "Expected cart to have at least " + minItems + " item(s), but got: " + count);
    }

    @When("I open the cart")
    public void i_open_the_cart() {
        foodOrderPage.openCart();
    }

    @Then("I should be on the cart page")
    public void i_should_be_on_the_cart_page() {
        Assert.assertTrue(foodOrderPage.isOnCartPage(), "Should be on cart page");
    }
}
