package com.capgemini.utils;
 
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class Screenshots {
	static int imageCount = 1;
	public static String takeScreenShot(WebDriver drv,String filename) throws Exception {
		String screenshotPath = System.getProperty("user.dir") + "./Screenshots";
		File screenshot = ((TakesScreenshot) drv).getScreenshotAs(OutputType.FILE);        
		String screenshotName = "Step_" + (imageCount++) + "_"+filename+".png";
		screenshotPath = screenshotPath + File.separator + screenshotName;

		FileUtils.copyFile(screenshot, new File(screenshotPath));
		return screenshotPath;
	}
}
 



























//The Screenshots class captures screenshots of the browser window during test execution using 
//Selenium WebDriver. It's especially useful for logging test failures or documenting test steps.
//File: Represents file and directory pathnames.
//FileUtils: From Apache Commons IO, used to copy files.
//TakesScreenshot: Selenium interface for capturing screenshots.
//WebDriver: The browser automation interface.
//Captures a screenshot of the current browser window and saves it to the ./Screenshots directory.
//🧱 Parameters:
//drv: The WebDriver instance.
//filename: A custom name to include in the screenshot file.
