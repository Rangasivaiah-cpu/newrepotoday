package profoodorderbasepackage;

import java.io.InputStream;
import java.util.Properties;

/**
 * Safe config: reads from profoodorder.properties (not committed) or env vars.
 * Copy profoodorder.properties.example to profoodorder.properties and set your values.
 */
public final class ProFoodOrderConfig {

    private static final String DEFAULT_URL = "https://www.food-order.net/index.php/web_orders/home/WUZNUlZO?uid=66fa54f5d8ecd";
    private static final String DEFAULT_EMAIL = "arepatiranga@gmail.com";
    private static final String DEFAULT_PASSWORD = "12345678";
    private static final String DEFAULT_POSTCODE = "EH6 6AX";
    private static final String DEFAULT_ADDRESS = "Uppal, Hyderabad, Telangana, India";

    private static Properties props;

    static {
        props = new Properties();
        try (InputStream in = ProFoodOrderConfig.class.getClassLoader().getResourceAsStream("profoodorder.properties")) {
            if (in != null) {
                props.load(in);
            }
        } catch (Exception ignored) {
            // use defaults
        }
    }

    private static String get(String key, String envKey, String defaultValue) {
        String v = props.getProperty(key);
        if (v != null && !v.isBlank()) return v.trim();
        if (envKey != null) {
            String e = System.getenv(envKey);
            if (e != null && !e.isBlank()) return e.trim();
        }
        return defaultValue != null ? defaultValue : "";
    }

    public static String getAppUrl() {
        return get("app.url", "PROFOODORDER_APP_URL", DEFAULT_URL);
    }

    public static String getTestEmail() {
        return get("test.login.email", "PROFOODORDER_TEST_EMAIL", DEFAULT_EMAIL);
    }

    public static String getTestPassword() {
        return get("test.login.password", "PROFOODORDER_TEST_PASSWORD", DEFAULT_PASSWORD);
    }

    public static String getTestPostcode() {
        return get("test.postcode", null, DEFAULT_POSTCODE);
    }

    public static String getTestAddress() {
        return get("test.address", null, DEFAULT_ADDRESS);
    }

    private ProFoodOrderConfig() {}
}
