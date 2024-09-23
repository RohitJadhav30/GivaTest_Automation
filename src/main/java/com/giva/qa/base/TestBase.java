package com.giva.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(TestBase.class);
    public ExtentReports extentReport = new ExtentReports();
    public ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("extentReport.html");

    public TestBase(WebDriver driver) {
        extentSparkReporter.config().setReportName("Automation Test Report");
        extentSparkReporter.config().setDocumentTitle("Reports");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReport.setSystemInfo("Operating System", "Windows 11");
        extentReport.setSystemInfo("Tester", "Rohit");
        extentReport.setSystemInfo("Browser", "Chrome");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TestBase() {
    }

    public void initialize() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.giva.co/");
        logger.info("Driver initialized and navigated to the website.");
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
