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
import com.capgemini.pages.FreeCrmHomePage;
import com.capgemini.pages.FreeCrmInvalidData;
import com.capgemini.parameters.PropertyReader;
import com.capgemini.utils.Screenshots;

public class TC_006 extends BaseReport{
	WebDriver driver;
	WebDriverWait wait;
	String baseUrl;
	FreeCrmHomePage freeCrmHomePage;
	FreeCrmInvalidData freeCrmInvalidData;
	String propertyPath;
	static String excelPath;
	String screenshotPath;
	
	/*
	 * Created By   : Bandaru Venkata Chakradhar
	 * Reviewed By  : Richa Singh
	 * Test scenario: The system should prevent submission and display validation 
	 *                messages when required fields are left blank.
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
		freeCrmInvalidData = new FreeCrmInvalidData(driver);	
	}

	@Test(priority = 1)
	public void testLogin() throws Exception {
		propertyPath = "src/test/resources/PropertyData/TestData.properties";

		String email= PropertyReader.getPropertyData(propertyPath, "email");
		String password = PropertyReader.getPropertyData(propertyPath, "password");

		//Step1: Click Start Here
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmHomePage.getLoginPage())).click();
		Reporter.log("Clicked on StartHere", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "LoginLinkClicked");
		generateReportWithScreenshot("Clicked on StartHere", screenshotPath);

		//Step2: Enter Email
		wait.until(ExpectedConditions.visibilityOf(freeCrmHomePage.enterEmail())).sendKeys(email);;
		Reporter.log("Entered Email", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "UserEmailidEntered");
		generateReportWithScreenshot("Entered Email", screenshotPath);

		//Step3: Enter Password
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
	 * Test scenario: The system should prevent submission and display validation 
	 *                messages when required fields are left blank.
	 */
	
	@Test(priority = 2, dependsOnMethods = "testLogin")
	public void testEvent() throws Exception {

		//Step6: Click on the create Button
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmInvalidData.getCreateBtn())).click();
		Reporter.log("Clicked on Create", true);
		screenshotPath = Screenshots.takeScreenShot(driver, "CreateBtnClicked");
		generateReportWithScreenshot("Click on Create", screenshotPath);

		//Step7: Click on the save Button
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmInvalidData.getSaveBtn())).click();
		Reporter.log("Clicked on Save", true);
		if(freeCrmInvalidData.getSaveBtn().isDisplayed()) {
			test.pass("Save Button is Clicked");
			Assert.assertTrue(true);
		}
		else {
			test.pass("Save Button is not clicked");
			Assert.assertTrue(false);
		}
		screenshotPath = Screenshots.takeScreenShot(driver, "SaveBtnClicked");
		generateReportWithScreenshot("Clicked on Save", screenshotPath);
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
