

package com.giva.qa.pages;

import com.giva.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[@class=\"small-hide\"])[3]")
    WebElement webLogo;

    @FindBy(name = "customer[email]")
    WebElement email_Input;

    @FindBy(name = "customer[password]")
    WebElement pass_Input;

    @FindBy(xpath = "(//button)[12]")
    WebElement loginButton;

    @FindBy(xpath = "//img[@alt='GIVA Jewellery']") WebElement giva_Logo;

    public void clickAccountLogo() {
        logger.info("Clicked Account logo");
        webLogo.click();
    }

    public void login(String emailID, String password) {
        logger.info("Logging in with email: " + emailID);
        email_Input.sendKeys(emailID);
        pass_Input.sendKeys(password);
        loginButton.click();
        giva_Logo.click();
    }

    public String getTitle() {
        logger.info("Getting page title");
        return driver.getTitle();
    }

    public void loginTest(String emailID, String password) {
        clickAccountLogo();
        login(emailID, password);
        logger.info("Login test completed with title: " + getTitle());
    }
}
