import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RandomArticleTest extends MainTest {

    @Test
    public void randomArticleTest() {
        indexPage.openIndexPage();
        WebElement article = indexPage.selectRandomArticle();
        String selectedBrickTitle = indexPage.getBrickArticleTitle(article);
        indexPage.clickOnSelectedArticle(article);
        String openedArticleTitle = articlePage.getOpenedArticleTitle();
        correctArticleOpenedAssertion.isCorrectArticleOpened(selectedBrickTitle, openedArticleTitle);
    }
}
