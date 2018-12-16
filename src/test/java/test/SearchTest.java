package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;

public class SearchTest extends BaseTest {

    @DataProvider
    public Object[][] searchTermDataProvider() {
        return new Object[][]{
                {"selenium"},
                {"SELENIUM"},
        };
    }

    @Test(dataProvider = "searchTermDataProvider")
    public void searchTest(String searchTerm) {

        Assert.assertTrue(searchResultPage.isPageLoaded(), "Search Results Page is not loaded");
        HomePage resultPage = searchResultPage.search(searchTerm);
        Assert.assertTrue(resultPage.isPageLoaded(), "Home Page is not loaded");

        Assert.assertEquals(resultPage.getActivePaginationNumber(), 1, "Wrong pagination number is loaded");
        Assert.assertEquals(resultPage.getNumberOfSearchResults(), 10, "Search Results does not equals to 10");
        Assert.assertTrue(resultPage.isSearchTermPresent(searchTerm), "SearchTerm  not present in results");
        resultPage.goToNextPage();

        Assert.assertEquals(resultPage.getActivePaginationNumber(), 2, "Wrong pagination number is loaded");
        Assert.assertEquals(resultPage.getNumberOfSearchResults(), 10, "Search Results does not equals to 10");
        Assert.assertTrue(resultPage.isSearchTermPresent(searchTerm), "SearchTerm  not present in results");
    }

}