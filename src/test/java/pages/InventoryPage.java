package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{
    public static final PageElement H1 = new PageElement("Request",
            By.xpath("//h1[text()=\"Requests\"]"), true);
    public static final PageElement ITEMS_BUTTON = new PageElement("Items",
            By.xpath("//div[@class='category-sub-items']//a[@href='#/inventory/listing']"));

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(H1);
    }

    public void clickItemButton(){
        click(ITEMS_BUTTON);
    }


}