package pages;

import common.PageElement;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewInvoicePage extends BasePage{
    private static final PageElement h1 = new PageElement("New Invoice H1",
            By.cssSelector("H1"), true);
    private static final PageElement patientFld = new PageElement("Patient Field",
            By.xpath("//label[text()='Patient']/following-sibling::div//input[@dir='auto']"), true);
    private static final PageElement visitDpd = new PageElement("Visit Drop Down",
            By.cssSelector("select[id^='visit-ember']"), true);
    private static final PageElement visitor = new PageElement("Visitor",
            By.xpath("//option[text()='7/9/2020 (Admission)']"));
    private static final PageElement invoiceReadyBtn = new PageElement("Invoice Ready Button",
            By.xpath("//button[text()= 'Invoice Ready']"));
    private static final PageElement billingDpd = new PageElement("Billing Drop Down",
            By.xpath("//a[text()='Billing']"), true);
    private static final PageElement carl = new PageElement("Carl",
            By.xpath("//strong[text()='Carl Jacob Bread']"));


    public NewInvoicePage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void fillPatientFld(String fullName) throws InterruptedException{
        waitToBeVisible(patientFld);
        enterText(patientFld, fullName);
        clickVisitDpd();
        Thread.sleep(1000);
        clickVisitDpd();
    }

    public void clickVisitDpd(){
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

    public void selectFromPatientDpd() throws InterruptedException{
        Thread.sleep(1000);
        selectFromDropDownByIndex(carl, 1);
    }

    public void selectFromVisitDpd(){
        //selectFromDropdown(find());
        selectFromDropDownByIndex(visitDpd, 1);
    }






}
