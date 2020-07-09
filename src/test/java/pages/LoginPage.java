package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private static final String pageUrl = "http://demo.hospitalrun.io/#/login";


    private static final PageElement userNameFld = new PageElement("Username Field",
            By.id("identification"), true);

    private static final PageElement passwordFld = new PageElement("Password Field",
            By.id("password"), true);
    private static final PageElement signInBtn = new PageElement("Sign In Button",
            By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
    private static final PageElement warningOfIncorrectLoginOrPassword = new PageElement("Warning Of Incorrect Login Or Password",
            By.xpath("//div[text()=\"Username or password is incorrect.\"]"));
    private static final PageElement signInDescription = new PageElement("Please Sign In Description",
            By.xpath("//h2[@class='form-signin-heading']"));

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(signInDescription);
    }

    public void open(){
        driver.get(pageUrl);
    }

    public void fillUserNameField(String login){
        waitToBeVisible(userNameFld);
        enterText(userNameFld, login);
    }

    public void fillPasswordField(String password){
        waitToBeVisible(passwordFld);
        enterText(passwordFld, password);
    }

    public void clickSignInButton(){
        waitToBeVisible(signInBtn);
        click(signInBtn);
    }
    public boolean isWarningOfIncorrectLoginOrPasswordPresent(){
        return isElementPresent(warningOfIncorrectLoginOrPassword);
    }


}
