package tests.lorem.forms;

import elements.Link;
import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseForm {
    private final static By titleLocator = By.id("generate");
    private Link generateLoremIpsum = new Link(By.id("generate"), "Generate lorem ipsum button");

    public MainPage() {
        super(titleLocator, "Lorem main page");
        PageFactory.initElements(driver, this);
    }

    public void clickGenerateText(){
        generateLoremIpsum.clickViaJS();
    }
}
