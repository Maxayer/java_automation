package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewPatientPage extends BasePage{
    private static final PageElement H1 = new PageElement("New Patient",
            By.xpath("//h1[text()='New Patient']"), true);
    private static final PageElement FIRST_NAME_FIELD = new PageElement("First Name",
            By.xpath("//label[text()= 'First Name']/following-sibling::div/input"), true);
    private static final PageElement LAST_NAME_FIELD = new PageElement("Last Name",
            By.xpath("//label[text()= 'Last Name']/following-sibling::div/input"), true);
    private static final PageElement ADD_BUTTON = new PageElement("Add",
            By.xpath("//button[text()='Add']"), true);
    private static final PageElement PATIENTS_DROP_DOWN = new PageElement("Patients",
            By.xpath("//a[text()='Patients']"), true);

    public NewPatientPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void fillFirstNameField(String firstName){
        enterText(FIRST_NAME_FIELD, firstName);
    }

    public void fillLastNameField(String lastName){
        enterText(LAST_NAME_FIELD, lastName);
    }

    public void clickAddButton(){
        click(ADD_BUTTON);
    }

    public void clickPatientsDropDown(){
        click(PATIENTS_DROP_DOWN);
    }

}
