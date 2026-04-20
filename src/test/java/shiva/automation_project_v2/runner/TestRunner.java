package shiva.automation_project_v2.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * TestNG runner for Cucumber.
 * Run via testng.xml or: mvn test -Dtest=TestRunner
 */
@CucumberOptions(
    features = "classpath:features",
    glue = {
        "shiva.automation_project_v2.stepdefinitions",
        "shiva.automation_project_v2.hooks"
    },
    tags = "@foodorder",  // Only food order scenarios. Remove this line to run all features (Google + food order).
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
