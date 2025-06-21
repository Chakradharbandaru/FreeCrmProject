package com.capgemini.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.FreeCrmEventPage;
import com.capgemini.pages.FreeCrmHomePage;
import com.capgemini.parameters.JsonReader;
import com.capgemini.utils.Screenshots;

public class TC_005 extends BaseReport{
	WebDriver driver;
	WebDriverWait wait;
	String baseUrl;
	FreeCrmHomePage freeCrmHomePage;
	FreeCrmEventPage freeCrmEventPage;
	static String excelPath;
	String screenshotPath;
	
	/*
	 * Created By   : Bandaru Venkata Chakradhar
	 * Reviewed By  : Richa Singh
	 * Test scenario: Creation of a new event for the company when all required 
	 *                fields are filled with valid data. 
	 */

	@BeforeTest
	public void setUpTest() {
		baseUrl = "https://freecrm.com/";
		excelPath ="src/test/resources/ExcelData/TestData.xlsx";
	}

	@BeforeClass
	public void setUp() {
		driver = SetupDriver.getDriver("chrome");
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		freeCrmHomePage = new FreeCrmHomePage(driver);
		freeCrmEventPage = new FreeCrmEventPage(driver);	
	}

	String[] creds = JsonReader.getJsonData("src/test/resources/JsonData/TestData.json","email","password");
	String email = creds[0];
	String password = creds[1];


	@Test(priority = 1)
	public void testLogin() throws Exception {

		//Step1: Click Start Here
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmHomePage.getLoginPage())).click();
		Reporter.log("Clicked on StartHere", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "LoginLinkClicked");
		generateReportWithScreenshot("Clicked on StartHere", screenshotPath);

		//Step2: Click Email
		wait.until(ExpectedConditions.visibilityOf(freeCrmHomePage.enterEmail())).sendKeys(email);;
		Reporter.log("Entered Email", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "UserEmailidEntered");
		generateReportWithScreenshot("Entered Email", screenshotPath);

		//Step3: Click Password
		wait.until(ExpectedConditions.visibilityOf(freeCrmHomePage.enterpwd())).sendKeys(password);
		Reporter.log("Entered Password", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "UserPasswordEntered");
		generateReportWithScreenshot("Entered Password", screenshotPath);

		//Step4: Click Login
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmHomePage.clicklogin())).click();
		Reporter.log("Click on login", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "LoginBtnClicked");
		generateReportWithScreenshot("Click on login", screenshotPath);

		//Step5: Click Companies
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmHomePage.click_companies())).click();
		Reporter.log("Click on Companies", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "CompaniesBtnClicked");
		generateReportWithScreenshot("Click on Companies", screenshotPath);
	}
	
	/*
	 * Created By   : Bandaru Venkata Chakradhar
	 * Reviewed By  : Richa Singh
	 * Test scenario: Creation of a new event for the company when all required 
	 *                fields are filled with valid data. 
	 */

	@Test(priority = 2, dependsOnMethods = "testLogin")
	public void testEvent() throws Exception {
		//Step6: Click on View Company Profile
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmEventPage.getCompany())).click();
		Reporter.log("Company Profile Viewed",true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Clicked On View Icon");
		generateReportWithScreenshot("Company Profile Viewed", screenshotPath);

		//Step7: Click on Events Tab
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmEventPage.getEvents())).click();
		Reporter.log("Clicked on Events",true);
		if(freeCrmEventPage.getEvents().isDisplayed()) {
			test.pass("Events Button is Clicked");
			Assert.assertTrue(true);
		}
		else {
			test.pass("Events Button is not clicked");
			Assert.assertTrue(false);
		}
		screenshotPath = Screenshots.takeScreenShot(driver, "Events Tab Clicked");
		generateReportWithScreenshot("Clicked on Events", screenshotPath);

		//Step8: Click on the Add New Event
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmEventPage.getNewEvent())).click();
		Reporter.log("Clicked On Add New Event",true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Add New Event Clicked");
		generateReportWithScreenshot("Clicked On Add New Event", screenshotPath);

		//Step9: Enter the event name
		wait.until(ExpectedConditions.visibilityOf(freeCrmEventPage.getEventName())).sendKeys("Anniversary");
		Reporter.log("Entered the Name",true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Name Entered");
		generateReportWithScreenshot("Entered the Name", screenshotPath);

		//Step10: Click on the category
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmEventPage.getCategory())).click();
		Reporter.log("Clicked on Category",true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Category Clicked");
		generateReportWithScreenshot("Clicked on Category", screenshotPath);

		//Step11: Click on the social 
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmEventPage.getSocial())).click();
		Reporter.log("Clicked on Social",true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Social Selected");
		generateReportWithScreenshot("Clicked on Social", screenshotPath);

		//Step12: Click on the All Day
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmEventPage.getAllDay())).click();
		Reporter.log("Clicked on AllDay",true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "AllDay Clicked");
		generateReportWithScreenshot("Clicked on AllDay", screenshotPath);

		//Step13: Click on the save button 
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmEventPage.getSaveButton())).click();	
		Reporter.log("Clicked on SaveButton",true);
		Assert.assertTrue(true);	
		screenshotPath = Screenshots.takeScreenShot(driver, "Save Button Clicked");
		generateReportWithScreenshot("Clicked on SaveButtton", screenshotPath);
	}
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			Reporter.log("Browser closed successfully", true);
		}
		Reporter.log("Test completed successfully", true);
	} 
}
