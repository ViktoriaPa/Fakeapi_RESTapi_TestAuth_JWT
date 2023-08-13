package com.coherentsolutions.training.auto.API.pashkovskaya.util;

import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class TestAllureListener implements ITestListener {
    private final Logger log = LoggerFactory.getLogger(TestAllureListener.class);
    private static String getTestMethodName (ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message){
        return message;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        Date d = new Date();
        String[] dateTokens = d.toString().split(" ");
        saveTextLog(dateTokens[1] + ", " + dateTokens[2] + " " + dateTokens[5] + "; " + dateTokens[3] + " " + getTestMethodName(iTestResult) + " failed and screenshot taken");
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
