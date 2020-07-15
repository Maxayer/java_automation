package tests;

import common.Config;
import common.Utils;
import common.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import workflows.*;

public class BaseTest {

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected UserPage userPage;
    protected AddNewUserPage addNewUserPage;
    protected AdminWorkflow adminWorkflow;
    protected ViewUserPage viewUserPage;
    protected AddNewBusPage addNewBusPage;
    protected AddRoutePage addRoutePage;
    protected AddSeasonPage addSeasonPage;
    protected AddStopPage addStopPage;
    protected AddSignPage addSignPage;
    protected PatientListingPage patientListingPage;
    protected BilledInvoicesPage billedInvoicesPage;
    protected MedicationRequestPage medicationRequestPage;
    protected InventoryPage inventoryPage;
    protected ItemsPage itemsPage;
    protected NewItemPage newItemPage;
    protected PopUpPages popUpPages;
    protected NewPatientPage newPatientPage;
    protected EditPatientPage editPatientPage;
    protected NewInvoicePage newInvoicePage;
    protected NewVisitPage newVisitPage;
    protected DeleteInvoicePage deleteInvoicePage;
    protected DeleteItemPage deleteItemPage;
    protected DeletePatientPage deletePatientPage;

    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    @Parameters("browser")
    public void setupTestRun(@Optional("Chrome") String browserName) {
        driver = new DriverFactory(browserName).getDriver();
        wait = new WebDriverWait(driver, 5);
        initPages();
    }


    @BeforeMethod(enabled = false)
    public void logout() {
        if (dashboardPage.isAlertPresent()) {
            dashboardPage.handleAlert();
        }
        if (dashboardPage.isServerInternalError()) {
            driver.get(Config.BASE_URL);
        }
        try {
            dashboardPage.isLoggedIn();
        } catch (org.openqa.selenium.WebDriverException e) {
            Utils.sleep(3000);
            dashboardPage.isLoggedIn();
        }
    }



    @AfterMethod()
    public void turnDown() {

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }




    private void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        userPage = new UserPage(driver);
        addNewUserPage = new AddNewUserPage(driver);
        adminWorkflow = new AdminWorkflow(driver);
        viewUserPage = new ViewUserPage(driver);
        addNewBusPage = new AddNewBusPage(driver);
        addRoutePage = new AddRoutePage(driver);
        addSeasonPage = new AddSeasonPage(driver);
        addStopPage = new AddStopPage(driver);
        addSignPage = new AddSignPage(driver);
        patientListingPage = new PatientListingPage(driver);
        billedInvoicesPage = new BilledInvoicesPage(driver);
        medicationRequestPage = new MedicationRequestPage(driver);
        inventoryPage = new InventoryPage(driver);
        itemsPage = new ItemsPage(driver);
        newItemPage = new NewItemPage(driver);
        popUpPages = new PopUpPages(driver);
        newPatientPage = new NewPatientPage(driver);
        editPatientPage = new EditPatientPage(driver);
        newInvoicePage = new NewInvoicePage(driver);
        newVisitPage = new NewVisitPage(driver);
        deleteInvoicePage = new DeleteInvoicePage(driver);
        deleteItemPage = new DeleteItemPage(driver);
        deletePatientPage = new DeletePatientPage(driver);
    }
}
