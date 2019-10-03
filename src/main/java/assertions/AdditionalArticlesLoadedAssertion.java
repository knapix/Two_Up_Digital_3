package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MainPage;

public class AdditionalArticlesLoadedAssertion extends MainPage {

    public AdditionalArticlesLoadedAssertion(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void isAdditionalArticlesLoaded(int before, int after) {
        Assert.assertTrue(after > before, "New articles not loaded");
    }
}
