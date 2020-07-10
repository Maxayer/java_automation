package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletePatientPage extends BasePage {
    private static final PageElement deleteBtn = new PageElement("Delete Button",
            By.xpath("//div[@class='modal-footer']/button[text()='Delete']"), true);

    public DeletePatientPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickDeleteButton(){
        waitToBeClickable(deleteBtn);
        click(deleteBtn);
    }

}
