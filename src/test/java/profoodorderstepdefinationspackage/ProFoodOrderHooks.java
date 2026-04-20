package profoodorderstepdefinationspackage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import profoodorderbasepackage.profoodorderbaseclass;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Closes the browser after each Cucumber scenario for Pro Food Order.
 * On failure, attaches screenshot to the Cucumber report and saves to target/screenshots.
 */
public class ProFoodOrderHooks {

    private static final String SCREENSHOT_DIR = "target/screenshots";
    private static final String INVALID_ADDRESS_ATTACHMENT_NAME = "Invalid postcode and address entered (for manager review)";
    private static final String INVALID_COUPON_ATTACHMENT_NAME = "Invalid coupon code - cart amount less than 25 (bug report)";

    @AfterStep(order = 1)
    public void afterStep(Scenario scenario) {
        if (profoodorderstepdefinationclass.attachInvalidAddressToCucumberNextAfterStep
                && profoodorderstepdefinationclass.invalidAddressScreenshotForCucumber != null
                && profoodorderstepdefinationclass.invalidAddressScreenshotForCucumber.length > 0) {
            scenario.attach(profoodorderstepdefinationclass.invalidAddressScreenshotForCucumber, "image/png", INVALID_ADDRESS_ATTACHMENT_NAME);
            profoodorderstepdefinationclass.invalidAddressScreenshotForCucumber = null;
            profoodorderstepdefinationclass.attachInvalidAddressToCucumberNextAfterStep = false;
        }
        if (profoodorderstepdefinationclass.attachInvalidCouponToCucumberNextAfterStep
                && profoodorderstepdefinationclass.invalidCouponScreenshotForCucumber != null
                && profoodorderstepdefinationclass.invalidCouponScreenshotForCucumber.length > 0) {
            scenario.attach(profoodorderstepdefinationclass.invalidCouponScreenshotForCucumber, "image/png", INVALID_COUPON_ATTACHMENT_NAME);
            profoodorderstepdefinationclass.invalidCouponScreenshotForCucumber = null;
            profoodorderstepdefinationclass.attachInvalidCouponToCucumberNextAfterStep = false;
        }
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed() && profoodorderbaseclass.driver != null && profoodorderbaseclass.driver instanceof TakesScreenshot) {
                try {
                    byte[] screenshot = ((TakesScreenshot) profoodorderbaseclass.driver).getScreenshotAs(OutputType.BYTES);
                    if (screenshot != null && screenshot.length > 0) {
                        scenario.attach(screenshot, "image/png", scenario.getName() + "_failure");
                        Allure.addAttachment("Failure screenshot: " + scenario.getName(), "image/png", new ByteArrayInputStream(screenshot), "png");
                        try {
                            Path dir = Paths.get(SCREENSHOT_DIR);
                            Files.createDirectories(dir);
                            String name = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_")
                                    + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".png";
                            Files.write(dir.resolve(name), screenshot);
                        } catch (Exception ignored) { }
                    }
                } catch (Throwable ignored) {
                    // Screenshot failed (e.g. browser crashed); don't fail the hook so next scenario can run
                }
            }
        } finally {
            // Always quit browser so next scenario gets a fresh one; never throw so execution continues
            try {
                profoodorderbaseclass.quitBrowser();
            } catch (Throwable ignored) {
                profoodorderbaseclass.driver = null;
            }
        }
    }
}
