package webdriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webdriver.Browser.Browsers;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BrowserFactory {

    private static RemoteWebDriver setUp(final Browsers type) {
        DesiredCapabilities capabilitiesProxy = new DesiredCapabilities();
        capabilitiesProxy.setPlatform(Platform.WINDOWS);
        RemoteWebDriver driver = null;

        switch (type) {
            case FIREFOX:
                capabilitiesProxy.setBrowserName("firefox");
                //driver = new FirefoxDriver(capabilitiesProxy);
                break;

            case CHROME:
                capabilitiesProxy.setBrowserName("chrome");
                //TODO: in progress
                break;

            case IEXPLORE:
                capabilitiesProxy.setBrowserName("IE");
                //TODO: in progress
                break;

            case OPERA:
                capabilitiesProxy.setBrowserName("opera");
                //TODO: in progress
                break;

            case SAFARI:
                capabilitiesProxy.setBrowserName("safari");
                //TODO: in progress
                break;

            default:
                break;
        }

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"), capabilitiesProxy);
        }
        catch(MalformedURLException ex){
            ex.printStackTrace();
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
