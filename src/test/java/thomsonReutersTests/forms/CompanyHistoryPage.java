package thomsonReutersTests.forms;

import forms.BaseForm;
import org.openqa.selenium.By;

public class CompanyHistoryPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[text()='Thomson Reuters Company History']");

    public CompanyHistoryPage() {
        super(titleLocator, "Company history page");
    }
}
