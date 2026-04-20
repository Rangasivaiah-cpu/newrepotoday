package shiva.automation_project_v2.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import shiva.automation_project_v2.base.TestBase;
import shiva.automation_project_v2.config.TestConfig;
import shiva.automation_project_v2.utils.DriverUtils;

/**
 * Cucumber hooks: driver lifecycle and screenshot on failure.
 */
public class Hooks {

    @Before(order = 0)
    public void beforeScenario() {
        TestBase.initDriver();
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        if (TestConfig.isScreenshotOnFailure() && scenario.isFailed() && TestBase.getDriver() != null) {
            byte[] screenshot = DriverUtils.takeScreenshotBytes(TestBase.getDriver());
            if (screenshot.length > 0) {
                scenario.attach(screenshot, "image/png", scenario.getName() + "_failure");
            }
            DriverUtils.saveScreenshot(TestBase.getDriver(), scenario.getName().replaceAll("[^a-zA-Z0-9]", "_"));
        }
        TestBase.quitDriver();
    }
}
