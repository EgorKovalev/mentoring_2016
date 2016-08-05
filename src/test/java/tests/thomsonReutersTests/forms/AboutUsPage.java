package tests.thomsonReutersTests.forms;

import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[text()='About Thomson Reuters']");
    private AboutUsDropMenu aboutUsDropMenu = new AboutUsDropMenu();

    public AboutUsPage() {
        super(titleLocator, "About us page");
        PageFactory.initElements(driver, this);
    }

    public void clickDropList(String name, String subItem){
        aboutUsDropMenu.selectDropItem(name, subItem);
    }
}