package com.vs.framework.base;

import com.vs.framework.manager.WebDriverSetUp;
import com.vs.framework.utils.ExtentReportManager;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

/**
 * Created by : Vinay Shetty
 * on 01-03-2025 at 20:32
 **/
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) {
        WebDriverSetUp.setupDriver("src/main/resources/config.properties");
        ExtentReportManager.startTest(method.getName());
        driver = WebDriverSetUp.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        ExtentReportManager.flush();
        WebDriverSetUp.quitDriver();
    }
}
