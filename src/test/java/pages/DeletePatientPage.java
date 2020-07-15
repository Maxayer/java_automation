package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletePatientPage extends BasePage {
    private static final PageElement deleteBtn = new PageElement("Delete Button",
            By.cssSelector("div.modal-footer>button:nth-child(2)"), true);

    public DeletePatientPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickDeleteButton() throws InterruptedException {
        waitToBeClickable(deleteBtn);
        click(deleteBtn);
        Thread.sleep(2000);
    }

}
