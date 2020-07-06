package tests;

import common.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import workflows.*;

public class BaseTest {

    protected TestLoginPage testLoginPage;
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
    protected TestPatientListingPage testPatientListingPage;
    protected TestBilledInvoicesPage testBilledInvoicesPage;
    protected TestMedicationRequestPage testMedicationRequestPage;

    public static WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    @Parameters("browser")
    public void setupTestRun(@Optional("Chrome") String browserName) {
        driver = new DriverFactory(browserName).getDriver();
        wait = new WebDriverWait(driver, 5);
        initPages();
    }

    /*
    @BeforeMethod
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

     */

    @AfterMethod
    public void turnDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initPages() {
        testLoginPage = new TestLoginPage(driver);
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
        testPatientListingPage = new TestPatientListingPage(driver);
        testBilledInvoicesPage = new TestBilledInvoicesPage(driver);
        testMedicationRequestPage = new TestMedicationRequestPage(driver);
    }
}
