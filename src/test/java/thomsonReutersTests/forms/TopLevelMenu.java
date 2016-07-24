package thomsonReutersTests.forms;

import elements.Link;
import forms.BaseForm;
import org.openqa.selenium.By;

public class TopLevelMenu extends BaseForm{
    private final static By titleLocator = By.className("global-site-header-nav");
    private final static String linkPath = "//*[@id='global-site-header-nav']//a[contains(text(),'%s')]";

    public TopLevelMenu() {
        super(titleLocator, "Top level menu");
    }

    public void clickLink(String name){
        new Link(By.xpath(String.format(linkPath, name)), "Top level menu link " + name).click();
    }
}