package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static WebDriver webDriver = null;

    private final String LOGIN = "login@login.com";
    private final String PASSWORD = "password123";
    private final String PASSWORD_INVALID = "password";

    private final By EMAIL_LOGIN_INPUT_LOCATOR = By.xpath("//input[@id='input-email']");
    private final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@id='input-password']");
    private final By LOGIN_INPUT_LOCATOR = By.xpath("//input[@value='Login']");
    private final By TEXT_LOCATOR = By.xpath("//h2[contains(text(), 'My Account')]");
    private final By MY_ACCOUNT_LOCATOR = By.xpath("//span[contains(text(), 'My Account')]");
    private final By LOGOUT_LOCATOR = By.xpath("//a[@href='http://electonicstore.com/index.php?route=account/logout']");
    private final By TEXT_LOCATOR_LOGOUT = By.xpath("//div[@id='content']/h1");
    private final By TEXT_LOCATOR_INVALID_PASSWORD = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    @BeforeClass
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(priority = 4)
    public void loginToMailInvalidTest() throws InterruptedException{
        webDriver.get("http://electonicstore.com/index.php?route=account/login");

        WebElement loginField = webDriver.findElement(EMAIL_LOGIN_INPUT_LOCATOR);
        loginField.clear();
        loginField.sendKeys(LOGIN);

        WebElement passwordField = webDriver.findElement(PASSWORD_INPUT_LOCATOR);
        passwordField.clear();
        passwordField.sendKeys(PASSWORD_INVALID);

        WebElement enterButton = webDriver.findElement(LOGIN_INPUT_LOCATOR);
        enterButton.click();

        WebElement webPageText = webDriver.findElement(TEXT_LOCATOR_INVALID_PASSWORD);
        String textFromPage = webPageText.getText();

        Assert.assertEquals(textFromPage, "Warning: No match for E-Mail Address and/or Password.", "Testing of logging with valid data is failed");
    }

    @Test(priority = 5)
    public void loginToMailTest() throws InterruptedException {
        webDriver.get("http://electonicstore.com/index.php?route=account/login");

        WebElement loginField = webDriver.findElement(EMAIL_LOGIN_INPUT_LOCATOR);
        loginField.clear();
        loginField.sendKeys(LOGIN);

        WebElement passwordField = webDriver.findElement(PASSWORD_INPUT_LOCATOR);
        passwordField.clear();
        passwordField.sendKeys(PASSWORD);

        WebElement enterButton = webDriver.findElement(LOGIN_INPUT_LOCATOR);
        enterButton.click();

        WebElement webPageText = webDriver.findElement(TEXT_LOCATOR);
        String textFromPage = webPageText.getText();

        Assert.assertEquals(textFromPage, "My Account", "Testing of logging with valid data is failed");
    }

    @Test(priority = 6)
    public void loginLogOutTest() throws InterruptedException {
        webDriver.get("http://electonicstore.com/index.php?route=account/account");

        WebElement enterButton = webDriver.findElement(MY_ACCOUNT_LOCATOR);
        enterButton.click();

        WebElement clickButton = webDriver.findElement(LOGOUT_LOCATOR);
        clickButton.click();

        WebElement webPageText = webDriver.findElement(TEXT_LOCATOR_LOGOUT);
        String textFromPage = webPageText.getText();

        Assert.assertEquals(textFromPage, "Account Logout", "Testing of logging with valid data is failed");
    }


    @AfterClass
    public void closeBrowser() {
        webDriver.quit();
    }
}
