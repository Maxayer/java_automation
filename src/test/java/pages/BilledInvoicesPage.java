package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BilledInvoicesPage extends BasePage{

    private static final String PAGE_URL = "http://demo.hospitalrun.io/#/invoices";
    private static final PageElement H1 = new PageElement("Billed Invoices",
            By.xpath("//h1[text()=\"Billed Invoices\"]"));
    private static final PageElement MEGA_OCTICON = new PageElement("Mega Octicon",
            By.xpath("//span[@class='mega-octicon octicon-gear']"));
    private static final PageElement LOG_OUT_BUTTON = new PageElement("Log OUT",
            By.xpath("//a[@class='logout']"));

    public BilledInvoicesPage(WebDriver driver){
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
}