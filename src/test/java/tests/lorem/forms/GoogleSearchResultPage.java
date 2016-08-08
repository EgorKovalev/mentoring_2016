package tests.lorem.forms;

import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResultPage extends BaseForm {
    private final static By titleLocator = By.id("hdtbSum");

    public GoogleSearchResultPage() {
        super(titleLocator, "Google search result page");
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "g")
    private List<WebElement> resultsList;

    public List<WebElement> getResultsList(){
        return resultsList;
    }
}
