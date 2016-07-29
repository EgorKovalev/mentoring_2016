package thomsonReutersTests.forms;

import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopicPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[@class='parsys T12_region5']");

    @FindBy(xpath = "//*[@class='heading-1']")
    private WebElement topicName;

    public TopicPage() {
        super(titleLocator, "Topic page");
        PageFactory.initElements(driver, this);
    }

    public String getTopicName(){
        return topicName.getText();
    }
}
