package com.giva.qa.tests;

import com.giva.qa.pages.SignUp;
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
public class SignUpTest extends SignUp {
    SignUp signUp;

    @BeforeMethod
    public void setUp(){
        initialize();
        signUp = new SignUp();
    }

    @Test(priority = 1, dataProvider = "signUpData", dataProviderClass = ExelFile.class)
    @Severity(SeverityLevel.BLOCKER)
    @Description("This test verify the signUp method")
    public void signUpTest(String fName, String lName, String email, String pass){
        signUp.signUpTest(fName, lName, email, pass);
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
