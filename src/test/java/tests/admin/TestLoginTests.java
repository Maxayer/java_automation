package tests.admin;

import common.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestLoginPage;
import pages.TestPatientListingPage;
import tests.BaseTest;

public class TestLoginTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        DriverFactory factory = new DriverFactory("Chrome");
        driver = factory.getDriver();
        wait = new WebDriverWait(driver, 5);
    }
    @DataProvider(name = "loginRightDataProvider")
    public Object[][] getData(){
        return new Object[][] {{"hr.doctor@hospitalrun.io", "HRt3st12"}, {"hr.nurse@hospitalrun.io", "HRt3st12"},
                {"hr.nurse.manager@hospitalrun.io", "HRt3st12"},{"hr.hospital.admin@hospitalrun.io", "HRt3st12"},
                {"hr.hospital.office@hospitalrun.io", "HRt3st12"}, {"hr.pharmacist@hospitalrun.io", "HRt3st12"}};
    }

    @Test(dataProvider = "loginRightDataProvider")
    public void logInWithRightCredentials(String login, String password){
        TestLoginPage testLoginPage = new TestLoginPage(driver);
        testLoginPage.open();
        testLoginPage.fillUserNameField(login);
        testLoginPage.fillPasswordField(password);
        TestPatientListingPage testPatientListingPage = testLoginPage.clickSignInButton();

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()=\"Patient Listing\"]")));
        Assert.assertTrue(testPatientListingPage.atPage());
    }

    @Test
    public void logInWithWrongCredentials(){
        TestLoginPage testLoginPage = new TestLoginPage(driver);
        testLoginPage.open();
        testLoginPage.fillUserNameField("Vasya");
        testLoginPage.fillPasswordField("12345");
        testLoginPage.clickSignInButton();
        Assert.assertTrue(testLoginPage.isWarningOfIncorrectLoginOrPasswordPresent());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
