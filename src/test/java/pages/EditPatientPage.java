package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditPatientPage extends BasePage{

    private static final PageElement h1 = new PageElement("Edit Patient H1",
            By.xpath("//h1[text()='Edit Patient']"), true);
    private static final PageElement generalBtn = new PageElement("General Button",
            By.xpath("//a[@href='#general']"), true);
    private static final PageElement firstNameFld = new PageElement("First Name Field",
            By.xpath("//label[text()='First Name']/following-sibling::div/input"), true);
    private static final PageElement lastNameFld = new PageElement("Last Name Field",
            By.xpath("//label[text()='Last Name']/following-sibling::div/input"), true);
    private static final PageElement middleNameFld = new PageElement("Middle Name Field",
            By.xpath("//label[text()='Middle Name']/following-sibling::div/input"), true);
    private static final PageElement updateBtn = new PageElement("Update Button",
            By.xpath("//div[@class= 'panel-footer']//button[text()='Update']"), true);
    private static final PageElement patientsDpd = new PageElement("Patients Drop Down",
            By.xpath("//a[text()='Patients']"));
    private static final PageElement visitsBtn = new PageElement("Visits Button",
            By.xpath("//a[text()='Visits']"), true);
    private static final PageElement newVisitBtn = new PageElement("New Visit Button",
            By.xpath("//button[text()='New Visit']"));

    public EditPatientPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickGeneralButton(){
        waitToBeVisible(generalBtn);
        click(generalBtn);
    }

    public void fillFirstNameField(String firstName){
        waitToBeVisible(firstNameFld);
        enterText(firstNameFld, firstName);
    }

    public void fillLastNameField(String lastName){
        waitToBeVisible(lastNameFld);
        enterText(lastNameFld, lastName);
    }

    public void fillMiddleNameField(String middleName){
        waitToBeVisible(middleNameFld);
        enterText(middleNameFld, middleName);
    }

    public void clickUpdateButton(){
        waitToBeVisible(updateBtn);
        click(updateBtn);
    }

    public void clickPatientsDropDown(){
        waitToBeVisible(patientsDpd);
        click(patientsDpd);
    }

    public void clickVisitsButton(){
        waitToBeVisible(visitsBtn);
        click(visitsBtn);
    }

    public void clickNewVisitButton(){
        waitToBeVisible(newVisitBtn);
        click(newVisitBtn);
    }
}
