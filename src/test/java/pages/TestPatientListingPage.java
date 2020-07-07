package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPatientListingPage extends BasePage{

    private static final String PAGE_URL = "http://demo.hospitalrun.io/#/patients";
    private static final PageElement H1 = new PageElement("Patient Listing",
            By.xpath("//h1[text()=\"Patient Listing\"]"));
    private static final PageElement MEGA_OCTICON = new PageElement("Mega Octicon",
            By.xpath("//span[@class='mega-octicon octicon-gear']"));
    private static final PageElement LOG_OUT_BUTTON = new PageElement("Log OUT",
            By.xpath("//a[@class='logout']"));
    private static final PageElement INVENTORY_DROPDOWN = new PageElement("Inventory",
            By.cssSelector("#ember716"));

    public TestPatientListingPage(WebDriver driver){
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
    public void clickInventoryDropDown(){
        click(INVENTORY_DROPDOWN);
    }

}
