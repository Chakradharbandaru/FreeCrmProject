package com.capgemini.tests;
 
import java.lang.reflect.Method;
 
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
 
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.capgemini.utils.Screenshots;
 
public class BaseReport {
 
    protected static ExtentReports extent;
    protected static ExtentSparkReporter spark;
    protected ExtentTest parentTest; // Class-level node
    protected ExtentTest test;       // Method-level node
    protected WebDriver driver;      // Make sure subclasses initialize this
 
    @BeforeSuite
    public void setUpReport() {
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + 
        													"./Extent Reports/AutomationReport.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("FREECRM Automation Suite");
 
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
 
    @BeforeClass
    public void setUpClass() {
        parentTest = extent.createTest(getClass().getSimpleName());
    }
 
    @BeforeMethod
    public void setUpMethod(Method method) {
        test = parentTest.createNode(method.getName());
    }
 
    @AfterMethod
    public void tearDownMethod(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = Screenshots.takeScreenShot(driver, result.getName());
            test.fail(result.getThrowable());
            test.fail("<b>Screenshot:</b><br><img src='" + screenshotPath + 
            			"' style='width:90%; height:auto;'>");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getThrowable());
        }
    }
 
    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
     
    public void generateReportWithScreenshot(String stepDescription, String screenshotPath) {
        test.info(stepDescription + "<br><img src='" + screenshotPath + 
        			"' style='width:90%; height:auto;'/>");
    }
}







//The BaseReport class is a TestNG base class that integrates ExtentReports for generating rich HTML test reports. 
//It also supports screenshot capture on test failure and organizes test logs in a structured, hierarchical format.
//Method: Used to get the current test method name.
//WebDriver: For browser automation.
//ITestResult: Captures the result of a test method (pass/fail/skip).
//ExtentReports, ExtentTest, ExtentSparkReporter: For generating structured HTML reports.
//Screenshots: A custom utility class to capture screenshots.
//Method: Used to get the current test method name.
//WebDriver: For browser automation.
//ITestResult: Captures the result of a test method (pass/fail/skip).
//ExtentReports, ExtentTest, ExtentSparkReporter: For generating structured HTML reports.
//Screenshots: A custom utility class to capture screenshots.
//extent: Main report object.
//spark: Reporter that generates the HTML file.
//parentTest: Represents the test class in the report.
//test: Represents individual test methods.
//driver: WebDriver instance (to be initialized in subclasses).

//BEFORE SUITE: Initializes the report before the test suite starts.
//				Sets the report file path, theme, title, and name.			
//BEFORE CLASS: Creates a PARENT node in the report for the test class.
//BEFORE METHOD: Creates a CHILD node in the report for the test METHOD.
// AFTER METHOD: Logs the result of each test method.
//				If the test fails, it captures a screenshot and attaches it to the report.
//AFTER SUITE: Finalizes and writes the report to disk after all tests are done.
//CUSTOM METHOD GENERATE SS: Allows logging custom steps with screenshots during test execution.
//FLUSH IT WILL FLUSH OUTPUT TO THE HTML.
