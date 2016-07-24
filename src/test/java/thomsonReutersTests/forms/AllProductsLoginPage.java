package thomsonReutersTests.forms;

import forms.BaseForm;
import org.openqa.selenium.By;

public class AllProductsLoginPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'page-header-simple')]");

    public AllProductsLoginPage() {
        super(titleLocator, "All products login page");
    }
}
