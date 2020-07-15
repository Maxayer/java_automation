package tests.admin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;
import common.Config;

import java.util.List;

public class LoginTests extends BaseTest {



    @DataProvider(name = "loginRightDataProviderForHealthWorkers")
    public Object[][] getHealthWorkersCredentials(){
        return new Object[][] {{Config.DOCTOR_NAME, Config.DOCTOR_PASS}, {Config.NURSE_NAME, Config.NURSE_PASS},
                {Config.NURSE_MANAGER_NAME, Config.NURSE_MANAGER_PASS}};
    }
    @DataProvider(name = "loginRightDataProviderForAdminWorkers")
    public Object[][] getAdminWorkersCredentials(){
        return new Object[][] {{Config.HOSPITAL_ADMINISTRATOR_NAME, Config.HOSPITAL_ADMINISTRATOR_PASS},
                {Config.BUSINESS_OFFICE_NAME, Config.BUSINESS_OFFICE_PASS}};
    }
    @DataProvider(name = "loginRightDataProviderForSupportWorkers")
    public Object[][] getSupportWorkersCredentials(){
        return new Object [][] {{Config.PHARMACIST_NAME, Config.PHARMACIST_PASS}};
    }
    @DataProvider(name = "loginFalseDataProvider")
    public Object[][] getWrongCredentials(){
        return new Object[][] {{Config.WRONG_NAME, Config.WRONG_PASS}};
    }

    @Test(dataProvider = "loginRightDataProviderForHealthWorkers")
    public void logInAsHealthWorkerWithRightCredentials(String login, String password){
        loginPage.open();

        loginPage.fillUserNameField(login);
        loginPage.fillPasswordField(password);
        loginPage.clickSignInButton();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()=\"Patient Listing\"]")));
        Assert.assertTrue(patientListingPage.pageIsDisplayed());

        patientListingPage.logOut();
        Assert.assertTrue(loginPage.pageIsDisplayed());
    }

    @Test(dataProvider = "loginRightDataProviderForAdminWorkers")
    public void logInAsAdminWorkerWithRightCredentials(String login, String password){
        loginPage.open();
        loginPage.fillUserNameField(login);
        loginPage.fillPasswordField(password);
        loginPage.clickSignInButton();
        Assert.assertTrue(billedInvoicesPage.pageIsDisplayed());

        billedInvoicesPage.logOut();
        Assert.assertTrue(billedInvoicesPage.pageIsDisplayed());

    }
    @Test(dataProvider = "loginRightDataProviderForSupportWorkers")
    public void logInAsSupportWorkerWithRightCredentials(String login, String password){
        loginPage.open();
        loginPage.fillUserNameField(login);
        loginPage.fillPasswordField(password);
        loginPage.clickSignInButton();
        Assert.assertTrue(medicationRequestPage.pageIsDisplayed());

        medicationRequestPage.logOut();
        Assert.assertTrue(loginPage.pageIsDisplayed());
    }

    @Test(dataProvider = "loginFalseDataProvider")
    public void logInWithWrongCredentials(String login, String password){
        loginPage.open();
        loginPage.fillUserNameField(login);
        loginPage.fillPasswordField(password);
        loginPage.clickSignInButton();
        Assert.assertTrue(loginPage.pageIsDisplayed());
        Assert.assertTrue(loginPage.isWarningOfIncorrectLoginOrPasswordPresent());
    }

}
