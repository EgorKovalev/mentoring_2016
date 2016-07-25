package thomsonReutersTests.forms;

import elements.Link;
import forms.BaseForm;
import org.openqa.selenium.By;

public class AboutUsDropMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//*[contains(@class,'local-navigation-navigation')]");
    private final static String linkPath = "//*[@class='local-navigation-list']//*[contains(text(),'%s')]";
    private final static String subLinkPath = linkPath + "/following-sibling::div//*[contains(text(),'%s')]";

    public AboutUsDropMenu() {
        super(titleLocator, "About us drop menu");
    }

    public void selectDropItem(String name, String itemName){
        new Link(By.xpath(String.format(linkPath, name)), name + " dropdown list").click();
        new Link(By.xpath(String.format(subLinkPath, name, itemName)), itemName + " item").click();
    }
}
