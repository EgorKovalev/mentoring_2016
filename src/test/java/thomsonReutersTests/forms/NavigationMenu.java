package thomsonReutersTests.forms;

import elements.Link;
import forms.BaseForm;
import org.openqa.selenium.By;

public class NavigationMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//*[contains(@class, 'site-specific-header')]");
    private final static String linkPath = "//*[@id='primary-navigation-list']//*[contains(text(),'%s')]";

    public NavigationMenu() {
        super(titleLocator, "Top level menu");
    }

    public void clickLink(String name){
        new Link(By.xpath(String.format(linkPath, name)), "Navigation menu link " + name).click();
    }
}
