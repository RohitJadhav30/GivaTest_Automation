package listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.giva.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.TestUtil;

public class CustomListener extends TestBase implements ITestListener {

    private static final Logger logger = LogManager.getLogger(CustomListener.class);
    private TestUtil util;
    private ExtentTest test;

    public CustomListener() {
        super();
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test case started: " + result.getName());
        extentReport.attachReporter(extentSparkReporter);
        test = extentReport.createTest(result.getName());
        test.log(Status.INFO, "The test case is started: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test case skipped: " + result.getName());
        test = extentReport.createTest(result.getName());
        test.log(Status.SKIP, "Test case skipped: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test case succeeded: " + result.getName());
        test = extentReport.createTest(result.getName());
        test.log(Status.PASS, "Test executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test case failed: " + result.getName());
        test = extentReport.createTest(result.getName());
        util = new TestUtil();
        util.takescreenshotFaliure(driver);
        test.log(Status.FAIL, "Test failed: " + result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Flushed the Extent Report");
        extentReport.flush();
    }
}
