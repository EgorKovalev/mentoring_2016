package thomsonReutersTests.forms;

import elements.Button;
import elements.TextBox;
import forms.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'siteSpecificHeader')]");
    private final static TextBox searchField = new TextBox(By.className("global-search-input"), "Search text box");
    private final static Button searchLink = new Button(By.className("global-search-submit"), "Run search button");
    private TopLevelMenu topLevelMenu = new TopLevelMenu();

    public MainPage() {
        super(titleLocator, "TR main page");
    }

    public void clickTopMenuLink(String linkName){
        topLevelMenu.clickLink(linkName);
    }

    public void runSearch(String request){
        searchField.click();
        searchField.setText(request);
        searchLink.click();
    }
}
