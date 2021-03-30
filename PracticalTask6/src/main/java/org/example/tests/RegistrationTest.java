package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private static WebDriver driver = null;

    private final static String FIRST_NAME = "Mary";
    private static String LAST_NAME = "Poppins";
    private static String EMAIL = "xzlk8@vmani.com";
    private static String TELEPHONE = "2515643465";
    private static String PASSWORD = "password123";

    private final By REGISTRATION_FIRST_NAME_LOCATOR = By.xpath("//input[@name='firstname']");
    private final By REGISTRATION_LAST_NAME_LOCATOR = By.xpath("//input[@name='lastname']");
    private final By REGISTRATION_EMAIL_LOCATOR = By.xpath("//input[@name='email']");
    private final By REGISTRATION_TELEPHONE_LOCATOR = By.xpath("//input[@name='telephone']");
    private final By REGISTRATION_PASSWORD_LOCATOR = By.xpath("//input[@name='password']");
    private final By REGISTRATION_PASSWORD_CONFIRM_LOCATOR = By.xpath("//input[@name='confirm']");
    private final By REGISTRATION_NEWSLETTER_SUBSCRIBE_LOCATOR = By.xpath("//*[@name='newsletter']");
    private final By REGISTRATION_CHECK_BOX_PRIVACY_POLICY_LOCATOR = By.xpath("//input[@name='agree']");
    private final By CONTINUE_INPUT_LOCATOR = By.xpath("//input[@value='Continue']");
    private final By TEXT_LOCATOR = By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]");
    private final By TEXT_LOCATOR_ERROR = By.xpath("//*[@id='content']/h1");
    private final By TEXT_LOCATOR_ERROR_CHECK_BOX = By.xpath("//*[contains(text(), 'Warning')]");

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void registrationToMailTest() throws InterruptedException {
        driver.get("http://electonicstore.com/index.php?route=account/register");

        //Thread.sleep(10000);

        WebElement registrationFirstNameField = driver.findElement(REGISTRATION_FIRST_NAME_LOCATOR);
        registrationFirstNameField.clear();
        registrationFirstNameField.sendKeys(FIRST_NAME);

        WebElement registrationLastNameField = driver.findElement(REGISTRATION_LAST_NAME_LOCATOR);
        registrationLastNameField.clear();
        registrationLastNameField.sendKeys(LAST_NAME);

        WebElement registrationEmailField = driver.findElement(REGISTRATION_EMAIL_LOCATOR);
        registrationEmailField.clear();
        registrationEmailField.sendKeys(EMAIL);

        WebElement registrationTelephoneField = driver.findElement(REGISTRATION_TELEPHONE_LOCATOR);
        registrationTelephoneField.clear();
        registrationTelephoneField.sendKeys(TELEPHONE);

        WebElement registrationPasswordField = driver.findElement(REGISTRATION_PASSWORD_LOCATOR);
        registrationPasswordField.clear();
        registrationPasswordField.sendKeys(PASSWORD);

        WebElement registrationPasswordConfirmField = driver.findElement(REGISTRATION_PASSWORD_CONFIRM_LOCATOR);
        registrationPasswordConfirmField.clear();
        registrationPasswordConfirmField.sendKeys(PASSWORD);

        WebElement radioButton = driver.findElement(REGISTRATION_NEWSLETTER_SUBSCRIBE_LOCATOR);
        radioButton.click();

        WebElement checkBox = driver.findElement(REGISTRATION_CHECK_BOX_PRIVACY_POLICY_LOCATOR);
        checkBox.click();

        WebElement enterButton = driver.findElement(CONTINUE_INPUT_LOCATOR);
        enterButton.click();

        WebElement webPageText = driver.findElement(TEXT_LOCATOR);
        String textFromPage = webPageText.getText();

        Assert.assertEquals(textFromPage, "Your Account Has Been Created!", "Testing of logging with valid data is failed");
    }

    @Test(priority = 2)
    public void registrationToMailInvalidTest() throws InterruptedException {
        driver.get("http://electonicstore.com/index.php?route=account/register");

        //Thread.sleep(10000);

        WebElement registrationFirstNameField = driver.findElement(REGISTRATION_FIRST_NAME_LOCATOR);
        registrationFirstNameField.clear();
        registrationFirstNameField.sendKeys(FIRST_NAME);

        WebElement registrationLastNameField = driver.findElement(REGISTRATION_LAST_NAME_LOCATOR);
        registrationLastNameField.clear();
        registrationLastNameField.sendKeys(LAST_NAME);

        WebElement registrationEmailField = driver.findElement(REGISTRATION_EMAIL_LOCATOR);
        registrationEmailField.clear();
        registrationEmailField.sendKeys(EMAIL);

        WebElement registrationTelephoneField = driver.findElement(REGISTRATION_TELEPHONE_LOCATOR);
        registrationTelephoneField.clear();
        registrationTelephoneField.sendKeys(TELEPHONE);

        WebElement registrationPasswordField = driver.findElement(REGISTRATION_PASSWORD_LOCATOR);
        registrationPasswordField.clear();
        registrationPasswordField.sendKeys(PASSWORD);

        WebElement registrationPasswordConfirmField = driver.findElement(REGISTRATION_PASSWORD_CONFIRM_LOCATOR);
        registrationPasswordConfirmField.clear();
        registrationPasswordConfirmField.sendKeys(PASSWORD);

        WebElement radioButton = driver.findElement(REGISTRATION_NEWSLETTER_SUBSCRIBE_LOCATOR);
        radioButton.click();

        WebElement checkBox = driver.findElement(REGISTRATION_CHECK_BOX_PRIVACY_POLICY_LOCATOR);
        checkBox.click();

        WebElement enterButton = driver.findElement(CONTINUE_INPUT_LOCATOR);
        enterButton.click();

        WebElement webPageText = driver.findElement(TEXT_LOCATOR_ERROR);
        String textFromPage = webPageText.getText();

        Assert.assertEquals(textFromPage, "Register Account", "Testing of logging with valid data is failed");
    }

    @Test(priority = 3)
    public void registrationToMailCheckBoxTest() throws InterruptedException {
        driver.get("http://electonicstore.com/index.php?route=account/register");

        //Thread.sleep(10000);

        WebElement registrationFirstNameField = driver.findElement(REGISTRATION_FIRST_NAME_LOCATOR);
        registrationFirstNameField.clear();
        registrationFirstNameField.sendKeys(FIRST_NAME);

        WebElement registrationLastNameField = driver.findElement(REGISTRATION_LAST_NAME_LOCATOR);
        registrationLastNameField.clear();
        registrationLastNameField.sendKeys(LAST_NAME);

        WebElement registrationEmailField = driver.findElement(REGISTRATION_EMAIL_LOCATOR);
        registrationEmailField.clear();
        registrationEmailField.sendKeys(EMAIL);

        WebElement registrationTelephoneField = driver.findElement(REGISTRATION_TELEPHONE_LOCATOR);
        registrationTelephoneField.clear();
        registrationTelephoneField.sendKeys(TELEPHONE);

        WebElement registrationPasswordField = driver.findElement(REGISTRATION_PASSWORD_LOCATOR);
        registrationPasswordField.clear();
        registrationPasswordField.sendKeys(PASSWORD);

        WebElement registrationPasswordConfirmField = driver.findElement(REGISTRATION_PASSWORD_CONFIRM_LOCATOR);
        registrationPasswordConfirmField.clear();
        registrationPasswordConfirmField.sendKeys(PASSWORD);

        WebElement radioButton = driver.findElement(REGISTRATION_NEWSLETTER_SUBSCRIBE_LOCATOR);
        radioButton.click();

        WebElement enterButton = driver.findElement(CONTINUE_INPUT_LOCATOR);
        enterButton.click();

        WebElement webPageText = driver.findElement(TEXT_LOCATOR_ERROR_CHECK_BOX);
        String textFromPage = webPageText.getText();

        Assert.assertEquals(textFromPage, "Warning: You must agree to the Privacy Policy!", "Testing of logging with valid data is failed");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
