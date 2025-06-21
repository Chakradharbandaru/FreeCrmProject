package com.capgemini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCrmDeletePage {
	WebDriver driver;

	@FindBy (xpath = "//tbody/tr[1]/td[4]/button[1]/i[1]")
	private WebElement deleteButton;

	@FindBy (xpath = "//button[normalize-space()='Delete']")
	private WebElement delete;

	public FreeCrmDeletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	public WebElement getDelete() {
		return delete;
	}
}
