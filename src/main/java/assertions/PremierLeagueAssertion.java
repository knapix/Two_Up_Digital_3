package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import org.testng.Assert;


public class PremierLeagueAssertion extends MainPage {

    public PremierLeagueAssertion(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void isUserOnPremierLeaguePage() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Premier League"), "This page does not contain 'Premier League'!");
    }
}
