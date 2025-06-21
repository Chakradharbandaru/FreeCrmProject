package com.capgemini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCrmEventPage {
	WebDriver driver;

	@FindBy (xpath ="(//button[@class=\"ui icon button\"]//i[@class=\"unhide icon\"])[3]")
	private WebElement viewCompany;

	@FindBy(xpath="//a[contains(text(),'Events')]")
	private WebElement clickEvents;

	@FindBy(xpath = "//i[@class='add icon']")
	private WebElement addEvent;

	@FindBy(xpath ="//input[@name='title']")
	private WebElement eventName;

	@FindBy(css = "div[name='category'][role='listbox']")
	private WebElement category;

	@FindBy(xpath = "//span[contains(text(),'Social')]")
	private WebElement clickSocial;

	@FindBy(xpath = "//div[@class='ui toggle checkbox']")
	private WebElement clickAllDay;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	private WebElement SaveEvent;

	public FreeCrmEventPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCompany() {
		return viewCompany;
	}
	public WebElement getEvents() {
		return clickEvents;
	}
	public WebElement getNewEvent() {
		return addEvent;
	}
	public WebElement getEventName() {
		return eventName;
	}
	public WebElement getCategory() {
		return category;
	}
	public WebElement getSocial() {
		return clickSocial;
	}
	public WebElement getAllDay() {
		return clickAllDay;
	}
	public WebElement getSaveButton() {
		return SaveEvent;
	}	
}
