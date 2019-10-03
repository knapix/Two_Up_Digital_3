package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MainPage;

public class CorrectArticleOpenedAssertion extends MainPage {

    public CorrectArticleOpenedAssertion(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void isCorrectArticleOpened(String brickTitle, String articleTitle) {
        Assert.assertEquals(brickTitle, articleTitle, "Wrong title of article!");
    }
}
