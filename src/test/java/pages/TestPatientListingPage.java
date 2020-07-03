package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPatientListingPage {
    private WebDriver driver;

    private static final String PAGE_URL = "http://demo.hospitalrun.io/#/patients";
    private static final PageElement H1 = new PageElement("Patient Listing",
            By.xpath("//h1[text()=\"Patient Listing\"]"));

    public TestPatientListingPage(WebDriver driver){
        this.driver = driver;
    }



    public boolean atPage(){
        return driver.getCurrentUrl().contains(PAGE_URL);
    }
}
