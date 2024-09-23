package com.giva.qa.tests;

import com.giva.qa.pages.LoginPage;
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
public class LoginTest extends LoginPage {

    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        initialize();
        loginPage = new LoginPage();
    }

    @Test(priority = 1, dataProvider = "LoginData", dataProviderClass = ExelFile.class)
    @Severity(SeverityLevel.BLOCKER)
    @Description("This test verify the login method")
    public void loginTest(String emailID, String password) {
        loginPage.loginTest(emailID, password);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("This test verify the title")
    public void getTitles(){
        String title = loginPage.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Buy Beautiful Silver, Gold & Lab Grown Diamond Jewellery at Best Price – GIVA Jewellery");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}