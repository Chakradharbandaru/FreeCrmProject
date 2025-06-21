package com.capgemini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCrmFiltersPage {
	WebDriver driver;

	@FindBy(xpath = "//div/button[contains(.,'Show Filters')]")
	private WebElement showFilters;

	@FindBy(xpath = "//div/input[@class='search']")
	private WebElement search;

	@FindBy(xpath = "//div/span[text()='Name']")
	private WebElement searchDropdown;

	@FindBy(xpath = "//div[text()='Operator']")
	private WebElement operator;

	@FindBy(xpath = "//div/span[text()='Equals']")
	private WebElement operatorDropdown;

	@FindBy(xpath = "//input[@placeholder='Value']")
	private WebElement value;

	@FindBy(xpath = "//button[text()='Filter']")
	private WebElement filter;

	public FreeCrmFiltersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getShowFilters() {
		return showFilters;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getSearchDropdown() {
		return searchDropdown;
	}
	public WebElement getOperator() {
		return operator;
	}
	public WebElement getOperatorDropdown() {
		return operatorDropdown;
	}
	public WebElement getValue() {
		return value;
	}
	public WebElement getFilter() {
		return filter;
	}
}

