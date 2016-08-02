package thomsonReutersTests.forms;

import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[contains(@class, 'heading-page-header-with-search')]");

    @FindBy(css = "div.cq-searchpromote-results ul>li")
    public List<WebElement> searchResults;

    public SearchResultsPage() {
        super(titleLocator, "Search results page");
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchResultPresent(){
        return searchResults.isEmpty();
    }
}
