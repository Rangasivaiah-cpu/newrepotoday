package profoodorderrunnerpackage;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(
        features = "src/test/resources/features/food_order_login.feature",
        glue = "profoodorderstepdefinationspackage",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber-login.json",
                "junit:target/cucumber-reports/cucumber-login.xml"
        },
        monochrome = true
)
public class profoodorderrunnerclass extends AbstractTestNGCucumberTests {
    // No extra code needed; TestNG + Cucumber integration handled by AbstractTestNGCucumberTests
}
