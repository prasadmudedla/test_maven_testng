package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;
import suite.SuiteManager;
import testdata.loginCredentials;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends SuiteManager {

    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;
    public SearchResultsPage searchResultsPage;

    @Test(dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void login(String loginId, String password) {
        basePage = new BasePage();
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(loginId, password);
        homePage.waitForLoginMessage();
    }

    @Test
    public void searchProducts() {
        ArrayList<String> listOfProducts = new ArrayList<String>();
        String searchString = config.getProperty("searchItem");
        searchResultsPage = homePage.searchWithKeyWord(searchString);
        String message = searchResultsPage.getSearchCompleteMessage(searchString);
        Assert.assertEquals("Search results for '" + searchString + "'", message);

        listOfProducts = searchResultsPage.getProductsList();
        listOfProducts.forEach((productname) -> {
            Assert.assertTrue(productname.contains(searchString));
        });

    }



}