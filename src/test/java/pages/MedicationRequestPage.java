package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MedicationRequestPage extends BasePage{
    private static final String pageUrl = "";
    private static final PageElement h1 = new PageElement("Medication Request H1",
            By.xpath("//h1[text()=\"Medication Requests\"]"));
    private static final PageElement megaOcticonBtn = new PageElement("Mega Octicon Button",
            By.xpath("//span[@class='mega-octicon octicon-gear']"));
    private static final PageElement logOutBtn = new PageElement("Log Out Button",
            By.xpath("//a[@class='logout']"));

    public MedicationRequestPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(h1);
    }
    public void logOut(){
        waitToBeVisible(megaOcticonBtn);
        click(megaOcticonBtn);
        waitToBeVisible(logOutBtn);
        click(logOutBtn);
    }

}
