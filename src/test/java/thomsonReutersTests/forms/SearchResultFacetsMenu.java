package thomsonReutersTests.forms;

import elements.Link;
import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SearchResultFacetsMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'search-results-filter-set-wrapper')]");
    private static String linkPath = "//div[@class='search-results-category-list']/span[text()='%s']/following-sibling::ul/li/a[text()='%s']";
    private static String facetPath = "//div[@class='search-results-category-list']/ul/li/a[text()='%s']/span";

    public SearchResultFacetsMenu() {
        super(titleLocator, "Search results types menu");
        PageFactory.initElements(driver, this);
    }

    public void clickTypeFromType(String type, String link){
        new Link(By.xpath(String.format(linkPath, type, link)), "Search result facet " + link).click();
    }

    public int getDocsNumberInFacet(String facetname){
        String number = new Link(By.xpath(String.format(facetPath, facetname)), "Search result facet " + facetname).getText();
        return Integer.parseInt(number);
    }
}
