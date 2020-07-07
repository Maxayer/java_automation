package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpPages extends BasePage{
    private static final PageElement OK_BUTTON = new PageElement("Ok",
            By.xpath("//button[contains(text(),'Ok')]"));

    public PopUpPages(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(OK_BUTTON);
    }

    public void clickOkButton(){
        click(OK_BUTTON);
    }


}
