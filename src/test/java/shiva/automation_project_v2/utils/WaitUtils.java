package shiva.automation_project_v2.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shiva.automation_project_v2.config.TestConfig;

import java.time.Duration;

/**
 * Explicit wait helpers for stable automation.
 */
public final class WaitUtils {

    private static Duration defaultTimeout() {
        return Duration.ofSeconds(TestConfig.getExplicitWaitSeconds());
    }

    public static WebElement waitForVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, defaultTimeout())
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, defaultTimeout())
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForTitleContains(WebDriver driver, String titlePart) {
        return new WebDriverWait(driver, defaultTimeout())
                .until(ExpectedConditions.titleContains(titlePart));
    }

    public static void waitForUrlContains(WebDriver driver, String urlPart) {
        new WebDriverWait(driver, defaultTimeout())
                .until(ExpectedConditions.urlContains(urlPart));
    }
}
