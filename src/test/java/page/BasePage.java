package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for all pages
 */

public abstract class BasePage {

    WebDriver webDriver;

    /**
     * Method check if the page with special url is loaded
     *
     * @param url for current page
     */
    public void waitPageOpen(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.urlContains(url));
    }
}
