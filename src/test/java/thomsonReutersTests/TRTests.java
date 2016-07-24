package thomsonReutersTests;

import org.testng.annotations.Test;
import thomsonReutersTests.forms.AllProductsLoginPage;
import thomsonReutersTests.forms.MainPage;
import thomsonReutersTests.forms.SearchResultsPage;
import webdriver.BaseTest;

public class TRTests extends BaseTest {

    @Test
    public void openProductsListLoginPage(){
        MainPage mainPage = new MainPage();
        mainPage.clickTopMenuLink("Login");
        new AllProductsLoginPage();
    }

    @Test
    public void runSearch(){
        MainPage mainPage = new MainPage();
        mainPage.runSearch("test request");
        new SearchResultsPage();
    }
}
