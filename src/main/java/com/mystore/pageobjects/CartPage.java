package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//h2[contains(text(),'Subscription')]")
    WebElement subscriptionTitle;
    @FindBy(id = "susbscribe_email")
    WebElement subscriptField;
    @FindBy(id = "subscribe")
    WebElement subscriptBtn;
    @FindBy(id = "success-subscribe")
    WebElement successSubMeg;
    @FindBy(id = "cart_items")
    WebElement verifyCart;

    public CartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean verifyCartPage() {
        action.fluentWait(getDriver(), verifyCart, 5);
        return action.isDisplayed(getDriver(), verifyCart);
    }

    public void inputSubField(String subEmail) {
        action.scrollByVisibilityOfElement(getDriver(), subscriptField);
        action.type(subscriptField, subEmail);
    }

    public void clickSubBtn() {
        action.click(getDriver(), subscriptBtn);
    }

    public boolean verifySuccessSub() {
        action.fluentWait(getDriver(), successSubMeg, 3);
        return action.isDisplayed(getDriver(), successSubMeg);
    }

    public boolean verifySubTitle() {
        return action.isDisplayed(getDriver(), subscriptionTitle);
    }

}
