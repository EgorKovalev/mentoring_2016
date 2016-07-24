package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TextBox extends BaseElement {

    public TextBox(final By locator, final String name) {
        super(locator, name);
    }

    public void setText(String text){
        Actions builder = new Actions(driver);
        Actions seriesOfActions = builder.moveToElement(getElement()).click().sendKeys(getElement(), text);
        seriesOfActions.perform();
    }
}
