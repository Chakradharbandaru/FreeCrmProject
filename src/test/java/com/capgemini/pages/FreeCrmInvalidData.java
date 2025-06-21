package com.capgemini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCrmInvalidData {
	WebDriver driver;

	@FindBy(xpath ="//button[text() = 'Create']")
	private WebElement createBtn;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	public FreeCrmInvalidData (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}

	public WebElement getSaveBtn() {
		return saveButton;
	}
}
