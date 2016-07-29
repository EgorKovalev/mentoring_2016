package forms;

import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.Browser;
import webdriver.Logger;

import java.util.Date;

public abstract class BaseForm {
    private final long DEFAULT_WAIT_SEC = 30L;
    protected static RemoteWebDriver driver = Browser.getInstance().getDriver();
    protected By titleLocator;
    protected String name;
    protected static Logger logger = Logger.getInstance();

    protected BaseForm(final By titleLoc, final String pageName){
        titleLocator = titleLoc;
        name = pageName;
        checkIfPageIsOpened();
    }

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_SEC);
            wait.until(expectation);
        } catch (Throwable error) {
            logger.error("Page loading error");
        }
    }

    private void checkIfPageIsOpened(){
        long startTime = new Date().getTime();
        Link element = new Link(titleLocator, name);
        try {
            element.waitForElementVisible(titleLocator);
            long period = new Date().getTime() - startTime;
            logger.info(name + " was loaded in " + period + "ms");
        } catch (Throwable e) {
            logger.error("Error while opening page");
        }
    }
}
