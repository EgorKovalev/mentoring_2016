package webdriver;

import com.google.common.base.Strings;
import org.openqa.selenium.remote.RemoteWebDriver;
import javax.naming.NamingException;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static final long IMPLICITY_WAIT = 60L;
    private static final String BROWSER_PROP = "browser";

    static final String PROPERTIES_FILE = "selenium.properties";

    private static Browser instance;
    private static RemoteWebDriver driver;

    public static PropertiesManager props;
    public static Browsers currentBrowser;
    protected static Logger logger = Logger.getInstance();

    private Browser() {  }

    public static String getBaseUrl(){
        return System.getProperty("urlLoginPage", props.getProperty("urlLoginPage"));
    }

    public static Browser getInstance() {
        if (instance == null) {
            initProperties();
            try {
                driver = BrowserFactory.setUp(currentBrowser.toString());
                driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
            } catch (NamingException e) {
                e.printStackTrace();
            }
            instance = new Browser();
        }
        return instance;
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    protected void info(final String message) {
        logger.info(message);
    }

    private static void initProperties() {
        props = new PropertiesManager(PROPERTIES_FILE);

        if (!Strings.isNullOrEmpty(props.getProperty(BROWSER_PROP))) {
            String proper = props.getProperty(BROWSER_PROP);
            currentBrowser = Browsers.valueOf(proper.toUpperCase());
        } else {
            //TODO: run default browser
        }
    }

    public void windowMaximise() {
        driver.manage().window().maximize();
    }

    public void navigate(final String url) {
        driver.navigate().to(url);
    }

    public boolean isBrowserAlive() {
        return instance != null;
    }

    public RemoteWebDriver getDriver(){
        return driver;
    }

    public enum Browsers {
        FIREFOX("firefox"),
        IEXPLORE("iexplore"),
        CHROME("chrome"),
        OPERA("opera"),
        SAFARI("safari");

        public String value;

        Browsers(final String values) {
            value = values;
        }

        public String toString() {
            return value;
        }
    }
}
