package com.inetbanking.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.inetbanking.testCases.BaseClass;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }
    
    @Override
    public void onTestStart(ITestResult result) {

    	System.out.println("🔥 onTestStart executed for: "
                + result.getMethod().getMethodName());
    	
        ExtentTestManager.setTest(
                extent.createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.PASS, "Test Passed");
    }

    
    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().fail(result.getThrowable());

        Object currentClass = result.getInstance();
        BaseClass base = (BaseClass) currentClass;

        String screenshotPath = base.takeScreenShot(
                result.getMethod().getMethodName());

        ExtentTestManager.getTest()
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
        ExtentTestManager.unload();
    }
}