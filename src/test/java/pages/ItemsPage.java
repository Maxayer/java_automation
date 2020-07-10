package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<WebElement> getListOfItems()  {

        List<WebElement> items = findAll(By.xpath("//tr"));
        items = items.subList(1, items.size());
        return items;
    }

    public String getCommodityName(int index){
        return getListOfItems().get(index).findElements(By.xpath("./td")).get(1).getText();
    }

    public List<String> getNamesOfItemsOnPage(){
        return findAll(By.xpath("//tr/td[2]")).stream().map((name) -> name.getText()).collect(Collectors.toList());
    }

    public void deleteItem(String name) throws InterruptedException {
        List<WebElement> items = findAll(By.xpath("//tr"));
        items = items.subList(1, items.size());

        for(WebElement item: items){
            if(item.findElement(By.xpath("./td[2]")).getText().startsWith(name)){
                item.findElement(By.xpath(".//button[text()='Delete']")).click();
                break;
            }
        }
    }


}
