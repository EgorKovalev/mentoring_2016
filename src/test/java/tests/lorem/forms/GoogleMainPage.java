package tests.lorem.forms;

import elements.Link;
import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.Browser;

public class GoogleMainPage extends BaseForm {
    private final static By titleLocator = By.xpath("//input[@id='lst-ib']");

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
        if("chrome".equals(Browser.getBrowserName())){
            clickEnter();
        }
        else {
            new Link(By.xpath("//input[@name='btnK']"), "Search button").clickViaJS();
        }
    }
}
