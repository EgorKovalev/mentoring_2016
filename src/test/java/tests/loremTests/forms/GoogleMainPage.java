package tests.loremTests.forms;

import elements.Link;
import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends BaseForm {
    private final static By titleLocator = By.id("hplogop");

    public GoogleMainPage() {
        super(titleLocator, "Google main page");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchInput;

    public WebElement getSearchInput(){
        return searchInput;
    }

    public void clickSearchViaJS(){
        new Link(By.xpath("//input[@name='btnK']"), "Search button").clickViaJS();
    }
}
