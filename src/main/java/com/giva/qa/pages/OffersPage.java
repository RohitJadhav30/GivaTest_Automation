package com.giva.qa.pages;

import com.giva.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage extends TestBase {

    private static final Logger logger = LogManager.getLogger(OffersPage.class);

    public OffersPage() {
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

    @FindBy(id = "HeaderMenu-offers")
    WebElement offers;

    public void clickAccountLogo() {
        logger.info("Clicked Account logo");
        webLogo.click();
    }

    public void login(String emailID, String password) {
        logger.info("Logging in with email: " + emailID);
        email_Input.sendKeys(emailID);
        pass_Input.sendKeys(password);
        loginButton.click();
    }

    public void clickOnOffers() {
        logger.info("Clicked on Offers");
        offers.click();
    }

    public String getTitle() {
        logger.info("Getting page title");
        return driver.getTitle();
    }
    public void offersTest(String emailID, String password) {
        clickAccountLogo();
        login(emailID, password);
        clickOnOffers();
        logger.info("Offers test completed for email: " + emailID);
    }
}
