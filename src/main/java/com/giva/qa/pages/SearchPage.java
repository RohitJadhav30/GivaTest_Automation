package com.giva.qa.pages;

import com.giva.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends TestBase {

    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    public SearchPage() {
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

    @FindBy(xpath = "(//input[@id='Search-In-Modal'])[1]")
    WebElement searchInput;

    @FindBy(xpath = "(//*[name()='svg'][@class='icon icon-search'])[1]")
    WebElement searchIcon;

//    @FindBy(xpath = "//a[@id='CardLink--7532623233186']") WebElement zircon_Ring;
//
//    @FindBy(xpath = "//button[@id='ProductBuyButton-template--16317651517602__main']") WebElement buyNow;

    public void clickAccountLogo() {
        logger.info("Clicked Account logo");
        webLogo.click();
    }

    public void enterEmail(String emailID) {
        logger.info("Entering Email: " + emailID);
        email_Input.sendKeys(emailID);
    }

    public void enterPassword(String password) {
        logger.info("Entering Password");
        pass_Input.sendKeys(password);
    }

    public void clickLoginButton() {
        logger.info("Clicked Login button");
        loginButton.click();
    }

    public void searchBar(String search) {
        logger.info("Entering search term: " + search);
        searchInput.sendKeys(search);
    }

    public void clickOnSearch() {
        logger.info("Clicked on Search icon");
        searchIcon.click();
    }

    public void searchTest(String emailID, String password, String search) {
        logger.info("Starting Search Test");
        clickAccountLogo();
        enterEmail(emailID);
        enterPassword(password);
        clickLoginButton();
        searchBar(search);
        clickOnSearch();
        logger.info("Search Test completed for search term: " + search);
    }

//    public void buyRing(){
//        logger.info("selcted item");
//        zircon_Ring.click();
//        buyNow.click();
//    }
}
