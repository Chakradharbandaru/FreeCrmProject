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
import com.capgemini.pages.FreeCrmDeletePage;
import com.capgemini.pages.FreeCrmEditPage;
import com.capgemini.pages.FreeCrmHomePage;
import com.capgemini.parameters.ExcelReader;
import com.capgemini.utils.Screenshots;


public class TC_002 extends BaseReport{
	WebDriver driver;
	WebDriverWait wait;
	static String baseUrl;
	FreeCrmHomePage freeCrmHomePage;
	FreeCrmEditPage freeCrmEditPage;
	FreeCrmDeletePage freeCrmDeletePage;
	static String excelPath;
	String screenshotPath;
	
	/*
	 * Created By   : Bandaru Venkata Chakradhar
	 * Reviewed By  : Richa Singh
	 * Test scenario: The system should allow editing of existing company details and 
	 * 				  reflect the changes immediately after saving. 
	 */

	@BeforeTest
	public void setUpTest() {
		baseUrl = "https://freecrm.com/";
		excelPath = "src/test/resources/ExcelData/TestData.xlsx";
	}

	@BeforeClass
	public void setUp() {
		driver = SetupDriver.getDriver("chrome");
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		freeCrmHomePage = new FreeCrmHomePage(driver);
		freeCrmEditPage = new FreeCrmEditPage(driver);
	}

	@Test(priority = 1)
	public void testLogin() throws Exception {
		String email = ExcelReader.getCellData(excelPath, "Login_Details", 1, 0);
		String password = ExcelReader.getCellData(excelPath, "Login_Details", 1, 1);

		//Step1: Click Start Here
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmHomePage.getLoginPage())).click();
		Reporter.log("Clicked on StartHere", true);

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
	 * Test scenario: The system should allow editing of existing company details and 
	 * 				  reflect the changes immediately after saving. 
	 */
	
	@Test(priority = 2)
	public void testEdit() throws Exception {

		//Step6: Click on Edit Button
		freeCrmEditPage.clickEditButton();
		Reporter.log("Click on Edit Button",true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "ClickedEdit Button");
		generateReportWithScreenshot("Click on Edit Button", screenshotPath);
		Thread.sleep(2000);

		//Step7: Update the Company Name
		freeCrmEditPage.updateTitle("SVCPVT");
		Reporter.log("Updated the Name");
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Updated Name");
		generateReportWithScreenshot("Updated the Name", screenshotPath);



		//Step8: Update the Industry
		freeCrmEditPage.updateIndustry("Construction");
		Reporter.log("Updated the Industry");
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Updated Industry");
		generateReportWithScreenshot("Updated the Industry", screenshotPath);
		Thread.sleep(2000);

		//Step9: Save the Company
		freeCrmEditPage.saveCompany();
		Reporter.log("Save the Company");
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Saved the Company");
		generateReportWithScreenshot("Save the Company", screenshotPath);
		Thread.sleep(2000);

		//Step10: Open Companies Tab
		freeCrmHomePage.click_companies().click();
		Reporter.log("Click on the Companies");
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "Companies Tab Clicked");
		generateReportWithScreenshot("Click on the Companies", screenshotPath);
		Thread.sleep(2000);
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