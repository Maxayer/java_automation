package tests.admin;

import common.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestBilledInvoicesPage;
import pages.TestLoginPage;
import pages.TestPatientListingPage;
import tests.BaseTest;

public class TestLoginTests extends BaseTest {

    @DataProvider(name = "loginRightDataProviderForHealthWorkers")
    public Object[][] getHealthWorkersCredentials(){
        return new Object[][] {{"hr.doctor@hospitalrun.io", "HRt3st12"}, {"hr.nurse@hospitalrun.io", "HRt3st12"},
                {"hr.nurse.manager@hospitalrun.io", "HRt3st12"}};
    }
    @DataProvider(name = "loginRightDataProviderForAdminWorkers")
    public Object[][] getAdminWorkersCredentials(){
        return new Object[][] {{"hr.hospital.admin@hospitalrun.io", "HRt3st12"},
                {"hr.hospital.office@hospitalrun.io", "HRt3st12"}};
    }
    @DataProvider(name = "loginRightDataProviderForSupportWorkers")
    public Object[][] getSupportWorkersCredentials(){
        return new Object [][] {{"hr.pharmacist@hospitalrun.io", "HRt3st12"}};
    }
    @DataProvider(name = "loginFalseDataProvider")
    public Object[][] getWrongCredentials(){
        return new Object[][] {{"Katya", "147852"}};
    }

    @Test(dataProvider = "loginRightDataProviderForHealthWorkers")
    public void logInAsHealthWorkerWithRightCredentials(String login, String password){
        testLoginPage.open();

        testLoginPage.fillUserNameField(login);
        testLoginPage.fillPasswordField(password);
        testLoginPage.clickSignInButton();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()=\"Patient Listing\"]")));
        Assert.assertTrue(testPatientListingPage.pageIsDisplayed());

        testPatientListingPage.logOut();
        Assert.assertTrue(testLoginPage.pageIsDisplayed());
    }

    @Test(dataProvider = "loginRightDataProviderForAdminWorkers")
    public void logInAsAdminWorkerWithRightCredentials(String login, String password){
        testLoginPage.open();
        testLoginPage.fillUserNameField(login);
        testLoginPage.fillPasswordField(password);
        testLoginPage.clickSignInButton();
        Assert.assertTrue(testBilledInvoicesPage.pageIsDisplayed());

        testBilledInvoicesPage.logOut();
        Assert.assertTrue(testBilledInvoicesPage.pageIsDisplayed());

    }
    @Test(dataProvider = "loginRightDataProviderForSupportWorkers")
    public void logInAsSupportWorkerWithRightCredentials(String login, String password){
        testLoginPage.open();
        testLoginPage.fillUserNameField(login);
        testLoginPage.fillPasswordField(password);
        testLoginPage.clickSignInButton();
        Assert.assertTrue(testMedicationRequestPage.pageIsDisplayed());

        testMedicationRequestPage.logOut();
        Assert.assertTrue(testLoginPage.pageIsDisplayed());
    }

    @Test(dataProvider = "loginFalseDataProvider")
    public void logInWithWrongCredentials(String login, String password){
        TestLoginPage testLoginPage = new TestLoginPage(driver);
        testLoginPage.open();
        testLoginPage.fillUserNameField(login);
        testLoginPage.fillPasswordField(password);
        testLoginPage.clickSignInButton();
        Assert.assertTrue(testLoginPage.pageIsDisplayed());
        Assert.assertTrue(testLoginPage.isWarningOfIncorrectLoginOrPasswordPresent());
    }
}
