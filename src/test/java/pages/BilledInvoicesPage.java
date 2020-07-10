package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class BilledInvoicesPage extends BasePage{

    private static final String pageUrl = "http://demo.hospitalrun.io/#/invoices";
    private static final PageElement h1 = new PageElement("Billed Invoices H1",
            By.xpath("//h1[text()=\"Billed Invoices\"]"), true);
    private static final PageElement megaOcticonDpd = new PageElement("Mega Octicon Drop Down",
            By.xpath("//span[@class='mega-octicon octicon-gear']"));
    private static final PageElement logOutBtn = new PageElement("Log Out Button",
            By.xpath("//a[@class='logout']"));
    private static final PageElement newInvoicesBtn = new PageElement("New Invoices Button",
            By.xpath("//button[text()='+ new invoice']"), true);
    private static final PageElement namesOfPatients = new PageElement("A List of patients names in the Invoices",
            By.xpath("//tr/td[4]"));
    private static final PageElement invoices = new PageElement("Invoices on the page",
            By.xpath("//tr"));

    public BilledInvoicesPage(WebDriver driver){
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

    public void clickNewInvoices(){
        waitToBeVisible(newInvoicesBtn);
        click(newInvoicesBtn);
    }

    public List<String> getNamesOfPatientsOnPage(){
        List<WebElement> patients = findAll(namesOfPatients);
        return patients.stream().map((patient) -> patient.getText()).collect(Collectors.toList());

    }

    public void deleteInvoiceByPatientName(String fullName){
        List<WebElement> inv = findAll(invoices);
        inv = inv.subList(1, inv.size());

        for(WebElement invoice: inv){
            if(invoice.findElement(By.xpath("./td[4]")).getText().startsWith(fullName)){
                invoice.findElement(By.xpath(".//button[text()='Delete']")).click();
                break;
            }
        }
    }
}