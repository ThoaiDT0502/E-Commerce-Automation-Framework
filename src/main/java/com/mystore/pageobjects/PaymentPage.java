package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class PaymentPage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//input[@data-qa='name-on-card']")
    WebElement nameOnCardField;
    @FindBy(xpath = "//input[@data-qa='card-number']")
    WebElement cardNumberField;
    @FindBy(xpath = "//input[@data-qa='cvc']")
    WebElement cvcField;
    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    WebElement expiryMonthField;
    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    WebElement expiryYearField;
    @FindBy(id = "submit")
    WebElement confirmOrderBtn;
    @FindBy(xpath = "//*[@id=\"form\"]//p")
    WebElement validateOrderPlaced;
    @FindBy(xpath = "//h2[@data-qa='order-placed']")
    WebElement orderPacedTitle;
    @FindBy(css = "a.btn.btn-default.check_out")
    WebElement downloadInvoiceBtn;

    public PaymentPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void typeToCardField(String cardfield) {
        action.type(nameOnCardField, cardfield);
    }

    public void typeToNumberField(String number) {
        action.type(cardNumberField, number);
    }

    public void typeToCvcField(String cvc) {
        action.type(cvcField, cvc);
    }

    public void typeToExpirationMothField(String expMth) {
        action.type(expiryMonthField, expMth);
    }

    public void typeToExpirationYearField(String expYear) {
        action.type(expiryYearField, expYear);
    }

    public void clickConfirmOrder() {
        action.click(getDriver(), confirmOrderBtn);
    }

    public boolean validateOrderPlaced() {
        return action.isDisplayed(getDriver(), validateOrderPlaced);
    }

    public boolean verifyOrderPacedTitle() {
        action.fluentWait(getDriver(), orderPacedTitle, 5);
        return action.isDisplayed(getDriver(), orderPacedTitle);
    }

    public void clickDownloadInvoice() {
        action.JSClick(getDriver(), downloadInvoiceBtn);
    }

    public boolean isFileDownloaded(String fileName, int timeoutSeconds) {
        String downloadPath = System.getProperty("user.home") + "/Downloads";
        File dir = new File(downloadPath);

        int waitTime = 0;

        while (waitTime < timeoutSeconds) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().contains(fileName) && !file.getName().endsWith(".crdownload")) {
                        return true;
                    }
                }
            }

            try {
                Thread.sleep(1000);
                waitTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
