package shiva.automation_project_v2.pages;

import org.openqa.selenium.By;

/**
 * Page object for Google home/search. Extend with more actions as needed.
 */
public class GooglePage extends BasePage {

    private static final String URL = "https://www.google.com";
    private static final By SEARCH_BOX = By.name("q");

    public void open() {
        open(URL);
    }

    public void search(String query) {
        waitForVisible(SEARCH_BOX).sendKeys(query);
        waitForClickable(SEARCH_BOX).submit();
    }

    public boolean isTitleContaining(String text) {
        return getTitle().contains(text);
    }
}
