package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PatientListingPage extends BasePage{

    private static final String PAGE_URL = "http://demo.hospitalrun.io/#/patients";
    private static final PageElement H1 = new PageElement("Patient Listing",
            By.xpath("//h1[text()=\"Patient Listing\"]"));
    private static final PageElement MEGA_OCTICON = new PageElement("Mega Octicon",
            By.xpath("//span[@class='mega-octicon octicon-gear']"));
    private static final PageElement LOG_OUT_BUTTON = new PageElement("Log OUT",
            By.xpath("//a[@class='logout']"));
    private static final PageElement INVENTORY_DROPDOWN = new PageElement("Inventory",
            By.cssSelector("#ember716"));
    private static final PageElement NEW_PATIENT_BUTTON = new PageElement("+new patient",
            By.cssSelector("button[class='btn btn-primary']"), true);
    private static final PageElement NEXT_PAGE_BUTTON =new PageElement("Chevron right",
            By.xpath("//span[@class= 'glyphicon glyphicon-chevron-right']/parent::button"), true);

    public PatientListingPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(H1);
    }

    public void logOut(){
        click(MEGA_OCTICON);
        click(LOG_OUT_BUTTON);
    }
    public void clickInventoryDropDown(){
        click(INVENTORY_DROPDOWN);
    }

    public void clickNewPatientButton(){
        click(NEW_PATIENT_BUTTON);
    }

    public void clickNextPageButton(){
        click(NEXT_PAGE_BUTTON);
    }

    public void goToEndOfPatientsList(){
        while(!("true".equals(getAttribute(NEXT_PAGE_BUTTON, "disabled")))){
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
