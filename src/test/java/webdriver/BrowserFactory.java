package webdriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webdriver.Browser.Browsers;
import javax.naming.NamingException;

public abstract class BrowserFactory {

    private static RemoteWebDriver setUp(final Browsers type) {
        DesiredCapabilities capabilitiesProxy = null;
        RemoteWebDriver driver = null;

        switch (type) {
            case FIREFOX:
                driver = new FirefoxDriver(capabilitiesProxy);
                break;

            case CHROME:
                //TODO: in progress
                break;

            case IEXPLORE:
                //TODO: in progress
                break;

            case OPERA:
                //TODO: in progress
                break;

            case SAFARI:
                //TODO: in progress
                break;

            default:
                break;
        }
        return driver;
    }

    public static RemoteWebDriver setUp(final String type) throws NamingException {
        for (Browsers t : Browsers.values()) {
            if (t.toString().equalsIgnoreCase(type)) {
                return setUp(t);
            }
        }
        //TODO: fix exception and add logger message here
        throw new NamingException("");
    }
}
