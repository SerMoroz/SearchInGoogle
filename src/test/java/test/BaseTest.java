package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.HomePage;
import page.SearchResultPage;

public class BaseTest {

    private WebDriver webDriver;
    public HomePage homePage;
    public SearchResultPage searchResultPage;

    @Parameters({"browserName"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName) {
        if (browserName.toLowerCase().equals("chrome")) {
            webDriver = new ChromeDriver();

        }

        if (browserName.toLowerCase().equals("firefox")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new FirefoxDriver();
        } else {
            try {
                throw new Exception("Browser name " + browserName + " is not supported");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        webDriver.navigate().to("https://www.google.com");
        searchResultPage = PageFactory.initElements(webDriver, SearchResultPage.class);
    }

    @AfterMethod
    public void afterMethod() {

        webDriver.close();
    }
}