package tests.lorem.forms;

import forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneratedPage extends BaseForm {
    private final static By titleLocator = By.id("lipsum");
    private final static int PARAGRAPH_NUMBER = 2;

    public GeneratedPage() {
        super(titleLocator, "Page with generated text");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='lipsum']/p["+PARAGRAPH_NUMBER+"]")
    private WebElement paragraph;

    public WebElement getParagraph(){
        return paragraph;
    }

    public String getSentenceFromParagraph(int number){
        String text = paragraph.getText();
        return text.split("\\.| \\? | !")[number];
    }
}

