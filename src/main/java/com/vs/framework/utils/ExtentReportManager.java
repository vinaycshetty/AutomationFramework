package com.vs.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Created by : Vinay Shetty
 * on 01-04-2025 at 22:38
 **/
public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void init() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void log(String message) {
        test.info(message);
    }

    public static void flush() {
        extent.flush();
    }
}
