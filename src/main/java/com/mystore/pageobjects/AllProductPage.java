package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductPage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    WebElement productPageTitle;

    @FindBy(css = ".features_items .col-sm-4")
    WebElement productDisplay;

    @FindBy(css = "a[href*='product_details']")
    WebElement viewProductBtn;

    @FindBy(id = "search_product")
    WebElement searchProduct;

    @FindBy(id="submit_search")
    WebElement submitSearchBtn;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    WebElement searchProductTitle;

    public AllProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isProductAvailable() {
        return action.isDisplayed(getDriver(), productDisplay);
    }

    public boolean verifyProductPage() {
        return action.isDisplayed(getDriver(), productPageTitle);
    }

    public ProductDetailPage clickViewFirstProduct() {
        action.click(getDriver(), viewProductBtn);
        return new ProductDetailPage();
    }

    public void InputSearchKey(String text) {
        action.type(searchProduct, text);
    }

    public void clickSearchBtn() {
        action.click(getDriver(), submitSearchBtn);
    }

    public boolean verifySearchProduct() {
        return action.isDisplayed(getDriver(), searchProductTitle);
    }

}
