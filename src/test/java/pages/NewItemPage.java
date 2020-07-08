package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class NewItemPage extends BasePage{
    private static final PageElement H1 = new PageElement("New Item",
            By.xpath("//h1[text()=\"New Item\"]"));
    private static final PageElement NAME_FIELD = new PageElement("Name",
            By.xpath("//input[contains(@id,'name-ember')]"));
    private static final PageElement TYPE_DROP_DOWN = new PageElement("Type",
            By.xpath("//select[contains(@id,'inventoryType-ember')]"));
    private static final PageElement TYPE_MEDICATION  = new PageElement("Type",
            By.xpath("//option[text()='Medication']"));
    private static final PageElement DISTRIBUTION_UNIT_DROP_DOWN  = new PageElement("Distribution unit",
            By.xpath("//select[contains(@id, 'distributionUnit-ember')]"));
    private static final PageElement PILL_DISTRIBUTION_UNIT = new PageElement("Pill",
            By.xpath("//select[contains(@id, 'distributionUnit-ember')]/option[@value=\"pill\"]"));
    private static final PageElement UNIT_DROP_DOWN = new PageElement("Unit",
            By.xpath("//select[contains(@id, 'ember') and @tabindex = '-1']"));
    private static final PageElement PILL_UNIT = new PageElement("pill",
            By.xpath("//select[contains(@id, 'ember') and @tabindex = '-1']/option[@value = 'pill']"));
    private static final PageElement QUANTITY_FIELD = new PageElement("Quantity",
            By.xpath("//div[@class = 'form-group required has-error test-inv-quantity']/input[contains(@id, 'ember')]"));
    private static final PageElement PURCHASE_COST_FIELD = new PageElement("Purchase Cost",
            By.xpath("//input[contains(@id, 'purchaseCost-ember')]"));
    private static final PageElement VENDOR_FIELD = new PageElement("Vendor",
            By.xpath("//input[contains(@id, 'vendor-ember')]"));
    private static final PageElement ADD_BUTTON = new PageElement("Add",
            By.xpath("//button[contains(@class, 'btn btn-primary on')]"));
    private static final PageElement ITEMS_DROP_DOWN = new PageElement("Items",
            By.xpath("//div[@class='category-sub-items']//a[@href='#/inventory/listing']"));



    public NewItemPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(H1);
    }

    public void fillNameField(String string){
        enterText(NAME_FIELD, string);
    }

    public void chooseType(String type){
        click(TYPE_DROP_DOWN);
        switch(type){
            case "Medication":
                click(TYPE_MEDICATION);
                break;
        }
        click(TYPE_DROP_DOWN);

    }
    public void chooseDistributionUnit(String unit){
        click(DISTRIBUTION_UNIT_DROP_DOWN);
        switch (unit){
            case "pill":
                click(PILL_DISTRIBUTION_UNIT);
                break;
        }
        click(DISTRIBUTION_UNIT_DROP_DOWN);
    }
    public void chooseUnit(String unit){
        click(UNIT_DROP_DOWN);
        switch (unit){
            case "pill":
                click(PILL_UNIT);
                break;
        }
        click(UNIT_DROP_DOWN);
    }
    public void fillQuantityField(String quantity){
        enterText(QUANTITY_FIELD, quantity);
    }
    public void fillPurchaseCostField(String purchaseCost){
        enterText(PURCHASE_COST_FIELD, purchaseCost);
    }
    public void fillVendorField(String vendor){
        enterText(VENDOR_FIELD, vendor);
    }
    public void clickAddButton(){
        click(ADD_BUTTON);
    }
    public void clickItemsDropDown(){
        click(ITEMS_DROP_DOWN);
    }


}
