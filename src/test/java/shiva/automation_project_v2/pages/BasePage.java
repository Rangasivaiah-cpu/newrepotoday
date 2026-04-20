package shiva.automation_project_v2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shiva.automation_project_v2.base.TestBase;
import shiva.automation_project_v2.utils.WaitUtils;

/**
 * Base for all page objects. Provides driver, common waits, and navigation.
 */
public abstract class BasePage {

    protected WebDriver getDriver() {
        return TestBase.getDriver();
    }

    protected WebElement waitForVisible(By locator) {
        return WaitUtils.waitForVisible(getDriver(), locator);
    }

    protected WebElement waitForClickable(By locator) {
        return WaitUtils.waitForClickable(getDriver(), locator);
    }

    public void open(String url) {
        getDriver().get(url);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
