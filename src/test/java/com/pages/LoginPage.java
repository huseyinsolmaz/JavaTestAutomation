package com.pages;

import com.utilities.MainUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class LoginPage {
    WebDriver driver;

    private By corporateLoginOption = By.xpath("//a[@href=\"https://isyerim.param.com.tr/#/\"]");
    private By usernameField = By.name("userCardNo");
    private By passwordField = By.name("userPassword");
    private By loginSubmitButton = By.id("loginbutton");
    private By validationMessage = By.xpath("//*[@class=\"modalTitle___WE5UD\"]");
    private By validationMessageOkey = By.xpath("//button[@class=\"buttonPrimary___2VioJ undefined\"]");
    private By registerLink = By.xpath("//span[contains(@class,'signUp')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCorporateLogin() {
        driver.findElement(corporateLoginOption).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

    }

    public void enterUsername(String username) {
        MainUtilities.waitForElementToBeVisible(driver, usernameField, 10);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginSubmit() {
        driver.findElement(loginSubmitButton).click();
    }

    public String getValidationMessage() {
        MainUtilities.waitForElementToBeVisible(driver, validationMessage, 10);
        return driver.findElement(validationMessage).getText();
    }
    public void clickNotificationOkey(){
        driver.findElement(validationMessageOkey).click();
    }
    public void clickRegisterLink() {
        MainUtilities.waitForElementToBeVisible(driver, registerLink, 10);
        driver.findElement(registerLink).click();
    }
}