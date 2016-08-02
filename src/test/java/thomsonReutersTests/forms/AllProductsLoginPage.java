package thomsonReutersTests.forms;

import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllProductsLoginPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'page-header-simple')]");

    @FindBys({@FindBy(xpath = "//div[@class='list-of-links']/div/div/div/ul[@class='list-links']/li")})
    private List<WebElement> productsList;

    public AllProductsLoginPage() {
        super(titleLocator, "All products login page");
        PageFactory.initElements(driver, this);
    }

    public int getProductsNumber(){
        return productsList.size();
    }
}
