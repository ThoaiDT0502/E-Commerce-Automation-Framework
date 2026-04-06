package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
    WebElement contactUsTitle;

    @FindBy(xpath = "//div[contains(text(),'Success! Your details have been submitted successfully.')]")
    WebElement submittedMsg;

    @FindBy(xpath = "//input[@data-qa='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@data-qa='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@data-qa='subject']")
    WebElement subjectField;

    @FindBy(xpath = "//textarea[@data-qa='message']")
    WebElement messageField;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadFileBtn;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    WebElement submitBtn;

    public ContactUsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean verifyContactUsPage() {
        return action.isDisplayed(getDriver(), contactUsTitle);
    }

    public void fillForm(String name, String email, String subject, String msg) {
        action.type(nameField, name);
        action.type(emailField, email);
        action.type(subjectField, subject);
        action.type(messageField, msg);
    }

    public void uploadFile(String relativePath) {
        String fullPath = System.getProperty("user.dir") + "/" + relativePath;
        uploadFileBtn.sendKeys(fullPath);
    }

    public void clickSubmitBtn() {
        action.click(getDriver(), submitBtn);
    }

    public boolean verifyContactUsSubmitted() {
        return action.isDisplayed(getDriver(), submittedMsg);
    }

    public String acceptAlertAndGetText() {
        return action.handleAlert(getDriver(), "accept");
    }

    public String dismissAlertAndGetText() {
        return action.handleAlert(getDriver(), "dismiss");
    }


}
