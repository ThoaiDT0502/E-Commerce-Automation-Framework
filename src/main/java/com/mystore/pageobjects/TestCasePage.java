package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//b[contains(text(),'Test Cases')]")
    WebElement testCasePageTitle;

    public TestCasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean verifyTestCasePageTitle() {
        return action.isDisplayed(getDriver(), testCasePageTitle);
    }

}
