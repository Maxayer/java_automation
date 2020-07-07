package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestItemsPage extends BasePage{

    private static final PageElement H1 = new PageElement("Items",
            By.xpath("//h1[text()=\"Items\"]"), true);
    private static final PageElement NEW_ITEM_BUTTON = new PageElement("+ new item",
            By.xpath("//button[contains(text(),'+ new item')]"));


    public TestItemsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(H1);
    }

    public void clickNewItemButton(){
        click(NEW_ITEM_BUTTON);
    }

    public List<WebElement> getListOfItems(){
        return findAll(By.xpath("//tr")).subList(1, 26);
    }

    public String getCommodityName(int index){
        return getListOfItems().get(index).findElements(By.xpath("./td")).get(1).getText();
    }


}
