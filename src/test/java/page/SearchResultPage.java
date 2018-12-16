package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;


    public SearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method  checks if page is loaded
     *
     * @return true/false
     */
    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.google.com/")
                && webDriver.getTitle().equals("Google")
                && isSearchFieldDisplayed();
    }

    /**
     * Method checks if the searchField is displayed
     *
     * @return true if the searchField is displayed
     */
    public boolean isSearchFieldDisplayed() {
        return searchField.isDisplayed();
    }

    /**
     * Method that search the specific search term
     *
     * @param searchTerm String with searchTerm ("Selenium" in this case)
     * @return ResultPage object
     */
    public HomePage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return PageFactory.initElements(webDriver, HomePage.class);
    }
}