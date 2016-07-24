package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;

public abstract class BaseElement {
    protected By locator;
    protected WebElement element;
    protected String name;

    protected static Browser browser = Browser.getInstance();
    protected static RemoteWebDriver driver = browser.getDriver();

    private final long DEFAULT_WAIT_SEC = 60L;

    protected BaseElement(final By loc, final String elemName) {
        locator = loc;
        element = driver.findElement(locator);
        name = elemName;
    }

    protected WebElement getElement(){
        return element;
    }

    public void click() {
        waitForElementVisible();
        element.click();
    }

    public String getText() {
        waitForElementVisible();
        return element.getText();
    }

    public void sendKeys(Keys key) {
        waitForElementVisible();
        driver.findElement(locator).sendKeys(key);
    }

    private WebElement waitForElementVisible(){
        return waitForElementVisible(locator);
    }

    public WebElement waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_SEC);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public WebElement waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_SEC);
        return (WebElement)wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
