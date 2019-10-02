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

//    @FindBy(css = "#main > div.widget-frame.cf > div:nth-child(3) > div.post-list-frame.mobile-hidden.cf")
//    private List<WebElement> latestBettingNewsExtended;

    @FindBy(xpath = "//div[.='Latest Betting news']/following-sibling::*[1]//div[@class='h3']")
    private WebElement seeMoreButtonOnLatestBettingNews;

    @FindBy(css = ".post-brick")
    private List<WebElement> randomArtList;

    @FindBy(css = ".article-header")
    private WebElement articleHeader;

    @FindBy(css = "h1.entry-title")
    private WebElement articleTitle;

    public IndexPage(WebDriver driver, WebDriverWait wait, String url) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
        this.url = url;
        additionalArticlesLoadedAssertion = new AdditionalArticlesLoadedAssertion(driver, wait);
    }

    public void openIndexPage() {
        driver.get(url);
        waitForJStoLoad();
    }

    public void hoverTabFootball() {
        //Actions hoverMouse = new Actions(driver);
        //hoverMouse.moveToElement(tabFootball).build().perform();
        hoverOverElement(tabFootball);

    }

    public void clickPremierLeague() {
        //linkPremierLeague.click();
        waitForElementToBeClickableAndClick(linkPremierLeague);
    }

//    public int countElement(List<WebElement> list) {
//        return list.size();
//    }

    public int countElementsInLatestBettingNews() {
        return latestBettingNewsDefault.size();

        // int sizeElement = latestBettingNewsDefault.size();
        // System.out.println(sizeElement);
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
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("['h3 loading-more']")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("['h3 loading-more']")));

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    public WebElement selectRandomArticle() {
        int listSize = randomArtList.size();
        //random z zakresu
        Random ran = new Random();
        int x = ran.nextInt(listSize);
        return randomArtList.get(x);
    }

    public String getBrickArticleTitle(WebElement article) {
        return article.findElement(By.cssSelector(".h2")).getText().trim();
    }

    public void clickOnSelectedArticle(WebElement article) {
        waitForElementToBeClickableAndClick(article);
        //article.click();
        wait.until(ExpectedConditions.visibilityOf(articleHeader));
    }

//    public void clickOnRandomArticle() {
//        randomArtList.size();
//
//    }

    public String getOpenedArticleTitle() {
        return articleTitle.getText().trim() ;
    }
}
