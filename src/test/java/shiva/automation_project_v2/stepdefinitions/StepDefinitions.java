package shiva.automation_project_v2.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import shiva.automation_project_v2.base.TestBase;

/**
 * Step definitions for feature files.
 */
public class StepDefinitions {

    private WebDriver getDriver() {
        return TestBase.getDriver();
    }

    @Given("I open the url {string}")
    public void i_open_the_url(String url) {
        getDriver().get(url);
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expected) {
        String title = getDriver().getTitle();
        Assert.assertNotNull(title);
        Assert.assertTrue(title.contains(expected),
            "Expected title to contain '" + expected + "' but got: " + title);
    }
}
