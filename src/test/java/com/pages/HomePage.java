package com.pages;

import com.utilities.MainUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    private By loginButton = By.xpath("//a[@id='menu_login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement loginBtn = MainUtilities.waitForElementToBeVisible(driver, loginButton, 10);
        loginBtn.click();
    }
}