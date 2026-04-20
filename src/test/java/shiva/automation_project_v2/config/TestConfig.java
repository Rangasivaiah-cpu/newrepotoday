package shiva.automation_project_v2.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * Central test configuration. Loads from config.properties.
 */
public final class TestConfig {

    private static final String CONFIG_FILE = "config.properties";
    private static Properties props;

    static {
        props = new Properties();
        try (InputStream is = TestConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (is != null) {
                props.load(is);
            }
        } catch (Exception e) {
            // defaults used if file missing
        }
    }

    public static String getBrowser() {
        return get("browser", "chrome");
    }

    public static int getImplicitWaitSeconds() {
        return Integer.parseInt(get("implicit.wait", "10"));
    }

    public static int getPageLoadTimeoutSeconds() {
        return Integer.parseInt(get("page.load.timeout", "30"));
    }

    public static int getExplicitWaitSeconds() {
        return Integer.parseInt(get("explicit.wait", "15"));
    }

    public static String getBaseUrl() {
        return get("base.url", "https://www.foodorder.info");
    }

    public static boolean isScreenshotOnFailure() {
        return Boolean.parseBoolean(get("screenshot.on.failure", "true"));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless", "false"));
    }

    private static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value != null && !value.isEmpty()) {
            return value;
        }
        return props.getProperty(key, defaultValue);
    }
}
