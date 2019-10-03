import org.testng.annotations.Test;

public class AdditionalArticlesTest extends MainTest {

    @Test
    public void additionalArticlesShouldBeLoaded() {
        indexPage.openIndexPage();
        int sizeBefore = indexPage.countElementsInLatestBettingNews();
        indexPage.clickSeeMoreOnLatestBettingNews();
        int sizeAfter = indexPage.countElementsInLatestBettingNews();
        additionalArticlesLoadedAssertion.isAdditionalArticlesLoaded(sizeBefore, sizeAfter);
    }
}
