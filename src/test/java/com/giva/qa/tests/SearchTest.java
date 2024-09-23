package com.giva.qa.tests;

import com.giva.qa.pages.SearchPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listener.CustomListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.ExelFile;

@Listeners(CustomListener.class)
public class SearchTest extends SearchPage {

    SearchPage searchPage;

    @BeforeMethod
    public void setUp(){
        initialize();
        searchPage = new SearchPage();
    }

    @Test(priority = 1, dataProvider = "SearchData", dataProviderClass = ExelFile.class)
    @Severity(SeverityLevel.NORMAL)
    @Description("This test verify the search page")
    public void searchTest(String emailID, String password, String search){
        searchPage.searchTest(emailID, password, search);
    }

//    @Test(priority = 2)
//    @Severity(SeverityLevel.NORMAL)
//    @Description("This test verify the buying process")
//    public void buyRing(){
//        searchPage.buyRing();
//    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
