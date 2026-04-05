package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//b[contains(text(),'Account Deleted!')]")
    WebElement accountDeletedTitle;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueBtn;

    public AccountDeletedPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean verifyDeletedTitle() {
        action.fluentWait(getDriver(), accountDeletedTitle, 10);
        return action.isDisplayed(getDriver(), accountDeletedTitle);
    }

    public HomePage clickContinueBtn() {
        action.JSClick(getDriver(), continueBtn);
        return new HomePage();
    }

}
