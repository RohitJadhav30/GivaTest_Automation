package com.giva.qa.pages;

import com.giva.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp extends TestBase {

    private static final Logger logger = LogManager.getLogger(SignUp.class);

    public SignUp() {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[@class=\"small-hide\"])[3]")
    WebElement webLogo;

    @FindBy(xpath = "(//a[normalize-space()='Create a new account'])[1]")
    WebElement createAccount;

    @FindBy(xpath = "(//input[@id='RegisterForm-FirstName'])")
    WebElement firstName;

    @FindBy(xpath = "(//input[@id='RegisterForm-LastName'])")
    WebElement lastName;

    @FindBy(id = "RegisterForm-email")
    WebElement inputEmail;

    @FindBy(id = "RegisterForm-password")
    WebElement password;

    @FindBy(xpath = "(//*[@id=\"create_customer\"]/button)")
    WebElement signUpButton;

    public void clickAccountLogo() {
        logger.info("Clicked Account logo");
        webLogo.click();
    }

    public void clickOnCreateNewAccount() {
        logger.info("Clicked on Create a New Account");
        createAccount.click();
    }

    public void enterFirstName(String fName) {
        logger.info("Entering First Name: " + fName);
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        logger.info("Entering Last Name: " + lName);
        lastName.sendKeys(lName);
    }

    public void enterEmail(String email) {
        logger.info("Entering Email: " + email);
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String pass) {
        logger.info("Entering Password");
        password.sendKeys(pass);
    }

    public void clickSignUpButton() {
        logger.info("Clicked Sign Up button");
        signUpButton.click();
    }

    public void signUpTest(String fName, String lName, String email, String pass) {
        logger.info("Starting Sign Up Test");
        clickAccountLogo();
        clickOnCreateNewAccount();
        enterFirstName(fName);
        enterLastName(lName);
        enterEmail(email);
        enterPassword(pass);
        clickSignUpButton();
        logger.info("Sign Up Test completed for email: " + email);
    }
}
