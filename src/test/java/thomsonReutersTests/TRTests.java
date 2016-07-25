package thomsonReutersTests;

import org.testng.annotations.Test;
import thomsonReutersTests.forms.*;
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

    @Test
    public void browseTopics(){
        MainPage mainPage = new MainPage();
        mainPage.clickTopic("Legal");
        new TopicPage();
    }

    @Test
    public void companyHistory(){
        MainPage mainPage = new MainPage();
        mainPage.clickNavigationMenuLink("About Us");
        AboutUsPage aboutUsPage = new AboutUsPage();
        aboutUsPage.clickDropList("Our Company", "Company History");
        new CompanyHistoryPage();
    }
}
