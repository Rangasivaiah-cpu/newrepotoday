package shiva.automation_project_v2.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Driver utilities: screenshots, window, etc.
 */
public final class DriverUtils {

    private static final String SCREENSHOT_DIR = "target/screenshots";

    public static byte[] takeScreenshotBytes(WebDriver driver) {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }

    public static String saveScreenshot(WebDriver driver, String prefix) {
        if (!(driver instanceof TakesScreenshot)) {
            return null;
        }
        try {
            Path dir = Paths.get(SCREENSHOT_DIR);
            Files.createDirectories(dir);
            String name = prefix + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".png";
            Path file = dir.resolve(name);
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(file, bytes);
            return file.toAbsolutePath().toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }
}
