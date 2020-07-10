package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteItemPage extends BasePage {
    private static final PageElement okBtn = new PageElement("Ok Button",
            By.xpath("//div[@class='modal-footer']//button[text()='Delete']"), true);

    public DeleteItemPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickOkBtn(){
        waitToBeVisible(okBtn);
        click(okBtn);
    }

}
