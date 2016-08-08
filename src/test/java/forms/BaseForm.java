package forms;

import elements.Link;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
    private static JavascriptExecutor js = (JavascriptExecutor)driver;
    private static Actions actions = new Actions(driver);

    protected BaseForm(final By titleLoc, final String pageName){
        waitForPageToLoad();
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

    public void navigateTo(String url){
        driver.get(url);
    }

    public String getTextViaJSFrom(WebElement element){
        return js.executeScript("var text = (arguments[0].innerHTML.split(/([\\.\\?!])(?= )/)[2]);\n" +
                "    var r = document.createRange();\n" +
                "    r.selectNodeContents(arguments[0]);  \n" +
                "    var sel=window.getSelection(); \n" +
                "    sel.removeAllRanges(); \n" +
                "    sel.addRange(r); \n" +
                "    return window.getSelection().toString();", element).toString();
    }

    public void pasteTextViaJSTo(WebElement input, String text){
        js.executeScript("var input = arguments[1];" +
                "input.value = arguments[0];", text, input);
    }

    //doesn't work correctly
    public void clickEnterJs(){
        js.executeScript("var ev = document.createEvent('KeyboardEvent'); \n" +
                        "ev.initKeyEvent('keydown', true, true, window, false, false, false, false, 13, 0); \n" +
                        "document.body.dispatchEvent(ev);");
    }

    public void selectTextViaActions(String text){
        actions.sendKeys(Keys.chord(Keys.CONTROL,"+f")).sendKeys(text).sendKeys(Keys.ESCAPE).sendKeys(Keys.chord(Keys.CONTROL,"+c")).build().perform();
    }

    public void pasteFromClipboardViaActions(){
        actions.sendKeys(Keys.chord(Keys.CONTROL,"+v")).sendKeys(Keys.ENTER).build().perform();
    }

    public void clickEnter(){
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}
