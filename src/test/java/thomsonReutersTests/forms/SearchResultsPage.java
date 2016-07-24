package thomsonReutersTests.forms;

import forms.BaseForm;
import org.openqa.selenium.By;

public class SearchResultsPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[contains(@class, 'heading-page-header-with-search')]");

    public SearchResultsPage() {
        super(titleLocator, "Search results page");
    }
}
