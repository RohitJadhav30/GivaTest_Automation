package com.giva.qa.tests;

import com.giva.qa.pages.OffersPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.ExelFile;

@Listeners(CustomListener.class)
public class OffersTest extends OffersPage {

    OffersPage offersPage;

    @BeforeMethod
    public void setUp(){
        initialize();
        offersPage = new OffersPage();
    }

    @Test(priority = 1, dataProvider = "LoginData", dataProviderClass = ExelFile.class)
    @Severity(SeverityLevel.NORMAL)
    @Description("This test verify the offers page")
    public void offersTest(String emailID, String password){
        offersPage.offersTest(emailID, password);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("This test verify the title")
    public void getTitles(){
        String title = offersPage.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Buy Beautiful Silver, Gold & Lab Grown Diamond Jewellery at Best Price – GIVA Jewellery");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
