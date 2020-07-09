package tests.admin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;
import common.Config;

public class TestLoginTests extends BaseTest {

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
        LoginPage testLoginPage = new LoginPage(driver);
        testLoginPage.open();
        testLoginPage.fillUserNameField(login);
        testLoginPage.fillPasswordField(password);
        testLoginPage.clickSignInButton();
        Assert.assertTrue(testLoginPage.pageIsDisplayed());
        Assert.assertTrue(testLoginPage.isWarningOfIncorrectLoginOrPasswordPresent());
    }
    @Test
    public void addNewMedicineItemAsDoctor(){

        loginPage.open();
        loginPage.fillUserNameField(Config.DOCTOR_NAME);
        loginPage.fillPasswordField(Config.DOCTOR_PASS);
        loginPage.clickSignInButton();
        Assert.assertTrue(patientListingPage.pageIsDisplayed());


        patientListingPage.clickInventoryDropDown();
        inventoryPage.clickItemButton();
        Assert.assertTrue(itemsPage.pageIsDisplayed());
        itemsPage.clickNewItemButton();

        Assert.assertTrue(newItemPage.pageIsDisplayed());
        newItemPage.fillNameField("AAAA");
        newItemPage.chooseType("Medication");
        newItemPage.chooseDistributionUnit("pill");
        newItemPage.chooseUnit("pill");
        newItemPage.fillQuantityField("100");
        newItemPage.fillPurchaseCostField("100");
        newItemPage.fillVendorField("Pharma");
        newItemPage.clickAddButton();

        popUpPages.clickOkButton();


        newItemPage.clickItemsDropDown();
        Assert.assertTrue(itemsPage.pageIsDisplayed());
        Assert.assertTrue(itemsPage.getCommodityName(0).equals("AAAA"));
    }

    @Test
    public void addNewPatientAsDoctor(){
        loginPage.open();
        loginPage.fillUserNameField(Config.DOCTOR_NAME);
        loginPage.fillPasswordField(Config.DOCTOR_PASS);
        loginPage.clickSignInButton();
        Assert.assertTrue(patientListingPage.pageIsDisplayed());
        patientListingPage.clickNewPatientButton();

        Assert.assertTrue(newPatientPage.pageIsDisplayed());
        String firstName = "Erl";
        String lastName = "Pie";
        newPatientPage.fillFirstNameField(firstName);
        newPatientPage.fillLastNameField(lastName);
        newPatientPage.clickAddButton();
        newPatientPage.clickPatientsDropDown();

        Assert.assertTrue(patientListingPage.pageIsDisplayed());
        patientListingPage.goToEndOfPatientsList();
        String[] patientFullName = patientListingPage.getFullNameOfLastPatient();
        Assert.assertTrue(firstName.equals(patientFullName[0]) && lastName.equals(patientFullName[1]));
        patientListingPage.getLastPatient().findElement(By.xpath(".//button[text()='Edit']")).click();

        firstName = "Carl";
        lastName = "Bread";
        String middleName = "Jacob";
        Assert.assertTrue(editPatientPage.pageIsDisplayed());
        editPatientPage.clickGeneralButton();
        editPatientPage.fillFirstNameField(firstName);
        editPatientPage.fillLastNameField(lastName);
        editPatientPage.fillMiddleNameField(middleName);
        editPatientPage.clickUpdateButton();

        editPatientPage.clickVisitsButton();
        editPatientPage.clickNewVisitButton();

        Assert.assertTrue(newVisitPage.pageIsDisplayed());
        newVisitPage.clickAddBtn();

        editPatientPage.clickPatientsDropDown();
        Assert.assertTrue(patientListingPage.pageIsDisplayed());
        patientListingPage.goToEndOfPatientsList();
        patientFullName = patientListingPage.getFullNameOfLastPatient();
        Assert.assertTrue(firstName.equals(patientFullName[0]) && lastName.equals(patientFullName[1]));

    }

    // is to be done
    @Test
    public void addNewInvoiceAsDoctor() throws InterruptedException {
        loginPage.open();
        loginPage.fillUserNameField(Config.DOCTOR_NAME);
        loginPage.fillPasswordField(Config.DOCTOR_PASS);
        loginPage.clickSignInButton();
        Assert.assertTrue(patientListingPage.pageIsDisplayed());

        patientListingPage.clickBillingDropDown();
        Assert.assertTrue(billedInvoicesPage.pageIsDisplayed());
        billedInvoicesPage.clickNewInvoices();

        Assert.assertTrue(newInvoicePage.pageIsDisplayed());

        newInvoicePage.fillPatientFld("Carl Jacob Bread");
        newInvoicePage.chooseVisit();

        Thread.sleep(3000);

        newInvoicePage.chooseVisit();

        Thread.sleep(3000);

        newInvoicePage.chooseVisit();

        newInvoicePage.clickVisit();

        newInvoicePage.clickInvoiceReadyBtn();
        newInvoicePage.clickBillingDpd();

        Assert.assertTrue(billedInvoicesPage.pageIsDisplayed());
        billedInvoicesPage.refreshPage();


    }


}
