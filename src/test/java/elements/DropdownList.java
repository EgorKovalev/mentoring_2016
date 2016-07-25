package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropdownList extends BaseElement {

    public DropdownList(final By locator, final String name) {
        super(locator, name);
    }

    public void selectItemByName(String text){
        new Select(element).selectByVisibleText(text);
    }
}
