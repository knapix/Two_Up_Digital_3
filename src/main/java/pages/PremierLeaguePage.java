package pages;

import assertions.PremierLeagueAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PremierLeaguePage extends MainPage {
    public PremierLeagueAssertion premierLeagueAssertion;


    public PremierLeaguePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
        premierLeagueAssertion = new PremierLeagueAssertion(driver, wait);
    }

}
