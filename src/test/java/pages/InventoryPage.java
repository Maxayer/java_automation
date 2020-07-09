package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{
    public static final PageElement h1 = new PageElement("Request H1",
            By.xpath("//h1[text()=\"Requests\"]"), true);
    public static final PageElement itemsBtn = new PageElement("Items Button",
            By.xpath("//div[@class='category-sub-items']//a[@href='#/inventory/listing']"));

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(h1);
    }

    public void clickItemButton(){
        waitToBeVisible(itemsBtn);
        click(itemsBtn);
    }


}