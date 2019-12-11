package tests;

public class IgnoreTest {

    //Selectors
    String emailInput = "#spree_user_email";
    String passwordInput = "#spree_user_password";
    String loginButton = "#new_spree_user > p:nth-child(4) > input";
    String loginMessageText = "Logged in successfully";
    String loginMessageSelector = "#content > div.alert.alert-success";
    String signoutLinkSelector = "//*[@id=\"nav-bar\"]/li[2]/a";
    String signoutMessageLocator = "#content > div.alert.alert-notice";
    String signoutMessageText = "Signed out successfully.";

}
