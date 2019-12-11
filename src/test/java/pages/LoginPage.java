package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

public class LoginPage extends SuiteManager {

    public LoginPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(id = "spree_user_email")
    private WebElement usernameField;

    @FindBy(id = "spree_user_password")
    private WebElement passwordField;

    @FindBy(css = "#new_spree_user > p:nth-child(4) > input")
    private WebElement submitButton;

    public void enterValue(WebElement field, String value) {
        field.click();
        field.clear();
        field.sendKeys(value);
    }

    public void clickButton(WebElement button) {
        button.click();
    }


    public HomePage login(String username, String password) {
        enterValue(usernameField, username);
        enterValue(passwordField, password);
        clickButton(submitButton);
        return new HomePage();
    }




}
