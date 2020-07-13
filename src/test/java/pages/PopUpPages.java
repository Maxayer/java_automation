package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpPages extends BasePage{
    private static final PageElement okBtn = new PageElement("Ok Button",
            By.xpath("//button[contains(text(),'Ok')]"));

    public PopUpPages(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(okBtn);
    }

    public void clickOkButton(){
        waitToBeClickable(okBtn);
        click(okBtn);
    }


}
