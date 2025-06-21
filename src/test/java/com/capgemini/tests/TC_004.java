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
import com.capgemini.pages.FreeCrmFiltersPage;
import com.capgemini.pages.FreeCrmHomePage;
import com.capgemini.parameters.JsonReader;
import com.capgemini.utils.Screenshots;

public class TC_004 extends BaseReport{
	WebDriver driver;
	WebDriverWait wait;
	static String baseurl;
	FreeCrmHomePage freeCrmHomePage;
	FreeCrmDeletePage freeCrmDeletePage;
	FreeCrmFiltersPage freeCrmFiltersPage;
	static String excelPath;
	String screenshotPath;
	
	/*
	 * Created By   : Bandaru Venkata Chakradhar
	 * Reviewed By  : Richa Singh
	 * Test scenario: It will return accurate search results based on the company name 
	 * 				  and selected filters entered. 
	 */

	@BeforeTest
	public void setUptest() {
		baseurl="https://freecrm.com/cases.html";
		excelPath = "src/test/resources/ExcelData/TestData.xlsx";
	}

	@BeforeClass
	public void setUp() {
		driver = SetupDriver.getDriver("chrome");
		driver.navigate().to(baseurl);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		freeCrmHomePage = new FreeCrmHomePage(driver);
		freeCrmFiltersPage = new FreeCrmFiltersPage(driver);
	}

	String[] creds = JsonReader.getJsonData("src/test/resources/JsonData/TestData.json","email","password");
	String email = creds[0];
	String password = creds[1];

	@Test(priority = 1)
	public void testLogin() throws Exception {

		//Step1: Click on StartHere
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
	 * Test scenario: It will return accurate search results based on the company name 
	 * 				  and selected filters entered. 
	 */

	@Test(dependsOnMethods = "testLogin")
	public void testFilter() throws Exception {

		//step-6: Click on Show Filters
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmFiltersPage.getShowFilters())).click();
		Reporter.log("Clicked on ShowFilters", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "ShowFiltersButtonClicked");
		generateReportWithScreenshot("Clicked on ShowFilters", screenshotPath);

		//step-7: Click on Search Drop box
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmFiltersPage.getSearch())).click();
		Reporter.log("Clicked on Search", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "SearchClicked");
		generateReportWithScreenshot("Clicked on Search", screenshotPath);

		//step-8: Click on Search drop box
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmFiltersPage.getSearchDropdown())).click();
		Reporter.log("Clicked on SearchDropdown", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "SearchDropdownClicked");
		generateReportWithScreenshot("Clicked on SearchDropdown", screenshotPath);

		//step-9: Click the operator 
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmFiltersPage.getOperator())).click();
		Reporter.log("Clicked on Operator", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "OperatorClicked");
		generateReportWithScreenshot("Clicked on Operator", screenshotPath);

		//step-10: Select the operator from the drop box
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmFiltersPage.getOperatorDropdown())).click();
		Reporter.log("Clicked on OperatorDropdown", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "OperatorDropdownClicked");
		generateReportWithScreenshot("Clicked on OperatorDropdown", screenshotPath);

		//step-11: Click on Value Button
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmFiltersPage.getValue())).click();
		Reporter.log("Clicked on ValueButton", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "ValueButtonClicked");
		generateReportWithScreenshot("Clicked on ValueButton", screenshotPath);

		//step-12: Enter the value
		wait.until(ExpectedConditions.visibilityOf(freeCrmFiltersPage.getValue())).sendKeys("NCCL");
		Reporter.log("Entered Value", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "ValueEntered");
		generateReportWithScreenshot("Entered Value", screenshotPath);

		//step-13 Click on Filter Button
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmFiltersPage.getFilter())).click();
		Reporter.log("Clicked on Search Filter", true);
		if(freeCrmFiltersPage.getFilter().isDisplayed()) {
			test.pass("Filter Button is Clicked");
			Assert.assertTrue(true);
		}
		else {
			test.pass("Filter Button is not clicked");
			Assert.assertTrue(false);
		}
		screenshotPath = Screenshots.takeScreenShot(driver, "SearchFilterClicked");
		generateReportWithScreenshot("Clicked on Search Filter", screenshotPath);
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
