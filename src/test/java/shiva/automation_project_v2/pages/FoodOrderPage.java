package shiva.automation_project_v2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shiva.automation_project_v2.config.TestConfig;

import java.time.Duration;
import java.util.List;

/**
 * Page object for food order site (foodorder.info uk).
 * base.url is set in config.properties (default https://www.foodorder.info).
 * If your site has different layout, update the selectors below to match.
 */
public class FoodOrderPage extends BasePage {

    // Green Kart / Selenium Practice selectors (adjust if your site differs)
    private static final By SEARCH_BOX = By.cssSelector("input.search-keyword");
    private static final By PRODUCT_NAMES = By.cssSelector("h4.product-name");
    private static final By ADD_TO_CART_BUTTONS = By.xpath("//button[text()='ADD TO CART']");
    private static final By CART_ICON = By.cssSelector("a.cart-icon");
    private static final By CART_ITEMS_COUNT = By.cssSelector(".cart-info tbody tr:nth-child(1) td strong");
    private static final By PRODUCTS_CONTAINER = By.cssSelector(".products");

    public void openFoodOrderSite() {
        String baseUrl = TestConfig.getBaseUrl();
        getDriver().get(baseUrl);
    }

    public void searchProduct(String keyword) {
        WebElement search = waitForVisible(SEARCH_BOX);
        search.clear();
        search.sendKeys(keyword);
        // Wait for results to load (Green Kart filters as you type)
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TestConfig.getExplicitWaitSeconds()));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(PRODUCT_NAMES, 0));
    }

    public boolean isTitleContaining(String text) {
        return getTitle().contains(text);
    }

    public boolean hasProductsOrSearch() {
        try {
            return waitForVisible(PRODUCTS_CONTAINER).isDisplayed() || waitForVisible(SEARCH_BOX).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean searchResultsContain(String productName) {
        List<WebElement> products = getDriver().findElements(PRODUCT_NAMES);
        for (WebElement el : products) {
            if (el.getText().toLowerCase().contains(productName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void addFirstProductToCart() {
        List<WebElement> addButtons = getDriver().findElements(ADD_TO_CART_BUTTONS);
        if (!addButtons.isEmpty()) {
            waitForClickable(ADD_TO_CART_BUTTONS).click();
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TestConfig.getExplicitWaitSeconds()));
            wait.until(d -> getCartItemsCount() >= 1);
        }
    }

    public int getCartItemsCount() {
        try {
            WebElement el = getDriver().findElement(CART_ITEMS_COUNT);
            String text = el.getText().trim();
            return Integer.parseInt(text);
        } catch (Exception e) {
            return 0;
        }
    }

    public void openCart() {
        waitForClickable(CART_ICON).click();
    }

    private static final By PROCEED_TO_CHECKOUT = By.xpath("//button[contains(text(),'Proceed') or contains(text(),'PROCEED')]");

    public boolean isOnCartPage() {
        String url = getCurrentUrl();
        if (url != null && (url.contains("cart") || url.contains("basket"))) {
            return true;
        }
        try {
            return getDriver().findElement(PROCEED_TO_CHECKOUT).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
