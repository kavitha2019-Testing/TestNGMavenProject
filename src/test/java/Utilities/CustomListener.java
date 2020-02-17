package Utilities;

import Base.screenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomListener extends screenshot implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Testcase started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Testcase passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Testcase failure");
        try {
            captureScreen(result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

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
}