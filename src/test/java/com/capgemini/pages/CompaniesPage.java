package com.capgemini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPage {
	WebDriver driver;

	@FindBy(xpath ="//button[text() = 'Create']")
	WebElement createBtn;

	@FindBy(name = "name")
	WebElement companyNameField;

	@FindBy(name = "industry")
	WebElement industryField;
	
	@FindBy(css = "input[name='image']")
	WebElement imageUpload;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;


	public CompaniesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateBtn(){
		return createBtn;
	}
	public WebElement getCompanyName() {
		return companyNameField;
	}
	public WebElement enter_industry() {
		return industryField;
	}
	public WebElement getUploadImage() {
		return imageUpload;
	}
	public WebElement click_save() {
		return saveButton;
	}
}
