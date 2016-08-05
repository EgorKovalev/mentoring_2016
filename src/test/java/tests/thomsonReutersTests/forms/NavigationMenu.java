package tests.thomsonReutersTests.forms;

import elements.Link;
import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//*[contains(@class, 'site-specific-header')]");
    private final static String linkPath = "//div[@class='primary-navigation-list-wrapper']/ul/li/*[contains(text(),'%s')]";

    public NavigationMenu() {
        super(titleLocator, "Top level menu");
        PageFactory.initElements(driver, this);
    }

    public void clickLink(String name){
        new Link(By.xpath(String.format(linkPath, name)), "Navigation menu link " + name).click();
    }
}
