package webdriver.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import webdriver.driver.DriverManager;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(iTestResult.getTestName() + "test has started");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(iTestResult.getTestName() + "test has successful");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(iTestResult.getTestName() + "test has fell");
        screenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(iTestResult.getTestName() + "test has skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void screenshot() {
        File screen = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File(
                    ".//target/screenshots/" + getCurrentTime()
                            + ".png"
            ));
        } catch (IOException exc) {
            Log.error(exc);
        }
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
