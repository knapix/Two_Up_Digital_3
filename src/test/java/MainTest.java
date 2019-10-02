import assertions.AdditionalArticlesLoadedAssertion;
import assertions.CorrectArticleOpenedAssertion;
import assertions.PremierLeagueAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.IndexPage;
import pages.PremierLeaguePage;

public class MainTest {
    WebDriver driver;
    WebDriverWait wait;
    IndexPage indexPage;
    PremierLeaguePage premierLeaguePage;
    PremierLeagueAssertion premierLeagueAssertion;
    AdditionalArticlesLoadedAssertion additionalArticlesLoadedAssertion;
    CorrectArticleOpenedAssertion correctArticleOpenedAssertion;


    @BeforeTest
    @Parameters({"url"})
    public void before( String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 30);
        indexPage = new IndexPage(driver, wait, url);
        premierLeaguePage = new PremierLeaguePage(driver, wait);
        premierLeagueAssertion = new PremierLeagueAssertion(driver, wait);
        additionalArticlesLoadedAssertion = new AdditionalArticlesLoadedAssertion(driver, wait);
        correctArticleOpenedAssertion = new CorrectArticleOpenedAssertion(driver, wait);


       // indexPage.openIndexPage();

    }

//    @AfterTest
//    public void quitDriver() {
//        driver.quit();
//    }
}
