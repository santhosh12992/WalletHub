package com.qa.auto.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.auto.emun.InsuranceCompany;

public class CreateReviewPage {
	WebDriver driver;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog//*[contains(text(), 'Submit')]")
	WebElement reviewSubmit;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog//ng-dropdown//span")
	WebElement selectDD;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog//write-review//li[contains(text(), 'Health Insurance')]")
	WebElement selectHealthInsurance;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog//write-review//textarea")
	WebElement reviewText;

	public CreateReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectDD(InsuranceCompany value) {
		selectDD.click();
		if (value.equals(InsuranceCompany.HEALTH_INSURANCE)) {
			selectHealthInsurance.click();
		}
	}

	public void submitReviewText(String content) {
		reviewText.sendKeys(content);
		reviewSubmit.click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains("Review Confirmation"));
	}
}
