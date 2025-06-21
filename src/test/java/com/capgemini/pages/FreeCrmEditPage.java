package com.capgemini.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FreeCrmEditPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath="//tbody/tr[3]/td[4]/a[2]/button[1]/i[1]")
	private WebElement editButton;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement editCompanyName;

	@FindBy(name = "industry")
	private WebElement editIndustry;

	@FindBy(xpath="//button[contains(.,'Save')]")
	private WebElement saveButton;

	public FreeCrmEditPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void clickEditButton() {
		wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
	}

	public void updateTitle(String title) {
		wait.until(ExpectedConditions.visibilityOf(editCompanyName)).clear();
		editCompanyName.sendKeys(title);
	}

	public void updateIndustry(String Industry) {
		wait.until(ExpectedConditions.visibilityOf(editIndustry)).clear();
	}

	public void saveCompany() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	}
}
