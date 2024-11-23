package com.pages;

import com.utilities.MainUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    private By nameInput = By.name("name");
    private By surnameInput = By.name("surname");
    private By emailInput = By.name("email");
    private By phoneNumberInput = By.name("gsmNumber");
    private By checkBox1 = By.xpath("//div[@name=\"checkBox1\"]//img[contains(@src,'check')]");
    private By checkBox2 = By.xpath("//div[@name=\"checkBox2\"]//img[contains(@src,'check')]");
    private By checkBox3 = By.xpath("//div[@name=\"checkBox3\"]//img[contains(@src,'check')]");

    private By otpInbox1 = By.name("input1");
    private By otpInbox2 = By.name("input2");
    private By otpInbox3 = By.name("input3");
    private By otpInbox4 = By.name("input4");
    private By otpInbox5 = By.name("input5");
    private By otpInbox6 = By.name("input6");
    private By continueButton = By.id("continue_from_signup");
    private By confirmButton = By.id("continue_from_otp");
    private By notification = By.id("errorVerificationNo");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterName(String name){
        MainUtilities.waitForElementToBeVisible(driver, nameInput, 10);
        driver.findElement(nameInput).sendKeys(name);
    }
    public void enterSurname(String surname){
        driver.findElement(surnameInput).sendKeys(surname);
    }
    public void enterEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }
    public void clickCheckBoxes(){
            driver.findElement(checkBox1).click();
            driver.findElement(checkBox2).click();
            driver.findElement(checkBox3).click();
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }
    public void enterOTP(){
        MainUtilities.waitForElementToBeVisible(driver, otpInbox1, 10);
        driver.findElement(otpInbox1).sendKeys("1");
        driver.findElement(otpInbox2).sendKeys("1");
        driver.findElement(otpInbox3).sendKeys("1");
        driver.findElement(otpInbox4).sendKeys("1");
        driver.findElement(otpInbox5).sendKeys("1");
        driver.findElement(otpInbox6).sendKeys("1");
    }

    public String getNotificationMessage() {
        MainUtilities.waitForElementToBeVisible(driver, notification, 10);
        return driver.findElement(notification).getText();
    }


}
