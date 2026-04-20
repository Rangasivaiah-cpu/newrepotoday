package shiva.automation_project_v2.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import shiva.automation_project_v2.config.TestConfig;
import shiva.automation_project_v2.utils.DriverUtils;

import java.time.Duration;

/**
 * Base class for test setup. Uses config.properties for browser and timeouts.
 */
public class TestBase {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver initDriver() {
        return initDriver(TestConfig.getBrowser());
    }

    public static WebDriver initDriver(String browser) {
        WebDriver webDriver = createDriver(browser);
        int implicit = TestConfig.getImplicitWaitSeconds();
        int pageLoad = TestConfig.getPageLoadTimeoutSeconds();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoad));
        DriverUtils.maximize(webDriver);
        driver.set(webDriver);
        return webDriver;
    }

    private static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fo = new FirefoxOptions();
                if (TestConfig.isHeadless()) {
                    fo.addArguments("-headless");
                }
                return new FirefoxDriver(fo);
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eo = new EdgeOptions();
                if (TestConfig.isHeadless()) {
                    eo.addArguments("--headless");
                }
                return new EdgeDriver(eo);
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--start-maximized", "--disable-notifications");
                if (TestConfig.isHeadless()) {
                    co.addArguments("--headless", "--disable-gpu", "--no-sandbox");
                }
                return new ChromeDriver(co);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
            } finally {
                driver.remove();
            }
        }
    }
}
