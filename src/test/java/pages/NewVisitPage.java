package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewVisitPage extends BasePage{
    private static final PageElement h1 = new PageElement("New Visit H1",
            By.xpath("//h1[text()='New Visit']"), true);
    private static final PageElement addBtn = new PageElement("Add Button",
            By.xpath("//button[text()='Add']"), true);

    public NewVisitPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickAddBtn(){
        waitToBeVisible(addBtn);
        click(addBtn);
    }
}
