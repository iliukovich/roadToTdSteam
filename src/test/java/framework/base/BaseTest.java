package framework.base;

import api.TestrailApi;
import aqa.logger.Logger;
import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import framework.configurations.Configuration;
import framework.enums.TestStatus;
import helpers.TestInfo;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected final Logger logger = Logger.getInstance();

    protected TestInfo testInfo;
    private static Long runId;

    @BeforeMethod()
    public void createRun() {
        if (Boolean.parseBoolean(System.getProperty("report"))) {
            logger.info("Reporting is enabled. Creating run");
            runId = new TestrailApi().createRun();
            testInfo = getClass().getAnnotation(TestInfo.class);
        }
        logger.info("Reporting is disabled. No need to create run");
    }

    /**
     * To override.
     */
    protected abstract void runTest();

    /**
     * Before Class method
     * Configure environment
     * Make a browser window
     */


    @BeforeMethod
    public void before() throws WebDriverException, MalformedURLException {
        logger.logPreconditions();
        getBrowser().goTo(Configuration.getCurrentEnvironment().getStartUrl());
        getBrowser().setWindowSize(1920, 1080);
    }

    /**
     * Close browser and made screenshot after each test Class
     */
    @AfterMethod
    public void afterMethod(ITestContext testContext, ITestResult testResult) {
        TestStatus testStatus;
        if (testResult.getStatus() == TestResult.SUCCESS) {
            testStatus = TestStatus.PASSED;
        } else {
            testStatus = TestStatus.FAILED;
        }
        makeScreenshot();
        logger.logFormattedMessage(Logger.getLoc("loc.base.test.testEnd"), testContext.getName(), testStatus.toString(),
                formatDuration(testResult.getEndMillis() - testResult.getStartMillis()));
        getBrowser().quit();
    }

    @AfterMethod
    public void report(ITestResult testResult) {
        if (Boolean.parseBoolean(System.getProperty("report"))) {
            new TestrailApi().postTestResults(runId, testInfo.id(), testResult);
        }
    }

    private String formatDuration(long milliseconds) {
        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds - TimeUnit.HOURS.toMillis(hours));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds - TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes));
        return logger.getFormattedMessage(Logger.getLoc("loc.base.test.duration"), hours, minutes, seconds);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return getBrowser().getScreenshot();
    }

    private Browser getBrowser(){
        return BrowserManager.getBrowser();
    }
}

