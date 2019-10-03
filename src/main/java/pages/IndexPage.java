package pages;

import assertions.AdditionalArticlesLoadedAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class IndexPage extends MainPage {

    public AdditionalArticlesLoadedAssertion additionalArticlesLoadedAssertion;

    @FindBy(css = "[id^='ubermenu-main'] [href$='/football']")
    private WebElement tabFootball;

    @FindBy(css = "[href$='/premier-league']")
    private WebElement linkPremierLeague;

    @FindBy(xpath = "//div[.='Latest Betting news']/following-sibling::*[1]//div[contains(@class,'post-brick ')]")
    private List<WebElement> latestBettingNewsDefault;

    @FindBy(xpath = "//div[.='Latest Betting news']/following-sibling::*[1]//div[contains(@class,'post-brick ')]")
    private List<WebElement> latestBettingNewsExtended;

    @FindBy(xpath = "//div[.='Latest Betting news']/following-sibling::*[1]//div[@class='h3']")
    private WebElement seeMoreButtonOnLatestBettingNews;

    @FindBy(css = ".mobile-hidden .post-brick .h2")
    private List<WebElement> randomArtList;

    @FindBy(css = ".article-header")
    private WebElement articleHeader;


    public IndexPage(WebDriver driver, WebDriverWait wait, String url) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
        this.url = url;
    }

    public void openIndexPage() {
        driver.get(url);
        waitForJStoLoad();
    }

    public void hoverTabFootball() {
        hoverOverElement(tabFootball);
    }

    public void clickPremierLeague() {
        waitForElementToBeClickableAndClick(linkPremierLeague);
    }

    public int countElementsInLatestBettingNews() {
        return latestBettingNewsDefault.size();
    }

    public void countMoreElementsInLatestBettingNews() {
        int sizeMoreElement = latestBettingNewsExtended.size();
        System.out.println(sizeMoreElement);
    }

    public void clickSeeMoreOnLatestBettingNews() {
        int numOfElements = latestBettingNewsDefault.size();
        String xpathBettingNews = "//div[.='Latest Betting news']/following-sibling::*[1]//div[contains(@class,'post-brick ')]";
        waitForElementToBeClickableAndClick(seeMoreButtonOnLatestBettingNews);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpathBettingNews), numOfElements));
    }


    public WebElement selectRandomArticle() {
        int listSize = randomArtList.size();
        Random ran = new Random();
        int x = ran.nextInt(listSize);
        return randomArtList.get(x);
    }

    public String getBrickArticleTitle(WebElement article) {
        System.out.println(article.getText().trim().toUpperCase());
        return article.getText().trim().toUpperCase();
    }

    public void clickOnSelectedArticle(WebElement article2) {
        waitForElementToBeClickableAndClick(article2);
        wait.until(ExpectedConditions.visibilityOf(articleHeader));

    }
}
