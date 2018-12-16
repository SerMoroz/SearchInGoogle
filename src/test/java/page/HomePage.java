package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Search using xpath on Google Home Page
 */

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@class='pn']")
    private WebElement nextButton;

    @FindBy(xpath = "//tr/td[@class='cur']")
    private WebElement pageNumber;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitPageOpen("search?source");
    }

    /**
     * +
     * Method to check if page is loaded
     *
     * @return true/false
     */
    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().contains("search?source")
                && webDriver.getTitle().contains("Google");
    }

    /**
     * Method to check number of items with searchTerm
     *
     * @return
     */
    public int getNumberOfSearchResults() {
        return searchResults.size();
    }

    /**
     * Checking  if search term is present in the  each result's item
     *
     * @param searchTerm - String with searchTerm
     * @return true/false
     */
    public boolean isSearchTermPresent(String searchTerm) {
        for (WebElement element : searchResults) {
            String elementText = element.getText();
            if (!elementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method which help navigate to the next page
     */
    public void goToNextPage() {
        nextButton.click();
    }

    /**
     * Method returns the page number
     *
     * @return
     */
    public int getActivePaginationNumber() {
        return Integer.parseInt(pageNumber.getText());
    }
}