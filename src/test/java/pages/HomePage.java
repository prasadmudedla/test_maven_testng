package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suite.SuiteManager;
import util.DriverManager;

public class HomePage extends SuiteManager {

    public HomePage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(css = "#content > div.alert.alert-success")
    private WebElement successMessage;

    @FindBy(id = "keywords")
    private WebElement searchBar;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    public void waitForLoginMessage() {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }

    public SearchResultsPage searchWithKeyWord(String searchKey) {
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(searchKey);
        submitButton.click();
        return new SearchResultsPage();
    }

}
