package com.sd.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sd.utility.BrowserSettings;
import com.sd.utility.ConfigDataReader;
import com.sd.utility.ExcelTestDataReader;
import com.sd.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class launcherClass {
    public WebDriver driver;
    public BrowserSettings bs = new BrowserSettings();
    public ExcelTestDataReader exReader;
    public ConfigDataReader configReader;
    public ExtentReports report;
    public String randomFilename;
    public ExtentTest logger;

    //Set up before each tests
    @Parameters({"browser","url"})
    @BeforeClass()
    public void setUp(String browser, String url){
        Reporter.log("Test config is being prepared" , true);
        exReader = new ExcelTestDataReader();
        configReader = new ConfigDataReader();
        randomFilename = Helper.getRandomValue();
        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/TestReport_"+randomFilename+".html"));
        report = new ExtentReports();
        report.attachReporter(htmlReport);
        Reporter.log("Test can be started" , true);
        Reporter.log("Launching the application" , true);
        //driver = bs.openBrowser(configReader.getBrowserValue(), configReader.getTestUrl());
        driver = bs.openBrowser(browser, url);
        //Helper.getScreenshot(driver);
        Reporter.log("Application launched" , true);
    }

    //Quit browser
    @AfterClass
    public void tearDown() {
        bs.quitBrowser(driver);
    }

    //Report generation
    @AfterMethod
    public void finalTearDown(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            logger.fail("Testcase failed: ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver)).build());
        } else if (result.getStatus() == ITestResult.SUCCESS){
            logger.pass("Testcase passed: ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver)).build());
        } else if (result.getStatus() == ITestResult.SKIP){
            logger.skip("Testcase skipped: ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver)).build());
        }
        report.flush();
    }
}
