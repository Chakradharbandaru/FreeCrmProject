package com.capgemini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCrmHomePage {
	@FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	private WebElement signin;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement user_email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement user_pwd;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	private WebElement login_link;

	@FindBy(xpath ="//span[contains(text(),'Companies')]")
	WebElement companiesTab;

	WebDriver driver;

	public FreeCrmHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	public WebElement getLoginPage() {
		return signin;
	}
	public WebElement enterEmail() {
		return user_email;
	}
	public WebElement enterpwd() {
		return user_pwd;
	}
	public WebElement clicklogin() {
		return login_link;
	}
	public WebElement click_companies() {
		return companiesTab;
	}
}

