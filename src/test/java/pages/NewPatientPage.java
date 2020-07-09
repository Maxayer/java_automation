package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewPatientPage extends BasePage{
    private static final PageElement h1 = new PageElement("New Patient H1",
            By.xpath("//h1[text()='New Patient']"), true);
    private static final PageElement firstNameFld = new PageElement("First Name Field",
            By.xpath("//label[text()= 'First Name']/following-sibling::div/input"), true);
    private static final PageElement lastNameFld = new PageElement("Last Name Field",
            By.xpath("//label[text()= 'Last Name']/following-sibling::div/input"), true);
    private static final PageElement addBtn = new PageElement("Add Button",
            By.xpath("//button[text()='Add']"), true);
    private static final PageElement patientsDpd = new PageElement("Patients Drop Down",
            By.xpath("//a[text()='Patients']"), true);

    public NewPatientPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void fillFirstNameField(String firstName){
        waitToBeVisible(firstNameFld);
        enterText(firstNameFld, firstName);
    }

    public void fillLastNameField(String lastName){
        waitToBeVisible(lastNameFld);
        enterText(lastNameFld, lastName);
    }

    public void clickAddButton(){
        waitToBeVisible(addBtn);
        click(addBtn);
    }

    public void clickPatientsDropDown(){
        waitToBeVisible(patientsDpd);
        click(patientsDpd);
    }

}
