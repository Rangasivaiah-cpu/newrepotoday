package profoodorderbasepackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class profoodorderbaseclass {

    public static WebDriver driver;

    public static void launchbrowser() throws InterruptedException {
        if (driver != null) {
            quitBrowser();
        }
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(ProFoodOrderConfig.getAppUrl());
            Thread.sleep(4000);
        } catch (Throwable t) {
            quitBrowser();
            throw t;
        }
    }

    public static void quitBrowser() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Throwable ignored) {
                // safe cleanup
            } finally {
                driver = null;
            }
        }
    }
}
