package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewItemPage extends BasePage{
    private static final PageElement h1 = new PageElement("New Item H1",
            By.xpath("//h1[text()=\"New Item\"]"));
    private static final PageElement nameFld = new PageElement("Name Field",
            By.xpath("//input[contains(@id,'name-ember')]"));
    private static final PageElement typeDpd = new PageElement("Type Drop Down",
            By.xpath("//select[contains(@id,'inventoryType-ember')]"));
    private static final PageElement typeMedication = new PageElement("Type Medication",
            By.xpath("//option[text()='Medication']"));
    private static final PageElement distributionUnitDpd = new PageElement("Distribution Unit Drop Down",
            By.xpath("//select[contains(@id, 'distributionUnit-ember')]"));
    private static final PageElement pillDistributionUnit = new PageElement("Pill Distribution Unit",
            By.xpath("//select[contains(@id, 'distributionUnit-ember')]/option[@value=\"pill\"]"));
    private static final PageElement unitDpd = new PageElement("Unit Drop Down",
            By.xpath("//select[contains(@id, 'ember') and @tabindex = '-1']"));
    private static final PageElement pillUnit = new PageElement("Pill Unit",
            By.xpath("//select[contains(@id, 'ember') and @tabindex = '-1']/option[@value = 'pill']"));
    private static final PageElement quantityFld = new PageElement("Quantity Field",
            By.xpath("//div[@class = 'form-group required has-error test-inv-quantity']/input[contains(@id, 'ember')]"));
    private static final PageElement purchaseCostFld = new PageElement("Purchase Cost Field",
            By.xpath("//input[contains(@id, 'purchaseCost-ember')]"));
    private static final PageElement vendorFld = new PageElement("Vendor Field",
            By.xpath("//input[contains(@id, 'vendor-ember')]"));
    private static final PageElement addBtn = new PageElement("Add Button",
            By.xpath("//button[contains(@class, 'btn btn-primary on')]"));
    private static final PageElement itemsDpd = new PageElement("Items Drop Down",
            By.xpath("//div[@class='category-sub-items']//a[@href='#/inventory/listing']"));



    public NewItemPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return isElementPresent(h1);
    }

    public void fillNameField(String string){
        waitToBeVisible(nameFld);
        enterText(nameFld, string);
    }

    public void chooseType(String type){
        waitToBeVisible(typeDpd);
        click(typeDpd);

        switch(type){
            case "Medication":
                waitToBeVisible(typeMedication);
                click(typeMedication);
                break;
        }
        click(typeDpd);

    }
    public void chooseDistributionUnit(String unit){
        waitToBeVisible(distributionUnitDpd);
        click(distributionUnitDpd);
        switch (unit){
            case "pill":
                waitToBeVisible(pillDistributionUnit);
                click(pillDistributionUnit);
                break;
        }
        click(distributionUnitDpd);
    }
    public void chooseUnit(String unit){
        waitToBeVisible(unitDpd);
        click(unitDpd);
        switch (unit){
            case "pill":
                waitToBeVisible(pillUnit);
                click(pillUnit);
                break;
        }
        click(unitDpd);
    }
    public void fillQuantityField(String quantity){
        waitToBeVisible(quantityFld);
        enterText(quantityFld, quantity);
    }
    public void fillPurchaseCostField(String purchaseCost){
        waitToBeVisible(purchaseCostFld);
        enterText(purchaseCostFld, purchaseCost);
    }
    public void fillVendorField(String vendor){
        waitToBeVisible(vendorFld);
        enterText(vendorFld, vendor);
    }
    public void clickAddButton(){
        waitToBeVisible(addBtn);
        click(addBtn);
    }
    public void clickItemsDropDown(){
        waitToBeClickable(itemsDpd);
        click(itemsDpd);
    }


}
