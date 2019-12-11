package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suite.SuiteManager;
import util.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends SuiteManager {

    public SearchResultsPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(css = "#content .search-results-title")
    private WebElement searchCompleteMessage;

    @FindBy(css = "#products .product-body .info")
    private List<WebElement> productList;

    public String getSearchCompleteMessage(String searchItem) {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchCompleteMessage));
        return searchCompleteMessage.getText();
    }


    public ArrayList<String> getProductsList() {
        ArrayList<String> listOfProducts = new ArrayList<String>();
        productList.forEach(element -> listOfProducts.add(element.getText()));
        return listOfProducts;
    }
}
