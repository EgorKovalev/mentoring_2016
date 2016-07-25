package thomsonReutersTests.forms;

import elements.Link;
import elements.TextBox;
import forms.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'siteSpecificHeader')]");
    private final static TextBox searchField = new TextBox(By.className("global-search-input"), "Search text box");
    private final static Link searchLink = new Link(By.className("global-search-submit"), "Run search button");
    private static String pathToTopicLink = "//*[contains(@class,'contentItemManualDropdown')]//a[contains(text(),'%s')]";
    private TopLevelMenu topLevelMenu = new TopLevelMenu();
    private NavigationMenu navigationMenu = new NavigationMenu();

    public MainPage() {
        super(titleLocator, "TR main page");
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
