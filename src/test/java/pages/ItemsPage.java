package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemsPage extends BasePage{

    private static final PageElement h1 = new PageElement("Items H1",
            By.xpath("//h1[text()=\"Items\"]"), true);
    private static final PageElement newItemBtn = new PageElement("New Item Button",
            By.xpath("//button[contains(text(),'+ new item')]"));


    public ItemsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(h1);
    }

    public void clickNewItemButton(){
        waitToBeVisible(newItemBtn);
        click(newItemBtn);
    }

    public List<WebElement> getListOfItems(){
        return findAll(By.xpath("//tr")).subList(1, 26);
    }

    public String getCommodityName(int index){
        return getListOfItems().get(index).findElements(By.xpath("./td")).get(1).getText();
    }


}
