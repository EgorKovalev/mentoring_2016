package thomsonReutersTests.forms;

import forms.BaseForm;
import org.openqa.selenium.By;

public class TopicPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[@class='parsys T12_region5']");

    public TopicPage() {
        super(titleLocator, "Topic page");
    }
}
