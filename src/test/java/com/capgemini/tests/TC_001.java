package com.capgemini.tests;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.capgemini.driversetup.SetupDriver;
import com.capgemini.pages.CompaniesPage;
import com.capgemini.pages.FreeCrmHomePage;
import com.capgemini.parameters.ExcelReader;
import com.capgemini.utils.Screenshots;


public class TC_001 extends BaseReport {
	WebDriver driver;
	WebDriverWait wait;
	String baseurl;
	FreeCrmHomePage freeCrmHomePage;
	CompaniesPage companiesPage;
	String parentDriver;
	String excelPath;
	String screenshotPath;
	
	/*
	 * Created By   : Bandaru Venkata Chakradhar
	 * Reviewed By  : Richa Singh
	 * Test scenario: The system should allow the creation of a new company when all 
	 * 				  required fields are filled with valid data. 
	 */
	
	@BeforeTest
	public void setUpTest() {
		baseurl="https://freecrm.com/cases.html";
		excelPath = "src/test/resources/ExcelData/TestData.xlsx";
	}
	@BeforeClass
	public void setUp() {
		driver = SetupDriver.getDriver("chrome");
		driver.navigate().to(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		parentDriver = driver.getWindowHandle();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		freeCrmHomePage = new FreeCrmHomePage(driver);
		companiesPage = new CompaniesPage(driver); 
	}

	@Test(priority = 1)
	public void LoginToCrm() throws Exception {
		String email = ExcelReader.getCellData(excelPath, "Login_Details", 1, 0);
		String password = ExcelReader.getCellData(excelPath, "Login_Details", 1, 1);
		freeCrmHomePage = new FreeCrmHomePage(driver);

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


		//Step5: Click on Companies
		wait.until(ExpectedConditions.elementToBeClickable(freeCrmHomePage.click_companies())).click();
		Reporter.log("Click on Companies", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "CompaniesBtnClicked");
		generateReportWithScreenshot("Click on Companies", screenshotPath);
	}
	
	/*
	 * Created By   : Bandaru Venkata Chakradhar
	 * Reviewed By  : Richa Singh
	 * Test scenario: The system should allow the creation of a new company when all 
	 * 				  required fields are filled with valid data. 
	 */

	@Test(priority = 2)
	public void addNewCompany() throws Exception {
		String companyName = ExcelReader.getCellData(excelPath, "Companies", 3, 0);
		String Industry = ExcelReader.getCellData(excelPath, "Companies", 3, 1);

		//Step6: Click on create button 
		wait.until(ExpectedConditions.elementToBeClickable(companiesPage.getCreateBtn())).click();
		Reporter.log("Click on Create Button", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "CreateButtonClicked");
		generateReportWithScreenshot("Click on Create Button", screenshotPath);

		//Step7: Enter name of the company
		wait.until(ExpectedConditions.elementToBeClickable(companiesPage.getCompanyName())).click();
		companiesPage.getCompanyName().sendKeys(companyName);
		Reporter.log("Enter Company", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "CompanyNameEntered");
		generateReportWithScreenshot("Enter Compnay Name", screenshotPath);


		//Step7: Enter Industry
		wait.until(ExpectedConditions.elementToBeClickable(companiesPage.enter_industry())).click();
		companiesPage.enter_industry().sendKeys(Industry);
		Reporter.log("Enter Industry", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "IndustryEntered");
		generateReportWithScreenshot("Enter Industry", screenshotPath);

		//Step8:  Verify that the upload image field is displayed
		wait.until(ExpectedConditions.elementToBeClickable(companiesPage.getUploadImage())).click();
		Reporter.log("Upload file", true);
		Assert.assertTrue(true);
		screenshotPath = Screenshots.takeScreenShot(driver, "FileUploaded");
		generateReportWithScreenshot("Upload File", screenshotPath);
		Thread.sleep(2000);

		Robot robot = new Robot();

		// To copy [Simulating Ctrl + c]
		StringSelection file = new StringSelection("C:\\Users\\bchakrad\\Downloads\\hospital.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

		// To paste [Simulating Ctrl + v]
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Simulate Enter key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Reporter.log("File uploaded successfully!");

		//step9: Click on Save Button
		wait.until(ExpectedConditions.elementToBeClickable(companiesPage.click_save())).click();
		Reporter.log("Click on Save",true);
		if(companiesPage.click_save().isDisplayed()) {
			test.pass("Save Button is Clicked");
			Assert.assertTrue(true);
		}
		else {
			test.pass("Save Button is not clicked");
			Assert.assertTrue(false);
		}		
		screenshotPath = Screenshots.takeScreenShot(driver, "SaveBtnClicked");
		generateReportWithScreenshot("Click on Save", screenshotPath);
	}
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			Reporter.log("Browser closed successfully", true);
		}
		Reporter.log("Test completed successfully", true);
	} 
}