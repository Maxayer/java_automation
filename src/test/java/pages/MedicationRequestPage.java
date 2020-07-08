package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MedicationRequestPage extends BasePage{
    private static final String PAGE_URL = "";
    private static final PageElement H1 = new PageElement("Medication Request",
            By.xpath("//h1[text()=\"Medication Requests\"]"));
    private static final PageElement MEGA_OCTICON = new PageElement("Mega Octicon",
            By.xpath("//span[@class='mega-octicon octicon-gear']"));
    private static final PageElement LOG_OUT_BUTTON = new PageElement("Log OUT",
            By.xpath("//a[@class='logout']"));

    public MedicationRequestPage(WebDriver driver){
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
