package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}