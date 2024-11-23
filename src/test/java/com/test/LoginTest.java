package com.test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://param.com.tr");
    }

    @Test
    public void testInvalidLoginValidation() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickLoginButton();
        loginPage.selectCorporateLogin();
        loginPage.enterUsername("12345678911");
        loginPage.enterPassword("123456");
        loginPage.clickLoginSubmit();
        String expectedMessage = "Hatalı bilgi girişi yaptınız.\n" +
                " Lütfen bilgilerinizi kontrol ediniz.";
        Assert.assertEquals(loginPage.getValidationMessage(), expectedMessage);
        loginPage.clickNotificationOkey();

    }

    @Test
    public void testInvalidOtpRegistrationValidation() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        homePage.clickLoginButton();
        loginPage.selectCorporateLogin();
        loginPage.clickRegisterLink();
        registerPage.enterName("Hüseyin");
        registerPage.enterSurname("solmaz");
        registerPage.enterEmail("test@nomail.com");
        registerPage.enterPhoneNumber("5559999988");
        registerPage.clickCheckBoxes();
        registerPage.clickContinueButton();
        registerPage.enterOTP();
        registerPage.clickConfirmButton();
        String expectedMessage = "Girdiğiniz onay kodu hatalıdır.";
        Assert.assertEquals(registerPage.getNotificationMessage(), expectedMessage);

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}