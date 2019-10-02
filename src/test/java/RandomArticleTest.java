import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RandomArticleTest extends MainTest {

    @Test
    public void randomArticleTest() {
        indexPage.openIndexPage();
                try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement article = indexPage.selectRandomArticle();
        String selectedBrickTitle = indexPage.getBrickArticleTitle(article);
        indexPage.clickOnSelectedArticle(article);
        String openedArticleTitle = indexPage.getOpenedArticleTitle();
        correctArticleOpenedAssertion.isCorrectArticleOpened(selectedBrickTitle, openedArticleTitle);



    }
}
