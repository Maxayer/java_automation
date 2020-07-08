package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditPatientPage extends BasePage{

    private static final PageElement H1 = new PageElement("Edit Patient",
            By.xpath("//h1[text()='Edit Patient']"), true);
    private static final PageElement GENERAL_BUTTON = new PageElement("General",
            By.xpath("//a[@href='#general']"), true);
    private static final PageElement FIRST_NAME_FIELD = new PageElement("First Name",
            By.xpath("//label[text()='First Name']/following-sibling::div/input"), true);
    private static final PageElement LAST_NAME_FIELD = new PageElement("Last Name",
            By.xpath("//label[text()='Last Name']/following-sibling::div/input"), true);
    private static final PageElement MIDDLE_NAME_FIELD = new PageElement("Middle Name",
            By.xpath("//label[text()='Middle Name']/following-sibling::div/input"), true);
    private static final PageElement UPDATE_BUTTON = new PageElement("Update",
            By.xpath("//div[@class= 'panel-footer']//button[text()='Update']"), true);
    private static final PageElement PATIENTS_DROP_DOWN = new PageElement("Patients",
            By.xpath("//a[text()='Patients']"));

    public EditPatientPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickGeneralButton(){
        click(GENERAL_BUTTON);
    }

    public void fillFirstNameField(String firstName){
        enterText(FIRST_NAME_FIELD, firstName);
    }

    public void fillLastNameField(String lastName){
        enterText(LAST_NAME_FIELD, lastName);
    }

    public void fillMiddleNameField(String middleName){
        enterText(MIDDLE_NAME_FIELD, middleName);
    }

    public void clickUpdateButton(){
        click(UPDATE_BUTTON);
    }

    public void clickPatientsDropDown(){
        click(PATIENTS_DROP_DOWN);
    }
}
