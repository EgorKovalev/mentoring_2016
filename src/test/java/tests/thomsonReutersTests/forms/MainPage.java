package tests.thomsonReutersTests.forms;

import elements.Link;
import elements.TextBox;
import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'siteSpecificHeader')]");
    private final static TextBox searchField = new TextBox(By.className("global-search-input"), "Search text box");
    private static String pathToTopicLink = "//div[contains(@class,'contentItemManualDropdown')]/h6/strong/a[contains(text(),'%s')]";
    private TopLevelMenu topLevelMenu = new TopLevelMenu();
    private NavigationMenu navigationMenu = new NavigationMenu();

    @FindBy(className = "global-search-submit")
    private WebElement searchLink;

    public MainPage() {
        super(titleLocator, "TR main page");
        PageFactory.initElements(driver, this);
    }

    public void clickTopMenuLink(String linkName){
        topLevelMenu.clickLink(linkName);
    }

    public void clickNavigationMenuLink(String linkName){
        navigationMenu.clickLink(linkName);
    }

    public void runSearch(String request){
        searchField.click();
        searchField.setText(request);
        searchLink.click();
    }

    public void clickTopic(String name){
        Link topicLink = new Link(By.xpath(String.format(pathToTopicLink, name)), name + " topic link");
        topicLink.clickViaJS();
    }
}
