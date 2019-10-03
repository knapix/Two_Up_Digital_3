package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePage extends MainPage {

    @FindBy(css = "h1.entry-title")
    private WebElement articleTitle;

    public ArticlePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public String getOpenedArticleTitle() {
        System.out.println(getTextNode(articleTitle));
        return getTextNode(articleTitle);
    }
}
