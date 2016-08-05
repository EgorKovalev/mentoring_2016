package tests.loremTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.loremTests.forms.GeneratedPage;
import tests.loremTests.forms.GoogleMainPage;
import tests.loremTests.forms.GoogleSearchResultPage;
import tests.loremTests.forms.MainPage;
import webdriver.BaseTest;

public class ActionsTest extends BaseTest {
    private final static int SENTENCE_NUMBER = 2;
    private final static String GOOGLE = "google.com";

    @Test
    public void openProductsListLoginPage(){
        MainPage mainPage = new MainPage();
        mainPage.clickGenerateText();

        GeneratedPage generatedPage = new GeneratedPage();
        String sentence = generatedPage.getSentenceFromParagraph(SENTENCE_NUMBER);
        generatedPage.selectTextViaActions(sentence);
        generatedPage.navigateTo(GOOGLE);

        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.getSearchInput().click();
        googleMainPage.pasteFromClipboardViaActions();

        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage();
        Assert.assertTrue(!googleSearchResultPage.getResultsList().isEmpty(), "Search result list is empty");
    }
}
