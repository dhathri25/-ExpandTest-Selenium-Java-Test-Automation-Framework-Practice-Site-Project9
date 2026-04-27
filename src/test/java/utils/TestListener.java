
package utils;

import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = BaseTest.driver;

        test.log(Status.FAIL, "Test Failed");

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = "screenshots/" + result.getName() + ".png";

        try {
            FileUtils.copyFile(src, new File(path));

            test.addScreenCaptureFromPath(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}