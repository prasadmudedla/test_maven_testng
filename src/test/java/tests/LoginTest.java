package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;
import testdata.loginCredentials;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

public class LoginTest extends SuiteManager {

    public BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;

    @Test(dataProvider = "loginCredentials", dataProviderClass = loginCredentials.class)
    public void login(String loginId, String password) {

        basePage = new BasePage();
        loginPage = basePage.clickLoginButton();
        homePage = loginPage.login(loginId, password);



    }


}