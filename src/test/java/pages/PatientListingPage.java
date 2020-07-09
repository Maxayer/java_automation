package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PatientListingPage extends BasePage{

    private static final String pageUrl = "http://demo.hospitalrun.io/#/patients";
    private static final PageElement h1 = new PageElement("Patient Listing H1",
            By.xpath("//h1[text()=\"Patient Listing\"]"));
    private static final PageElement megaOcticonDpd = new PageElement("Mega Octicon Drop Down",
            By.xpath("//span[@class='mega-octicon octicon-gear']"));
    private static final PageElement logOutBtn = new PageElement("Log Out Button",
            By.xpath("//a[@class='logout']"));
    private static final PageElement inventoryDpd = new PageElement("Inventory Drop Down",
            By.cssSelector("#ember716"));
    private static final PageElement newPatientBtn = new PageElement("New Patient Button",
            By.cssSelector("button[class='btn btn-primary']"), true);
    private static final PageElement nextPageBtn = new PageElement("Next Page Button",
            By.xpath("//span[@class= 'glyphicon glyphicon-chevron-right']/parent::button"), true);
    private static final PageElement billingDpd = new PageElement("Billing Drop Down",
            By.xpath("//a[text()='Billing']"), true);

    public PatientListingPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(h1);
    }

    public void logOut(){
        waitToBeVisible(megaOcticonDpd);
        click(megaOcticonDpd);
        waitToBeVisible(logOutBtn);
        click(logOutBtn);
    }
    public void clickInventoryDropDown(){
        waitToBeVisible(inventoryDpd);
        click(inventoryDpd);
    }
    public void clickBillingDropDown(){
        waitToBeVisible(billingDpd);
        click(billingDpd);
    }

    public void clickNewPatientButton(){
        waitToBeVisible(newPatientBtn);
        click(newPatientBtn);
    }

    public void clickNextPageButton(){
        waitToBeVisible(nextPageBtn);
        click(nextPageBtn);
    }

    public void goToEndOfPatientsList(){
        while(!("true".equals(getAttribute(nextPageBtn, "disabled")))){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            try{
                clickNextPageButton();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public List<WebElement> getListOfPatientsOnCurrentPage(){
         List<WebElement> patients = findAll(By.xpath("//tr"));
         patients = patients.subList(1, patients.size());
         return patients;
    }

    public WebElement getLastPatient(){
        List<WebElement> patients = getListOfPatientsOnCurrentPage();
        int index = patients.size() - 1;
        return patients.get(index);
    }

    public String[] getFullNameOfLastPatient(){
        List<WebElement> patients = getListOfPatientsOnCurrentPage();
        int index = patients.size() - 1;
        WebElement patient = getLastPatient();
        String firstName = patient.findElement(By.xpath("./td[2]")).getText();
        String latsName = patient.findElement(By.xpath("./td[3]")).getText();

        return new String [] {firstName, latsName};
    }
}
