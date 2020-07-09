package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewInvoicePage extends BasePage{
    private static final PageElement h1 = new PageElement("New Invoice H1",
            By.cssSelector("H1"), true);
    private static final PageElement patientFld = new PageElement("Patient Field",
            By.xpath("//label[text()='Patient']/following-sibling::div//input[@dir='auto']"), true);
    private static final PageElement visitDpd = new PageElement("Visit Drop Down",
            By.xpath("//option[text()='Please select a visit']/parent::select"), true);
    private static final PageElement visitor = new PageElement("Visitor",
            By.xpath("//option[text()='7/9/2020 (Admission)']"));
    private static final PageElement invoiceReadyBtn = new PageElement("Invoice Ready Button",
            By.xpath("//button[text()= 'Invoice Ready']"));
    private static final PageElement billingDpd = new PageElement("Billing Drop Down",
            By.xpath("//a[text()='Billing']"), true);


    public NewInvoicePage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void fillPatientFld(String fullName){
        waitToBeVisible(patientFld);
        enterText(patientFld, fullName);
    }

    public void chooseVisit(){
        waitToBeVisible(visitDpd);
        click(visitDpd);
    }

    public void clickVisit(){
        waitToBeVisible(visitor);
        click(visitor);
    }
    public void clickInvoiceReadyBtn(){
        waitToBeVisible(invoiceReadyBtn);
        click(invoiceReadyBtn);
    }

    public void clickBillingDpd(){
        waitToBeVisible(billingDpd);
        click(billingDpd);
    }




}
