package pages;

import common.PageElement;
import common.driver.DriverFactory;
import jdk.nashorn.internal.runtime.regexp.joni.Warnings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPage extends BasePage{

    private static final String PAGE_URL = "http://demo.hospitalrun.io/#/login";

    private static final PageElement USERNAME_FIELD = new PageElement("Username field",
            By.xpath("//input[@id='identification']"), true);
    private static final PageElement PASSWORD_FIELD = new PageElement("Password field",
            By.xpath("//input[@id='password']"));
    private static final PageElement SIGN_IN_BUTTON = new PageElement("Sign in button",
            By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
    private static final PageElement WARNING_OF_INCORRECT_LOGIN_OR_PASSWORD = new PageElement("Warning of incorrect login or password",
            By.xpath("//div[text()=\"Username or password is incorrect.\"]"));
    private static final PageElement SIGN_IN_DESCRIPTION = new PageElement("PLEASE SIGN IN",
            By.xpath("//h2[@class='form-signin-heading']"));

    public TestLoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(SIGN_IN_DESCRIPTION);
    }

    public void open(){
        driver.get(PAGE_URL);
    }

    public void fillUserNameField(String login){
        enterText(USERNAME_FIELD, login);
    }

    public void fillPasswordField(String password){
        enterText(PASSWORD_FIELD, password);
    }

    public TestPatientListingPage clickSignInButton(){
        click(SIGN_IN_BUTTON);
        return new TestPatientListingPage(driver);
    }
    public boolean isWarningOfIncorrectLoginOrPasswordPresent(){
        return isElementPresent(WARNING_OF_INCORRECT_LOGIN_OR_PASSWORD);
    }
    public boolean atPage(){
        return driver.getCurrentUrl().equalsIgnoreCase(PAGE_URL);
    }


}
