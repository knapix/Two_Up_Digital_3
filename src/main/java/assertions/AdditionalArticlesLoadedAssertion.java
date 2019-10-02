package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.MainPage;

import java.util.List;


public class AdditionalArticlesLoadedAssertion extends MainPage {

//    @FindBy(xpath = "//div[.='Latest Betting news']/following-sibling::*[1]//div[contains(@class,'post-brick ')]")
//    private List<WebElement> latestBettingNewsSeeMore;


    public AdditionalArticlesLoadedAssertion(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);

    }

    public void isAdditionalArticlesLoaded(int before, int after) {
        Assert.assertTrue(after > before, "New articles not loaded");
    }
}
